package com.xd.myspringbootblog.authorization.manager;

import com.xd.myspringbootblog.authorization.entity.Token;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.xd.myspringbootblog.authorization.manager.TokenManager;
import com.xd.myspringbootblog.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class TokenManager {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public Token createToken(Integer userId) {
        System.out.println("create token...");
        String key = "userId_" + userId;
        String tokenStr  = UUID.randomUUID().toString().replace("-", "");
        Token token = new Token(userId, tokenStr);

        redisTemplate.boundValueOps(key).set(tokenStr, Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);

        return token;
    }

    public Token getToken(String authentication){
        if (authentication == null || authentication.length() == 0){
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2){
            return null;
        }

        Integer userId = Integer.valueOf(param[0]);
        String token = param[1];
        return new Token(userId, token);
    }

    public boolean checkToken(Token token) {
        if (token == null){
            return false;
        }
        String key = "userId_" + token.getUserId();
        String tokenStr = redisTemplate.boundValueOps(key).get();

        if (tokenStr == null || !tokenStr.equals(token.getToken())){
            return false;
        }

        redisTemplate.boundValueOps(key).expire(Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);

        return true;
    }

    public void deleteToken(Integer userId){
        redisTemplate.delete(userId.toString());
    }

}
