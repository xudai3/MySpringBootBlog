package com.xd.myspringbootblog.controller;

import com.xd.myspringbootblog.authorization.entity.Token;
import com.xd.myspringbootblog.authorization.manager.JWTTokenManager;
import com.xd.myspringbootblog.entity.UserAuthDO;
import com.xd.myspringbootblog.entity.UserDO;
import com.xd.myspringbootblog.response.Response;
import com.xd.myspringbootblog.response.StatusCode;
import com.xd.myspringbootblog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private JWTTokenManager tokenManager;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/v1/session", method = RequestMethod.GET)
    public Response getToken(){
        Response resp = new Response();
        return resp;
    }

    @RequestMapping(value = "/v1/session", method = RequestMethod.DELETE)
    public Response signOut(){
        Response resp = new Response();
        return resp;
    }

    @RequestMapping(
            value = "/v1/session",
            method = RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json")
    public Response signIn(@RequestBody UserAuthDO userAuth, HttpServletRequest request){
        logger.info("sign_in...");

        Response resp = new Response();
        boolean isValidUser = userService.countMatchLoginUser(userAuth);
        if(!isValidUser){
            return resp.failure(StatusCode.USER_LOGIN_ERROR);
        }


        String loginIp = request.getRemoteAddr();
        Date loginDate = new Date();
        userAuth.setLastIp(loginIp);
        userAuth.setLastVisit(loginDate);

        userService.loginSuccess(userAuth);

        Token token = tokenManager.createToken(userAuth.getUserId());

        return resp.success(token);

    }

    @RequestMapping(
            value = "/v1/session",
            method = RequestMethod.PUT)
    public Response updateSession(){
        Response resp = new Response();
        return resp;
    }
}
