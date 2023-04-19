package com.back_movo_cosmetic_pupil_shop.dao;

import com.back_movo_cosmetic_pupil_shop.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Address)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-19 08:31:50
 */
public interface AddressDao {

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
    int updateByUidAndAddressId(Address address);


    /**
     * 通过 address_id 和 uid 删除数据
     * @param addressId
     * @return
     */
    int deleteByUidAndAddressId(Integer addressId,Integer uid);

    /**
     * 通过 uid defaultContact(默认地址值)全部改为0
     * @param uid
     * @return
     */
    int updateDefaultContact0ByUid(Integer uid);

    /**
     * 通过 address_id 和 uid  defaultContact(默认地址值)改为1
     * @param addressId
     * @param uid
     * @return
     */
    int updateDefaultContact1ByUidAndAddressId(@Param("addressId")Integer addressId,@Param("uid")Integer uid);


    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 影响行数
     */
    int insert(Address address);

    /**
     * 通过 defaultContact 和 uid 查询
     * @param uid
     * @return
     */
    List<Address> queryByUidAndDefaultContact(Integer uid);

//    ------------

    /**
     * 通过ID查询单条数据
     *
     * @param addressId 主键
     * @return 实例对象
     */
    Address queryById(Integer addressId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Address> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param address 实例对象
     * @return 对象列表
     */
    List<Address> queryAll(Address address);



    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Address> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Address> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Address> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Address> entities);

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 影响行数
     */
    int update(Address address);

    /**
     * 通过主键删除数据
     *
     * @param addressId 主键
     * @return 影响行数
     */
    int deleteById(Integer addressId);

}

