package com.example.demo.controller;

import lombok.Data;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;

@Data
@Controller
public class myController {
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    @RequestMapping("/login")
    public String login() {
        Logger logger =  LoggerFactory.getLogger(myController.class);
        logger.info("用户访问了一次登陆界面");
        System.out.println("hell word!");
        return "login";
    }

}
