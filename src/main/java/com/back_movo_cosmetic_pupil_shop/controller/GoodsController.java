package com.back_movo_cosmetic_pupil_shop.controller;

import com.alibaba.fastjson.JSONArray;
import com.back_movo_cosmetic_pupil_shop.entity.Goods;
import com.back_movo_cosmetic_pupil_shop.service.GoodsService;
import com.back_movo_cosmetic_pupil_shop.tools.GetStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Goods)表控制层
 *
 * @author makejava
 * @since 2023-04-18 14:12:16
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsService goodsService;

    /**
     * 查询热门商品
     *
     * @return 单条数据
     */
    @GetMapping("/hot")
    public Map<String, Object> queryById() {
        Map<String, Object> map = new HashMap<>();
        Goods goods = goodsService.queryById(1);
        map.put("topImg", goods.getTopImg());
        //String 转 JSON
        map.put("shufflingFigure", JSONArray.parseArray(goods.getShufflingFigure()));
        map.put("bottomImg", goods.getBottomImg());
        return map;
    }


    /**
     * 首页-查询 全部商品
     *
     * @return 对象列表
     */
    @GetMapping("/AllGoods")
    public List<Map<String,Object>> queryAllGoods(){
//        最后过滤完要返回的list
        List<Map<String,Object>> goodsHomeList = new ArrayList<Map<String,Object>>();
//        查询goods全表的list
        List<Goods> goodsList = goodsService.queryAllGoods();
        for (Goods goodsItem : goodsList) {
            Map<String,Object> map = new HashMap<>();
            map.put("goodId",goodsItem.getGoodId());
            map.put("gname",goodsItem.getGname());
            map.put("price",goodsItem.getPrice());
            map.put("mainImg",goodsItem.getMainImg());
            map.put("classId",goodsItem.getClassId());
            goodsHomeList.add(map);
        }

        return goodsHomeList;
    }
}

