package org.ipay.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.ipay.dao.T_merchant_rateMapper;
import org.ipay.model.T_merchant_rate;
import org.ipay.server.T_merchant_rateServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Audience
 * @since 2017年9月1日 下午4:17:53
 */
@Service
@Transactional
public class T_merchant_rateServerImpl implements T_merchant_rateServer{

	/* (non-Javadoc)
	 * @see org.ipay.server.T_merchant_rateServer#insertData()
	 */
	@Resource
	private T_merchant_rateMapper t_merchant_rateMapper;
	private T_merchant_rate t_merchant_rate=new T_merchant_rate();
	public void insertData(long template_id,String rate,String channel_id) {
		// TODO Auto-generated method stub
		t_merchant_rate.setTEMPLATE_ID(new BigDecimal(template_id));
		t_merchant_rate.setRATE(new BigDecimal(rate));
		t_merchant_rate.setCHANNEL_ID(channel_id);
		t_merchant_rateMapper.insertSelective(t_merchant_rate);
	}

}
