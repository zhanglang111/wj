package com.evan.wj.Mapper;

import com.evan.wj.Pojo.AdminMenu;
import com.evan.wj.Pojo.AdminPermission;
import com.evan.wj.Pojo.AdminRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Code by langlang on 2020/2/28
 */
@Mapper
public interface AdminPermissionMapper {

    @Select("SELECT admin_permission.* FROM admin_role_permission, admin_permission WHERE admin_role_permission.pid AND admin_role_permission.rid = #{Rid}")
    List<AdminPermission> listPermsByRoleId(int Rid);

    @Select("SELECT admin_role.* FROM admin_role")
    public List<AdminRole> listRoles();

    @Select("SELECT admin_permission.* FROM admin_role_permission, admin_permission WHERE admin_permission.id = admin_role_permission.pid AND admin_role_permission.rid = #{Rid}")
    public List<AdminPermission> listPermsByRid(int Rid);

    @Select("SELECT admin_menu.* FROM admin_role_menu, admin_menu WHERE admin_menu.id = admin_role_menu.mid AND admin_role_menu.rid = #{Rid}")
    public List<AdminMenu> listMenusByRid(int Rid);

    @Select("SELECT admin_permission.* FROM admin_permission")
    List<AdminPermission> listPerms();
}
