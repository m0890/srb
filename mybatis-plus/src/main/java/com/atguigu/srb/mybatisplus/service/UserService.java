package com.atguigu.srb.mybatisplus.service;

import com.atguigu.srb.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<User> {

    List<User> listAllByName(String name);

}
