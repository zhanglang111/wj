package com.evan.wj.Controller;

import com.alibaba.fastjson.JSONArray;
import com.evan.wj.Pojo.jotterArticle;
import com.evan.wj.Service.ArticleService;
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

        List<JSONArray> jsonObjectList = new ArrayList<>();
        List<jotterArticle> articlelist = articleService.getArticleByPage(page, pageSize);
        List<jotterArticle> allArticlelist = articleService.getArticleList();
        JSONArray jsonArray1 = (JSONArray) JSONArray.toJSON(articlelist);
        JSONArray jsonArray2 = (JSONArray) JSONArray.toJSON(allArticlelist);
////        String articlelistString = jsonArray1.toString();
////        String allArticlelistString = jsonArray2.toString();
////        List<String> stringList = new ArrayList<>();

        jsonObjectList.add(jsonArray1);
        jsonObjectList.add(jsonArray2);
        return jsonObjectList;
    }
}
