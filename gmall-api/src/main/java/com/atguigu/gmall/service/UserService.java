package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserInfo;

import java.util.List;

/**
 * @author yufei
 * @create 2018-07-30 18:38
 */
public interface UserService {
    List<UserInfo> getUserAll();
    UserInfo getUserInfoOne(UserInfo userInfo);

    int addUserInfo(UserInfo userInfo);
}
