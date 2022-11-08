package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/**
 * @author lianx
 *
 */
@Data
@TableName("dailycheck")
public class DailyCheck {
    @TableId(type = IdType.AUTO)
    private int did;

    @TableField("sid")
    private int sid;

    @TableField("daytemp")
    private String daytemp;

    @TableField("nighttemp")
    private String nighttemp;

    @TableField("checktime")
    private String checktime;

}
