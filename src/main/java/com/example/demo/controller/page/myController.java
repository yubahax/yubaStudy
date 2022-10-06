package com.example.demo.controller.page;

import com.example.demo.entity.UserDetil;
import lombok.Data;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Data
@Controller
public class myController {
    @Resource
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/index")
    public String index(HttpSession session) {
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context.getAuthentication().getName());
        return "index";
    }

    @RequestMapping("/hi")
    public String hi() {
        return "hi";
    }


    @RequestMapping({"/login","/"})
    public String login() {
//        Logger logger =  LoggerFactory.getLogger(myController.class);
//        logger.info("用户访问了一次登陆界面");
        return "Login";
    }

}
