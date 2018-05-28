package org.ipay.dao;

import org.ipay.model.T_rate_template_type;

public interface T_rate_template_typeMapper {
    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(T_rate_template_type record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(T_rate_template_type record);
}