package com.xd.myspringbootblog.authorization.interceptor;

import com.xd.myspringbootblog.authorization.annotation.Authorization;
import com.xd.myspringbootblog.authorization.entity.Token;
import com.xd.myspringbootblog.authorization.manager.TokenManager;
import com.xd.myspringbootblog.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class AuthorizationInterceptor {

    @Autowired
    private TokenManager tokenManager;

    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception{
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();

        String authorization = request.getHeader(Constants.AUTHORIZATION);
        Token token = tokenManager.getToken(authorization);
        if (tokenManager.checkToken(token)) {
            request.setAttribute(Constants.CURRENT_USER_ID, token.getUserId());
            return true;
        }

        if (method.getAnnotation(Authorization.class) != null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        return true;
    }
}
