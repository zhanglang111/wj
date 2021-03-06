package com.evan.wj.Mapper;

import com.evan.wj.Pojo.AdminRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Code by langlang on 2020/2/26
 */
@Mapper
public interface AdminRoleMapper {
    @Select("SELECT admin_permission.*  FROM admin_permission, admin_role_permission,admin_role WHERE admin_role.id = #{Rid} AND admin_role_permission.rid = admin_role.id AND admin_permission.id = admin_role_permission.pid")
    public AdminRole selectRoleByIdWithPermission(int Rid);

    @Select("SELECT admin_role.* FROM admin_user_role, admin_role WHERE admin_user_role.uid = #{Uid} AND admin_role.id = admin_user_role.rid")
    public List<AdminRole> getRoleByUserid(int Uid);

    @Select("SELECT admin_role.* FROM admin_role")
    public List<AdminRole> findAll();

    @Delete("DELETE FROM `admin_role` WHERE `admin_role`.id = #{Rid}")
    public int deleteRole(int Rid);

    @Update("UPDATE `admin_role` SET `admin_role`.enabled = #{value} WHERE `admin_role`.id = #{Rid}")
    public int EnableStatus(boolean value,int Rid);

    @Update("UPDATE `admin_role` SET `admin_role`.name_zh = #{name_zh} WHERE `admin_role`.name = #{name}")
    public int  UpdateRoleInfo(AdminRole adminRole);

}
