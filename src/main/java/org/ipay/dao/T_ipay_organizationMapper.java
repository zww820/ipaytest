package org.ipay.dao;

import java.math.BigDecimal;
import org.ipay.model.T_ipay_organization;

public interface T_ipay_organizationMapper {
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
    int insert(T_ipay_organization record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(T_ipay_organization record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param ID
     */
    T_ipay_organization selectByPrimaryKey(BigDecimal ID);
    
    /**
     * 根据机构code获取一条记录
     * @param org_code
     */
    T_ipay_organization selectByorgcode(String org_code);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(T_ipay_organization record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(T_ipay_organization record);
}