package org.ipay.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.ipay.dao.T_merchant_shopMapper;
import org.ipay.model.T_merchant_shop;
import org.ipay.server.T_merchant_shopServer;
import org.ipay.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Audience
 * @since 2017年9月12日 下午3:52:42
 */
@Service
@Transactional
public class T_merchant_shopServerImpl implements T_merchant_shopServer{
	
	@Resource
	T_merchant_shopMapper t_merchant_shopMapper;
	T_merchant_shop t_merchant_shop=new T_merchant_shop();
	
	public void insertData(long org_id,long merchant_id,String shop_code,String shop_name){
		t_merchant_shop.setORG_ID(new BigDecimal(org_id));
		t_merchant_shop.setMERCHANT_ID(new BigDecimal(merchant_id));
		t_merchant_shop.setSHOP_CODE(shop_code);
		t_merchant_shop.setSHOP_NAME("小赵店铺"+shop_name);
		t_merchant_shop.setSHOP_SHORT_NAME("小赵店铺简称"+shop_name);
		t_merchant_shopMapper.insertSelective(t_merchant_shop);
		Constants.SHOP_ID=t_merchant_shop.getID();
		Constants.SHOP_NAME=t_merchant_shop.getSHOP_NAME();
		
	}

}
