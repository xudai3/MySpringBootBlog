package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginLogDao {

    boolean saveLoginLog(LoginLog loginLog);
}
