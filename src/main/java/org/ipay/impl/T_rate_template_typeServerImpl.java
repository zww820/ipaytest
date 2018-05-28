package org.ipay.impl;

import javax.annotation.Resource;

import org.ipay.dao.T_rate_template_typeMapper;
import org.ipay.model.T_rate_template_type;
import org.ipay.server.T_pay_orderServer;
import org.ipay.server.T_rate_template_typeServer;
import org.ipay.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Audience
 * @since 2017年9月5日 上午11:48:11
 */
@Service
@Transactional
public class T_rate_template_typeServerImpl implements T_rate_template_typeServer{
	
	@Resource
	T_rate_template_typeMapper t_rate_template_typeMapper;
	T_rate_template_type t_rate_template_type=new T_rate_template_type();
	
	
	public void insertData(String name){
		t_rate_template_type.setNAME("小赵费率类型"+name);
		t_rate_template_type.setSTATUS("0");
		t_rate_template_typeMapper.insertSelective(t_rate_template_type);
		Constants.RATE_TMP_TYPE_ID=t_rate_template_type.getID();
	}

}
