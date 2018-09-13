package com.xd.myspringbootblog.entity;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
    private Integer articleId;
    private String articleTitle;
    private String articleAuthor;
    private String articleContent;
    private String articleStatus;
    private Integer userId;
    private Integer readCount;
    private Integer likeCount;
    private Integer commentCount;
    private Date createDate;
    private Date changeDate;

    public Article(){}

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleAuthor='" + articleAuthor + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleStatus='" + articleStatus + '\'' +
                ", userId=" + userId +
                ", readCount=" + readCount +
                ", likeCount=" + likeCount +
                ", commentCount=" + commentCount +
                ", createDate=" + createDate +
                ", changeDate=" + changeDate +
                '}';
    }

}