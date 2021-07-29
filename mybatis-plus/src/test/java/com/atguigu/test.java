package com.atguigu;

import com.atguigu.srb.Srb;
import com.atguigu.srb.mybatisplus.mapper.UserMapper;
import com.atguigu.srb.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.lang.model.SourceVersion;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = Srb.class)
public class test {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        List<User> users = userMapper.selectList(null);

        for (User user : users) {
            System.out.println("user = " + user);
        }

    }

    @Test
    public void test02(){
        User user = userMapper.selectById(1);

        System.out.println("user = " + user);

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));

        for (User user1 : users) {
            System.out.println(user1);
        }

    }

    @Test
    public void test03(){
        User user = new User();

        user.setId(1L);
        user.setAge(100);

        int i = userMapper.updateById(user);
        System.out.println("影响行数 = " + i);

    }

    @Test
    public void test04(){
        int i = userMapper.deleteById(6);
        System.out.println("i = " + i);
    }
}
