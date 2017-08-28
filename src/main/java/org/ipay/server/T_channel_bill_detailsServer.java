package org.ipay.server;

import java.math.BigDecimal;
import java.util.List;

import org.ipay.model.T_channel_bill_details;
import org.springframework.stereotype.Component;

@Component
public interface T_channel_bill_detailsServer {
	
	public T_channel_bill_details selectByid(BigDecimal id);
	
	public List<T_channel_bill_details> selectBycheckdate(String checkdate);
	
	public List<T_channel_bill_details> selectBycheckdateANDbusinesstype(String checkdate,String businesstype);
	
	public void insertData(String check_date,String channel_code,String channel_order_no,String out_order_no,
			String channel_total_amount,String channel_discount_amount,String channel_refund_no,String out_refund_no,String fee,String business_type,
			String check_status,String date);
	
	public void updateData();
}
