package com.atguigu.srb.mybatisplus.controller;

import com.atguigu.srb.mybatisplus.service.UserService;
import com.atguigu.srb.pojo.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/list")
    public List<User> list(){
        return userService.list();
    }

}
