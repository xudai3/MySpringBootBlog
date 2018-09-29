package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.TagDO;
import org.springframework.stereotype.Repository;

@Repository
public interface TagDAO {
    int removeByPrimaryKey(Integer pkId);

    int save(TagDO record);

    int saveSelective(TagDO record);

    TagDO getByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(TagDO record);

    int updateByPrimaryKey(TagDO record);
}