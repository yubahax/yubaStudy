package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.*;

/**
 * 学生mapper
 * @author yuba
 *
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    /**
     *根据传入的sid查找一个学生，封装为实体类并返回
     *
     * @param sid 传入当前学生的sid
     * @return Student 返回一个学生实体类
     */
    @Select("select * from student where sid = #{sid}")
    Student selectStudentBysId(int sid);

    /**
     * 通过id更改学生基本信息
     * @param student 传入一个学生实体类
     */
    @Update("update student set sname = #{sname},age = #{age},sex = #{sex},room = #{room},major = #{major},grade = #{grade} where id = #{id}")
    void updateStudentById(Student student);

    /**
     * 根据学生的用户id，查找对应学生基本信息
     * @param id 用户id
     * @return 对应学生实体类
     */
    @Select("select * from student where id = #{id}")
    Student getStudentByUserId(int id);


}
