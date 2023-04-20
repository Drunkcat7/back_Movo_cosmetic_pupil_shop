package com.back_movo_cosmetic_pupil_shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.back_movo_cosmetic_pupil_shop.dao.ClassificationDao;
import com.back_movo_cosmetic_pupil_shop.dao.GoodTypesDao;
import com.back_movo_cosmetic_pupil_shop.entity.AppGoodFrom;
import com.back_movo_cosmetic_pupil_shop.entity.GoodTypes;
import com.back_movo_cosmetic_pupil_shop.entity.Goods;
import com.back_movo_cosmetic_pupil_shop.dao.GoodsDao;
import com.back_movo_cosmetic_pupil_shop.entity.GoodsImgFiles;
import com.back_movo_cosmetic_pupil_shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Goods)表服务实现类
 *
 * @author makejava
 * @since 2023-04-18 14:12:17
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;
    @Resource
    private GoodTypesDao goodTypesDao;

    @Resource
    private ClassificationDao classDao;

    /**
     * 通过ID查询单条数据
     *
     * @param goodId 主键
     * @return 实例对象
     */
    @Override
    public Goods queryById(Integer goodId) {
        return this.goodsDao.queryById(goodId);
    }

    /**
     * 分类页-根据class_id(类别id) 查询
     *
     * @return 对象列表
     */
    @Override
    public List<Goods> queryByClassId(Integer classId) {
        return this.goodsDao.queryAllGoods(classId);
    }

    /**
     * 首页-查询商品表全部数据
     *
     * @return 对象列表
     */
    @Override
    public List<Goods> queryAllGoods() {
        return this.goodsDao.queryAllGoods();
    }

    /**
     * 查询商品详细信息
     *
     * @param goodId
     * @return
     */
    @Override
    public Map queryGoodInfo(Integer goodId) {
        Goods goods = this.goodsDao.queryById(goodId);
        Map map = JSON.parseObject(JSON.toJSONString(goods), Map.class);
        map.put("shufflingFigure", JSONArray.parseArray(goods.getShufflingFigure()));
        map.put("detailsFigure", JSONArray.parseArray(goods.getDetailsFigure()));
        //查询对应的商品信息
        List<GoodTypes> goodTypes = this.goodTypesDao.queryGoodItems(goodId);
        map.put("goodTypes", goodTypes);
        return map;
    }


    /**
     * 通过主键删除数据
     *
     * @param goodId 主键
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteById(Integer goodId) {
        int i = this.goodsDao.deleteById(goodId);
        return i != 0;
    }

    /**
     * 添加商品数据
     *
     * @param appGoodFrom
     * @return
     */

    /**
     * 添加商品
     * gname,描述,price,classId,List<GTypeId>
     * mainImg,topImg,shufflingFigure,
     * 实体类合集,Good,==>给Good表和gTypeId表添加数据,参照提交订单接口
     */
    @Override
    public Boolean addGoofData(AppGoodFrom appGoodFrom) {
        if (appGoodFrom.getGoods() == null || appGoodFrom.getGoodTypesList() == null) {
            return false;
        }
        goodsDao.insert(appGoodFrom.getGoods());
        List<GoodTypes> goodTypesList = appGoodFrom.getGoodTypesList();
        for (GoodTypes goodTypes : goodTypesList) {
            goodTypesDao.insert(goodTypes);
        }
        return true;
    }

    /*
       1. 直接通过goodId修改goods的数据
       2.删除所有gType表中关于goodId的数据
       3.再次循环添加
       **/
    @Override
    public Boolean updateGoodsData(AppGoodFrom appGoodFrom) {
        if (appGoodFrom.getGoods() == null || appGoodFrom.getGoodTypesList() == null) {
            return false;
        }
        this.goodsDao.update(appGoodFrom.getGoods());
        this.goodTypesDao.deleteByIdGoodId(appGoodFrom.getGoods().getGoodId());
        List<GoodTypes> goodTypesList = appGoodFrom.getGoodTypesList();
        for (GoodTypes goodTypes : goodTypesList) {
            goodTypesDao.insert(goodTypes);
        }
        return true;
    }

    @Value("${file.uploadFilePath}")
    String filePathHead;//文件存储路径

    /**
     * 上传商品图片
     *
     * @param goodsImgFiles
     * @return
     */
    @Override
    public Map<String, Object> uploadFile(GoodsImgFiles goodsImgFiles) {
        Map<String, Object> map = new HashMap<>();
        //请求所属的class的名称
        String className = classDao.queryNameById(goodsImgFiles.getClassId());
        long count = goodsDao.count(goodsImgFiles.getClassId()) + 1;
        String classHead = className + count;
        String mainImg = uploadImg(goodsImgFiles.getMainImg(), "主图/" + classHead + "_主图");
        String topImg = uploadImg(goodsImgFiles.getTopImg(), classHead + "/" + classHead + "_顶图");
        String bottomImg = uploadImg(goodsImgFiles.getBottomImg(), classHead + "/" + classHead + "_底图");

        List<String> shufflingFigure = uploadImgGroup(goodsImgFiles.getShufflingFigure(), classHead + "/" +
                classHead + "_轮播图_000");
        List<String> detailsFigure = uploadImgGroup(goodsImgFiles.getDetailsFigure(), classHead + "/" +
                classHead + "_详情图_000");
        List<String> gTypeList = uploadImgGroup(goodsImgFiles.getGTypeList(), classHead + "/" +
                classHead + "_商品图_000");
        map.put("mainImg", mainImg);
        map.put("topImg", topImg);
        map.put("shufflingFigure", shufflingFigure);
        map.put("bottom", bottomImg);
        map.put("detailsFigure", detailsFigure);
        map.put("gTypeList", gTypeList);
        return map;
    }

    //上传多文件
    public List<String> uploadImgGroup(MultipartFile[] files, String filePath) {
        List<String> imgUrl = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            imgUrl.add(this.uploadImg(files[i], filePath + i));
        }
        return imgUrl;
    }

    //上传单文件
    public String uploadImg(MultipartFile file, String filePath) {
        //文件后缀
        String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        // 文件格式
        //System.out.println(filePathHead + filePath + fileSuffix);
        //System.out.println("返回的数据：" + filePath + fileSuffix);
//        // 文件全路径
//        File targetFile = new File(filePathHead + filePath + fileSuffix);
//        // 判断文件存储目录是否存在，不存在则新建目录
//        if (!targetFile.getParentFile().exists()) {
//            targetFile.getParentFile().mkdir();
//        }
        try {
//            // 将图片保存
//            file.transferTo(targetFile);
            return filePath + fileSuffix;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
