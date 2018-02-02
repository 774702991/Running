package com.qf.service.impl;

import com.qf.dao.UserInfoDao;
import com.qf.pojo.UserInfo;
import com.qf.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo getUserInfoById(Integer id) {
        return userInfoDao.getUserInfoById(id);
    }

    @Override
    public void addUserInfo(UserInfo userInfo) {
        userInfoDao.addUserInfo(userInfo);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoDao.updateUserInfo(userInfo);
    }

    @Override
    public void updateUserInfoImg(String img,Integer id) {
        userInfoDao.updateUserInfoImg(img,id);
    }

    @Override
    public List<UserInfo> getUser() {
        return userInfoDao.getUser();
    }
}
