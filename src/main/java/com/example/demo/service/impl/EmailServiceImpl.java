package com.example.demo.service.impl;

import com.example.demo.Util.RedisUtils;
import com.example.demo.entity.EmailBox;
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
        List<EmailBox> emailBoxes = (List<EmailBox>) redisUtils.get("emailBoxes");
        //获取emailBoxes的缓存
        if(emailBoxes == null) {
            emailBoxes = emailBoxMapper.selectList(null);
            redisUtils.set("emailBoxes", emailBoxes);
        }
        return emailBoxes;
    }

    @Override
    public void addStudentEmail(EmailBox email) {
        List<EmailBox> emailBoxes = (List<EmailBox>) redisUtils.get("emailBoxes");
        //获取emailBoxes的缓存
        if(emailBoxes != null){
            emailBoxes.add(0,email);
            redisUtils.set("emailBoxes",emailBoxes);
        }
        emailBoxMapper.insert(email);
    }

    @Override
    public void deleteStudentEmail(int eid) {
        List<EmailBox> emailBoxes = (List<EmailBox>) redisUtils.get("emailBoxes");
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
            redisUtils.set("emailBoxes",emailBoxes);
        }
        emailBoxMapper.deleteById(eid);
    }
}
