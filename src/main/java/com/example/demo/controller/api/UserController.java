package com.example.demo.controller.api;

import com.example.demo.entity.UserDetil;
import com.example.demo.service.UserService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping("/api")
public class UserController {
    @Resource
    UserService service;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public boolean register(@RequestParam("username")String name,@RequestParam("password")String password,@RequestParam("email")String email,@RequestParam("code") String code) {
       if (service.veriFyCodeIsTrue(email,code)) {
           return service.userRegister(new UserDetil(name, new BCryptPasswordEncoder().encode(password), "user", email));
       } else {
           return false;
       }
    }

    @RequestMapping("/sendEmail")
    @ResponseBody
    public void sendEmail(@RequestParam("email") String email) {
        service.sendVerifyCode(email);
    }
}
