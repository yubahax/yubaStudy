package com.example.demo.controller.page;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.Data;
import org.springframework.data.redis.core.StringRedisTemplate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Data
@Controller
public class StudentPageController {
    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Resource
    UserService userService;

    @RequestMapping("/index")
    public String index(HttpSession session) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String name = authentication.getName();
        User user = userService.selectUserByName(name);
        session.setAttribute("user",user);
        if (user.getRole().equals("admin")) {return "admin";}
        if (userService.ifStudentInfoIsEXist(session,name)) {
            return "index";
        } else {
            return "redirect:/hi";
        }
    }

    @RequestMapping("/hi")
    public String hi() {
        return "hi";
    }


    @RequestMapping({"/login","/"})
    public String login() {

        return "Login";
    }

}
