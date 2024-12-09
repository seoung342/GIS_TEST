package com.example.new_project.service;

import com.example.new_project.entity.Account;
import com.example.new_project.entity.Frequently_Question;
import com.example.new_project.mapper.AccountMapper;
import com.example.new_project.mapper.FAQMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FAQServiceImpl implements FAQService {

    private final FAQMapper faqMapper;

    @Override
    public List<Frequently_Question> selectAllFAQ() throws Exception {
        return faqMapper.selectAllFAQ();
    }
}
