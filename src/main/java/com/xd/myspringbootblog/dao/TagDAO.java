package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.TagDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagDAO {
    int removeTagByTagId(Integer pkTagId);

    int saveTag(TagDO record);

    int saveTagSelective(TagDO record);

    TagDO getTagByTagId(Integer pkTagId);

    TagDO getTagByTagName(String tagName);

    List<TagDO> listAllTags();

    List<TagDO> listTagsByTagType(String tagType);

    List<TagDO> listTagsByArticleId(Integer articleId);

    int updateByTagIdSelective(TagDO record);

    int updateByTagId(TagDO record);
}