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

    String email;
    public UserDetil(String name, String password, String role,String email) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.email = email;
    }
}
