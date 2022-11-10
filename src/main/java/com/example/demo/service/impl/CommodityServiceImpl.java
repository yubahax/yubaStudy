package com.example.demo.service.impl;

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

    @Override
    public List<Commodity> getCommodityByType(String ctype){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ctype",ctype);
        return commodityMapper.selectByMap(map);
    };

    @Override
    public List<Commodity> getStudentCommodity(int sid, String ctype) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sid",sid);
        map.put("ctype",ctype);
        return commodityMapper.selectByMap(map);
    }

    @Override
    public void addCommodity(Commodity commodity) {
        commodityMapper.insert(commodity);
    }
}
