package com.back_movo_cosmetic_pupil_shop.service.impl;

import com.back_movo_cosmetic_pupil_shop.entity.Address;
import com.back_movo_cosmetic_pupil_shop.dao.AddressDao;
import com.back_movo_cosmetic_pupil_shop.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Address)表服务实现类
 *
 * @author makejava
 * @since 2023-04-19 08:31:50
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressDao addressDao;

    /**
     * 通过uid查询数据对象列表
     * @param uid
     * @return 对象列表
     */
    @Override
    public List<Address> queryByUid(Integer uid) {
        return this.addressDao.queryByUid(uid);
    }

    /**
     * 通过 uid 和 address_id 修改数据
     * @param address
     * @return 影响行数
     */
    @Override
    public Address updateByUidAndAddressId(Address address) {
        this.addressDao.updateByUidAndAddressId(address);
        Address refAddress = this.queryById(address.getAddressId());
        if (refAddress.getUid() != address.getUid()){
            return null;
        }
        //更新默认地址
        this.updateDefaultContact(address,address.getUid());
        return this.queryById(address.getAddressId());
    }

    /**
     * 通过 address_id 和 uid 删除数据
     * @param addressId
     * @return
     */
    @Override
    public boolean deleteByUidAndAddressId(Integer addressId, Integer uid) {
        return this.addressDao.deleteByUidAndAddressId(addressId,uid) > 0;
    }

    /**
     * 通过 address_id 和 uid 修改默认地址
     * @param address
     * @param uid
     * @return
     */
    @Override
    public boolean updateDefaultContact(Address address, Integer uid) {
        if (address.getDefaultContact() != 1) {
            return false;
        }
        System.out.println("LOG，"+uid);
        this.addressDao.updateDefaultContact0ByUid(uid);
//        this.addressDao.updateDefaultContact1ByUidAndAddressId(addressId,uid);
        return this.addressDao.updateDefaultContact1ByUidAndAddressId(address.getAddressId(),uid) > 0;
    }
    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    @Override
    public Address insert(Address address) {
        this.addressDao.insert(address);
        //更新默认地址
        this.updateDefaultContact(address,address.getUid());
        return address;
    }

    /**
     * 通过 uid 查询
     * @param uid
     * @return
     */
    @Override
    public List<Address> queryByUidAndDefaultContact(Integer uid) {
        return this.addressDao.queryByUidAndDefaultContact(uid);
    }

    /** 婚戒线------------------------- */

    /**
     * 通过ID查询单条数据
     *
     * @param addressId 主键
     * @return 实例对象
     */
    @Override
    public Address queryById(Integer addressId) {
        return this.addressDao.queryById(addressId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Address> queryAllByLimit(int offset, int limit) {
        return this.addressDao.queryAllByLimit(offset, limit);
    }


    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    @Override
    public Address update(Address address) {
        this.addressDao.update(address);
        return this.queryById(address.getAddressId());
    }

    /**
     * 通过主键删除数据
     *
     * @param addressId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer addressId) {
        return this.addressDao.deleteById(addressId) > 0;
    }
}
