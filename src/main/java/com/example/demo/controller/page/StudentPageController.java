package com.example.demo.controller.page;


import com.example.demo.Util.RedisUtils;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.service.StudentService;
import com.example.demo.service.UserService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
public class StudentPageController {
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Resource
    UserService userService;
    @Resource
    StudentService studentService;

    @Resource
    RedisUtils redisUtils;
    @RequestMapping("/index")
    public String index() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String name = authentication.getName();
        User user = (User) redisUtils.get(name);
        if(user == null) {
            user = userService.selectUserByName(name);
            redisUtils.set(name,user);
        }
        if ("admin".equals(user.getRole())) {return "redirect:/teacherInfo";}
        if (studentService.ifStudentInfoIsExist(user.getId())) {
            return "index";
        } else {
            return "redirect:/saveInfo";
        }
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
    @RequestMapping(value = "/api/saveStudentInfo",method = RequestMethod.POST)
    public String saveStudentInfo(@RequestParam("sid") int sid,
                                @RequestParam("name") String sname,
                                @RequestParam("sex") String sex,
                                @RequestParam("age") int age,
                                @RequestParam("grade") int grade,
                                @RequestParam("major") String major,
                                @RequestParam("room") String room,HttpSession session) {
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
        studentService.saveStudentInfo(student);
        return "redirect:/index";
    }
    @RequestMapping("/saveInfo")
    public String hi() {
        return "saveStudentInfo";
    }

    @RequestMapping({"/login","/"})
    public String login() {
        return "login";
    }

    @RequestMapping({"/user/mybook","/user/book.html"})
    public String studentBook(){
        return "book";
    }

    @RequestMapping({"/user/personInfo","/user"})
    public String personInfo(){
        return "personPage";
    }

    @RequestMapping("/user/changeInfo")
    public String changeInfo(){
        return "changeUser";
    }

    @RequestMapping("/user/myCommodity")
    public String studentCommodity(){
        return "commodity";
    }

    @RequestMapping("/user/sendCommodity")
    public String sendCommodity(){
        return "saveCommodity";
    }
}
