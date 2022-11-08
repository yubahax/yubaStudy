package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("relationship")
public class Relationship {
    @TableId(type = IdType.AUTO)
    private int rid;

    @TableField("bid")
    private int bid;

    @TableField("sid")
    private int sid;
}
