package com.example.demo.service.impl;

import com.example.demo.Util.RedisUtils;
import com.example.demo.entity.Commodity;
import com.example.demo.mapper.CommodityMapper;
import com.example.demo.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
@Service
public class CommodityServiceImpl implements CommodityService {

    @Resource
    CommodityMapper commodityMapper;

    @Resource
    RedisUtils redisUtils;

    @Override
    public List<Commodity> getCommodityByType(String ctype){
        List<Commodity> commodities = (List<Commodity>) redisUtils.get(ctype+"commodity");
        if (commodities == null) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("ctype", ctype);
            commodities = commodityMapper.selectByMap(map);
            redisUtils.set(ctype + "commodity", commodities);
        }
        return commodities;
    };

    @Override
    public List<Commodity> getStudentCommodity(int sid, String ctype) {
        List<Commodity> commodities = (List<Commodity>) redisUtils.get("student"+sid+ctype+"commodity");
        if (commodities == null) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("sid", sid);
            map.put("ctype", ctype);
            commodities = commodityMapper.selectByMap(map);
            redisUtils.set("student" + sid + ctype + "commodity", commodities);
        }
        return commodities;
    }

    @Override
    public void addCommodity(Commodity commodity) {
        List<Commodity> commodities = (List<Commodity>) redisUtils.get(commodity.getCtype()+"commodity");
        //获取主页面commodities缓存
        if (commodities != null) {
            commodities.add(0,commodity);
            //插入至第一位
            redisUtils.set(commodity.getCtype() + "commodity", commodities);
            //更新主页面中commodities缓存
        }
        commodities = (List<Commodity>) redisUtils.get("student"+commodity.getSid()+commodity.getCtype()+"commodity");
        //获取学生commodities缓存
        if (commodities != null) {
            commodities.add(0,commodity);
            //插入至第一位
            redisUtils.set("student"+commodity.getSid()+commodity.getCtype()+"commodity", commodities);
            //更新学生管理页面中的commodities缓存
        }
        commodityMapper.insert(commodity);
    }

    @Override
    public void deleteCommodity(int cid,String ctype,int sid) {
        List<Commodity> commodities = (List<Commodity>) redisUtils.get(ctype+"commodity");
        //获取主页面commodities缓存
        if(commodities != null){
            Iterator<Commodity> iterator = commodities.iterator();
            while(iterator.hasNext()) {
                Commodity commodity = iterator.next();
                if(commodity.getCid() == cid) {
                    iterator.remove();
                    //从缓存中删除信息
                    break;
                }
            }
            redisUtils.set(ctype+"commodity",commodities);
        }
        commodities = (List<Commodity>) redisUtils.get("student"+sid+ctype+"commodity");
        //获取学生commodities缓存
        if(commodities != null){
            Iterator<Commodity> iterator = commodities.iterator();
            while(iterator.hasNext()) {
                Commodity commodity = iterator.next();
                if(commodity.getCid() == cid) {
                    iterator.remove();
                    //从缓存中删除信息
                    break;
                }
            }
            redisUtils.set(ctype+"commodity",commodities);
        }
        commodityMapper.deleteById(cid);
    }
}
