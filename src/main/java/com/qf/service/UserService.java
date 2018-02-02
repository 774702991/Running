package com.qf.service;

import com.qf.pojo.User;

public interface UserService {

    User getUserById(User user);

    void addUser(User user);
}
