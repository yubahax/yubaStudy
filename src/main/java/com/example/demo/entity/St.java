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
@TableName("st")
public class St implements Serializable {
    @TableId(type = IdType.AUTO)
    private int stid;

    @TableField("id")
    private int id;

    @TableField("major")
    private String major;

    @TableField("grade")
    private int grade;
}
