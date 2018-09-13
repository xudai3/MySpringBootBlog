package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao {

    List<Article> listArticlesByUserId(Integer userId);

    Article getArticleByArticleId(Integer articleId);

    List<Article> listArticlesByTagId(Integer tagId);

    boolean saveArticle(Article article);

    boolean removeArticleByArticleId(Integer articleId);

    boolean updateArticle(Article article);
}
