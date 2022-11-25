package com.example.demo.service;

import com.example.demo.entity.LeaveApproval;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.vo.SubClass;
import com.example.demo.vo.SubStudent;

import java.util.List;


public interface TeacherService {

    /**
     * 根据登录的教师id，查询其督导班级信息
     * @param id 传入当前用户id
     * @return 返回视图模型（view model） SubClass列表
     */
    public List<SubClass> getMajorList(int id);

    /**
     * 根据传入的专业和年级查询对应学生
     * @param major 专业 字符串
     * @param grade 年级 整形变量
     * @return 当前专业年级的全部学生列表
     */
    public List<Student> getStudentList(String major, int grade);

    /**
     * 根据学号sid查找某一学生
     * @param sid 传入的学生学号
     * @return 学生实体类
     */
    public Student getStudent(int sid);

    /**
     * 辅导员获取其所管理学生的请假申请
     * @param id 用户id
     * @return 当前辅导员所管理的全部学生的全部请假申请
     */
    public List<LeaveApproval> getLeaveApprovalList(int id);

    /**
     * 审批学生的请假申请
     * @param lid 请假申请的lid
     * @param status 审核状态，初始为0，不通过为-1，通过为1
     */
    public void changeApprovalStatus(int lid, int status);

    /**
     * 获取辅导员当日未进行健康打卡的学生列表
     * @param id 用户id
     * @return 当前辅导员当日未进行健康打卡的学生列表
     */
    public List<Student> getNoCheckStudent(int id);

    /**
     * 修改辅导员信息
     * @param teacher 将要修改信息封装为teacher实体类
     */
    public void modifyTeacherInfo(Teacher teacher);


    /**
     * 给未健康打卡的学生发送提示邮件
     * @param sid 学生学号
     * @param id 教师id
     */
    public void checkStudent(int sid,int id);
}
