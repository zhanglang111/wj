package com.evan.wj.Service;

import com.evan.wj.Pojo.AdminMenu;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Code by langlang on 2020/2/26
 */
@Service
public interface AdminMenuService {

    public List<AdminMenu> getMenusByCurrentUser();

    public AdminMenu getMenusByMid(int Mid);

    public List<AdminMenu> getMenusByRoleId(int Rid);

}
