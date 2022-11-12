package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("teacher")
public class Teacher implements Serializable {

    int tid;

    @TableField("id")
    int id;

    @TableField("tname")
    String tname;

    @TableField("sex")
    String sex;

    @TableField("age")
    int age;

    @TableField("education")
    String education;

    @TableField("idcard")
    String idcard;

    @TableField("appointment")
    String appointment;
}
