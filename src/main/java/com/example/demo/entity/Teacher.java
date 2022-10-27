package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    int tid;
    int id;
    String tname;
    String sex;
    int age;
    String education;
    String idcard;
    String appointment;
}
