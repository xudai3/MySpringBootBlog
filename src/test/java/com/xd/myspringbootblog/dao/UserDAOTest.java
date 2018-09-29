package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void removeByPrimaryKey() throws Exception {
    }

    @Test
    public void save() throws Exception {
        UserDO user = new UserDO();
        user.setNickname("xudai1");
        user.setAvatar("/static/avatar/default.png");
        user.setCredit(0);
        userDAO.save(user);
    }

    @Test
    public void saveSelective() throws Exception {
    }

    @Test
    public void getByPrimaryKey() throws Exception {
    }

    @Test
    public void listAll() throws Exception {
        List<UserDO> userList = new ArrayList<UserDO>();
        userList = userDAO.listAll();

    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

    @Test
    public void updateCreditByPrimaryKey() throws Exception {
    }

}