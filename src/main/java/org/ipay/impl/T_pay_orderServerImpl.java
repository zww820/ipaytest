package org.ipay.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.ipay.dao.T_pay_orderMapper;
import org.ipay.enums.ChannelEnum;
import org.ipay.model.T_pay_order;
import org.ipay.server.T_pay_orderServer;
import org.ipay.utils.Constants;
import org.ipay.utils.Randparams;
import org.ipay.utils.StoDate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Audience
 * @since 2017年8月8日 上午11:37:47
 */
@Service
@Transactional
public class T_pay_orderServerImpl implements T_pay_orderServer{
	@Resource
	T_pay_orderMapper t_pay_orderMapper;
	
	T_pay_order t_pay_order=new T_pay_order();
	StoDate stodate=new StoDate();

	/* (non-Javadoc)
	 * @see org.ipay.server.T_pay_orderServer#insertData()
	 */
	public void insertData(String date,String order_no,String trade_no,String status,String platform_amount,
			String merchant_amount,String channel_amount,String platform_discount,String merchant_discount,
			String channel_discount,String check_status,String check_date,String channel_code,String channel_service_amoun,
			String org_id,String merchant_id,String cle_status,String discount,String pay_type_id,String shop_id,String shop_name,
			String merchant_name) {
		// TODO Auto-generated method stub
		try {
			setDefault();
			int channel_id;
			if(channel_code.equals(ChannelEnum.WXPAY.getValue())){
				channel_id=1;
			}else{
				channel_id=2;
			}
			t_pay_order.setSHOP_ID(new BigDecimal(shop_id));
			t_pay_order.setCHANNEL_PAY_TIME(stodate.StoDate(date));
			t_pay_order.setORDER_NO(order_no);
			t_pay_order.setTRADE_NO(trade_no);
			t_pay_order.setCHANNEL_ID(new BigDecimal(channel_id));
			t_pay_order.setCHANNEL_CODE(channel_code);
			t_pay_order.setPAY_TYPE_ID(new BigDecimal(pay_type_id));
			t_pay_order.setSTATUS(status);
			t_pay_order.setPLATFORM_AMOUNT(new BigDecimal(platform_amount));
			t_pay_order.setMERCHANT_AMOUNT(new BigDecimal(merchant_amount));
			t_pay_order.setCHANNEL_AMOUNT(new BigDecimal(channel_amount));
			t_pay_order.setDISCOUNT(new BigDecimal(discount));
			t_pay_order.setPLATFORM_DISCOUNT(new BigDecimal(platform_discount));
			t_pay_order.setMERCHANT_DISCOUNT(new BigDecimal(merchant_discount));
			t_pay_order.setCHANNEL_DISCOUNT(new BigDecimal(channel_discount));
			t_pay_order.setTOTOL_DISCOUNT(new BigDecimal(Double.toString((Double.valueOf(platform_discount)+Double.valueOf(merchant_discount)))));
			t_pay_order.setCHECK_STATUS(check_status);
			t_pay_order.setTRADE_DATE(check_date);
			t_pay_order.setCHECK_DATE(check_date);
			t_pay_order.setCLE_STATUS(Integer.valueOf(cle_status));
			t_pay_order.setCREATED_TIME(stodate.StoDate(date));
//			t_pay_order.setCHANNEL_SERVICE_AMOUNT(new BigDecimal(channel_service_amoun));
			t_pay_order.setORG_ID(new BigDecimal(org_id));
			t_pay_order.setMERCHANT_ID(new BigDecimal(merchant_id));
			t_pay_order.setSHOP_NAME(shop_name);
			t_pay_order.setMERCHANT_NAME(merchant_name);
			t_pay_orderMapper.insertSelective(t_pay_order);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see org.ipay.server.T_pay_orderServer#updateData()
	 */
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.ipay.server.T_pay_orderServer#updatestatusByorderno()
	 */
	public void updatestatusByorderno(String status,String order_no) {
		// TODO Auto-generated method stub
		t_pay_orderMapper.updatestatusByorderno(status,order_no);
	}
	
	public void setDefault(){
		t_pay_order.setTOP_ORG_ID(new BigDecimal(1));
		t_pay_order.setPLATFORM_AMOUNT(new BigDecimal(0.0));
		t_pay_order.setMERCHANT_AMOUNT(new BigDecimal(0.0));
		t_pay_order.setCHANNEL_AMOUNT(new BigDecimal(0.0));
		t_pay_order.setDISCOUNT(new BigDecimal(0.0));
		t_pay_order.setPLATFORM_DISCOUNT(new BigDecimal(0.0));
		t_pay_order.setMERCHANT_DISCOUNT(new BigDecimal(0.0));
		t_pay_order.setCHANNEL_DISCOUNT(new BigDecimal(0.0));
		t_pay_order.setTOTOL_DISCOUNT(new BigDecimal(0.0));
		t_pay_order.setCLE_STATUS(1);
		t_pay_order.setMERCHANT_SERVICE_AMOUNT(new BigDecimal(0.0));
		t_pay_order.setCHANNEL_SERVICE_AMOUNT(new BigDecimal(0.0));;
		t_pay_order.setPLATFORM_SERVICE_AMOUNT(new BigDecimal(0.0));
		t_pay_order.setPLATFORM_RD_SERVICE_AMOUNT(new BigDecimal(0.0));
		t_pay_order.setSTL_AMOUNT(new BigDecimal(0.0));
	}

	/* (non-Javadoc)
	 * @see org.ipay.server.T_pay_orderServer#selectjineBycheckdateandorderno(java.lang.String, java.lang.String)
	 */
	public T_pay_order selectjineBycheckdateandorderno(String order_no) {
		// TODO Auto-generated method stub
		return t_pay_orderMapper.selectjineBycheckdateandorderno(order_no);
	}

}
