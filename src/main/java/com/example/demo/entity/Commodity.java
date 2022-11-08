package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commodity {
    private int cid;
    private int sid;
    private String ctime;
    private int cmoney;
    private String caddress;
    private String memo;
    private int isalive;
    private String ctype;



}
