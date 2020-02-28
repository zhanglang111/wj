package com.evan.wj.Service.Impl;

import com.evan.wj.Mapper.AdminUserRoleMapper;
import com.evan.wj.Pojo.AdminRole;
import com.evan.wj.Pojo.AdminUserRole;
import com.evan.wj.Service.AdminUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Code by langlang on 2020/2/26
 */
@Service
public class AdminUserRoleServiceImpl implements AdminUserRoleService {


    @Autowired
    AdminUserRoleMapper adminUserRoleMapper;

    @Override
    public List<AdminUserRole> listAllByUid(int uid) {
        return adminUserRoleMapper.listAllByUid(uid);
    }

    @Override
    public int deleteUserRole(int Uid) {
        return adminUserRoleMapper.deleteUserRole(Uid);
    }

    @Override
    public void editUserRole(int Uid,List<AdminRole> roles) {
        adminUserRoleMapper.deleteUserRole(Uid);
        for (AdminRole role:roles) {
            adminUserRoleMapper.insertUserRoleByUid(Uid,role.getId());
        }
    }
}
