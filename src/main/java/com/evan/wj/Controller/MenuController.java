package com.evan.wj.Controller;

import com.evan.wj.Pojo.AdminMenu;
import com.evan.wj.Service.AdminMenuService;
import com.evan.wj.Utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Code by langlang on 2020/2/26
 */
@RestController
@RequestMapping("/api")
public class MenuController {

    @Autowired
    AdminMenuService adminMenuService;

    @GetMapping("/menu")
    public Object menu() {
        List<AdminMenu> menus = adminMenuService.getMenusByCurrentUser();
        if(menus!=null){
            return ResultUtil.OK(menus);
        }else{
            return ResultUtil.error(500,"error");
        }
    }
}
