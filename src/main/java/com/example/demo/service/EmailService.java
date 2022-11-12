package com.example.demo.service;

import com.example.demo.entity.EmailBox;

import java.util.List;

public interface EmailService {


    /**
     * 获取学生的所有邮件
     * @return 邮件实体类
     */
    public List<EmailBox> getStudentEmail();

    /**
     * 辅导员调用，给指定学生发邮件，注意增加email后，应检查学生邮件缓存，若已经缓存就要更新
     * @param email 邮件实体类 eid为空，其他都有值
     */
    public void addStudentEmail(EmailBox email);

    /**
     * 学生端调用，删除自己的邮件
     * @param eid 邮件编号
     */
    public void deleteStudentEmail(int eid);

}
