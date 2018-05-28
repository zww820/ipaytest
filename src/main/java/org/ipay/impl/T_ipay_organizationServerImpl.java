package org.ipay.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.ipay.dao.T_ipay_organizationMapper;
import org.ipay.model.T_channel_bill_details;
import org.ipay.model.T_ipay_organization;
import org.ipay.server.T_ipay_organizationServer;
import org.ipay.utils.Constants;
import org.ipay.utils.Randparams;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Audience
 * @since 2017年9月1日 下午4:17:40
 */
@Service
@Transactional
public class T_ipay_organizationServerImpl implements T_ipay_organizationServer{

	/* (non-Javadoc)
	 * @see org.ipay.server.T_ipay_organizationServer#insertData()
	 */
	@Resource
	private T_ipay_organizationMapper t_ipay_organizationMapper;
	
	private T_ipay_organization t_ipay_organization=new T_ipay_organization();
	Randparams randparams=new Randparams();
	
	public void insertData(String org_name) {
		// TODO Auto-generated method stub
		t_ipay_organization.setORG_CODE(randparams.randonStoInt(10));
		t_ipay_organization.setORG_NAME("小赵机构"+org_name);
		t_ipay_organization.setADDRESS_CODE("450312");
		t_ipay_organization.setORG_TYPE("2");
		t_ipay_organization.setPARENT_ID(new BigDecimal(0));
		t_ipay_organization.setVALIDATE_STATUS("1");
		t_ipay_organization.setACTIVATE_STATUS("1");
		t_ipay_organization.setSTATUS((short) 0);
		t_ipay_organization.setCREATED_TIME(new Date());
		t_ipay_organization.setUPDATED_TIME(new Date());
		t_ipay_organization.setTOP_ORG_ID(new BigDecimal(1));
		t_ipay_organizationMapper.insertSelective(t_ipay_organization);
		Constants.ORG_ID=t_ipay_organization.getID();
		Constants.ORG_CODE=t_ipay_organization.getORG_CODE();
	}
	
	public T_ipay_organization selectByorgcode(String org_code){
		return t_ipay_organizationMapper.selectByorgcode(org_code);
	}

}
