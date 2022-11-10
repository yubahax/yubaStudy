package com.example.demo.service;

import com.example.demo.entity.DailyCheck;
import com.example.demo.entity.LeaveApproval;
import com.example.demo.entity.Student;

import javax.servlet.http.HttpSession;

public interface StudentService {
    /**
     * 判断当前用户的学生信息是否存在
     * @param session 会话session，由controller传入
     * @param name 用户名
     * @return 用户存在则true，不存在则为false
     */
    public boolean ifStudentInfoIsExist(HttpSession session, String name);

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

    /**
     * 根据学生的用户id，查找对应学生基本信息
     * @param id 用户id
     * @return 对应学生实体类
     */
    public Student getStudentByUserId(int id);

    /**
     * 学生添加(insert)一条请假信息
     * @param leaveApproval 请假信息，注意：请假信息中lid为空，
     *                      不需要插入由数据库自增，sendtime
     *                      也为空，由impl赋值 格式为yyyy-M
     *                      M-dd HH:mm:ss，精确到秒
     */
    public void addLeaveApproval(LeaveApproval leaveApproval);

    /**
     * 学生每日健康打卡
     * 打卡信息，注意：打卡中did为数据库自增处理，checktime也为空，
     * 插入数据库时，其由impl赋值，格式为yyyy-MM-dd，精确到天
     * @param sid 学号
     * @param daytemp 早间体温
     * @param nighttemp 晚间体温
     */
    public void addDailyCheck(int sid,String daytemp,String nighttemp);
}
