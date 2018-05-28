package org.ipay.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.ipay.dao.T_pay_order_refundMapper;
import org.ipay.enums.ChannelEnum;
import org.ipay.model.T_pay_order_refund;
import org.ipay.server.T_pay_order_refundServer;
import org.ipay.utils.Randparams;
import org.ipay.utils.StoDate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Audience
 * @since 2017年8月12日 下午5:06:28
 */

@Service
@Transactional
public class T_pay_order_refundServerImpl implements T_pay_order_refundServer{

	@Resource
	T_pay_order_refundMapper t_pay_order_refundMapper;
	

	T_pay_order_refund t_pay_order_refund=new T_pay_order_refund();
	
	StoDate stodate=new StoDate();
	/* (non-Javadoc)
	 * @see org.ipay.server.T_pay_order_refundServer#insertData()
	 */
	public void insertData(String amount,String status,String channel_code,String refund_no,String serial_no,
			String order_pay_time,String order_trade_no,String order_no,String date,String refund_date,String check_date,
			String check_status,String org_id,String merchant_id,String cle_status,String shop_id,
			String shop_name,String merchant_name,String pay_type_id) {
		// TODO Auto-generated method stub
		try{
			setDefault();
			int channel_id;
			if(channel_code.equals(ChannelEnum.WXPAY.getValue())){
				channel_id=1;
			}else{
				channel_id=2;
			}
			t_pay_order_refund.setAMOUNT(new BigDecimal(amount));
			t_pay_order_refund.setSTATUS(status);
			t_pay_order_refund.setCHANNEL_CODE(channel_code);			
			t_pay_order_refund.setCHANNEL_ID(new BigDecimal(channel_id));
			t_pay_order_refund.setREFUND_NO(refund_no);
			t_pay_order_refund.setSERIAL_NO(serial_no);
			t_pay_order_refund.setORDER_NO(order_no);
			t_pay_order_refund.setORDER_PAY_TIME(stodate.StoDate(order_pay_time));
			t_pay_order_refund.setORDER_TRADE_NO(order_trade_no);
			t_pay_order_refund.setCHANNEL_REFUND_TIME(stodate.StoDate(date));
			t_pay_order_refund.setREFUND_DATE(refund_date);
			t_pay_order_refund.setCHECK_DATE(check_date);
			t_pay_order_refund.setCHECK_STATUS(check_status);
			t_pay_order_refund.setORG_ID(new BigDecimal(org_id));
			t_pay_order_refund.setMERCHANT_ID(new BigDecimal(merchant_id));
			t_pay_order_refund.setCLE_STATUS(Integer.valueOf(cle_status));
			t_pay_order_refund.setMERCHANT_NAME(merchant_name);
			t_pay_order_refund.setSHOP_ID(new BigDecimal(shop_id));
			t_pay_order_refund.setSHOP_NAME(shop_name);
			t_pay_order_refund.setPAY_TYPE_ID(new BigDecimal(pay_type_id));
			t_pay_order_refundMapper.insertSelective(t_pay_order_refund);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see org.ipay.server.T_pay_order_refundServer#updateData()
	 */
	public void updateData() {
		// TODO Auto-generated method stub
		
	}
	
	public void setDefault(){
		t_pay_order_refund.setSTL_STATUS(1);
		t_pay_order_refund.setPLATFORM_AMOUNT(new BigDecimal(0.0));
		t_pay_order_refund.setMERCHANT_AMOUNT(new BigDecimal(0.0));
		t_pay_order_refund.setCHANNEL_AMOUNT(new BigDecimal(0.0));
		t_pay_order_refund.setDISCOUNT(new BigDecimal(0.0));
		t_pay_order_refund.setMERCHANT_SERVICE_AMOUNT(new BigDecimal(0.0));
		t_pay_order_refund.setCHANNEL_SERVICE_AMOUNT(new BigDecimal(0.0));
	}

	/* (non-Javadoc)
	 * @see org.ipay.server.T_pay_order_refundServer#insertjineByoutorderno(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void updatejineByorderno(BigDecimal platform_amount, BigDecimal merchant_amount, BigDecimal channel_amount,
			BigDecimal discount,String order_no) {
		// TODO Auto-generated method stub
		t_pay_order_refund.setPLATFORM_AMOUNT(platform_amount);
		t_pay_order_refund.setMERCHANT_AMOUNT(merchant_amount);
		t_pay_order_refund.setCHANNEL_AMOUNT(channel_amount);
		t_pay_order_refund.setDISCOUNT(discount);
		t_pay_order_refund.setORDER_NO(order_no);
		t_pay_order_refundMapper.updatejineByorderno(t_pay_order_refund);
	}

}
