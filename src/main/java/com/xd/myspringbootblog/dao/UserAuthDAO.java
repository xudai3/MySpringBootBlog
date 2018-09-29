package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.UserAuthDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAuthDAO {
    int removeByPrimaryKey(Integer pkId);

    int save(UserAuthDO record);

    int saveSelective(UserAuthDO record);

    UserAuthDO getByPrimaryKey(Integer pkId);

    List<UserAuthDO> listAll();

    int countLoginAuth(String authType, String authIdentifier);

    int updateByPrimaryKeySelective(UserAuthDO record);

    int updateByPrimaryKey(UserAuthDO record);
}