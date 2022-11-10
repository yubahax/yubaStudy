package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.entity.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    /**
     * 用户注册，只有学生需要注册，辅导员内部账号
     * @param user 注册信息封装为实体类
     * @return 注册成功为true，注册失败为false
     */
    public boolean userRegister(User user);

    /**
     * 发送邮箱验证码
     * @param email 用户注册时填写的邮箱
     */
    public void sendVerifyCode(String email);

    /**
     * 用户注册时，校对邮箱验证码是否正确
     * @param email 邮箱
     * @param code 验证码
     * @return 验证码校对成功为true，失败为false；
     */
    public  boolean verifiyCodeIsTrue(String email,String code);

    /**
     * 判断当前用户的学生信息是否存在
     * @param session 会话session，由controller传入
     * @param name 用户名
     * @return 用户存在则true，不存在则为false
     */
    public boolean ifStudentInfoIsExist(HttpSession session,String name);

    /**
     * 根据用户名查找用户信息
     * @param name 用户名
     * @return 用户实体类
     */
    public User selectUserByName(String name);



    /**
     * 修改用户信息
     * @param user 用户信息
     */
    public void modifyUserInfo(User user);


}
