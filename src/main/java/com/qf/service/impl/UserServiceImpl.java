package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(User user) {
        return userDao.getUserById(user);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
