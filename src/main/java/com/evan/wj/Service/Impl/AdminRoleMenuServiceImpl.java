package com.evan.wj.Service.Impl;

import com.evan.wj.Mapper.AdminRoleMenuMapper;
import com.evan.wj.Pojo.AdminMenu;
import com.evan.wj.Pojo.AdminRoleMenu;
import com.evan.wj.Service.AdminRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Code by langlang on 2020/2/26
 */
@Service
public class AdminRoleMenuServiceImpl implements AdminRoleMenuService {

    @Autowired
    AdminRoleMenuMapper adminRoleMenuMapper;

    @Override
    public List<AdminRoleMenu> findAllByRid(int Rid) {
        return adminRoleMenuMapper.findAllByRid(Rid);
    }

    @Override
    public int deleteRoleMenu(int Rid) {
        return 0;
    }

    @Override
    public void editRoleMenu(int Rid, List<AdminMenu> adminMenus) {
        adminRoleMenuMapper.deleteRoleMenu(Rid);
        for (AdminMenu adminMenu:adminMenus) {
            adminRoleMenuMapper.editRoleMenu(Rid,adminMenu.getId());
        }
    }
}
