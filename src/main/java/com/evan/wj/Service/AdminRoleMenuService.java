package com.evan.wj.Service;

import com.evan.wj.Pojo.AdminMenu;
import com.evan.wj.Pojo.AdminRoleMenu;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Code by langlang on 2020/2/26
 */
@Service
public interface AdminRoleMenuService {
    List<AdminRoleMenu> findAllByRid(int Rid);

    public int deleteRoleMenu(int Rid);

    public void editRoleMenu(int Rid, List<AdminMenu> adminMenus);
}
