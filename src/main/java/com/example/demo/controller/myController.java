package com.example.demo.controller;

import com.example.demo.entity.Item;
import lombok.Data;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.lang.reflect.Type;

@Data
@Controller
public class myController {
    @Resource
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/index",method = RequestMethod.POST)
    @ResponseBody
    public String index(@RequestParam("name") String name) {
        System.out.println(name);
        return  "hello world!";
    }
    @RequestMapping("/login")
    public String login() {
//        Logger logger =  LoggerFactory.getLogger(myController.class);
//        logger.info("用户访问了一次登陆界面");
        return "Login";
    }

}
