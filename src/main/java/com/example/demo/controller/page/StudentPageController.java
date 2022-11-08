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
        session.setAttribute("id",user.getId());
        if ("admin".equals(user.getRole())) {return "admin";}
        if (userService.ifStudentInfoIsExist(session,name)) {
            return "index";
        } else {
            return "redirect:/saveInfo";
        }
    }

    @RequestMapping("/saveInfo")
    public String hi() {
        return "saveStudentInfo";
    }


    @RequestMapping({"/login","/"})
    public String login() {

        return "login";
    }

}
