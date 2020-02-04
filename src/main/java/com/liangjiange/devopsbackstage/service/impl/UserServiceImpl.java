package com.liangjiange.devopsbackstage.service.impl;

import com.liangjiange.devopsbackstage.entity.User;
import com.liangjiange.devopsbackstage.mapper.UserMapper;
import com.liangjiange.devopsbackstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }
}
