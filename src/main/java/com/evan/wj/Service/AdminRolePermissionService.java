package com.evan.wj.Service;

import org.springframework.stereotype.Service;

/**
 * Code by langlang on 2020/2/28
 */
@Service
public interface AdminRolePermissionService {
    public int deleteRolePerms(int Rid);

    public int addRolePerms(int Pid);
}
