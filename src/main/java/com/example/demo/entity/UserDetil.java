package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetil {
    int id;
    String name;
    String password;
    String role;

    public UserDetil(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }
}
