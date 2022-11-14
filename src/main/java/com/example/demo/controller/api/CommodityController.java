package com.example.demo.controller.api;


import com.example.demo.Util.RedisUtils;
import com.example.demo.entity.Commodity;
import com.example.demo.service.CommodityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/commodity")
public class CommodityController {

    @Resource
    RedisUtils redisUtils;

    @Resource
    CommodityService commodityService;

    @GetMapping("/getStudentCommodity")
    public List<Commodity> getStudentCommodity(@RequestParam("type") String type){
        int sid = redisUtils.getStudent().getSid();
        return commodityService.getStudentCommodity(sid,type);
    }

    @GetMapping("/deleteCommodity")
    public void deleteCommodity(@RequestParam("cid") int cid,@RequestParam("type") String type){
        int sid = redisUtils.getStudent().getSid();
        commodityService.deleteCommodity(cid,type,sid);
    }
}
