package com.example.demo.service.impl;

import com.example.demo.Util.RedisUtils;
import com.example.demo.entity.Commodity;
import com.example.demo.mapper.CommodityMapper;
import com.example.demo.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
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
        commodityMapper.insert(commodity);
    }
}
