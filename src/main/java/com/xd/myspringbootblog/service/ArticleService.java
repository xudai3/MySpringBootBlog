package com.xd.myspringbootblog.service;

import com.xd.myspringbootblog.dao.ArticleDao;
import com.xd.myspringbootblog.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<Article> listArticlesByUserId(int userId){
        List<Article> articlesList = new ArrayList<Article>();
        try {
            articlesList = articleDao.listArticlesByUserId(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return articlesList;
    }

    @Cacheable(value = "articleId", key = "#articleId")
    public Article getArticleByArticleId(int articleId){
//        String key = "articleId_" + articleId;
//        ValueOperations<String, Article> ops = redisTemplate.opsForValue();
//        boolean hasKey = redisTemplate.hasKey(key);
//        if(hasKey){
//            System.out.println("Already has key:" + key);
//            return ops.get(key);
//        }
//        System.out.println("Have not found key:" + key);
//        Article article = articleDao.getArticleByArticleId(articleId);
//        ops.set(key, article, 5, TimeUnit.MINUTES);
//        return article;
         return articleDao.getArticleByArticleId(articleId);
    }
    public List<Article> listArticlesByTagId(int tagId){
        return articleDao.listArticlesByTagId(tagId);
    }
    public boolean saveArticle(Article article){
        boolean flag = false;
        try{
            articleDao.saveArticle(article);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public boolean removeArticleByArticleId(int articleId){
        boolean flag = false;
        try{
            articleDao.removeArticleByArticleId(articleId);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public boolean updateArticle(Article article){
        boolean flag = false;
        try{
            articleDao.updateArticle(article);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
