package com.back_movo_cosmetic_pupil_shop.service;

import com.back_movo_cosmetic_pupil_shop.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Address)表服务接口
 *
 * @author makejava
 * @since 2023-04-19 08:31:50
 */
public interface AddressService {

    /**
     * 通过uid查询数据对象列表
     * @param uid
     * @return 对象列表
     */
    List<Address> queryByUid(Integer uid);

    /**
     * 通过 uid 和 address_id 修改数据
     * @param address
     * @return 影响行数
     */
    Address updateByUidAndAddressId(Address address);

    /**
     * 通过 address_id 和 uid 删除数据
     * @param addressId
     * @return
     */
    boolean deleteByUidAndAddressId(Integer addressId,Integer uid);

    /**
     * 通过 address_id 和 uid 修改默认地址
     * @param address
     * @param uid
     * @return
     */
    boolean updateDefaultContact(Address address,Integer uid);

    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    Address insert(Address address);



    /**
     * 通过 defaultContact 和 uid 查询
     * @param uid
     * @return
     */
    List<Address> queryByUidAndDefaultContact(Integer uid);


//    --------


    /**
     * 通过ID查询单条数据
     *
     * @param addressId 主键
     * @return 实例对象
     */
    Address queryById(Integer addressId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Address> queryAllByLimit(int offset, int limit);


    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    Address update(Address address);

    /**
     * 通过主键删除数据
     *
     * @param addressId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer addressId);

}
