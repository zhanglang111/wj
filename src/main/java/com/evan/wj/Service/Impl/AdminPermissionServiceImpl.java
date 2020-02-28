package com.evan.wj.Service.Impl;

import com.evan.wj.Mapper.AdminPermissionMapper;
import com.evan.wj.Pojo.AdminMenu;
import com.evan.wj.Pojo.AdminPermission;
import com.evan.wj.Pojo.AdminRole;
import com.evan.wj.Service.AdminPermissionService;
import com.evan.wj.Service.AdminRolePermissionService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Code by langlang on 2020/2/26
 */

@Service
public class AdminPermissionServiceImpl implements AdminPermissionService {


    @Autowired
    AdminPermissionMapper adminPermissionMapper;

    @Autowired
    AdminRolePermissionService adminRolePermissionService;

    @Override
    public Set<String> listPermissionURLsByUser(String username) {
        //按照角色获取
        return null;
    }

    @Override
    public List<AdminPermission> listPermsByRoleId(int Rid) {
        //按照角色的id获取该角色的权限
        return adminPermissionMapper.listPermsByRoleId(Rid);
    }

    @Override
    public List<AdminRole> listRolesWithPermsWithMenu() {
        List<AdminRole> adminRoles = adminPermissionMapper.listRoles();
        for (AdminRole adminRole:adminRoles) {
            List<AdminPermission> adminPermissions = adminPermissionMapper.listPermsByRoleId(adminRole.getId());
            adminRole.setPerms(adminPermissions);
            List<AdminMenu> adminMenus = adminPermissionMapper.listMenusByRid(adminRole.getId());
            adminRole.setMenus(adminMenus);
        }
        return adminRoles;
    }

    @Override
    public List<AdminPermission> listPerms() {
        return adminPermissionMapper.listPerms();
    }

    @Override
    public void editRolePerms(int Rid, List<AdminPermission> permissions) {
        adminRolePermissionService.deleteRolePerms(Rid);
        for (AdminPermission adminPermission:permissions) {
            adminRolePermissionService.addRolePerms(adminPermission.getId());
        }
    }
}
