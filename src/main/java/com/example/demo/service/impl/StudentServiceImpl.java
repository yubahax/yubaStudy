package com.example.demo.service.impl;

import com.example.demo.entity.DailyCheck;
import com.example.demo.entity.LeaveApproval;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.mapper.DailyCheckMapper;
import com.example.demo.mapper.LeaveApprovalMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @Resource
    LeaveApprovalMapper leaveApprovalMapper;

    @Resource
    DailyCheckMapper dailyCheckMapper;

    @Override
    public void saveStudentInfo(Student student) {
        studentMapper.insert(student);
    }
    @Override
    public void modifyStudentInfo(Student student) {
        studentMapper.updateStudentById(student);
    }

    @Override
    public boolean ifStudentInfoIsExist(HttpSession session, String name) {
        User user = (User) session.getAttribute("user");
        Student student =  studentMapper.selectById(user.getId());
        if (student == null) {
            return false;
        } else {
            session.setAttribute("student",student);
            return true;
        }
    }

    @Override
    public Student getStudentByUserId(int id) {
        return studentMapper.getStudentByUserId(id);
    }

    @Override
    public void addLeaveApproval(LeaveApproval leaveApproval) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String sendtime = format.format(date);
        leaveApproval.setSendtime(sendtime);
        leaveApprovalMapper.insert(leaveApproval);
    }

    @Override
    public void addDailyCheck(int sid, String daytemp, String nighttemp) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String checktime = format.format(date);
        DailyCheck dailyCheck = new DailyCheck();
        dailyCheck.setSid(sid);
        dailyCheck.setDaytemp(daytemp);
        dailyCheck.setNighttemp(nighttemp);
        dailyCheck.setChecktime(checktime);
        dailyCheckMapper.insert(dailyCheck);
    }

}
