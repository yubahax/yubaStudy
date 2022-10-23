package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    @Results({
            @Result(id = true, column = "sid", property = "sid"),
            @Result(column = "sname", property = "sname"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "age", property = "age"),
            @Result(column = "room", property = "room"),
            @Result(column = "class", property = "major"),
            @Result(column = "grade", property = "grade"),
            @Result(column = "id", property = "id"),
    })
    @Select("select * from student where id = #{id}")
    Student selectStudentById(int id);




}
