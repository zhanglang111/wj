package com.evan.wj.Service.Impl;

import com.evan.wj.Mapper.UserMapper;
import com.evan.wj.Pojo.User;
import com.evan.wj.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Code by langlang on 2020/2/22
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByname(String username) {
        return userMapper.getUserByname(username);
    }
}
