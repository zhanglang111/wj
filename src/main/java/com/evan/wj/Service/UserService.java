package com.evan.wj.Service;

import com.evan.wj.Pojo.User;
import org.springframework.stereotype.Service;

/**
 * Code by langlang on 2020/2/22
 */

@Service
public interface UserService {
    public User getUserByname(String username);

    public int register(User user);

    public int EnableStatus(boolean value,int id);

    public int UpdateUserInfo(User user);

    public int resetPassword(User user);

}
