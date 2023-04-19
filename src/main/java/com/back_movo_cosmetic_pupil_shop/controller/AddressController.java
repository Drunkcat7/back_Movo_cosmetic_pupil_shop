package com.back_movo_cosmetic_pupil_shop.controller;

import com.back_movo_cosmetic_pupil_shop.entity.Address;
import com.back_movo_cosmetic_pupil_shop.my_interceptor.CurrentUser;
import com.back_movo_cosmetic_pupil_shop.my_interceptor.CurrentUserInfo;
import com.back_movo_cosmetic_pupil_shop.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Address)表控制层
 *
 * @author makejava
 * @since 2023-04-19 08:31:50
 */
@RestController
@RequestMapping("address")
public class AddressController {
    /**
     * 服务对象
     */
    @Resource
    private AddressService addressService;

    /**
     * 查看用户所有地址
     * 通过uid查询数据对象列表
     * @param user
     * @return 对象列表
     */
    @GetMapping("/user/myAddress")
    public List<Address> queryByUid(@CurrentUser CurrentUserInfo user) {
        return this.addressService.queryByUid(user.getUid());
    }

    /**
     * 编辑单条地址信息 不包括设置默认地址
     * 通过 uid 和 address_id 修改数据
     * @param address
     * @return 影响行数
     */
    @PutMapping("/user/updateMyAddress")
    public Address updateByUidAndAddressId(Address address,@CurrentUser CurrentUserInfo user) {
        address.setUid(user.getUid());
        return this.addressService.updateByUidAndAddressId(address);
    }

    /**
     * 新增地址信息
     * @param address
     * @param user
     * @return
     */
    @PutMapping("/user/insertMyAddress")
    public Address insertAddress(Address address,@CurrentUser CurrentUserInfo user) {
        address.setUid(user.getUid());
        this.addressService.insert(address);
        return this.addressService.queryById(address.getAddressId());
    }


    /**
     * 删除地址信息
     * @param addressId
     * @param user
     * @return
     */
    @PutMapping("/user/deleteMyAddress")
    public boolean deleteAddress(Integer addressId,@CurrentUser CurrentUserInfo user) {
        return this.addressService.deleteByUidAndAddressId(addressId, user.getUid());
    }


    /**
     * 设置默认联系地址
     * @param address
     * @param user
     * @return
     */
    @PutMapping("/user/updateDefaultContact")
    public boolean updateDefaultContact(Address address ,@CurrentUser CurrentUserInfo user) {
        address.setDefaultContact(1);
        return this.addressService.updateDefaultContact(address,user.getUid());
    }

    /**
     * 通过 uid 查询
     * @param user
     * @return
     */
    @GetMapping("/user/defaultContactAddress")
    public List<Address> queryByUidAndDefaultContact(@CurrentUser CurrentUserInfo user) {
        return this.addressService.queryByUidAndDefaultContact(user.getUid());
    }

    /** ------------婚戒线--------------- */

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Address selectOne(Integer id) {
        return this.addressService.queryById(id);
    }

}
