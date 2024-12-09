package com.example.new_project.service;

import com.example.new_project.entity.Frequently_Question;

import java.util.List;

public interface FAQService {
    List<Frequently_Question> selectAllFAQ() throws Exception;
}
