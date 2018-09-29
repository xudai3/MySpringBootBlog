package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.UserCategoryDO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCategoryDAO {
    int deleteByPrimaryKey(Integer pkId);

    int insert(UserCategoryDO record);

    int insertSelective(UserCategoryDO record);

    UserCategoryDO selectByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(UserCategoryDO record);

    int updateByPrimaryKey(UserCategoryDO record);
}