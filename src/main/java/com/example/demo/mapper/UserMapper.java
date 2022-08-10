package com.example.demo.mapper;

import com.example.demo.entity.UserDetil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where name = #{name}")
    UserDetil login(@Param("name") String name);


}
