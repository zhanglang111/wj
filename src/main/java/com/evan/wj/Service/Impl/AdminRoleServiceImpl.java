package com.evan.wj.Service.Impl;

import com.evan.wj.Mapper.AdminRoleMapper;
import com.evan.wj.Pojo.AdminMenu;
import com.evan.wj.Pojo.AdminPermission;
import com.evan.wj.Pojo.AdminRole;
import com.evan.wj.Service.AdminMenuService;
import com.evan.wj.Service.AdminPermissionService;
import com.evan.wj.Service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Code by langlang on 2020/2/26
 */

@Service
public class AdminRoleServiceImpl implements AdminRoleService {

    @Autowired
    AdminRoleMapper adminRoleMapper;

    @Autowired
    AdminPermissionService adminPermissionService;

    @Autowired
    AdminMenuService adminMenuService;

    @Override
    public AdminRole selectRoleByIdWithPermission(int id) {
        return adminRoleMapper.selectRoleByIdWithPermission(id);
    }

    public List<AdminRole> list() {
        List<AdminRole> roles = findAll();
        List<AdminPermission> perms;
        List<AdminMenu> menus;
        for (AdminRole role : roles) {
            perms = adminPermissionService.listPermsByRoleId(role.getId());
            menus = adminMenuService.getMenusByRoleId(role.getId());
            role.setPerms(perms);
            role.setMenus(menus);
        }
        return roles;
    }

    public List<AdminRole> findAll(){
        return adminRoleMapper.findAll();
    }


}
