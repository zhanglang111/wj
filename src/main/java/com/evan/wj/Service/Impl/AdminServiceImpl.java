package com.evan.wj.Service.Impl;

import com.evan.wj.Mapper.AdminMapper;
import com.evan.wj.Mapper.AdminRoleMapper;
import com.evan.wj.Pojo.AdminRole;
import com.evan.wj.Pojo.User;
import com.evan.wj.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Code by langlang on 2020/2/28
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    AdminRoleMapper adminRoleMapper;


    @Override
    public List<User> getAllUser() {
        List<User> users = adminMapper.getAllUser();

        for (User user:users) {
            List<AdminRole> roles =  adminRoleMapper.getRoleByUserid(user.getId());
            user.setRoles(roles);
        }
        return users;
    }

    @Override
    public int deleteUserInfo(int Uid) {
        return adminMapper.deleteUser(Uid);
    }
}
