package com.example.demo.controller.api;


import com.example.demo.entity.Student;
import com.example.demo.service.TeacherService;
import com.example.demo.vo.SubClass;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class TeacherController {

    @Resource
    TeacherService teacherService;

    @GetMapping("/getMajorList")
    public List<SubClass> getMajorList(HttpSession session){
        int id = (int) session.getAttribute("id");
        return teacherService.getMajorList(id);
    }

    @GetMapping("/getStudentList")
    public List<Student> getStudentList(@Param("major") String major,@Param("grade") int grade){
        return teacherService.getStudentList(major,grade);
    }

    @GetMapping("/getStudent")
    public Student getStudent(@Param("sid") int sid) {
        return teacherService.getStudent(sid);
    }

    @GetMapping("/judge")
    public void changeStudentRequest(@Param("lid")int lid,@Param("change")int status) {
        teacherService.changeApprovalStatus(lid, status);
    }




}
