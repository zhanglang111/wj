package com.evan.wj.Service;

import com.evan.wj.Pojo.Category;
import org.springframework.stereotype.Service;

/**
 * Code by langlang on 2020/2/22
 */
@Service
public interface CategoryService {

    public Category listByCategory(int cid);
}
