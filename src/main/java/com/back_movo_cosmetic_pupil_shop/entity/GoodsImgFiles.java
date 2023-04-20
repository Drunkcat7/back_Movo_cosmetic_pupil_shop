package com.back_movo_cosmetic_pupil_shop.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Data
public class GoodsImgFiles {
    MultipartFile mainImg;
    MultipartFile topImg;
    MultipartFile[] shufflingFigure;
    MultipartFile bottomImg;
    MultipartFile[] detailsFigure;
    MultipartFile[] gTypeList;
    Integer classId;
}
