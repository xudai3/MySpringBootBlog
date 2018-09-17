package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.ArticleDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDAO {
    int removeArticleByArticleId(Integer pkArticleId);

    int saveArticle(ArticleDO record);

    int saveArticleSelective(ArticleDO record);

    ArticleDO getArticleByArticleId(Integer pkArticleId);

    List<ArticleDO> listArticlesByUserId(Integer userId);

    List<ArticleDO> listArticlesByTagId(Integer tagId);

    int updateArticleByArticleIdSelective(ArticleDO record);

    int updateArticleByArticleIdWithBLOBs(ArticleDO record);

    int updateArticleByArticleId(ArticleDO record);
}