package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.example.demo.entity.User;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where name = #{name}")
    User selectByName(@Param("name") String name);
    @Insert("insert into user(name,password,role,email) values(#{name},#{password},#{role},#{email})")
    void saveUser(User user);
    @Update("UPDATE user SET name = #{name}, password=#{password}, email= #{email} where id = #{id}")
    void  modifyUser(User user);
}
