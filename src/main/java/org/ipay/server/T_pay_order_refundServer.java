package org.ipay.server;

import org.springframework.stereotype.Component;

/**
 * @author Audience
 * @since 2017年8月12日 下午5:05:13
 */
@Component
public interface T_pay_order_refundServer {

	public void insertData(String amount,String status,String channel_code,String refund_no,String serial_no,
			String order_pay_time,String order_trade_no,String order_no,String date,String refund_date,String check_date,
			String check_status);
	
	public void updateData();
}
