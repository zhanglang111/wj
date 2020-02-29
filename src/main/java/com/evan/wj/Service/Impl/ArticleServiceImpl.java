package com.evan.wj.Service.Impl;

import com.evan.wj.Mapper.ArticleMapper;
import com.evan.wj.Pojo.jotterArticle;
import com.evan.wj.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Code by langlang on 2020/2/24
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Override
    public int AddOrUpdate(jotterArticle jotterArticle) {
        return articleMapper.AddOrUpdate(jotterArticle);
    }

    @Override
    public List<jotterArticle> getArticleList() {
        return articleMapper.getArticleList();
    }

    @Override
    public jotterArticle getArticleDetail(int id) {
        return articleMapper.getArticleDetail(id);
    }

    @Override
    public List<jotterArticle> getArticleByPage(int pageNo, int pageSize) {
        int startPageindex = (pageNo-1)*pageSize;
        return articleMapper.getArticleByPage(startPageindex,pageSize);
    }

    @Override
    public void deleteArticle(int aid) {
        articleMapper.deleteArticle(aid);
    }
}
