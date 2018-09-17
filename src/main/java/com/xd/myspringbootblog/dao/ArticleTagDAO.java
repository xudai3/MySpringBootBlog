package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.ArticleTagDO;
import com.xd.myspringbootblog.entity.ArticleTagDOKey;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleTagDAO {
    int removeArticleTagByArticleTagId(ArticleTagDOKey key);

    int saveArticleTag(ArticleTagDO record);

    int saveArticleTagSelective(ArticleTagDO record);

    ArticleTagDO getArticleTagByArticleTagId(ArticleTagDOKey key);

    int updateByArticleTagIdSelective(ArticleTagDO record);

    int updateByArticleTagId(ArticleTagDO record);
}