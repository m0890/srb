package com.atguigu.srb.test;

import com.atguigu.srb.mybatisplus.mapper.UserMapper;
import com.atguigu.srb.pojo.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class InterceptorTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void test01(){

        Page<User> userPage = new Page<>(1,2);

        userMapper.selectPage(userPage,null);

        System.out.println(userPage);

    }

    @Test
    public void test02(){

        Page<User> userPage = new Page<>(1,2);

        userMapper.selectPageByPage(userPage,20);

        List<User> records = userPage.getRecords();

        for (User record : records) {
            System.out.println("record = " + record);
        }
    }
}
