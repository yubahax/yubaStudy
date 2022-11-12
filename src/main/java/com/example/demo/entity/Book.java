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
@TableName("book")
public class Book implements Serializable {

    @TableId(type = IdType.AUTO)
    private int bid;

    @TableField("title")
    private String title;

    @TableField("author")
    private String author;

    @TableField("address")
    private String address;

    @TableField("type")
    private String type;

    @TableField("isalive")
    private int isalive;
}
