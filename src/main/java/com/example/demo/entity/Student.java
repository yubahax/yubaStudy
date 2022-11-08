package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("student")
public class Student {

    @TableId(type = IdType.AUTO)
    private int sid;

    @TableField("id")
    private int id;

    @TableField("sname")
    private String sname;

    @TableField("age")
    private int age;

    @TableField("sex")
    private String sex;

    @TableField("room")
    private String room;

    @TableField("grade")
    private int grade;

    @TableField("major")
    private String major;

}
