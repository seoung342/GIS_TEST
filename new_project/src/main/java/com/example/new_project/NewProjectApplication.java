package com.example.new_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewProjectApplication.class, args);

    }

    /*
    Postgre Sql db

    문자열 비교할 때 대, 소문자 구분함

    --- 계정 정보
create table account (
    account_num serial primary key,
    user_id varchar(20) not null,
    create_date timestamp not null default current_timestamp,
    state varchar(20) not null default 'user'
);

-- 사용자 정보
create table "user" (
    user_num serial primary key,
    id varchar(20) unique,
    pass varchar(20) not null,
    name varchar(20) unique,
    phone varchar(30) not null,
    email varchar(30) not null,
    state varchar(20) not null default 'user'
);

-- 공지사항
create table notice (
    notice_num serial primary key,
    title varchar(300) not null,
    contents text not null,
    hit_cnt int not null default 0,
    created_datetime timestamp not null default current_timestamp
);

-- 자주 묻는 질문
create table frequently_asked_question (
    faq_num serial primary key,
    question text not null,
    answer text not null
);

-- 문의사항 질문
create table question_user (
    question_num serial primary key,
    contents text not null,
    created_datetime timestamp not null default current_timestamp,
    creator_id varchar(20) not null,
    answer_yn char(1) not null default 'n'
);

-- 문의 사항 답변
create table question_answer (
    answer_num serial primary key,
    question_num int not null,
    contents text not null,
    created_datetime timestamp not null default current_timestamp
);

      **/

}
