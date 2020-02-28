package com.evan.wj.Controller;

import com.evan.wj.Pojo.AdminRole;
import com.evan.wj.Service.AdminRoleService;
import com.evan.wj.Service.AdminUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Code by langlang on 2020/2/28
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RoleController {

    @Autowired
    AdminRoleService adminRoleService;

    @Autowired
    AdminUserRoleService adminUserRoleService;

    @RequestMapping("/admin/role")
    public List<AdminRole> list(){
        return adminRoleService.list();
    }

}
