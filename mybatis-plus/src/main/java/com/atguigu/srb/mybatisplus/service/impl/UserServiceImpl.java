package com.atguigu.srb.mybatisplus.service.impl;

import com.atguigu.srb.mybatisplus.mapper.UserMapper;
import com.atguigu.srb.mybatisplus.service.UserService;
import com.atguigu.srb.pojo.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public List<User> listAllByName(String name) {

        return baseMapper.selectAllByName("tom");
    }
}
