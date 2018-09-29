package com.xd.myspringbootblog.controller;

import com.xd.myspringbootblog.entity.ArticleDO;
import com.xd.myspringbootblog.model.ArticleVO;
import com.xd.myspringbootblog.response.Response;
import com.xd.myspringbootblog.response.StatusCode;
import com.xd.myspringbootblog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MyBlogController {
    @Autowired
    ArticleService articleService;

    private static final Logger logger = LoggerFactory.getLogger(MyBlogController.class);

    @RequestMapping(value = "/v1/users/{uid}/articles", method = RequestMethod.GET)
    public Response initMainPage(@PathVariable Integer uid){
        logger.info("Article List Init...");

        Response resp = new Response();

        Integer cursor = 0;
        List<ArticleVO> articles = articleService.listArticlesByAuthorUid(uid, cursor);

        if(articles.isEmpty()){
            return resp.failure(StatusCode.DATA_NOT_FOUND);
        }else return resp.success(articles);
    }
}
