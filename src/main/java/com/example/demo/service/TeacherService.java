package com.example.demo.service;

import com.example.demo.entity.LeaveApproval;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.vo.SubClass;

import java.util.List;

public interface TeacherService {

    public List<SubClass> getMajorList(int id);

    public List<Student> getStudentList(String major,int grade);

    public Student getStudent(int sid);

    public List<LeaveApproval> getLeaveApprovalList(int id);

    public void changeApprovalStatus(int lid, int status);

    public List<Student> getNoCheckStudent(int id);

    public void modifyTeacherInfo(Teacher teacher);
}
