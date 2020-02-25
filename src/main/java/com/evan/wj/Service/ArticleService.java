package com.evan.wj.Service;

import com.evan.wj.Pojo.jotterArticle;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Code by langlang on 2020/2/24
 */
@Service
public interface ArticleService {

    public int AddOrUpdate(jotterArticle jotterArticle);

    public List<jotterArticle> getArticleList();

    public jotterArticle getArticleDetail(int id);

    public List<jotterArticle>  getArticleByPage(int pageNo,int pageSize);
}
