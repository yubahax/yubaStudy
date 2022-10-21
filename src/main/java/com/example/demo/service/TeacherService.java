package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.vo.SubClass;

import java.util.List;

public interface TeacherService {

    public List<SubClass> getMajorList(int id);

    public List<Student> getStudentList(String major,int grade);
}
