package com.example.demo.controller.api;

import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/api")
public class UserController {
    @Resource
    UserService service;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public boolean register(@RequestParam("username")String name,@RequestParam("password")String password,@RequestParam("email")String email,@RequestParam("code") String code) {
       if (service.verifiyCodeIsTrue(email,code)) {
           return service.userRegister(new User(name, new BCryptPasswordEncoder().encode(password), "user", email));
       } else {
           return false;
       }
    }

    @RequestMapping("/sendEmail")
    public void sendEmail(@RequestParam("email") String email) {
        service.sendVerifyCode(email);
    }

    @RequestMapping(value = "/saveStudentInfo",method = RequestMethod.POST)
    public void saveStudentInfo(@RequestParam("sid") int sid,
                                @RequestParam("name") String sname,
                                @RequestParam("sex") String sex,
                                @RequestParam("age") int age,
                                @RequestParam("grade") int grade,
                                @RequestParam("major") String major,
                                @RequestParam("room") String room,HttpSession session) {
        Student student = new Student();
        User user = (User) session.getAttribute("user");
        student.setAge(age);
        student.setSex(sex);
        student.setRoom(room);
        student.setMajor(major);
        student.setId(user.getId());
        student.setSname(sname);
        student.setSid(sid);
        student.setGrade(grade);
        service.saveStudentInfo(student);
    }

    @RequestMapping(value = "/modifyUserInfo",method = RequestMethod.POST)
    public void  modifyUserInfo(@RequestParam("name") String name,
                                @RequestParam("password")String password,
                                @RequestParam("email")String email,HttpSession session ){
        User user = new User();
        int id = (int) session.getAttribute("id");
        user.setName(name);
        user.setPassword(new BCryptPasswordEncoder().encode(password));//密码加密
        user.setEmail(email);
        user.setId(id);
        service.modifyUserInfo(user);
    }

    @RequestMapping(value = "/modifyStudentInfo",method = RequestMethod.POST)
    public void modifyStudentInfo(@RequestParam("sid") int sid,
                                  @RequestParam("name") String sname,
                                  @RequestParam("sex") String sex,
                                  @RequestParam("age") int age,
                                  @RequestParam("grade") int grade,
                                  @RequestParam("major") String major,
                                  @RequestParam("room") String room,HttpSession session){
        Student student = new Student();
        int id = (int) session.getAttribute("id");
        student.setAge(age);
        student.setSex(sex);
        student.setRoom(room);
        student.setMajor(major);
        student.setId(id);
        student.setSname(sname);
        student.setSid(sid);
        student.setGrade(grade);
        service.modifyStudentInfo(student);
    }

}
