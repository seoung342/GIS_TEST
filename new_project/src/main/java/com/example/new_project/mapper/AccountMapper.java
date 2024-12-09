package com.example.new_project.mapper;

import com.example.new_project.entity.Account;
import com.example.new_project.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {

    List<Account> selectAllAccount() throws Exception;

    void insertAccount(String id) throws Exception;

    void updateAccount(Account account) throws Exception;

    void deleteAccount(String account_num) throws Exception;
}
