package com.xd.myspringbootblog.service;

import com.xd.myspringbootblog.dao.ArticleDAO;
import com.xd.myspringbootblog.entity.ArticleContentDO;
import com.xd.myspringbootblog.entity.ArticleDO;
import com.xd.myspringbootblog.model.ArticleVO;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.UnexpectedException;
import java.util.*;

@Service
@Transactional
public class ArticleService {
    @Autowired
    private ArticleDAO articleDAO;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private SqlSessionTemplate sessionTemplate;

    private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);

    public List<ArticleVO> listArticlesByAuthorUid(int uid, int cursor){
        List<ArticleVO> articleVOList = new ArrayList<ArticleVO>();
        try {
            
            // List<ArticleDO> articleDOList = articleDAO.listAllByAuthorUid(uid);
            //BeanUtils.copyProperties(articleVOList, articleDOList);

//            MyBatisCursorItemReader<ArticleDO> articleDOMyBatisCursorItemReader = new MyBatisCursorItemReader<ArticleDO>();
//            articleDOMyBatisCursorItemReader.setQueryId("listAllByAuthorUid");
            int limit = 10;
            RowBounds rowBounds = new RowBounds(cursor, limit);

            List<ArticleDO> articleDOList = new ArrayList<ArticleDO>();
            List<ArticleContentDO> articleContentDOList = new ArrayList<ArticleContentDO>();

            sessionTemplate.select(
                    "com.xd.myspringbootblog.dao.ArticleDAO.listAllByAuthorUid",
                    uid,
                    rowBounds,
                    new ResultHandler() {
                @Override
                public void handleResult(ResultContext resultContext) {
                    ArticleDO articleDO = (ArticleDO)resultContext.getResultObject();
                    articleDOList.add(articleDO);

                }
            });

            BeanUtils.copyProperties(articleVOList, articleDOList);

            // mongoTemplate.getCollection().find().limit()

//            Query query = new Query(Criteria.where("authorUid").is(uid));
//            List<ArticleContentDO> articleContentDOList = mongoTemplate.find(query, ArticleContentDO.class);
            BeanUtils.copyProperties(articleVOList, articleContentDOList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return articleVOList;
    }

//    @Cacheable(value = "articleId", key = "#articleId")
    public ArticleVO getArticleByArticleId(Integer articleId){
//        String key = "articleId_" + articleId;
//        ValueOperations<String, Article> ops = redisTemplate.opsForValue();
//        boolean hasKey = redisTemplate.hasKey(key);
//        if(hasKey){
//            System.out.println("Already has key:" + key);
//            return ops.get(key);
//        }
//        System.out.println("Have not found key:" + key);
//        Article article = articleDAO.getArticleByArticleId(articleId);
//        ops.set(key, article, 5, TimeUnit.MINUTES);
//        return article;
        ArticleVO articleVO = new ArticleVO();
        ArticleDO articleDO = articleDAO.getByPrimaryKey(articleId);
        logger.debug(articleDO.toString());

//        articleVO.setArticleId(articleId);
//        articleVO.setArticleTitle(articleDO.getArticleTitle());
//        articleVO.setArticleAuthor(articleDO.getArticleAuthor());
//        articleVO.setArticleStatus(articleDO.getArticleStatus());
//        articleVO.setAuthorUid(articleDO.getAuthorUid());
//        articleVO.setGmtCreate(articleDO.getGmtCreate());
//        articleVO.setGmtModified(articleDO.getGmtModified());
//        articleVO.setCommentCount(articleDO.getCommentCount());
//        articleVO.setLikeCount(articleDO.getLikeCount());
//        articleVO.setReadCount(articleDO.getReadCount());
        BeanUtils.copyProperties(articleVO, articleDO);
        logger.debug(articleVO.toString());

        Query query = new Query(Criteria.where("articleId").is(articleId));
        ArticleContentDO articleContentDO = mongoTemplate.findOne(query, ArticleContentDO.class, "articleContent");
        logger.debug(articleContentDO.toString());

        articleVO.setArticleContent(articleContentDO.getArticleContent());
        logger.debug(articleVO.toString());

        return articleVO;
    }
//    public List<ArticleVO> listArticlesByTagId(int tagId){
//        return articleDAO.listAllByTagId(tagId);
//    }

    public boolean saveArticle(ArticleVO article){
        boolean flag = false;
        try{
            ArticleDO articleDO = new ArticleDO();
//            articleDO.setArticleAuthor(article.getArticleAuthor());
//            articleDO.setArticleTitle(article.getArticleTitle());
//            articleDO.setArticleStatus(article.getArticleStatus());
//            articleDO.setAuthorUid(article.getAuthorUid());
            BeanUtils.copyProperties(article, articleDO);
            System.out.println(articleDO.toString());
            articleDAO.save(articleDO);
            Integer articleId = articleDO.getPkId();
            logger.debug("articleId:{}", articleId);
            System.out.println("articleId:" + articleId);
            ArticleContentDO articleContentDO = new ArticleContentDO();
            articleContentDO.setArticleId(articleId);
            articleContentDO.setArticleContent(article.getArticleContent());
//            BeanUtils.copyProperties(article, articleContentDO);
            System.out.println(articleContentDO.toString());
            mongoTemplate.save(articleContentDO);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public boolean removeArticleByArticleId(Integer articleId) throws UnexpectedException{
        boolean flag = false;
        try{
            articleDAO.removeByPrimaryKey(articleId);
            Query query = new Query(Criteria.where("articleId").is(articleId));
            mongoTemplate.remove(query, ArticleContentDO.class);

            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public boolean updateArticleByArticleId(ArticleVO article){
        boolean flag = false;
        try{
            ArticleDO articleDO = new ArticleDO();
            ArticleContentDO articleContentDO = new ArticleContentDO();
            BeanUtils.copyProperties(articleDO, article);
            BeanUtils.copyProperties(articleContentDO, article);
            articleDAO.updateByPrimaryKey(articleDO);

            Query query = new Query(Criteria.where("articleId").is(article.getArticleId()));
            if (article.getArticleContent() != null) {
                Update update = new Update().set("articleContent", article.getArticleContent());
                mongoTemplate.updateFirst(query, update, ArticleContentDO.class);
            }
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
