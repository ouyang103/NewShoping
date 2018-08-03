package com.atguigu.gmall.user.service.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.user.mapper.UserMapper;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author yufei
 * @create 2018-07-30 18:44
 */
@Service
public class UserSericeImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserInfo> getUserAll() {
        return userMapper.selectAll();
    }

    @Override
    public UserInfo getUserInfoOne(UserInfo userInfo) {
        return userMapper.selectOne(userInfo);
    }

    @Override
    public int addUserInfo(UserInfo userInfo) {
        return userMapper.insert(userInfo);
    }
}
