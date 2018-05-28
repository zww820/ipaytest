package org.ipay.server;

import java.math.BigDecimal;
import java.util.Date;

import org.ipay.model.T_pay_order;
import org.springframework.stereotype.Component;

/**
 * @author Audience
 * @since 2017年8月8日 上午11:37:27
 */
@Component
public interface T_pay_orderServer {
	
	public void insertData(String date,String order_no,String trade_no,String status,String platform_amount,
			String merchant_amount,String channel_amount,String platform_discount,String merchant_discount,
			String channel_discount,String check_status,String check_date,String channel_code,String channel_service_amoun,
			String org_id,String merchant_id,String cle_status,String discount,String pay_type_id,String shop_id,String shop_name,
			String merchant_name);
	
	public void updateData();
	
	public void updatestatusByorderno(String status,String order_no);
	
	public T_pay_order selectjineBycheckdateandorderno(String order_no);

}
