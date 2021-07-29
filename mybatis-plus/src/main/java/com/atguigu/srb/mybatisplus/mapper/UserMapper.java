package com.atguigu.srb.mybatisplus.mapper;

import com.atguigu.srb.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> selectAllByName(String name);

    Page<User> selectPageByPage(Page<?> page, Integer age);
}
