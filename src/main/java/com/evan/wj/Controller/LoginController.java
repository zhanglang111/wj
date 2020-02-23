package com.evan.wj.Controller;

import com.evan.wj.Pojo.User;
import com.evan.wj.Service.UserService;
import com.evan.wj.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

/**
 * Code by langlang on 2020/2/22
 */

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            return new Result(200);
        }
    }

    @GetMapping("api/getUser")
    public Object getUser(String username){

        User user = userService.getUserByname(username);

        return user;
    }
}
