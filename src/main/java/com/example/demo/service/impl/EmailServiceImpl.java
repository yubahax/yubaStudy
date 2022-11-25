package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.example.demo.Util.RedisUtils;
import com.example.demo.entity.EmailBox;
import com.example.demo.entity.User;
import com.example.demo.mapper.EmailBoxMapper;
import com.example.demo.service.EmailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
@Service
public class EmailServiceImpl implements EmailService {

    @Resource
    EmailBoxMapper emailBoxMapper;

    @Resource
    RedisUtils redisUtils;

    @Override
    public List<EmailBox> getStudentEmail() {
        int sid = redisUtils.getStudent().getSid();
        List<EmailBox> emailBoxes = (List<EmailBox>) redisUtils.get("student"+sid+"emailBoxes");
        //获取emailBoxes的缓存
        if(emailBoxes == null) {
            emailBoxes = emailBoxMapper.selectList(new EntityWrapper<EmailBox>().eq("sid",sid));
            redisUtils.set("student"+sid+"emailBoxes", emailBoxes);
        }
        return emailBoxes;
    }

    @Override
    public void addStudentEmail(EmailBox email) {
        int sid = redisUtils.getStudent().getSid();
        List<EmailBox> emailBoxes = (List<EmailBox>) redisUtils.get("student"+sid+"emailBoxes");
        //获取emailBoxes的缓存
        if(emailBoxes != null){
            emailBoxes.add(0,email);
            redisUtils.set("student"+sid+"emailBoxes",emailBoxes);
        }
        emailBoxMapper.insert(email);
    }

    @Override
    public void deleteStudentEmail(List<String> strs) {
        int sid = redisUtils.getStudent().getSid();
        List<EmailBox> emailBoxes = (List<EmailBox>) redisUtils.get("student"+sid+"emailBoxes");
        //获取emailBoxes的缓存
        int i = 0;
        if(emailBoxes != null){
            emailBoxes = null;
            redisUtils.set("student"+sid+"emailBoxes",emailBoxes);

        }
        emailBoxMapper.deleteBatchIds(strs);
    }


}
