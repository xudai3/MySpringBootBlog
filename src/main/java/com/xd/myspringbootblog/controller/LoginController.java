package com.xd.myspringbootblog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xd.myspringbootblog.authorization.annotation.Authorization;
import com.xd.myspringbootblog.authorization.entity.Token;
import com.xd.myspringbootblog.authorization.manager.JWTTokenManager;
import com.xd.myspringbootblog.authorization.manager.TokenManager;
import com.xd.myspringbootblog.entity.User;
import com.xd.myspringbootblog.response.Response;
import com.xd.myspringbootblog.response.StatusCode;
import com.xd.myspringbootblog.service.UserService;
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
    public Response signIn(@RequestBody User user, HttpServletRequest request){
        System.out.println("sign_in...");

        Response resp = new Response();
        boolean isValidUser = userService.countMatchLoginUser(user);
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        if(!isValidUser){
            return resp.failure(StatusCode.USER_LOGIN_ERROR);
        }

        User loginUser = userService.getUserByUserName(user.getUserName());

        String loginIp = request.getRemoteAddr();
        Date loginDate = new Date();
        loginUser.setLastIp(loginIp);
        loginUser.setLastVisit(loginDate);

        userService.loginSuccess(loginUser);

        Token token = tokenManager.createToken(loginUser.getUserId());

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
