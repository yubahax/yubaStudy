package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;


@Entity  //表示这个类是一个实体类
@Table(name = "Item")    //对应的数据库中表名称
public class Item {

    @GeneratedValue(strategy = GenerationType.IDENTITY)   //生成策略，这里配置为自增
    @Column(name = "id")    //对应表中id这一列
    @Id     //此属性为主键
    int id;

    @Column(name = "username")   //对应表中username这一列
    String username;

    @Column(name = "password")   //对应表中password这一列
    String password;
}


