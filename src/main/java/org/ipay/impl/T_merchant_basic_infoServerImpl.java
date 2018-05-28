package org.ipay.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.ipay.dao.T_merchant_basic_infoMapper;
import org.ipay.model.T_merchant_basic_info;
import org.ipay.server.T_merchant_basic_infoServer;
import org.ipay.utils.Constants;
import org.ipay.utils.Randparams;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Audience
 * @since 2017年9月1日 下午5:32:09
 */
@Service
@Transactional
public class T_merchant_basic_infoServerImpl implements T_merchant_basic_infoServer{

	/* (non-Javadoc)
	 * @see org.ipay.server.T_merchant_basic_infoServer#insertData()
	 */
	Randparams randparams=new Randparams();
	@Resource
	private T_merchant_basic_infoMapper t_merchant_basic_infoMapper;
	private T_merchant_basic_info t_merchant_basic_info=new T_merchant_basic_info();
	public void insertData(long rate_id) {
		// TODO Auto-generated method stub
		t_merchant_basic_info.setMERCHANT_ID(new BigDecimal(Constants.MERCHANT_ID));
		t_merchant_basic_info.setMERCHANT_NAME(Constants.MERCHANT_NAME);
		t_merchant_basic_info.setMERCHANT_CODE(Constants.MERCHANT_CODE);
		t_merchant_basic_info.setRATE_ID(new BigDecimal(rate_id));
		t_merchant_basic_infoMapper.insertSelective(t_merchant_basic_info);
	}

}
