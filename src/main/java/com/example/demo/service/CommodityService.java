package com.example.demo.service;

import com.example.demo.entity.Commodity;

import java.util.List;

public interface CommodityService {

    /**
     * 由于跑腿信息和闲置信息共用一个数据库，根据type选择对应的信息（select）
     *
     * @return 对应实体类
     */
    public List<Commodity> getCommodity();


    /**
     * 获取学生对应的跑腿或者闲置信息表（select）
     * @param sid 学生学号
     * @param ctype 类型 run代表跑腿 sold代表闲置物品信息
     * @return 实体类
     */
    public List<Commodity> getStudentCommodity(int sid,String ctype);

    /**
     * 插入一条跑腿或者闲置信息，两者共用一个service
     * @param commodity 信息实体类
     */
    public void addCommodity(Commodity commodity);

    /**
     * 按照主键删除信息，注意增删改操作要考虑更新redis中的缓存
     * @param cid 主键
     */
    public void deleteCommodity(int cid,String ctype,int sid);
}
