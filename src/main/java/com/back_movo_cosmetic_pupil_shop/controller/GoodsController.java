package com.back_movo_cosmetic_pupil_shop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.back_movo_cosmetic_pupil_shop.entity.AppGoodFrom;
import com.back_movo_cosmetic_pupil_shop.entity.Goods;
import com.back_movo_cosmetic_pupil_shop.entity.GoodsImgFiles;
import com.back_movo_cosmetic_pupil_shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
        map.put("goodId", goods.getGoodId());
        map.put("topImg", goods.getTopImg());
        //String 转 JSON
        map.put("shufflingFigure", JSONArray.parseArray(goods.getShufflingFigure()));
        map.put("bottomImg", goods.getBottomImg());
        return map;
    }

    /**
     * 首页-查询 全部商品
     * 商品管理页-查询 全部商品
     *
     * @return 对象列表
     */
    @GetMapping({"/AllGoods", "/admin/AllGoods"})
    public List<Map<String, Object>> queryAllGoods() {
        //最后过滤完要返回的list
        List<Map<String, Object>> goodsHomeList = new ArrayList<>();
        //查询goods全表的list
        List<Goods> goodsList = goodsService.queryAllGoods();
        return getGoodsMaps(goodsHomeList, goodsList);
    }

    /**
     * 分类页-根据class_id(类别id) 查询
     *
     * @return 对象列表
     */
    @GetMapping("/TypeGoods")
    public List<Map<String, Object>> queryByClassId(Integer classId) {
//        最后过滤完要返回的list
        List<Map<String, Object>> goodsHomeList = new ArrayList<Map<String, Object>>();
//        查询goods全表的list
        List<Goods> goodsList = goodsService.queryByClassId(classId);
        return getGoodsMaps(goodsHomeList, goodsList);
    }

    private List<Map<String, Object>> getGoodsMaps(List<Map<String, Object>> goodsHomeList, List<Goods> goodsList) {
        for (Goods goodsItem : goodsList) {
            Map<String, Object> map = new HashMap<>();
            map.put("goodId", goodsItem.getGoodId());
            map.put("gname", goodsItem.getGname());
            map.put("introduce", goodsItem.getIntroduce());
            map.put("price", goodsItem.getPrice());
            map.put("mainImg", goodsItem.getMainImg());
            map.put("classId", goodsItem.getClassId());
            goodsHomeList.add(map);
        }
        return goodsHomeList;
    }


    /**
     * 查询商品详细信息
     *
     * @param goodId 商品id
     * @return 商品实体
     */
    @GetMapping({"/goodInfo", "/admin/goodInfo"})
    public Map queryById(Integer goodId) {
        return this.goodsService.queryGoodInfo(goodId);
    }

    /**
     * 删除商品
     *
     * @param goodId 主键
     * @return 是否删除的信息
     */
    @GetMapping("/admin/delGood")
    public Map<String, Object> delGood(Integer goodId) {
        Map<String, Object> map = new HashMap<>();
        Boolean isDel = this.goodsService.deleteById(goodId);
        if (isDel) {
            map.put("status", 200);
            map.put("msg", "删除成功");
        } else {
            map.put("status", 500);
            map.put("msg", "删除失败");
        }
        return map;
    }



    /*
     * 添加商品
     * 1.调用上传图片接口==>返回图片名称等数据（imgData）
     * 2.携带imgData和其他信息调用addGoods接口
     * */

    /**
     * 添加商品数据
     *
     * @param appGoodFrom
     * @return
     */
    @PostMapping("/admin/addGoodsData")
    public Map<String, Object> addGoods(@RequestBody AppGoodFrom appGoodFrom) {
        Boolean isInsert = this.goodsService.addGoofData(appGoodFrom);
        Map<String, Object> map = new HashMap<>();
        if (isInsert) {
            map.put("status", 200);
            map.put("msg", "添加成功");
        } else {
            map.put("status", 500);
            map.put("msg", "添加失败");
        }
        return map;
    }

    /*
     * 更改商品信息
     * 1.调用上传图片接口==>返回图片名称等数据（imgData）
     * 2.携带imgData和其他信息调用更改其他商品接口
     * */
    @PostMapping("/admin/updateGoodsData")
    public Map updateGoodsData(@RequestBody AppGoodFrom appGoodFrom) {
        Boolean isInsert = this.goodsService.updateGoodsData(appGoodFrom);
        if (!isInsert) return null;
        return this.goodsService.queryGoodInfo(appGoodFrom.getGoods().getGoodId());
    }


    /**
     * 上传图片文件
     *
     * @param goodsImgFiles
     * @return
     */
    @PostMapping("/admin/uploadGoodsImages")
    public Map<String, Object> uploadFile(GoodsImgFiles goodsImgFiles) {
        return this.goodsService.uploadFile(goodsImgFiles);
    }


}
