package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.ArticleDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDAO {
    int removeByPrimaryKey(Integer pkId);

    int save(ArticleDO record);

    int saveSelective(ArticleDO record);

    ArticleDO getByPrimaryKey(Integer pkId);

    List<ArticleDO> listAllByAuthorUid(Integer authorUid);

    List<ArticleDO> listAllByTagId(Integer tagId);

    int updateByPrimaryKeySelective(ArticleDO record);

    int updateByPrimaryKey(ArticleDO record);
}