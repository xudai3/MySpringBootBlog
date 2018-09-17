package com.xd.myspringbootblog.controller;

import com.xd.myspringbootblog.entity.UserDO;
import com.xd.myspringbootblog.response.Response;
import com.xd.myspringbootblog.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Api(value = "users", description = "users API")
@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(
            value = "get user by uid",
            notes = "get user by uid",
            response = UserDO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input", response = UserDO.class)})
    @RequestMapping(value = "/v1/users/{uid}", method = RequestMethod.GET)
    public Response getUser(@ApiParam(value = "uid", required = true) @PathVariable Integer uid){
        System.out.println("getting user info...");
        System.out.println(uid);

        Response resp = new Response();
        UserDO getUser = userService.getUserByUserId(uid);

        return resp.success(getUser);
    }

    @RequestMapping(value = "/v1/users", method = RequestMethod.POST)
    public Response saveUser(@RequestBody UserDO user, HttpServletRequest request){
        System.out.println("Signing up... adding user...");

        String loginIp = request.getRemoteAddr();
        Date loginDate = new Date();
        user.setLastIp(loginIp);
        user.setLastVisit(loginDate);

        Response resp = new Response();
        userService.saveUser(user);

        return resp.success();
    }

    @RequestMapping(value = "/v1/users", method = RequestMethod.DELETE)
    public Response removeUser(@PathVariable Integer uid){
        Response resp = new Response();
        userService.removeUserByUserId(uid);

        return resp.success();
    }

    @RequestMapping(value = "/v1/users", method = RequestMethod.PUT)
    public Response updateUser(){
        Response resp = new Response();

        return resp.success();
    }

    @RequestMapping(value = "/v1/users", method = RequestMethod.GET)
    public Response listUser(){
        System.out.println("getting user list...");
        Response resp = new Response();
        List<UserDO> userList = userService.listAllUsers();
        System.out.println(resp.success(userList).toString());
        return resp.success(userList);
    }

}
