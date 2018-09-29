package com.xd.myspringbootblog.model;

import java.io.Serializable;
import java.util.Date;

public class UserVO implements Serializable {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户积分
     */
    private Integer credit;

    /**
     * 上次登陆时间
     */
    private Date lastVisit;

    /**
     * 上次登陆IP
     */
    private String lastIp;

    /**
     * 登陆认证方式
     */
    private String authType;

    /**
     * 认证标识 username/email/phone/weibo/weixin
     */
    private String authIdentifier;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getAuthIdentifier() {
        return authIdentifier;
    }

    public void setAuthIdentifier(String authIdentifier) {
        this.authIdentifier = authIdentifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserVO userVO = (UserVO) o;

        if (getNickname() != null ? !getNickname().equals(userVO.getNickname()) : userVO.getNickname() != null)
            return false;
        if (getAvatar() != null ? !getAvatar().equals(userVO.getAvatar()) : userVO.getAvatar() != null) return false;
        if (getCredit() != null ? !getCredit().equals(userVO.getCredit()) : userVO.getCredit() != null) return false;
        if (getUserId() != null ? !getUserId().equals(userVO.getUserId()) : userVO.getUserId() != null) return false;
        if (getLastVisit() != null ? !getLastVisit().equals(userVO.getLastVisit()) : userVO.getLastVisit() != null)
            return false;
        if (getLastIp() != null ? !getLastIp().equals(userVO.getLastIp()) : userVO.getLastIp() != null) return false;
        if (getAuthType() != null ? !getAuthType().equals(userVO.getAuthType()) : userVO.getAuthType() != null)
            return false;
        return getAuthIdentifier() != null ? getAuthIdentifier().equals(userVO.getAuthIdentifier()) : userVO.getAuthIdentifier() == null;
    }

    @Override
    public int hashCode() {
        int result = getUserId() != null ? getUserId().hashCode() : 0;
        result = 31 * result + (getNickname() != null ? getNickname().hashCode() : 0);
        result = 31 * result + (getAvatar() != null ? getAvatar().hashCode() : 0);
        result = 31 * result + (getCredit() != null ? getCredit().hashCode() : 0);
        result = 31 * result + (getLastVisit() != null ? getLastVisit().hashCode() : 0);
        result = 31 * result + (getLastIp() != null ? getLastIp().hashCode() : 0);
        result = 31 * result + (getAuthType() != null ? getAuthType().hashCode() : 0);
        result = 31 * result + (getAuthIdentifier() != null ? getAuthIdentifier().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userId=" + userId +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", credit=" + credit +
                ", lastVisit=" + lastVisit +
                ", lastIp='" + lastIp + '\'' +
                ", authType='" + authType + '\'' +
                ", authIdentifier='" + authIdentifier + '\'' +
                '}';
    }
}
