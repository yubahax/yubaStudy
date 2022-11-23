package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lianx
 *
 */
@Data
@TableName("dailycheck")
public class DailyCheck implements Serializable {
    @TableId(type = IdType.AUTO)
    private int did;
    //  打卡id 不管
    @TableField("sid")
    private int sid;
    //  学号 不管
    @TableField("daytemp")
    private String daytemp;
    //早间体温
    @TableField("nighttemp")
    private String nighttemp;
    //晚间体温
    @TableField("checktime")
    private String checktime;
    //打卡时间 不管
}
