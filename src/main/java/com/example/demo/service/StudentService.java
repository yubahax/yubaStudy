package com.example.demo.service;

import com.example.demo.entity.Student;

public interface StudentService {
    /**
     * 保存的学生信息，其底层为insert
     * @param student 学生信息
     */
    public void saveStudentInfo(Student student);

    /**
     * 修改学生信息
     * @param student 学生信息
     */
    public void modifyStudentInfo(Student student);
}
