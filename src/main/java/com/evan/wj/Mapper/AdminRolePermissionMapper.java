package com.evan.wj.Mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Code by langlang on 2020/2/28
 */
@Mapper
public interface AdminRolePermissionMapper {

    @Delete("DELETE FROM `admin_role_permission` WHERE `admin_role_permission`.rid = #{Rid}")
    public int deleteRolePerms(int Rid);

    @Insert("INSERT INTO `admin_role_permission`(`admin_role_permission`.rid,`admin_role_permission`.pid) VALUES(#{Rid},#{Pid})")
    public int addRolePerms(int Pid);
}
