package com.example.demo.controller.api;


import com.example.demo.Util.RedisUtils;
import com.example.demo.entity.Commodity;
import com.example.demo.service.CommodityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author lianx
 */
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

    @GetMapping("/getCommodity")
    public List<Commodity> getCommodity(){
        return commodityService.getCommodity();
    }

    @GetMapping("/getNewCommodity")
    public  List<Commodity> getNewCommodity(){
        List<Commodity> commodities = commodityService.getCommodity();
        if (commodities.size()< 5) {
            return commodities;
        } else {
            return commodities.subList(commodities.size() - 5, commodities.size());
        }
    }

    @GetMapping("/deleteCommodity")
    public void deleteCommodity(@RequestParam("cid") int cid,@RequestParam("type") String type){
        int sid = redisUtils.getStudent().getSid();
        commodityService.deleteCommodity(cid,type,sid);
    }

    @PostMapping("/sendCommodity")
    public void sendCommodity(@RequestBody Commodity commodity) {
        int sid = redisUtils.getStudent().getSid();
        commodity.setSid(sid);
        String time = commodity.getCtime().substring(0,10);
        commodity.setCtime(time);
        commodityService.addCommodity(commodity);

    }
}
