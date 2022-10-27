package com.example.demo.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
//@RequestMapping(value = "数据绑定页面",method = RequestMethod.POST)
public class saveStudentInfo {

    public void saveStu(@RequestParam("sid") int sid,
                   @RequestParam("sname") String sname,
                   @RequestParam("sex") String sex,
                    @RequestParam("age") int age,
                    @RequestParam("grade") int grade,
                   @RequestParam("class") String class_name,
                   @RequestParam("room") String room){
       System.out.println("学号："+sid+"姓名："+sname
               +"性别："+sex+"年龄："+age+
               "年级："+grade+"班级："+class_name+"寝室号："+room);
    }
}
