package com.example.demo.controller.api;


import com.example.demo.entity.LeaveApproval;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;
import com.example.demo.service.TeacherService;
import com.example.demo.vo.SubClass;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/modifyTeacherInfo",method = RequestMethod.POST)
    public void modifyTeacherInfo(@RequestParam("tid")int tid,
                                  @RequestParam("tname") String tname,
                                  @RequestParam("sex") String sex,
                                  @RequestParam("age") int age,
                                  @RequestParam("education") String education,
                                  @RequestParam("idcard") String idcard,
                                  @RequestParam("appointment") String appointment,HttpSession session){
        Teacher teacher = new Teacher();
        int id = (int) session.getAttribute("id");
        teacher.setTid(tid);
        teacher.setTname(tname);
        teacher.setSex(sex);
        teacher.setAge(age);
        teacher.setEducation(education);
        teacher.setIdcard(idcard);
        teacher.setAppointment(appointment);
        teacher.setId(id);
        teacherService.modifyTeacherInfo(teacher);
    }

    @GetMapping("/getLeaveApprovalList")
    public List<LeaveApproval> getLeaveApprovalList(HttpSession session) {
        int id = (int) session.getAttribute("id");
        return teacherService.getLeaveApprovalList(id);
    }

    @GetMapping("/getNoCheckStudent")
    public List<Student> getNoCheckStudent(HttpSession session) {
        int id = (int) session.getAttribute("id");
        return teacherService.getNoCheckStudent(id);
    }

}
