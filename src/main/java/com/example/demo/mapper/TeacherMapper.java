package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.vo.SubClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Results({
            @Result(column = "major", property = "major"),
            @Result(column = "grade", property = "grade"),
            @Result(column = "sum", property = "count"),
    })
    @Select("select major,grade,count(*) as sum\n" +
            "from student\n" +
            "where (major,grade) in (select major,grade from st where id  = #{id})\n" +
            "group by major,grade")
    List<SubClass> getMajorList(int id);




}
