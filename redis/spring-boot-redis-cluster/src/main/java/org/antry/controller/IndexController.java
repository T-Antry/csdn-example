package org.antry.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    public static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("test_cluster")
    public String testCluster(){
        stringRedisTemplate.opsForValue().set("antry","cluster");
        System.out.println(stringRedisTemplate.opsForValue().get("antry"));
        return stringRedisTemplate.opsForValue().get("antry");
    }
}
