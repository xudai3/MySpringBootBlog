package com.xd.myspringbootblog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xd.myspringbootblog.entity.Article;
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
    public Response initMainPage(@PathVariable int uid){
        System.out.println("Article List Init...");

        Response resp = new Response();

        List<Article> articles = articleService.listArticlesByUserId(uid);

        if(articles.isEmpty()){
            return resp.failure(StatusCode.RESULE_DATA_NONE);
        }else return resp.success(articles);
    }
}
