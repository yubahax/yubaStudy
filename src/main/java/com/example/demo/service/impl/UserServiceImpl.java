package com.example.demo.service.impl;

import com.example.demo.Util.RedisUtils;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Resource
    StudentMapper studentMapper;

    @Resource
    private JavaMailSender sender;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Resource
    RedisUtils redisUtils;



    @Override
    public boolean userRegister(User user) {
        if (userMapper.selectByName(user.getName()) == null) {
            userMapper.saveUser(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void sendVerifyCode(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("[渝教育 智慧校园] 您的验证码");
        Random random = new Random();
        int code = random.nextInt(899999) + 100000;
        stringRedisTemplate.opsForValue().set("verify:code:" + email, code + "", 3, TimeUnit.MINUTES);
        message.setText("您的验证码为：" + code + ",三分钟内有效，请及时完成注册!如果不是本人操作,请忽略");
        message.setTo(email);
        message.setFrom("571239193@qq.com");
        sender.send(message);
    }

    @Override
    public boolean verifiyCodeIsTrue(String email, String code) {
        String string = stringRedisTemplate.opsForValue().get("verify:code:" + email);
        if (string == null) {
            return false;
        }
        return code.equals(string);
    }



    @Override
    public User selectUserByName(String name) {
        return userMapper.selectByName(name);

    }



    @Override
    public void modifyUserInfo(User user){
        redisUtils.set(user.getName(), user);
        userMapper.modifyUser(user);
    }


}
