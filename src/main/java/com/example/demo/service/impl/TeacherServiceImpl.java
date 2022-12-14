package com.example.demo.service.impl;

import com.example.demo.entity.EmailBox;
import com.example.demo.entity.LeaveApproval;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.mapper.TeacherMapper;
import com.example.demo.service.TeacherService;
import com.example.demo.vo.SubClass;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    TeacherMapper teacherMapper;

    @Resource
    StudentMapper studentMapper;

    @Override
    public List<SubClass> getMajorList(int id) {
        return teacherMapper.getMajorList(id);
    }

    @Override
    public List<Student> getStudentList(String major, int grade) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("major",major);
        map.put("grade",grade);
        return studentMapper.selectByMap(map);
    }

    @Override
    public Student getStudent(int sid) {
        return studentMapper.selectStudentBysId(sid);
    }

    @Override
    public List<LeaveApproval> getLeaveApprovalList(int id) {
        return teacherMapper.getStudentApproval(id);
    }

    @Override
    public void changeApprovalStatus(int lid, int status) {
        teacherMapper.changeApprovalStatus(lid,status);
    }

    @Override
    public List<Student> getNoCheckStudent(int id) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String time = format.format(date);
        return teacherMapper.getNoCheckStudent(id,time);
    }

    @Override
    public void modifyTeacherInfo(Teacher teacher) {
        teacherMapper.updateTeacherInfo(teacher);
    }

    @Override
    public void checkStudent(int sid,int id) {
        EmailBox emailBox = new EmailBox();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String time = format.format(date);
        emailBox.setGettime(time);
        emailBox.setSid(sid);
        emailBox.setSendid(id);
        emailBox.setTxt("????????????????????????????????????");
        teacherMapper.checkStudent(emailBox);
    }
}
