package com.xd.myspringbootblog.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ArticleVO implements Serializable {
    /**
     * 文章id
     */
    private Integer articleId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 文章作者
     */
    private String articleAuthor;

    /**
     * 文章状态
     */
    private String articleStatus;

    /**
     * 作者ID
     */
    private Integer authorUid;

    /**
     * 阅读数
     */
    private Integer readCount;

    /**
     * 点赞数
     */
    private Integer likeCount;

    /**
     * 评论数量
     */
    private Integer commentCount;

    /**
     * 标签ID列表
     */
    private List<Integer> tagIdList;

    /**
     * 标签名称列表
     */
    private List<String> tagNameList;

    /**
     * 分类ID
     */
    private Integer categoryId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 游标
     */
    private Integer cursor;

    public Integer getCursor() {
        return cursor;
    }

    public void setCursor(Integer cursor) {
        this.cursor = cursor;
    }

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

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Integer getAuthorUid() {
        return authorUid;
    }

    public void setAuthorUid(Integer authorUid) {
        this.authorUid = authorUid;
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

    public List<Integer> getTagIdList() {
        return tagIdList;
    }

    public void setTagIdList(List<Integer> tagIdList) {
        this.tagIdList = tagIdList;
    }

    public List<String> getTagNameList() {
        return tagNameList;
    }

    public void setTagNameList(List<String> tagNameList) {
        this.tagNameList = tagNameList;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleVO articleVO = (ArticleVO) o;

        if (getArticleId() != null ? !getArticleId().equals(articleVO.getArticleId()) : articleVO.getArticleId() != null)
            return false;
        if (getArticleTitle() != null ? !getArticleTitle().equals(articleVO.getArticleTitle()) : articleVO.getArticleTitle() != null)
            return false;
        if (getArticleContent() != null ? !getArticleContent().equals(articleVO.getArticleContent()) : articleVO.getArticleContent() != null)
            return false;
        if (getArticleAuthor() != null ? !getArticleAuthor().equals(articleVO.getArticleAuthor()) : articleVO.getArticleAuthor() != null)
            return false;
        if (getArticleStatus() != null ? !getArticleStatus().equals(articleVO.getArticleStatus()) : articleVO.getArticleStatus() != null)
            return false;
        if (getAuthorUid() != null ? !getAuthorUid().equals(articleVO.getAuthorUid()) : articleVO.getAuthorUid() != null)
            return false;
        if (getReadCount() != null ? !getReadCount().equals(articleVO.getReadCount()) : articleVO.getReadCount() != null)
            return false;
        if (getLikeCount() != null ? !getLikeCount().equals(articleVO.getLikeCount()) : articleVO.getLikeCount() != null)
            return false;
        if (getCommentCount() != null ? !getCommentCount().equals(articleVO.getCommentCount()) : articleVO.getCommentCount() != null)
            return false;
        if (getTagIdList() != null ? !getTagIdList().equals(articleVO.getTagIdList()) : articleVO.getTagIdList() != null)
            return false;
        if (getTagNameList() != null ? !getTagNameList().equals(articleVO.getTagNameList()) : articleVO.getTagNameList() != null)
            return false;
        if (getCategoryId() != null ? !getCategoryId().equals(articleVO.getCategoryId()) : articleVO.getCategoryId() != null)
            return false;
        if (getCategoryName() != null ? !getCategoryName().equals(articleVO.getCategoryName()) : articleVO.getCategoryName() != null)
            return false;
        if (getGmtCreate() != null ? !getGmtCreate().equals(articleVO.getGmtCreate()) : articleVO.getGmtCreate() != null)
            return false;
        if (getGmtModified() != null ? !getGmtModified().equals(articleVO.getGmtModified()) : articleVO.getGmtModified() != null)
            return false;
        return getCursor() != null ? getCursor().equals(articleVO.getCursor()) : articleVO.getCursor() == null;
    }

    @Override
    public int hashCode() {
        int result = getArticleId() != null ? getArticleId().hashCode() : 0;
        result = 31 * result + (getArticleTitle() != null ? getArticleTitle().hashCode() : 0);
        result = 31 * result + (getArticleContent() != null ? getArticleContent().hashCode() : 0);
        result = 31 * result + (getArticleAuthor() != null ? getArticleAuthor().hashCode() : 0);
        result = 31 * result + (getArticleStatus() != null ? getArticleStatus().hashCode() : 0);
        result = 31 * result + (getAuthorUid() != null ? getAuthorUid().hashCode() : 0);
        result = 31 * result + (getReadCount() != null ? getReadCount().hashCode() : 0);
        result = 31 * result + (getLikeCount() != null ? getLikeCount().hashCode() : 0);
        result = 31 * result + (getCommentCount() != null ? getCommentCount().hashCode() : 0);
        result = 31 * result + (getTagIdList() != null ? getTagIdList().hashCode() : 0);
        result = 31 * result + (getTagNameList() != null ? getTagNameList().hashCode() : 0);
        result = 31 * result + (getCategoryId() != null ? getCategoryId().hashCode() : 0);
        result = 31 * result + (getCategoryName() != null ? getCategoryName().hashCode() : 0);
        result = 31 * result + (getGmtCreate() != null ? getGmtCreate().hashCode() : 0);
        result = 31 * result + (getGmtModified() != null ? getGmtModified().hashCode() : 0);
        result = 31 * result + (getCursor() != null ? getCursor().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ArticleVO{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleAuthor='" + articleAuthor + '\'' +
                ", articleStatus='" + articleStatus + '\'' +
                ", authorUid=" + authorUid +
                ", readCount=" + readCount +
                ", likeCount=" + likeCount +
                ", commentCount=" + commentCount +
                ", tagIdList=" + tagIdList +
                ", tagNameList=" + tagNameList +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", cursor=" + cursor +
                '}';
    }
}
