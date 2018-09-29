package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.ReplyDO;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyDAO {
    int removeByPrimaryKey(Integer pkId);

    int save(ReplyDO record);

    int saveSelective(ReplyDO record);

    ReplyDO getByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(ReplyDO record);

    int updateByPrimaryKey(ReplyDO record);
}