package com.qf.service;

import com.qf.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {

    UserInfo getUserInfoById(Integer id);

    void addUserInfo(UserInfo userInfo);

    void updateUserInfo(UserInfo userInfo);

    void updateUserInfoImg(String img,Integer id);

    List<UserInfo> getUser();
}
