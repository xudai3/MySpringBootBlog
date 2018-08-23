//package com.xd.myspringbootblog.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//@Configuration
//public class RedisConfig {
//
//    @Autowired
//    RedisConnectionFactory redisConnectionFactory;
//
//    @Bean
//    public RedisTemplate<String, Object> customRedisTemplate(){
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        initCustomRedisTemplate(redisTemplate, redisConnectionFactory);
//        return redisTemplate;
//    }
//
//    private void initCustomRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory){
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
//        redisTemplate.setConnectionFactory(factory);
//    }
//}
