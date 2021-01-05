package com.wu.redis.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

@Configuration
public class RedisConfig {

    /**
     * RedisConnectionFactory（这个是配置连接信息，这里的RedisConnectionFactory是一个接口，
     * 我们需要使用它的实现类，在SpringD Data Redis方案中提供了一下四种工厂模型）
     *      JredisConnectionFactory
     *      JedisConnectionFactory
     *      LettuceConnectionFactory
     *      SrpConnectionFactory
     * Lettuce和Jedis的都是连接Redis Server的客户端程序。
     *  Jedis在实现上是直连redis server，多线程环境下非线程安全，除非使用连接池，为每个Jedis实例增加物理连接。
     *  Lettuce基于Netty的连接实例（StatefulRedisConnection），可以在多个线程间并发访问，且线程安全，
     *          满足多线程环境下的并发访问，同时它是可伸缩的设计，一个连接实例不够的情况也可以按需增加连接实例。
     *
     */
    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory factory) {
        RedisTemplate<String, Serializable> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());//key
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());//value
        return template;
    }

}