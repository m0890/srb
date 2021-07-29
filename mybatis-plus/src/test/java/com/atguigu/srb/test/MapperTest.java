package com.atguigu.srb.test;

import com.atguigu.srb.Srb;
import com.atguigu.srb.mybatisplus.mapper.UserMapper;
import com.atguigu.srb.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = Srb.class)
public class MapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test001(){
        User user = userMapper.selectById(1L);
        System.out.println(user);

    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("wow");
        user.setAge(18);

        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
        System.out.println("id:" + user.getId());

    }

    @Test
    public void test01(){
        List<User> users = userMapper.selectAllByName("tom");
        System.out.println("users = " + users);

    }

    @Test
    public void test02(){
        userMapper.deleteById(1);

    }
}
