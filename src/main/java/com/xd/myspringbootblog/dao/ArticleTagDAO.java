package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.ArticleTagDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleTagDAO {
    int removeByPrimaryKey(Integer pkId);

    int save(ArticleTagDO record);

    int saveSelective(ArticleTagDO record);

    ArticleTagDO getByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(ArticleTagDO record);

    int updateByPrimaryKey(ArticleTagDO record);
}