package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.entity.User;

import javax.servlet.http.HttpSession;

public interface UserService {

    public boolean userRegister(User user);

    public void sendVerifyCode(String email);

    public  boolean verifiyCodeIsTrue(String email,String code);

    public boolean ifStudentInfoIsEXist(HttpSession session,String name);

    public User selectUserByName(String name);

    public void saveStudentInfo(Student student);

}
