package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    int removeUserByUserId(Integer pkUserId);

    int saveUser(UserDO userDO);

    int saveUserSelective(UserDO userDO);

    UserDO getUserByUserId(Integer pkUserId);

    UserDO getUserByUserName(String userName);

    List<UserDO> listAllUsers();

    int updateByUserIdSelective(UserDO userDO);

    int updateByUserId(UserDO userDO);

    int countMatchLoginUser(UserDO userDO);
}