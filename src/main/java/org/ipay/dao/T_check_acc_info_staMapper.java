package org.ipay.dao;

import java.math.BigDecimal;
import org.ipay.model.T_check_acc_info_sta;

public interface T_check_acc_info_staMapper {
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
    int insert(T_check_acc_info_sta record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(T_check_acc_info_sta record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param ID
     */
    T_check_acc_info_sta selectByPrimaryKey(BigDecimal ID);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(T_check_acc_info_sta record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(T_check_acc_info_sta record);
}