package com.evan.wj.Controller;

import com.evan.wj.Pojo.User;
import com.evan.wj.Service.UserService;
import com.evan.wj.Utils.Result;
import com.evan.wj.Utils.ResultUtil;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

/**
 * Code by langlang on 2020/2/25
 */

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;


    //用户注册
    @PostMapping("/user/Register")
    public Object Register(@RequestBody User user){
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = user.getUsername();
        String name = user.getName();
        String phone = user.getPhone();
        String email = user.getEmail();
        String password = user.getPassword();

        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        phone = HtmlUtils.htmlEscape(phone);
        user.setPhone(phone);
        email = HtmlUtils.htmlEscape(email);
        user.setEmail(email);
        user.setEnabled(true);

        if(userService.getUserByname(username)!=null){
            return ResultUtil.error(304,"用户名以被占用");
        }

        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        //加盐hash加密
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 设置 hash 算法迭代次数
        int times = 2;
        // 得到 hash 后的密码
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
        // 存储用户信息，包括 salt 与 hash 后的密码
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        if(userService.register(user)!=0){
            return ResultUtil.OK();
        }
    }
}