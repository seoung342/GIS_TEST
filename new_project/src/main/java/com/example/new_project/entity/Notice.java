package com.example.new_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notice {

    private int notice_num;
    private String title;
    private String contents;
    private String hit_cnt;
    private String created_datetime;

    public Notice(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}
