package com.example.demo.controller.page;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeacherPageController {

    @RequestMapping(value = "/getStudentList",method = RequestMethod.GET)
    public String getStudentList() {
        return "StudentList";
    }

    @RequestMapping(value = "/getClassList",method = RequestMethod.GET)
    public String getClassList() {
        return "ClassList";
    }

    @RequestMapping(value = "/getStudentInfo",method = RequestMethod.GET)
    public String getStudentInfo() {
        return "StudentInfo";
    }

    @RequestMapping(value = "/teacherInfo",method = RequestMethod.GET)
    public String getTeacherInfo() {
        return "PersonalInfro";
    }

    @RequestMapping(value = "/dailyCheck",method = RequestMethod.GET)
    public String dailyCheck() {
        return "DailyCheck";
    }
    @RequestMapping(value = "/hangout",method = RequestMethod.GET)
    public String leaveApproval() {
        return "LeaveApproval";
    }
}
