package com.evan.wj.Service.Impl;

import com.evan.wj.Mapper.AdminRolePermissionMapper;
import com.evan.wj.Service.AdminRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Code by langlang on 2020/2/28
 */

@Service
public class AdminRolePermissionServiceImpl implements AdminRolePermissionService {

    @Autowired
    AdminRolePermissionMapper adminRolePermissionMapper;

    @Override
    public int deleteRolePerms(int Rid) {
        return adminRolePermissionMapper.deleteRolePerms(Rid);
    }

    @Override
    public int addRolePerms(int Pid) {
        return adminRolePermissionMapper.addRolePerms(Pid);
    }
}
