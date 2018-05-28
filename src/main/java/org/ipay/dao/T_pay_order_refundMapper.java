package org.ipay.dao;

import java.math.BigDecimal;
import org.ipay.model.T_pay_order_refund;

public interface T_pay_order_refundMapper {
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
    int insert(T_pay_order_refund record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(T_pay_order_refund record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param ID
     */
    T_pay_order_refund selectByPrimaryKey(BigDecimal ID);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(T_pay_order_refund record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(T_pay_order_refund record);
    
    /**
     * 根据订单号更新金额
     * 
     * @param orderno
     */
    void updatejineByorderno(T_pay_order_refund record);
}