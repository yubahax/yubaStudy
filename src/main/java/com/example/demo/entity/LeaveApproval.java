package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("leaveapproval")
public class LeaveApproval implements Serializable {
    @TableId(type = IdType.AUTO)
    private int lid;
    //请假编号 不管
    @TableField("sid")
    private int sid;
    //学号 不管
    @TableField("starttime")
    private String starttime;
    //离校时间
    @TableField("endtime")
    private String endtime;
    //返校时间
    @TableField("sendtime")
    private String sendtime;
    //申请时间 不管
    @TableField("reason")
    private String reason;
    //离校原因
    @TableField("place")
    private String place;
    //外出地址
    @TableField("status")
    private int status;
    //状态 不管
}
