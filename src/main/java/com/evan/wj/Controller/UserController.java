package com.evan.wj.Controller;

import com.evan.wj.Pojo.User;
import com.evan.wj.Service.UserService;
import com.evan.wj.Utils.Result;
import com.evan.wj.Utils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

/**
 * Code by langlang on 2020/2/25
 */

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/Login")
    public Result login(@RequestBody User user) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = user.getUsername();
        username = HtmlUtils.htmlEscape(username);
        Subject subject = SecurityUtils.getSubject();
        String password = user.getPassword();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        usernamePasswordToken.setRememberMe(true);
//        if(userService.getUserByname(username)!=null){
//            return ResultUtil.error(304,"用户名以被占用");
//        }
        try {
            subject.login(usernamePasswordToken);
            return ResultUtil.OK(usernamePasswordToken);
        }catch (UnknownAccountException e){
            return ResultUtil.error(304,"用户名不存在");
        }catch (IncorrectCredentialsException e){
            return ResultUtil.error(304,"密码错误");
        }
    }

    //用户注册
    @PostMapping("/Register")
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
        }else{
            return ResultUtil.error(500,"注册失败");
        }
    }


    @GetMapping("/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "成功登出";
        return ResultUtil.OK(message);
    }

    @GetMapping(value = "/authentication")
    public String authentication(){
        System.out.println("登陆");
        return null;
    }
}
