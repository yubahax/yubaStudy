package com.example.demo.service;

import com.example.demo.entity.UserDetil;
import com.example.demo.mapper.UserMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserAuthService implements UserDetailsService {

    @Resource
    UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetil data = mapper.login(username);
        if(data == null) throw new UsernameNotFoundException("用户 "+username+" 登录失败，用户名不存在！");
        return User
                .withUsername(data.getName())
                .password(data.getPassword())
                .roles(data.getRole())
                .build();
    }
}

