package com.atguigu.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yufei
 * @create 2018-07-30 18:22
 */
@RestController
public class UserController {
    @Reference
    private UserService userService;

    /**
     * 查询用户的所有信息
     * @return
     */
    @RequestMapping("/getUserAll")
    public List<UserInfo> getUserAll() {

        List<UserInfo> list =  userService.getUserAll();

        return list;
    }

    /**
     * 查询单个用户的信息
     * @return
     */
    @RequestMapping("getUserInfoOne")
    public UserInfo getUserInfoOne(UserInfo userInfo) {

        UserInfo user = userService.getUserInfoOne(userInfo);

        return userInfo;
    }

    /**
     * 增加用户信息
     * @param userInfo
     */
    @RequestMapping("addaddUserInfo")
    public int addUserInfo(UserInfo userInfo) {

        int num = userService.addUserInfo(userInfo);

        return  num ;
    }
}
