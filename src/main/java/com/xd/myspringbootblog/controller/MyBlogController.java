package com.xd.myspringbootblog.controller;

import com.xd.myspringbootblog.entity.ArticleDO;
import com.xd.myspringbootblog.response.Response;
import com.xd.myspringbootblog.response.StatusCode;
import com.xd.myspringbootblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MyBlogController {
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/v1/users/{uid}/articles", method = RequestMethod.GET)
    public Response initMainPage(@PathVariable Integer uid){
        System.out.println("Article List Init...");

        Response resp = new Response();

        List<ArticleDO> articles = articleService.listArticlesByUserId(uid);

        if(articles.isEmpty()){
            return resp.failure(StatusCode.DATA_NOT_FOUND);
        }else return resp.success(articles);
    }
}
