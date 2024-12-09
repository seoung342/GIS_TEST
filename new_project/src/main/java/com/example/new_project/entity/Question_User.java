package com.example.new_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Question_User {

    private int question_num;
    private String contents;
    private String created_datetime;
    private String creator_id;
    private String answer_yn;

}
