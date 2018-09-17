package com.xd.myspringbootblog.service;

import com.xd.myspringbootblog.dao.ArticleDAO;
import com.xd.myspringbootblog.entity.ArticleDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleDAO articleDAO;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<ArticleDO> listArticlesByUserId(int userId){
        List<ArticleDO> articlesList = new ArrayList<ArticleDO>();
        try {
            articlesList = articleDAO.listArticlesByUserId(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return articlesList;
    }

    @Cacheable(value = "articleId", key = "#articleId")
    public ArticleDO getArticleByArticleId(int articleId){
//        String key = "articleId_" + articleId;
//        ValueOperations<String, Article> ops = redisTemplate.opsForValue();
//        boolean hasKey = redisTemplate.hasKey(key);
//        if(hasKey){
//            System.out.println("Already has key:" + key);
//            return ops.get(key);
//        }
//        System.out.println("Have not found key:" + key);
//        Article article = articleDAO.getArticleByArticleId(articleId);
//        ops.set(key, article, 5, TimeUnit.MINUTES);
//        return article;
         return articleDAO.getArticleByArticleId(articleId);
    }
    public List<ArticleDO> listArticlesByTagId(int tagId){
        return articleDAO.listArticlesByTagId(tagId);
    }
    public boolean saveArticle(ArticleDO article){
        boolean flag = false;
        try{
            articleDAO.saveArticle(article);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public boolean removeArticleByArticleId(int articleId){
        boolean flag = false;
        try{
            articleDAO.removeArticleByArticleId(articleId);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public boolean updateArticleByArticleId(ArticleDO article){
        boolean flag = false;
        try{
            articleDAO.updateArticleByArticleId(article);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
