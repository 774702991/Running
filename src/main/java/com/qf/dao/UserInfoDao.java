package com.qf.dao;

import com.qf.pojo.UserInfo;

import java.util.List;

public interface UserInfoDao {

    UserInfo getUserInfoById(Integer id);

    void addUserInfo(UserInfo userInfo);

    void updateUserInfo(UserInfo userInfo);

    void updateUserInfoImg(String img,Integer id);

    List<UserInfo> getUser();
}
