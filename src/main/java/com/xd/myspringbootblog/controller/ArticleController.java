package com.xd.myspringbootblog.controller;

import com.xd.myspringbootblog.entity.ArticleDO;
import com.xd.myspringbootblog.entity.UserDO;
import com.xd.myspringbootblog.response.Response;
import com.xd.myspringbootblog.response.StatusCode;
import com.xd.myspringbootblog.service.ArticleService;
import com.xd.myspringbootblog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin
@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    UserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(
            value = "/v1/articles/{aid}",
            method = RequestMethod.GET)
    public Response getArticle(@PathVariable("aid") int aid){
        System.out.println("getting article...");

        Response resp = new Response();

        ArticleDO article = articleService.getArticleByArticleId(aid);
        if(article == null){
            System.out.println("Not Found...");
            return resp.failure(StatusCode.DATA_NOT_FOUND);
        }else return resp.success(article);
    }

    @RequestMapping(
            value = "/v1/articles",
            method = RequestMethod.POST)
    public Response saveArticle(@RequestBody ArticleDO article){
        System.out.println("adding article...");

        Response resp = new Response();
        UserDO articleAuthor = new UserDO();
        boolean sqlSuccess = false;

        try{
            articleAuthor = userService.getUserByUserId(article.getUserId());
            if(articleAuthor == null){
                System.out.println("Can not get articleAuthor");
                return resp.failure(StatusCode.DATA_NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        article.setArticleAuthor(articleAuthor.getUserName());
        article.setArticleStatus(article.getArticleStatus());
        Date articleCreateDate = new Date();
        article.setGmtCreate(articleCreateDate);
        article.setGmtModified(articleCreateDate);
        try{
            sqlSuccess = articleService.saveArticle(article);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(sqlSuccess) return resp.success();
        else return resp.failure(StatusCode.DATA_IS_WRONG);
    }

    @RequestMapping(
            value = "/v1/articles",
            method = RequestMethod.PUT,
            produces = "application/json",
            consumes = "application/json")
    public Response updateArticle(@RequestBody ArticleDO article){
        Response resp = new Response();
        article.setGmtModified(new Date());

        boolean sqlSuccess = articleService.updateArticleByArticleId(article);

        System.out.println("updating...");
        if(sqlSuccess) return resp.success();
        else return resp.failure(StatusCode.DATA_IS_WRONG);
    }
    @RequestMapping(
            value = "/v1/articles",
            method = RequestMethod.DELETE)
    public Response removeArticle(@RequestParam("articleId") int articleId){
        Response resp = new Response();
        boolean sqlSuccess = false;
        System.out.println("deleting...");
        try{
            sqlSuccess = articleService.removeArticleByArticleId(articleId);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(sqlSuccess) return resp.success();
        else return resp.failure(StatusCode.DATA_IS_WRONG);
    }

}
