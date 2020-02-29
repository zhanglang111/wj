package com.evan.wj.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.evan.wj.Pojo.jotterArticle;
import com.evan.wj.Service.ArticleService;
import com.evan.wj.Utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Code by langlang on 2020/2/24
 */
@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PostMapping("/admin/content/article")
    public int AddOrUpdate(@RequestBody jotterArticle jotterArticle){
        return articleService.AddOrUpdate(jotterArticle);
    }

    @GetMapping("/getArticleList")
    public Object getArticleList(){
        List<jotterArticle> articleList = articleService.getArticleList();
        return articleList;
    }

    @GetMapping("/getArticleDetail/{id}")
    public Object getArticleList(@PathVariable int id){
        jotterArticle articleDetail = articleService.getArticleDetail(id);
        return articleDetail;
    }

    @GetMapping("/article/{pageSize}/{page}")
    public Object getArticleList(@PathVariable int pageSize,@PathVariable int page){

        JSONObject jsonObject = new JSONObject();
        List<jotterArticle> articlelist = articleService.getArticleByPage(page, pageSize);
        List<jotterArticle> allArticlelist = articleService.getArticleList();
        JSONArray jsonArray1 = (JSONArray) JSONArray.toJSON(articlelist);
        JSONArray jsonArray2 = (JSONArray) JSONArray.toJSON(allArticlelist);

        jsonObject.put("content",jsonArray1);
        jsonObject.put("totalElements",jsonArray2);

        return ResultUtil.OK(jsonObject);
    }

    //删除文章

    @DeleteMapping("/admin/content/article/{id}")
    public Object deleteArticle(@PathVariable int id){
        articleService.deleteArticle(id);
        return ResultUtil.OK();
    }
}
