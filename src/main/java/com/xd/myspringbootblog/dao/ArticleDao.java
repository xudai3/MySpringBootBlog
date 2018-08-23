package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao {

    List<Article> listArticlesByUserId(int userId);

    Article getArticleByArticleId(int articleId);

    List<Article> listArticlesByTagId(int tagId);

    boolean saveArticle(Article article);

    boolean removeArticleByArticleId(int articleId);

    boolean updateArticle(Article article);
}
