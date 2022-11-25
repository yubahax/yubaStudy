package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("student")
public class Student implements Serializable {

    private int sid;

    @TableField("id")
    private int id;

    @TableField("sname")
    private String sname;

    @TableField("age")
    private int age;

    @TableField("sex")
    private String sex;

    @TableField("room")
    private String room;

    @TableField("grade")
    private int grade;

    @TableField("major")
    private String major;

    public static StudentBuilder builder(){   //通过builder方法直接获取建造者
        return new StudentBuilder();
    }

    public static class StudentBuilder{
        int sid;
        int id;

        String sname;
        int age;

        String sex;

        String room;
        int grade;

        String major;

        public StudentBuilder sid(int sid){
            this.sid = sid;
            return this;
        }
        public StudentBuilder id(int id){
            this.id = id;
            return this;
        }

        public StudentBuilder sname(String sname){
            this.sname = sname;
            return this;
        }
        public StudentBuilder room(String room){
            this.room = room;
            return this;
        }
        public StudentBuilder age(int age){
            this.age = age;
            return this;
        }
        public StudentBuilder sex(String sex){
            this.sex = sex;
            return this;
        }

        public StudentBuilder major(String major){
            this.major = major;
            return this;
        }
        public Student build(){    //最后我们只需要调用建造者提供的build方法即可根据我们的配置返回一个对象
            return new Student(id,sid,sname, age, sex, room, grade, major);
        }
    }


}
