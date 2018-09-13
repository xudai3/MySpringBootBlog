package com.xd.myspringbootblog.authorization.manager;

import com.auth0.jwt.interfaces.Claim;
import com.xd.myspringbootblog.authorization.entity.Token;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JWTTokenManagerTest {

    @Autowired
    private JWTTokenManager tokenManager;

    @Test
    public void createToken() throws Exception {
        Integer userId = 1;
        Token token = tokenManager.createToken(userId);
        String tokenStr =
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOiIxIiwib3JnIjoiWEQiLCJwcm9qIjoiQmxvZyIsImV4cCI6MTUzNjQ5NzQyMywiaWF0IjoxNTM2NDk3MTIzfQ.SdR1JjKJuc0Kdqsv9gjH_dfWNGFRkAlA9-bsHXsAzlw";
        Assert.assertNotEquals(tokenStr, token.getToken());
        System.out.println(token.getToken());
    }

    @Test
    public void checkToken() throws Exception {
        Integer userId = 1;
        Token token = tokenManager.createToken(userId);
        Map<String, Claim> claims = tokenManager.checkToken(token);
//        for (Map.Entry<String, Claim> entry : claims.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue().asString());
//        }
        String uid = "1";
        String org = "XD";
        String proj = "Blog";
        Assert.assertEquals(uid, claims.get("uid").asString());
        Assert.assertEquals(org, claims.get("org").asString());
        Assert.assertEquals(proj, claims.get("proj").asString());

        System.out.println(claims.get("exp").asDate());
        System.out.println(claims.get("iat").asDate());
//        System.out.println(claims.get("jti").asString());
    }

}