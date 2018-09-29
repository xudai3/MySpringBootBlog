package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    int removeByPrimaryKey(Integer pkId);

    int save(UserDO record);

    int saveSelective(UserDO record);

    UserDO getByPrimaryKey(Integer pkId);

    List<UserDO> listAll();

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    int updateCreditByPrimaryKey(Integer pkId, Integer credit);
}