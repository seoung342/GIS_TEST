package com.example.new_project.service;

import com.example.new_project.entity.User;
import com.example.new_project.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public List<User> selectAllUser() throws Exception {
        return userMapper.selectAllUser();
    }

    @Override
    public User selectUserOne(User user) throws Exception {
        return userMapper.selectUserOne(user);
    }

    @Override
    public User selectUserByNum(String user_num) throws Exception {
        return userMapper.selectUserByNum(user_num);
    }

    @Override
    public boolean selectUserCheck(String id) throws Exception {
        return userMapper.selectUserCheck(id);
    }

    @Override
    public void insertUser(User user) throws Exception {
        userMapper.insertUser(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(String user_num) throws Exception {
        userMapper.deleteUser(user_num);
    }
}
