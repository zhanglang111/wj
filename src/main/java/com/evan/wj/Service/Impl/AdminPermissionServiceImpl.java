package com.evan.wj.Service.Impl;

import com.evan.wj.Mapper.AdminPermissionMapper;
import com.evan.wj.Pojo.AdminPermission;
import com.evan.wj.Service.AdminPermissionService;
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
}
