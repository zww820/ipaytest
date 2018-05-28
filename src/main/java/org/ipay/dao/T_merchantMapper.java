package org.ipay.dao;

import java.math.BigDecimal;
import java.util.List;

import org.ipay.model.T_merchant;

public interface T_merchantMapper {
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
    int insert(T_merchant record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(T_merchant record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param ID
     */
    T_merchant selectByPrimaryKey(BigDecimal ID);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(T_merchant record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(T_merchant record);

    /**
     * 查询所有商户ID
     */
    List searchId();
}