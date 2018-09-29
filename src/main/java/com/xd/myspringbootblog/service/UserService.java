package com.xd.myspringbootblog.service;

import com.xd.myspringbootblog.dao.LoginLogDAO;
import com.xd.myspringbootblog.dao.UserAuthDAO;
import com.xd.myspringbootblog.dao.UserDAO;
import com.xd.myspringbootblog.entity.LoginLogDO;
import com.xd.myspringbootblog.entity.UserAuthDO;
import com.xd.myspringbootblog.entity.UserDO;
import com.xd.myspringbootblog.model.UserVO;
import org.springframework.beans.BeanUtils;
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
    private UserAuthDAO userAuthDAO;
    @Autowired
    private LoginLogDAO loginLogDAO;
    @Autowired
    private RedisTemplate redisTemplate;

    public boolean countMatchLoginUser(UserAuthDO userAuth){
        int matchCount = userAuthDAO.countLoginAuth(userAuth.getAuthType(), userAuth.getAuthIdentifier());
        return matchCount > 0;
    }

    public boolean saveUser(UserVO user){
        boolean flag = false;
        try{
            UserDO userDO = new UserDO();
            UserAuthDO userAuthDO = new UserAuthDO();
            BeanUtils.copyProperties(userDO, user);
            BeanUtils.copyProperties(userAuthDO, user);
            userDAO.save(userDO);
            userAuthDAO.save(userAuthDO);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean saveUserAuth(UserAuthDO userAuth){
        boolean flag = false;
        try{
            userAuthDAO.save(userAuth);
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

        return userDAO.removeByPrimaryKey(userId) > 0 ? true : false;

    }


//    @Cacheable(value = "10m", key = "'userId_' + #userId")
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
        return userDAO.getByPrimaryKey(userId);
    }

    public List<UserDO> listAllUsers(){
        return userDAO.listAll();
    }

    public void loginSuccess(UserAuthDO userAuth){

        LoginLogDO loginLog = new LoginLogDO();
        loginLog.setIp(userAuth.getLastIp());
        loginLog.setLoginDate(userAuth.getLastVisit());
        userAuthDAO.updateByPrimaryKeySelective(userAuth);
        loginLogDAO.save(loginLog);
    }
}
