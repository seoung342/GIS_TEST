package com.example.new_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {

    private int account_num;
    private String user_id;
    private String create_date;
    private String state;
}
