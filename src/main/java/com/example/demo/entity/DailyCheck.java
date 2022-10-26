package com.example.demo.entity;

import lombok.Data;

@Data
public class DailyCheck {
    private int did;
    private int sid;
    private String daytemp;
    private String nighttemp;
    private String checktime;
}
