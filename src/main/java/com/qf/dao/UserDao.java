package com.qf.dao;

import com.qf.pojo.User;

public interface UserDao {

    User getUserById(User user);

    void addUser(User user);
}
