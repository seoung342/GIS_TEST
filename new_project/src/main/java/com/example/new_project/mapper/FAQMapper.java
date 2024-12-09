package com.example.new_project.mapper;

import com.example.new_project.entity.Frequently_Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FAQMapper {

    List<Frequently_Question> selectAllFAQ() throws Exception;

}
