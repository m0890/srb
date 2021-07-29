package com.atguigu.srb.test;

import com.atguigu.srb.mybatisplus.mapper.ProductMapper;
import com.atguigu.srb.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class productTest {

    @Resource
    private ProductMapper productMapper;

    @Test
    public void test01(){

        Product p1 = productMapper.selectById(1L);

        Product p2 = productMapper.selectById(1L);

        p1.setPrice(p1.getPrice()+50);
        productMapper.updateById(p1);
        System.out.println(p1.getPrice());

        p2.setPrice(p2.getPrice() - 30);
        int i = productMapper.updateById(p2);
        System.out.println(p2.getPrice());

        if (i == 0){
            Product p3 = productMapper.selectById(1L);
            p3.setPrice(p3.getPrice() - 30);
            productMapper.updateById(p3);
        }
        System.out.println(productMapper.selectById(1L).getPrice());


    }

}
