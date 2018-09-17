package com.xd.myspringbootblog.service;

import com.xd.myspringbootblog.dao.LoginLogDAO;
import com.xd.myspringbootblog.dao.UserDAO;
import com.xd.myspringbootblog.entity.LoginLogDO;
import com.xd.myspringbootblog.entity.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@ComponentScan({"com.xd.myspringbootblog.dao"})
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private LoginLogDAO loginLogDAO;
    @Autowired
    private RedisTemplate redisTemplate;

    public boolean countMatchLoginUser(UserDO user){
        int matchCount = userDAO.countMatchLoginUser(user);
        return matchCount > 0;
    }

    public boolean saveUser(UserDO user){
        boolean flag = false;
        try{
            userDAO.saveUser(user);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public boolean removeUserByUserId(Integer userId){
//        boolean flag = false;
//        String key = "userId_" + userId;
//        ValueOperations<String, User> valueOperations = redisTemplate.opsForValue();
//        boolean hasKey = redisTemplate.hasKey(key);
//        if(hasKey){
//            System.out.println("Already has key:" + key);
//            redisTemplate.delete(key);
//        }
//        return flag;

        return userDAO.removeUserByUserId(userId) > 0 ? true : false;

    }

    public UserDO getUserByUserName(String userName){
        return userDAO.getUserByUserName(userName);
    }

    @Cacheable(value = "10m", key = "'userId_' + #userId")
    public UserDO getUserByUserId(Integer userId) {
//        String key = "userId_" + userId;
//        ValueOperations<String, User> valueOperations = redisTemplate.opsForValue();
//        boolean hasKey = redisTemplate.hasKey(key);
//        if(hasKey){
//            System.out.println("Already has key:" + key);
//            return valueOperations.get(key);
//        }
//        System.out.println("Have not found key:" + key);
//        User user = userDAO.getUserByUserId(userId);
//        valueOperations.set(key, user, 2, TimeUnit.MINUTES);
//        return user;
        return userDAO.getUserByUserId(userId);
    }

    public List<UserDO> listAllUsers(){
        return userDAO.listAllUsers();
    }

    public void loginSuccess(UserDO user){
        user.setCredit(5 + user.getCredit());
        LoginLogDO loginLog = new LoginLogDO();
        loginLog.setUserId(user.getPkUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDAO.updateByUserId(user);
        loginLogDAO.saveLoginLog(loginLog);
    }
}
