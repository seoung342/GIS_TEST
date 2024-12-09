package com.example.new_project.service;

import com.example.new_project.entity.Account;
import com.example.new_project.mapper.AccountMapper;
import com.example.new_project.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;

    @Override
    public List<Account> selectAllAccount() throws Exception {
        return accountMapper.selectAllAccount();
    }

    @Override
    public void insertAccount(String user_id) throws Exception {
        accountMapper.insertAccount(user_id);
    }

    @Override
    public void updateAccount(Account account) throws Exception {
        accountMapper.updateAccount(account);
    }

    @Override
    public void deleteAccount(String account_num) throws Exception {
        accountMapper.deleteAccount(account_num);
    }
}
