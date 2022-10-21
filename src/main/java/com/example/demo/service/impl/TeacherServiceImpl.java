package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.mapper.TeacherMapper;
import com.example.demo.service.TeacherService;
import com.example.demo.vo.SubClass;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
}
