package com.xd.myspringbootblog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * mb_reply
 * @author 
 */
public class ReplyDO implements Serializable {
    /**
     * 回复ID
     */
    private Integer pkId;

    /**
     * 评论ID
     */
    private Integer commentId;

    /**
     * 回复目标ID: reply_type为1时,reply_id等于comment_id reply_type为2时,reply_id等于回复对象的回复表主键ID
     */
    private Integer replyId;

    /**
     * 回复类型 1为回复评论 2为回复别人的回复
     */
    private Byte replyType;

    /**
     * 回复内容
     */
    private String replyContent;

    /**
     * 回复用户ID
     */
    private Integer fromUid;

    /**
     * 冗余回复用户昵称
     */
    private String fromNickname;

    /**
     * 冗余回复用户头像
     */
    private String fromAvatar;

    /**
     * 回复目标用户ID
     */
    private Integer toUid;

    /**
     * 冗余回复目标用户昵称
     */
    private String toNickname;

    /**
     * 是否为作者回复 0为普通回复 1为作者回复
     */
    private Byte isAuthor;

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

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Byte getReplyType() {
        return replyType;
    }

    public void setReplyType(Byte replyType) {
        this.replyType = replyType;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Integer getFromUid() {
        return fromUid;
    }

    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }

    public String getFromNickname() {
        return fromNickname;
    }

    public void setFromNickname(String fromNickname) {
        this.fromNickname = fromNickname;
    }

    public String getFromAvatar() {
        return fromAvatar;
    }

    public void setFromAvatar(String fromAvatar) {
        this.fromAvatar = fromAvatar;
    }

    public Integer getToUid() {
        return toUid;
    }

    public void setToUid(Integer toUid) {
        this.toUid = toUid;
    }

    public String getToNickname() {
        return toNickname;
    }

    public void setToNickname(String toNickname) {
        this.toNickname = toNickname;
    }

    public Byte getIsAuthor() {
        return isAuthor;
    }

    public void setIsAuthor(Byte isAuthor) {
        this.isAuthor = isAuthor;
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
        ReplyDO other = (ReplyDO) that;
        return (this.getPkId() == null ? other.getPkId() == null : this.getPkId().equals(other.getPkId()))
            && (this.getCommentId() == null ? other.getCommentId() == null : this.getCommentId().equals(other.getCommentId()))
            && (this.getReplyId() == null ? other.getReplyId() == null : this.getReplyId().equals(other.getReplyId()))
            && (this.getReplyType() == null ? other.getReplyType() == null : this.getReplyType().equals(other.getReplyType()))
            && (this.getReplyContent() == null ? other.getReplyContent() == null : this.getReplyContent().equals(other.getReplyContent()))
            && (this.getFromUid() == null ? other.getFromUid() == null : this.getFromUid().equals(other.getFromUid()))
            && (this.getFromNickname() == null ? other.getFromNickname() == null : this.getFromNickname().equals(other.getFromNickname()))
            && (this.getFromAvatar() == null ? other.getFromAvatar() == null : this.getFromAvatar().equals(other.getFromAvatar()))
            && (this.getToUid() == null ? other.getToUid() == null : this.getToUid().equals(other.getToUid()))
            && (this.getToNickname() == null ? other.getToNickname() == null : this.getToNickname().equals(other.getToNickname()))
            && (this.getIsAuthor() == null ? other.getIsAuthor() == null : this.getIsAuthor().equals(other.getIsAuthor()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPkId() == null) ? 0 : getPkId().hashCode());
        result = prime * result + ((getCommentId() == null) ? 0 : getCommentId().hashCode());
        result = prime * result + ((getReplyId() == null) ? 0 : getReplyId().hashCode());
        result = prime * result + ((getReplyType() == null) ? 0 : getReplyType().hashCode());
        result = prime * result + ((getReplyContent() == null) ? 0 : getReplyContent().hashCode());
        result = prime * result + ((getFromUid() == null) ? 0 : getFromUid().hashCode());
        result = prime * result + ((getFromNickname() == null) ? 0 : getFromNickname().hashCode());
        result = prime * result + ((getFromAvatar() == null) ? 0 : getFromAvatar().hashCode());
        result = prime * result + ((getToUid() == null) ? 0 : getToUid().hashCode());
        result = prime * result + ((getToNickname() == null) ? 0 : getToNickname().hashCode());
        result = prime * result + ((getIsAuthor() == null) ? 0 : getIsAuthor().hashCode());
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
        sb.append(", commentId=").append(commentId);
        sb.append(", replyId=").append(replyId);
        sb.append(", replyType=").append(replyType);
        sb.append(", replyContent=").append(replyContent);
        sb.append(", fromUid=").append(fromUid);
        sb.append(", fromNickname=").append(fromNickname);
        sb.append(", fromAvatar=").append(fromAvatar);
        sb.append(", toUid=").append(toUid);
        sb.append(", toNickname=").append(toNickname);
        sb.append(", isAuthor=").append(isAuthor);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}