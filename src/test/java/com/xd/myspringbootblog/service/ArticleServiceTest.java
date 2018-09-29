package com.xd.myspringbootblog.service;

import com.xd.myspringbootblog.model.ArticleVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void listArticlesByAuthorUid() throws Exception {
        Integer authorUid = 1;
        Integer cursor = 0;
        List<ArticleVO> articleVOList = articleService.listArticlesByAuthorUid(authorUid, cursor);
        for (ArticleVO articleVO : articleVOList){
            System.out.println(articleVO.toString());
        }
        articleVOList.clear();
        cursor += 15;
        articleVOList = articleService.listArticlesByAuthorUid(authorUid, cursor);
        for (ArticleVO articleVO : articleVOList){
            System.out.println(articleVO.toString());
        }

    }

    @Test
    public void getArticleByArticleId() throws Exception {
        ArticleVO articleVO = new ArticleVO();
        articleVO = articleService.getArticleByArticleId(3);
        System.out.println(articleVO.toString());
    }

    @Test
    public void saveArticle() throws Exception {
        for (int i = 0; i < 15; i++) {
            ArticleVO articleVO = new ArticleVO();
            articleVO.setArticleAuthor("xudai");
            articleVO.setArticleContent("#1 ##2 testContent");
            articleVO.setArticleStatus("public");
            articleVO.setArticleTitle("testTitle");
            articleVO.setAuthorUid(1);
            System.out.println(articleVO.toString());
            articleService.saveArticle(articleVO);
        }
    }

    @Test
    public void removeArticleByArticleId() throws Exception {
        Integer articleId = 4;
        articleService.removeArticleByArticleId(articleId);
    }

    @Test
    public void updateArticleByArticleId() throws Exception {
    }

}