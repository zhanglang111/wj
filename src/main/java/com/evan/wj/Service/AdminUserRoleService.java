package com.evan.wj.Service;

import com.evan.wj.Pojo.AdminRole;
import com.evan.wj.Pojo.AdminUserRole;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Code by langlang on 2020/2/26
 */

@Service
public interface AdminUserRoleService {
    //通过用户id查询用户角色
    public List<AdminUserRole> listAllByUid(int uid);

    //删除用户对应的角色
    public int deleteUserRole(int Uid);

    //设置用户时，对用户的角色进行编辑
    public void editUserRole(int Uid,List<AdminRole> roles);
}
