package com.qf.service.impl;

import com.qf.dao.AdminDao;
import com.qf.pojo.User;
import com.qf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public User getAdmin(User user) {
        return adminDao.getAdmin(user);
    }
}
