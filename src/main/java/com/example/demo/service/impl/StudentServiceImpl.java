package com.example.demo.service.impl;

import com.example.demo.entity.LeaveApproval;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;
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
}
