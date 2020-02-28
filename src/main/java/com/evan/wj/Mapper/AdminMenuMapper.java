package com.evan.wj.Mapper;

import com.evan.wj.Pojo.AdminMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Code by langlang on 2020/2/27
 */
@Mapper
public interface AdminMenuMapper {

    @Select("SELECT admin_menu.* FROM admin_menu WHERE admin_menu.id = #{Mid}")
    public AdminMenu getMenusByMid(int Mid);

    @Select("SELECT admin_menu.* FROM admin_menu WHERE admin_menu.parent_id = #{parentId}")
    List<AdminMenu> findAllByParentId(int parentId);

    @Select("SELECT admin_menu.* FROM admin_role_menu, admin_menu WHERE admin_role_menu.mid = admin_menu.id AND admin_role_menu.rid = #{Rid}")
    List<AdminMenu> getMenusByRoleId(int Rid);

    @Select("SELECT admin_menu.* FROM admin_menu")
    public List<AdminMenu> listMenus();
}
