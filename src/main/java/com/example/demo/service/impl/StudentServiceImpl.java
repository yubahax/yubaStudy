package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentService;

import javax.annotation.Resource;

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
}
