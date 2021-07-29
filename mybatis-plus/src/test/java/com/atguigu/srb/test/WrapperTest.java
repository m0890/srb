package com.atguigu.srb.test;

import com.atguigu.srb.mybatisplus.mapper.UserMapper;
import com.atguigu.srb.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.lang.model.SourceVersion;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
public class WrapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void test01(){
        //查询名字中包含n，年龄大于等于10且小于等于20，email不为空的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.like("name","n").between("age",20,30).isNotNull("email");

        List<User> users = userMapper.selectList(queryWrapper);

        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void test02(){
        //按年龄降序查询用户，如果年龄相同则按id升序排列
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.orderByDesc("age").orderByAsc("id");

        List<User> users = userMapper.selectList(queryWrapper);

        for (User user : users) {
            System.out.println("user = " + user);
        }

    }

    @Test
    public void test03(){
        //删除email为空的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.isNotNull("email");

        int delete = userMapper.delete(queryWrapper);

        System.out.println("delete = " + delete);


    }

    @Test
    public void test04(){
        //查询名字中包含n，且（年龄小于18或email为空的用户），并将这些用户的年龄设置为18，邮箱设置为 user@atguigu.com

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        userQueryWrapper.like("name","a").and(i-> i.lt("age",28).or().isNotNull("email"));

        User user = new User();
        user.setAge(18);
        user.setEmail("user@atguigu.com");

        int update = userMapper.update(user, userQueryWrapper);
        System.out.println("update = " + update);

    }

    @Test
    public void test05(){
        //查询所有用户的用户名和年龄
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age");

        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        for (Map<String, Object> map : maps) {
            System.out.println("map = " + map);

            }
        }
     @Test
    public void test06(){
        //查询id不大于3的所有用户的id列表
         QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            //sql注入
//         queryWrapper.inSql("id","select id from user where id<=3");

         queryWrapper.le("id",3);
         List<Object> objects = userMapper.selectObjs(queryWrapper);
         for (Object object : objects) {
             System.out.println("object = " + object);
         }

     }

     @Test
    public void test07(){
        //查询名字中包含n，且（年龄小于18或email为空的用户），并将这些用户的年龄设置为18，邮箱设置为 user@atguigu.com
         UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();

         updateWrapper.set("age",18).set("email","user@atguigu.com").like("name","a").and(i->i.lt("age",28).or().isNotNull("email"));
         User user = new User();
         int update = userMapper.update(user, updateWrapper);
         System.out.println("update = " + update);

     }

     @Test

    public void test08(){
        //查询名字中包含n，年龄大于10且小于20的用户，查询条件来源于用户输入，是可选的
         QueryWrapper<User> queryWrapper = new QueryWrapper<>();

         String name = null;
         Integer maxage = 20;
         Integer minage=10;

         queryWrapper.like("name","a").gt(minage!=null,"age",minage).lt(maxage!=null,"age",maxage);
         List<User> users = userMapper.selectList(queryWrapper);
         for (User user : users) {
             System.out.println("user = " + user);
         }


     }




}
