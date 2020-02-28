package com.evan.wj.Service;

import com.evan.wj.Pojo.AdminRole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Code by langlang on 2020/2/26
 */

@Service
public interface AdminRoleService {
    public AdminRole selectRoleByIdWithPermission(int Rid);

    public List<AdminRole> list();
}
