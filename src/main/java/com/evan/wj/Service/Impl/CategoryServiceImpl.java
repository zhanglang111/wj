package com.evan.wj.Service.Impl;

import com.evan.wj.Mapper.CategoryMapper;
import com.evan.wj.Pojo.Category;
import com.evan.wj.Service.CategoryService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Code by langlang on 2020/2/22
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public Category listByCategory(int cid) {
        return categoryMapper.listByCategory(cid);
    }
}
