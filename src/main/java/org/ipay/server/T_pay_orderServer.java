package org.ipay.server;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @author Audience
 * @since 2017年8月8日 上午11:37:27
 */
@Component
public interface T_pay_orderServer {
	
	public void insertData(String date,String order_no,String trade_no,String status,String platform_amount,
			String merchant_amount,String channel_amount,String check_status,String check_date,String channel_code,
			String merchant_service_rate);
	
	public void updateData();

}
