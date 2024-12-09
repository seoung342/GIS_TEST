package com.example.new_project.mapper;

import com.example.new_project.entity.Account;
import com.example.new_project.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectAllUser() throws Exception;

    User selectUserOne(User user) throws Exception;

    User selectUserByNum(String user_num) throws Exception;

    boolean selectUserCheck(String id) throws Exception;

    void insertUser(User user) throws Exception;

    void updateUser(User user) throws Exception;

    void deleteUser(String user_num) throws Exception;
}
