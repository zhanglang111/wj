package com.evan.wj.Service;

import com.evan.wj.Pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Code by langlang on 2020/2/28
 */
@Service
public interface AdminService {

    public List<User> getAllUser();

    public int deleteUserInfo(int Uid);
}
