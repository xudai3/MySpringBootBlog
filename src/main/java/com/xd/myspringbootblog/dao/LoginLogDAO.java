package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.LoginLogDO;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginLogDAO {
    int removeByPrimaryKey(Integer pkId);

    int save(LoginLogDO record);

    int saveSelective(LoginLogDO record);

    LoginLogDO getByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(LoginLogDO record);

    int updateByPrimaryKey(LoginLogDO record);
}