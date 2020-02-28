package com.evan.wj.Mapper;

import com.evan.wj.Pojo.AdminMenu;
import com.evan.wj.Pojo.AdminRole;
import com.evan.wj.Pojo.AdminUserRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Code by langlang on 2020/2/26
 */

@Mapper
public interface AdminUserRoleMapper {

    @Select("SELECT admin_user_role.* FROM admin_user_role WHERE admin_user_role.uid = #{uid}")
    public List<AdminUserRole> listAllByUid(int uid);

    //删除用户对应的角色
    @Delete("DELETE FROM `admin_user_role` WHERE `admin_user_role`.uid = #{Uid}")
    public int deleteUserRole(int Uid);

    //设置用户的角色
    @Insert("INSERT INTO `admin_user_role`(`admin_user_role`.rid,`admin_user_role`.uid) VALUES(#{Rid},#{Uid})")
    public int insertUserRoleByUid(int Uid,int Rid);

}
