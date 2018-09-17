package com.xd.myspringbootblog.entity;

import java.io.Serializable;

/**
 * mb_article_tag
 * @author 
 */
public class ArticleTagDOKey implements Serializable {
    private Integer pkArticleId;

    private Integer pkTagId;

    private static final long serialVersionUID = 1L;

    public Integer getPkArticleId() {
        return pkArticleId;
    }

    public void setPkArticleId(Integer pkArticleId) {
        this.pkArticleId = pkArticleId;
    }

    public Integer getPkTagId() {
        return pkTagId;
    }

    public void setPkTagId(Integer pkTagId) {
        this.pkTagId = pkTagId;
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
        ArticleTagDOKey other = (ArticleTagDOKey) that;
        return (this.getPkArticleId() == null ? other.getPkArticleId() == null : this.getPkArticleId().equals(other.getPkArticleId()))
            && (this.getPkTagId() == null ? other.getPkTagId() == null : this.getPkTagId().equals(other.getPkTagId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPkArticleId() == null) ? 0 : getPkArticleId().hashCode());
        result = prime * result + ((getPkTagId() == null) ? 0 : getPkTagId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkArticleId=").append(pkArticleId);
        sb.append(", pkTagId=").append(pkTagId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}