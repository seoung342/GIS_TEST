package com.example.new_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Frequently_Question {

    private int faq_num;
    private String question;
    private String answer;

}
