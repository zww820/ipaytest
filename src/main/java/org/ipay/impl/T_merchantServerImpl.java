package org.ipay.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.ipay.dao.T_merchantMapper;
import org.ipay.model.T_merchant;
import org.ipay.server.T_merchantServer;
import org.ipay.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Audience
 * @since 2017年9月1日 下午4:18:39
 */
@Service
@Transactional
public class T_merchantServerImpl implements T_merchantServer{

	@Autowired
	private T_merchantMapper t_merchantMapper;
	private T_merchant t_merchant=new T_merchant();
	/* (non-Javadoc)
	 * @see org.ipay.server.T_merchantServer#insertData()
	 */
	public void insertData(String merchant_name,String merchant_code) {
		// TODO Auto-generated method stub
		
		t_merchant.setORG_ID(new BigDecimal(Constants.ORG_ID));
		t_merchant.setTOP_ORG_ID(new BigDecimal(1));
		t_merchant.setMERCHANT_CODE(merchant_code);
		t_merchant.setMERCHANT_NAME("小赵商户"+merchant_name);
		t_merchant.setMERCHANT_SHORT_NAME("小赵商户简称"+merchant_name);
		t_merchantMapper.insertSelective(t_merchant);
		Constants.MERCHANT_ID=t_merchant.getID();
		Constants.MERCHANT_CODE=t_merchant.getMERCHANT_CODE();
		Constants.MERCHANT_NAME=t_merchant.getMERCHANT_NAME();
	}

	@Override
	public List searchMerchantID() {
		return t_merchantMapper.searchId();
	}

}
