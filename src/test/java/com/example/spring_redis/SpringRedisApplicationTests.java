package com.example.spring_redis;

import com.example.spring_redis.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class SpringRedisApplicationTests {


    @Resource
    private RedisTemplate redisTemplate;

    // 实际使用时会利用@Autowired将工具类注入当前类
    // 使用前先打开redis-server
    @Resource
    private RedisUtil redisUtil;

//    public SpringRedisApplicationTests(RedisUtil redisUtil){
//        this.redisUtil=redisUtil;
//    }

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("myKey", "myValue");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
    }


    @Test
    void testSetAndGet(){
        redisUtil.set("akey","avalue");
        System.out.println(redisUtil.get("akey"));
        System.out.println(redisUtil.get("aaa"));
    }


}
