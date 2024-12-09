package com.example.new_project.service;

import com.example.new_project.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> selectAllAccount() throws Exception;

    void insertAccount(String user_id) throws Exception;

    void updateAccount(Account account) throws Exception;

    void deleteAccount(String account_num) throws Exception;
}
