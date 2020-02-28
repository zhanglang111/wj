package com.evan.wj.Mapper;

import com.evan.wj.Pojo.AdminPermission;
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
}
