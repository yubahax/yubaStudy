package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@Data
@TableName("leaveapproval")
public class LeaveApproval {
    @TableId(type = IdType.AUTO)
    private int lid;

    @TableField("sid")
    private int sid;

    @TableField("starttime")
    private String starttime;

    @TableField("endtime")
    private String endtime;

    @TableField("sendtime")
    private String sendtime;

    @TableField("reason")
    private String reason;

    @TableField("place")
    private String place;

    @TableField("status")
    private int status;

}
