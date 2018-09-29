package com.xd.myspringbootblog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * mb_user_auth
 * @author 
 */
public class UserAuthDO implements Serializable {
    /**
     * 主键ID
     */
    private Integer pkId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 登陆认证方式
     */
    private String authType;

    /**
     * 认证标识 username/email/phone/weibo/weixin
     */
    private String authIdentifier;

    /**
     * 密码凭证 password_hash/access_token
     */
    private String authCredential;

    /**
     * 上次登陆时间
     */
    private Date lastVisit;

    /**
     * 上次登陆IP
     */
    private String lastIp;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getAuthCredential() {
        return authCredential;
    }

    public void setAuthCredential(String authCredential) {
        this.authCredential = authCredential;
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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserAuthDO other = (UserAuthDO) that;
        return (this.getPkId() == null ? other.getPkId() == null : this.getPkId().equals(other.getPkId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAuthType() == null ? other.getAuthType() == null : this.getAuthType().equals(other.getAuthType()))
            && (this.getAuthIdentifier() == null ? other.getAuthIdentifier() == null : this.getAuthIdentifier().equals(other.getAuthIdentifier()))
            && (this.getAuthCredential() == null ? other.getAuthCredential() == null : this.getAuthCredential().equals(other.getAuthCredential()))
            && (this.getLastVisit() == null ? other.getLastVisit() == null : this.getLastVisit().equals(other.getLastVisit()))
            && (this.getLastIp() == null ? other.getLastIp() == null : this.getLastIp().equals(other.getLastIp()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPkId() == null) ? 0 : getPkId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAuthType() == null) ? 0 : getAuthType().hashCode());
        result = prime * result + ((getAuthIdentifier() == null) ? 0 : getAuthIdentifier().hashCode());
        result = prime * result + ((getAuthCredential() == null) ? 0 : getAuthCredential().hashCode());
        result = prime * result + ((getLastVisit() == null) ? 0 : getLastVisit().hashCode());
        result = prime * result + ((getLastIp() == null) ? 0 : getLastIp().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkId=").append(pkId);
        sb.append(", userId=").append(userId);
        sb.append(", authType=").append(authType);
        sb.append(", authIdentifier=").append(authIdentifier);
        sb.append(", authCredential=").append(authCredential);
        sb.append(", lastVisit=").append(lastVisit);
        sb.append(", lastIp=").append(lastIp);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}