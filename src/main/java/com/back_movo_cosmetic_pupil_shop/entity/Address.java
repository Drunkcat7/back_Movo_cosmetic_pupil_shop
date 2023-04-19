package com.back_movo_cosmetic_pupil_shop.entity;

import java.io.Serializable;

/**
 * (Address)实体类
 *
 * @author makejava
 * @since 2023-04-19 08:31:50
 */
public class Address implements Serializable {
    private static final long serialVersionUID = 134169070830522883L;
    /**
     * 地址id
     */
    private Integer addressId;
    /**
     * 联系人
     */
    private String consignee;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 地址
     */
    private String address;
    /**
     * 详细地址
     */
    private String detailedAddress;
    /**
     * 是否为默认联系人，1是，0或者null代表不是
     */
    private Integer defaultContact;
    /**
     * 用户id，FK
     */
    private Integer uid;


    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public Integer getDefaultContact() {
        return defaultContact;
    }

    public void setDefaultContact(Integer defaultContact) {
        this.defaultContact = defaultContact;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

}
