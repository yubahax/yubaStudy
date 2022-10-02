package com.example.demo.controller.page;

import lombok.Data;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

@Data
@Controller
public class myController {
    @Resource
    StringRedisTemplate stringRedisTemplate;



//    @RequestMapping(value = "/index",method = RequestMethod.POST)
//    @ResponseBody
//    public Item index(@RequestParam("name") String name) {
//        System.out.println(name);
//        return  new Item("jojo","oo");
//    }
    @RequestMapping("/index")
    public String index() {
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
