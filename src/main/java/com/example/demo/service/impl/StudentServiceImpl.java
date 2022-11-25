package com.example.demo.service.impl;

import com.example.demo.Util.RedisUtils;
import com.example.demo.entity.DailyCheck;
import com.example.demo.entity.LeaveApproval;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.mapper.DailyCheckMapper;
import com.example.demo.mapper.LeaveApprovalMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @Resource
    LeaveApprovalMapper leaveApprovalMapper;

    @Resource
    DailyCheckMapper dailyCheckMapper;

    @Resource
    RedisUtils redisUtils;

    @Override
    public void saveStudentInfo(Student student) {
        User user = redisUtils.getUser();
        redisUtils.set("user"+user.getId()+"student",student);
        studentMapper.insert(student);
    }
    @Override
    public void modifyStudentInfo(Student student) {
        User user = redisUtils.getUser();
        redisUtils.set("user"+user.getId()+"student",student);
        studentMapper.updateStudentById(student);
    }

    @Override
    public boolean ifStudentInfoIsExist(int id) {
        Student student =  studentMapper.selectById(id);
        if (student == null) {
            return false;
        } else {
            redisUtils.set("user"+id+"student",student);
            return true;
        }
    }

    @Override
    public Student getStudentByUserId(int id) {
        return studentMapper.getStudentByUserId(id);
    }

    @Override
    public void addLeaveApproval(LeaveApproval leaveApproval) {
        int sid  = redisUtils.getStudent().getSid();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String sendtime = format.format(date);
        leaveApproval.setSendtime(sendtime);
        leaveApproval.setSid(sid);
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
