package com.xd.myspringbootblog.authorization.manager;

import com.auth0.jwt.interfaces.Claim;
import com.xd.myspringbootblog.authorization.entity.Token;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xd.myspringbootblog.authorization.entity.Token;
import com.xd.myspringbootblog.authorization.manager.JWTTokenManager;
import com.xd.myspringbootblog.config.Constants;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTTokenManager {

    public Token createToken(Integer userId) {
        Date iatDate = new Date();
        Calendar nowDate = Calendar.getInstance();
        nowDate.add(Calendar.MINUTE, 5);
        Date expireDate = nowDate.getTime();
        Map<String, Object> headerMap = new HashMap<String, Object>();
        headerMap.put("alg", "HS256");
        headerMap.put("typ", "JWT");
        String tokenStr = JWT.create()
                .withHeader(headerMap)
                .withClaim("uid", userId.toString())
                .withClaim("proj", "Blog")
                .withClaim("org", "XD")
                .withExpiresAt(expireDate)
                .withIssuedAt(iatDate)
                .sign(Algorithm.HMAC256(Constants.PUBLIC_SECRET));

        Token token = new Token(userId, tokenStr);
        return token;
    }

    public Map<String, Claim> checkToken(Token token){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(Constants.PUBLIC_SECRET))
                .build();
        DecodedJWT jwt = null;
        try{
            jwt = jwtVerifier.verify(token.getToken());
        }catch (Exception e){
            throw new RuntimeException("Token Expired, Please Login Again");
        }

        return jwt.getClaims();
    }
}
