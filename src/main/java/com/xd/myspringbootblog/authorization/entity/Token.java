package com.xd.myspringbootblog.authorization.entity;

public class Token {

    private Integer userId;

    private String token;

    public Token(){}

    public Token(Integer userId, String token){
        this.userId = userId;
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                '}';
    }
}
