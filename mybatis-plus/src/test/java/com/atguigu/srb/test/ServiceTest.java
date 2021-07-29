package com.atguigu.srb.test;

import com.atguigu.srb.Srb;
import com.atguigu.srb.mybatisplus.mapper.UserMapper;
import com.atguigu.srb.mybatisplus.service.UserService;
import com.atguigu.srb.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = Srb.class)
public class ServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test01(){
        int count = userService.count();
        System.out.println("count = " + count);


    }

    @Test
    public void test02(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("abc" + i);
            user.setAge(18 + i);
//            userService.save(user);
            users.add(user);
        }
        userService.saveBatch(users);
    }
    @Test
    public void test03(){

        List<User> tom = userService.listAllByName("tom");
        for (User user : tom) {
            System.out.println("user = " + user);
        }
    }


}
