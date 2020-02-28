package com.evan.wj.Service.Impl;

import com.evan.wj.Mapper.AdminMenuMapper;
import com.evan.wj.Pojo.AdminMenu;
import com.evan.wj.Pojo.AdminRoleMenu;
import com.evan.wj.Pojo.AdminUserRole;
import com.evan.wj.Pojo.User;
import com.evan.wj.Service.AdminMenuService;
import com.evan.wj.Service.AdminRoleMenuService;
import com.evan.wj.Service.AdminUserRoleService;
import com.evan.wj.Service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Code by langlang on 2020/2/26
 */
@Service
public class AdminMenuServiceImpl implements AdminMenuService {

    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminRoleMenuService adminRoleMenuService;

    @Autowired
    AdminMenuMapper adminMenuMapper;

    @Override
    public List<AdminMenu> getMenusByCurrentUser() {
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.getUserByname(username);
        //该用户的所有角色
        List<AdminUserRole> userRoleList = adminUserRoleService.listAllByUid(user.getId());
        List<AdminMenu> menus = new ArrayList<>();
        for (AdminUserRole userRole : userRoleList) {
            //该角色下的所有菜单
            List<AdminRoleMenu> rms = adminRoleMenuService.findAllByRid(userRole.getRid());
            for (AdminRoleMenu rm : rms) {
                //对菜单进行剔除
                // 增加防止多角色状态下菜单重复的逻辑
                AdminMenu menu = getMenusByMid(rm.getMid());
                boolean isExist = false;
                for (AdminMenu m : menus) {
                    if (m.getId() == menu.getId()) {
                        isExist = true;
                    }
                }
                if (!isExist) {
                    menus.add(menu);
                }
            }
        }
        handleMenus(menus);
        return menus;
    }

    @Override
    public AdminMenu getMenusByMid(int Mid) {
        return adminMenuMapper.getMenusByMid(Mid);
    }

    @Override
    public List<AdminMenu> getMenusByRoleId(int Rid) {
        return adminMenuMapper.getMenusByRoleId(Rid);
    }

    @Override
    public List<AdminMenu> listMenus() {
        return adminMenuMapper.listMenus();
    }

    public void handleMenus(List<AdminMenu> menus) {
        for (AdminMenu menu : menus) {
            //将父节点的所有子节点找出来。
            menu.setChildren(findAllByParentId(menu.getId()));
        }

        Iterator<AdminMenu> iterator = menus.iterator();
        while (iterator.hasNext()) {
            AdminMenu menu = iterator.next();
            if (menu.getParentId() != 0) {
                iterator.remove();
            }
        }
    }

    public List<AdminMenu> findAllByParentId(int parentId){
        return adminMenuMapper.findAllByParentId(parentId);
    }
}
