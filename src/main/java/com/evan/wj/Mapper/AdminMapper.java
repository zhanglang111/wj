package com.evan.wj.Mapper;

import com.evan.wj.Pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Code by langlang on 2020/2/28
 */
@Mapper
public interface AdminMapper {

    @Select("SELECT `user`.* FROM `user`")
    public List<User> getAllUser();

    //删除用户
    @Delete("DELETE FROM `user` WHERE `user`.id = #{Uid}")
    public int deleteUser(int Uid);

}
