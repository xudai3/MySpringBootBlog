package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.LoginLogDO;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginLogDAO {
    int removeLoginLogByLoginLogId(Integer pkLoginLogId);

    int saveLoginLog(LoginLogDO record);

    int saveLoginLogSelective(LoginLogDO record);

    LoginLogDO getLoginLogByLoginLogId(Integer pkLoginLogId);

    int updateByLoginLogIdSelective(LoginLogDO record);

    int updateByLoginLogId(LoginLogDO record);
}