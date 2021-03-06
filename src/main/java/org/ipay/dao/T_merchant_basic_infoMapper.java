package org.ipay.dao;

import java.math.BigDecimal;
import org.ipay.model.T_merchant_basic_info;

public interface T_merchant_basic_infoMapper {
    /**
     * 根据主键删除数据库的记录
     *
     * @param ID
     */
    int deleteByPrimaryKey(BigDecimal ID);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(T_merchant_basic_info record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(T_merchant_basic_info record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param ID
     */
    T_merchant_basic_info selectByPrimaryKey(BigDecimal ID);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(T_merchant_basic_info record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(T_merchant_basic_info record);
}