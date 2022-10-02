package com.example.demo.service.impl;

import com.example.demo.entity.UserDetil;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public boolean userRegister(UserDetil userDetil) {
        if (userMapper.selectByName(userDetil.getName()) == null) {
            userMapper.saveUser(userDetil);
            return true;
        } else {
            return false;
        }
    }
}
