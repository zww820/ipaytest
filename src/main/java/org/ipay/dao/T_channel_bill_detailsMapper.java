package org.ipay.dao;

import java.math.BigDecimal;
import java.util.List;

import org.ipay.model.T_channel_bill_details;

public interface T_channel_bill_detailsMapper {
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
    int insert(T_channel_bill_details record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(T_channel_bill_details record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param ID
     */
    T_channel_bill_details selectByPrimaryKey(BigDecimal ID);

    /**
     * 根据CHECK_DATE获取记录
     * @param checkdate
     * @return
     */
    List<T_channel_bill_details> selectBycheckdate(String checkdate);
    
    /**
     * 根据CHECK_DATE和BUSINESS_TYPE获取记录
     * @param checkdate
     * @param businesstype
     * @return
     */
    List<T_channel_bill_details> selectBycheckdateANDbusinesstype(String checkdate,String businesstype);
    
    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(T_channel_bill_details record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(T_channel_bill_details record);
    
}