package com.example.demo.controller.api;

import com.example.demo.Util.RedisUtils;
import com.example.demo.entity.EmailBox;
import com.example.demo.entity.LeaveApproval;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.service.EmailService;
import com.example.demo.service.StudentService;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {
    @Resource
    UserService service;

    @Resource
    StudentService studentService;

    @Resource
    RedisUtils redisUtils;

    @Resource
    EmailService emailService;
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public boolean register(@RequestParam("username")String name,@RequestParam("password")String password,@RequestParam("email")String email,@RequestParam("code") String code) {
       if (service.verifiyCodeIsTrue(email,code)) {
           return service.userRegister(new User(name, new BCryptPasswordEncoder().encode(password), "user", email));
       } else {
           return false;
       }
    }

    @GetMapping("/test")
    public List<User> test() {
        List<User> list = new ArrayList<>();
        User x = new User(1,"yuba","5858","user","571239193@qq.com");
        User y = new User(2,"yuba","5858","user","571239193@qq.com");
        User z = new User(3,"yuba","5858","user","571239193@qq.com");
        list.add(x);
        list.add(y);
        list.add(z);
        return list;
    }
    @RequestMapping("/sendEmail")
    public void sendEmail(@RequestParam("email") String email) {
        service.sendVerifyCode(email);
    }

    @RequestMapping(value = "/user/modifyUserInfo",method = RequestMethod.GET)
    public void  modifyUserInfo(@RequestParam("password")String password,
                                @RequestParam("email")String email){
        User user = new User();
        int id = redisUtils.getUser().getId();
        user.setName(redisUtils.getUser().getName());
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        //????????????
        user.setEmail(email);
        user.setId(id);
        service.modifyUserInfo(user);
    }

    @RequestMapping(value = "/user/modifyStudentInfo",method = RequestMethod.POST)
    public void modifyStudentInfo(@RequestParam("sid") int sid,
                                  @RequestParam("name") String sname,
                                  @RequestParam("sex") String sex,
                                  @RequestParam("age") int age,
                                  @RequestParam("grade") int grade,
                                  @RequestParam("major") String major,
                                  @RequestParam("room") String room){
        Student student = new Student();
        User user = redisUtils.getUser();
        student.setAge(age);
        student.setSex(sex);
        student.setRoom(room);
        student.setMajor(major);
        student.setId(user.getId());
        student.setSname(sname);
        student.setSid(sid);
        student.setGrade(grade);
        studentService.modifyStudentInfo(student);
    }

    @GetMapping("/user/getStudent")
    public Student getStudent(){
        return redisUtils.getStudent();
    }

    @PostMapping("/user/addLeaveApproval")
    public void addLeaveApproval(@RequestBody LeaveApproval leaveApproval){

        studentService.addLeaveApproval(leaveApproval);

    }

    @GetMapping("/user/addDailyCheck")
    public void addDailyCheck(@RequestParam("daytemp") String daytemp,@RequestParam("nighttemp") String nighttemp){
        int sid = redisUtils.getStudent().getSid();
        studentService.addDailyCheck(sid,daytemp,nighttemp);

    }

    @GetMapping("/user/getEmail")
    public List<EmailBox> getEamil() {
        return emailService.getStudentEmail();
    }

    @GetMapping("/user/deleteEmail")
    public void deleteEmail(@RequestParam("eids") String eid) {
        String[] strings = eid.split("-");
        List<String> str = Arrays.asList(strings);
        emailService.deleteStudentEmail(str);
    }
}
