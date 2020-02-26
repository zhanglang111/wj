package com.evan.wj.Mapper;

import com.evan.wj.Pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Code by langlang on 2020/2/22
 */
@Mapper
public interface UserMapper {
    @Select("SELECT `user`.username,`user`.password,`user`.salt, `user`.`name`, `user`.phone, `user`.email FROM `user` WHERE `user`.`username` = #{username}")
    public User getUserByname(String username);

    @Insert("INSERT INTO `user`(`user`.username,`user`.`password`,`user`.salt,`user`.name,`user`.phone,`user`.email,`user`.enabled) \n" +
            "VALUES (#{username},#{password},#{salt},#{name},#{phone},#{email},#{enabled});")
    public int register(User user);
}
