package com.evan.wj.Mapper;

import com.evan.wj.Pojo.AdminRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Code by langlang on 2020/2/26
 */
@Mapper
public interface AdminRoleMenuMapper {

    @Select("SELECT admin_role_menu.* FROM admin_role_menu WHERE admin_role_menu.rid = #{Rid}")
    public List<AdminRoleMenu> findAllByRid(int Rid);
}
