package com.evan.wj.Mapper;

import com.evan.wj.Pojo.AdminMenu;
import com.evan.wj.Pojo.AdminRoleMenu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    @Delete("DELETE FROM `admin_role_menu` WHERE `admin_role_menu`.rid = #{Rid}")
    public int deleteRoleMenu(int Rid);

    @Insert("INSERT INTO `admin_role_menu`(`admin_role_menu`.rid,`admin_role_menu`.mid) VALUES(#{Rid},#{Mid})")
    public int editRoleMenu(int Rid, int Mid);
}
