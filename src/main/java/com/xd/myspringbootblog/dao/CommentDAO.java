package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.CommentDO;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDAO {
    int removeByPrimaryKey(Integer pkId);

    int save(CommentDO record);

    int saveSelective(CommentDO record);

    CommentDO getByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(CommentDO record);

    int updateByPrimaryKey(CommentDO record);
}