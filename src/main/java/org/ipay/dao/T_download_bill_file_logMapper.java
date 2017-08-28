package org.ipay.dao;

import java.math.BigDecimal;
import org.ipay.model.T_download_bill_file_log;

public interface T_download_bill_file_logMapper {
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
    int insert(T_download_bill_file_log record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(T_download_bill_file_log record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param ID
     */
    T_download_bill_file_log selectByPrimaryKey(BigDecimal ID);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(T_download_bill_file_log record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(T_download_bill_file_log record);
}