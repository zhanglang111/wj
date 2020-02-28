package com.evan.wj.Service;

import com.evan.wj.Pojo.AdminPermission;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Code by langlang on 2020/2/26
 */

@Service
public interface AdminPermissionService {

    public Set<String> listPermissionURLsByUser(String username);

    public List<AdminPermission> listPermsByRoleId(int Rid);
}
