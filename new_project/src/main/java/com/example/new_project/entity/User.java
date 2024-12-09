package com.example.new_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private int user_num;
    private String id;
    private String pass;
    private String name;
    private String phone;
    private String email;
    private String state;

    public User(String id, String pass){
        this.id = id;
        this.pass = pass;
    }
}