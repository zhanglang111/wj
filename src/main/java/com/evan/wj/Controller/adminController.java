package com.evan.wj.Controller;

import com.evan.wj.Pojo.*;
import com.evan.wj.Service.*;
import com.evan.wj.Utils.ResultUtil;
import com.evan.wj.result.Result;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.List;

/**
 * Code by langlang on 2020/2/24
 */

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
public class adminController {

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @Autowired
    AdminUserRoleService adminUserRoleService;

    @Autowired
    AdminPermissionService adminPermissionService;

    @Autowired
    AdminMenuService adminMenuService;

    @Autowired
    AdminRoleService adminRoleService;

    @Autowired
    AdminRoleMenuService adminRoleMenuService;

    @Autowired
    AdminRolePermissionService adminRolePermissionService;

    //获取系统中的所有用户
    @GetMapping("/user")
    public Object getAllUser(){
        List<User> users = adminService.getAllUser();
        if(users!=null){
            return ResultUtil.OK(users);
        }else{
            return ResultUtil.error(500,"error");
        }
    }

    //获取系统中的所有用户及其对应的角色
    @GetMapping("/getAllrole")
    public Object getAllUserwithDetail(){
        List<User> users = adminService.getAllUser();
        return ResultUtil.OK(users);
    }

    @GetMapping("/rolesWithDetail")
    public Object rolesWithDetail() {
        //获取所有json每一个角色下所有的权限
        List<AdminRole> adminRoles = adminPermissionService.listRolesWithPermsWithMenu();
        return ResultUtil.OK(adminRoles);
    }

    @GetMapping("/role/perm")
    public Object listPerms() {
        //获取所有json每一个角色下所有的权限
        List<AdminPermission> adminPermissions = adminPermissionService.listPerms();
        return ResultUtil.OK(adminPermissions);
    }

    @GetMapping("/role/menu")
    public Object listMenus() {
        //获取所有json每一个角色下所有的权限
        List<AdminMenu> adminMenus = adminMenuService.listMenus();
        return ResultUtil.OK(adminMenus);
    }

    @PostMapping("/deleteUserInfo")
    public Object deleteUserInfo(@RequestBody User requestUser){
        if(adminService.deleteUserInfo(requestUser.getId())!=0){
            if(adminUserRoleService.deleteUserRole(requestUser.getId())!=0){
                return ResultUtil.OK();
            }else{
                return ResultUtil.error(304,"删除用户对应角色失败");
            }
        }else{
            return ResultUtil.error(500,"删除用户失败");
        }
    }

    @PostMapping("/deleteRoleInfo")
    public Object deleteRoleInfo(@RequestBody AdminRole requestRole){
        int Rid = requestRole.getId();
        adminRoleService.deleteRoleInfo(Rid);
        adminRolePermissionService.deleteRolePerms(Rid);
        adminRoleMenuService.deleteRoleMenu(Rid);
        return ResultUtil.OK();
    }

    //启用或者禁用角色的状态
    @PostMapping("/role/status")
    public Object EnableRoleStatus(@RequestBody AdminRole requestRole){
        if(adminRoleService.EnableStatus(requestRole.isEnabled(),requestRole.getId())!=0){
            return ResultUtil.OK();
        }else{
            return ResultUtil.error(304,"error");
        }
    }

    @PostMapping("/user/UpdateRoleInfo")
    public Object UpdateRoleInfo(@RequestBody AdminRole requestRole){
        //修改角色信息
        adminRoleService.UpdateRoleInfo(requestRole);
        adminPermissionService.editRolePerms(requestRole.getId(),requestRole.getPerms());
        adminRoleMenuService.editRoleMenu(requestRole.getId(),requestRole.getMenus())
        return ResultUtil.OK();

    }

    //启用或者禁用用户的状态
    @PostMapping("/user/status")
    public Object EnableUserStatus(@RequestBody User requestUser){
        if(userService.EnableStatus(requestUser.isEnabled(),requestUser.getId())!=0){
            return ResultUtil.OK();
        }else{
            return ResultUtil.error(304,"error");
        }
    }

    @PostMapping("/user/UpdateUserInfo")
    public Object UpdateUserInfo(@RequestBody User user){
        //修改用户信息
        if(userService.UpdateUserInfo(user)!=0){
            //设置用户的角色
            adminUserRoleService.editUserRole(user.getId(),user.getRoles());
            return ResultUtil.OK();
        }else{
            return ResultUtil.error(304,"error");
        }
    }


    //重置密码
    @PostMapping("/user/resetPassword")
    public Object resetPassword(@RequestBody User requestUser){
        User user = userService.getUserByname(requestUser.getUsername());
        //重新设置
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        user.setSalt(salt);
        String encodedPassword = new SimpleHash("md5", "123", salt, times).toString();
        user.setPassword(encodedPassword);
        userService.resetPassword(user);
        String message = "重置密码成功";
        return ResultUtil.OK(message);
    }
}
