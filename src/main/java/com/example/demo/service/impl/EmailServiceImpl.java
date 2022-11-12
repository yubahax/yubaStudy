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
    public void deleteStudentEmail(int eid) {
        int sid = redisUtils.getStudent().getSid();
        List<EmailBox> emailBoxes = (List<EmailBox>) redisUtils.get("student"+sid+"emailBoxes");
        //获取emailBoxes的缓存
        if(emailBoxes != null){
            Iterator<EmailBox> iterator = emailBoxes.iterator();
            while(iterator.hasNext()) {
                EmailBox emailBox = iterator.next();
                if(emailBox.getEid() == eid) {
                    iterator.remove();
                    //从缓存中删除邮件信息
                    break;
                }
            }
            redisUtils.set("student"+sid+"emailBoxes",emailBoxes);
        }
        emailBoxMapper.deleteById(eid);
    }
}
