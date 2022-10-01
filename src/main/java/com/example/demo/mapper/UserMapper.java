package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.UserDetil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserDetil> {


    @Select("select * from user where name = #{name}")
    UserDetil login(@Param("name") String name);

    @Select("select * from user")
    List<UserDetil> getAll();
}
