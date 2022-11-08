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
@TableName("emailbox")
public class EmailBox {
    @TableId(type = IdType.AUTO)
    private int eid;

    @TableField("sid")
    private int sid;

    @TableField("txt")
    private String txt;

    @TableField("gettime")
    private String gettime;

    @TableField("sendid")
    private int sendid;


}
