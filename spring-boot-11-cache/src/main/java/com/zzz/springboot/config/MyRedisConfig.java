package com.zzz.springboot.config;

import com.zzz.springboot.bean.Department;
import com.zzz.springboot.bean.Employee;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.net.UnknownHostException;
import java.time.Duration;

/**
 * Redis的自定义 存储方式为 json
 * 1、将数据以json的方式保存
 *  (1)自己将对象转为json
 * 	(2)redisTemplate默认的序列化规则；改变默认的序列化规则；
 * 自己的 因为默认的不是json形式
 */
@Configuration
public class MyRedisConfig {

    //这一步是为了往 redis 存数据 （数据库模式）
//    @Bean
//    public RedisTemplate<Object, Employee> empRedisTemplate(
//            RedisConnectionFactory redisConnectionFactory)
//            throws UnknownHostException {
//        RedisTemplate<Object, Employee> template = new RedisTemplate<Object, Employee>();
//        template.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer<Employee> ser = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
//        template.setDefaultSerializer(ser);//序列化器
//        return template;
//    }
//    @Bean
//    public RedisTemplate<Object, Department> deptRedisTemplate(
//            RedisConnectionFactory redisConnectionFactory)
//            throws UnknownHostException {
//        RedisTemplate<Object, Department> template = new RedisTemplate<Object, Department>();
//        template.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer<Department> ser = new Jackson2JsonRedisSerializer<Department>(Department.class);
//        template.setDefaultSerializer(ser);
//        return template;
//    }

    /**
     *这个方法 用到redis 就必须有 不用每个对象都定制redis
     */
    //这一步是为了往 redis 存缓存 （缓存模式）
    //CacheManagerCustomizers可以来定制缓存的一些规则
    @Primary  //将某个缓存管理器作为默认的
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        // 使用缓存的默认配置
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
        // 使用 GenericJackson2JsonRedisSerializer 作为序列化器
        config = config.serializeValuesWith(
                RedisSerializationContext.SerializationPair.fromSerializer(
                        new GenericJackson2JsonRedisSerializer()));
        RedisCacheManager.RedisCacheManagerBuilder builder =
                RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(config);
        return builder.build();
    }

}
