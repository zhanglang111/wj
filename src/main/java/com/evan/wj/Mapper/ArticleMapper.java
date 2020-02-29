package com.evan.wj.Mapper;

import com.evan.wj.Pojo.jotterArticle;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Code by langlang on 2020/2/24
 */
@Mapper
public interface ArticleMapper {
    @Insert("INSERT INTO jotter_article(jotter_article.article_title,jotter_article.article_date,jotter_article.article_cover,jotter_article.article_content_md,jotter_article.article_content_html,jotter_article.article_abstract) VALUES (#{articleTitle}," +
            "NOW(),#{articleCover},#{articleContentMd},#{articleContentHtml},#{articleAbstract})")
    public int AddOrUpdate(jotterArticle jotterArticle);

    @Select("SELECT * FROM jotter_article")
    public List<jotterArticle> getArticleList();

    @Select("SELECT * FROM jotter_article WHERE jotter_article.id = #{id}")
    public jotterArticle getArticleDetail(int id);

    @Select("SELECT * FROM jotter_article LIMIT #{startPageindex},#{pageSize}")
    public List<jotterArticle>  getArticleByPage(int startPageindex,int pageSize);

    @Delete("DELETE FROM jotter_article WHERE jotter_article.id = #{aid}")
    public void deleteArticle(int aid);
}
