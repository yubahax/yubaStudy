package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailBox {

    private int eid;
    private int sid;
    private String txt;
    private String gettime;
    private int sendid;


}
