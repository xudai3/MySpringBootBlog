package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.ArticleContentDO;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleContentDAO {
    int removeByPrimaryKey(Integer pkId);

    int save(ArticleContentDO record);

    int saveSelective(ArticleContentDO record);

    ArticleContentDO getByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(ArticleContentDO record);

    int updateByPrimaryKeyWithBLOBs(ArticleContentDO record);

    int updateByPrimaryKey(ArticleContentDO record);
}