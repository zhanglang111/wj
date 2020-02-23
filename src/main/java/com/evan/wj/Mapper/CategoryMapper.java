package com.evan.wj.Mapper;

import com.evan.wj.Pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Code by langlang on 2020/2/22
 */
@Mapper
public interface CategoryMapper {

    @Select("SELECT\n" +
            "category.`name`\n" +
            "FROM\n" +
            "category\n" +
            "WHERE\n" +
            "category.id = #{cid}\n")
    public Category listByCategory(int cid);
}
