package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class myController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        Logger logger =  LoggerFactory.getLogger(myController.class);
        logger.info("用户访问了一次登陆界面");
        return "login";
    }

}
