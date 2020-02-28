package com.evan.wj.Service;

import com.evan.wj.Pojo.AdminRoleMenu;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Code by langlang on 2020/2/26
 */
@Service
public interface AdminRoleMenuService {
    List<AdminRoleMenu> findAllByRid(int Rid);
}
