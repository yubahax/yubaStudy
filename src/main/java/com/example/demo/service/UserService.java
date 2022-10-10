package com.example.demo.service;

import com.example.demo.entity.UserDetil;

public interface UserService {

    public boolean userRegister(UserDetil userDetil);

    public void sendVerifyCode(String email);

    public  boolean veriFyCodeIsTrue(String email,String code);

}
