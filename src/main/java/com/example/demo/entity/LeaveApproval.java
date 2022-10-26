package com.example.demo.entity;

import lombok.Data;

@Data
public class LeaveApproval {
    private int lid;
    private int sid;
    private String starttime;
    private String endtime;
    private String sendtime;
    private String reason;
    private String place;
    private int status;

}
