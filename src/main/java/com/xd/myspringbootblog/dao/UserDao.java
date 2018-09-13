package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    int countMatchLoginUser(User user);

    User getUserByUserId(Integer userId);

    User getUserByUserName(String userName);

    boolean saveUser(User user);

    boolean removeUser(Integer userId);

    List<User> listUsers();

    boolean updateLoginInfo(User user);

}
