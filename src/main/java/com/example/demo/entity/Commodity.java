package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("commodity")
public class Commodity {
    @TableId(type = IdType.AUTO)
    private int cid;

    @TableField("sid")
    private int sid;

    @TableField("ctime")
    private String ctime;

    @TableField("cmoney")
    private int cmoney;

    @TableField("caddress")
    private String caddress;

    @TableField("memo")
    private String memo;

    @TableField("isalive")
    private int isalive;

    @TableField("ctype")
    private String ctype;



}
