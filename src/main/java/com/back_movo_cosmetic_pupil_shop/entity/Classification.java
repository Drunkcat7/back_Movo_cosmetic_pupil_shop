package com.back_movo_cosmetic_pupil_shop.entity;

import java.io.Serializable;

/**
 * (Classification)实体类
 *
 * @author makejava
 * @since 2023-04-20 13:35:24
 */
public class Classification implements Serializable {
    private static final long serialVersionUID = 989192658542485154L;
    /**
     * 分类表Id
     */
    private Integer classId;
    /**
     * 分类名称
     */
    private String cname;


    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

}

