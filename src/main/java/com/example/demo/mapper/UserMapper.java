package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.example.demo.entity.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserMapper extends BaseMapper<User> {


    @Select("select * from user where name = #{name}")
    User selectByName(@Param("name") String name);

    @Insert("insert into user(name,password,role,email) values(#{name},#{password},#{role},#{email})")
    void saveUser(User user);

}
