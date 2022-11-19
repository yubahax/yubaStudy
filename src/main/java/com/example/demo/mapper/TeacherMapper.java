package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.EmailBox;
import com.example.demo.entity.LeaveApproval;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.vo.SubClass;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher>{

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

    @Select("select * from leaveapproval\n" +
            "where sid \n" +
            "in \n" +
            "(select sid from student \n" +
            "where (major,sid)\n" +
            "in \n" +
            "(select major,sid from st where id = #{id})\n" +
            ")")
    List<LeaveApproval> getStudentApproval(int id);

    @Update("update leaveapproval set status = #{status} where lid = #{lid}")
    void changeApprovalStatus(int lid,int status);

    @Select("select * from student\n" +
            "where sid in \n" +
            "(select sid from student where (major,sid)\n" +
            "in \n" +
            "(select major,sid from st where id = #{id})\n" +
            ")\n" +
            "AND\n" +
            "sid not in(select sid from dailycheck where checktime = #{time})")
    List<Student> getNoCheckStudent(@Param("id") int id ,@Param("time") String time);


    @Update("update teacher set tname = #{tname},sex = #{sex},age = #{age},education = #{education},idcard = #{idcard},appointment = #{appointment} where id = #{id}")
    void updateTeacherInfo(Teacher teacher);

    @Insert("insert into emailbox (sid,txt,gettime,sendid) values(#{sid},#{txt},#{gettime},#{sendid})")
    void checkStudent(EmailBox emailBox);
}
