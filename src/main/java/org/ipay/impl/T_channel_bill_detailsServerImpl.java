package org.ipay.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.ipay.dao.T_channel_bill_detailsMapper;
import org.ipay.enums.ChannelEnum;
import org.ipay.model.T_channel_bill_details;
import org.ipay.server.T_channel_bill_detailsServer;
import org.ipay.utils.StoDate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class T_channel_bill_detailsServerImpl implements T_channel_bill_detailsServer{

	@Resource
	private T_channel_bill_detailsMapper t_channel_bill_detailsMapper;

	private T_channel_bill_details t_channel_bill_details=new T_channel_bill_details();
	StoDate stodate=new StoDate();

	//根据主键ID查询
	public T_channel_bill_details selectByid(BigDecimal id) {
		// TODO Auto-generated method stub
		return t_channel_bill_detailsMapper.selectByPrimaryKey(id);
	}
	
	public List<T_channel_bill_details> selectBycheckdate(String checkdate){
		return t_channel_bill_detailsMapper.selectBycheckdate(checkdate);
	}

	public void insertData(String check_date,String channel_code,String channel_order_no,String out_order_no,
			String channel_total_amount,String channel_discount_amount,String channel_refund_no,String out_refund_no,String fee,String business_type,
			String check_status,String date) {
		try{
			int channel_id;
			if(channel_code.equals(ChannelEnum.WXPAY.getValue())){
				channel_id=1;
			}else{
				channel_id=2;
			}
			// TODO Auto-generated method stub
			t_channel_bill_details.setCHECK_DATE(check_date);
			t_channel_bill_details.setCHANNEL_ID(new BigDecimal(channel_id));
			t_channel_bill_details.setCHANNEL_CODE(channel_code);
			t_channel_bill_details.setCHANNEL_ORDER_NO(channel_order_no);
			t_channel_bill_details.setOUT_ORDER_NO(out_order_no);
			t_channel_bill_details.setBUSINESS_TYPE(business_type);
			t_channel_bill_details.setCHANNEL_TOTAL_AMOUNT(new BigDecimal(channel_total_amount));
			t_channel_bill_details.setCHANNEL_DISCOUNT_AMOUNT(new BigDecimal(channel_discount_amount));
			t_channel_bill_details.setCHANNEL_EXPIRE_TIME(stodate.StoDate(date));	
			t_channel_bill_details.setCHANNEL_REFUND_NO(channel_refund_no);
			t_channel_bill_details.setOUT_REFUND_NO(out_refund_no);
			t_channel_bill_details.setFEE(new BigDecimal(fee));
			t_channel_bill_details.setCHECK_STATUS(check_status);
			t_channel_bill_detailsMapper.insertSelective(t_channel_bill_details);
		}catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

	public void updateData() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.ipay.server.T_channel_bill_detailsServer#selectBycheckdateANDbusinesstype(java.lang.String, java.lang.String)
	 */
	public List<T_channel_bill_details> selectBycheckdateANDbusinesstype(String checkdate,String businesstype) {
		// TODO Auto-generated method stub
		return t_channel_bill_detailsMapper.selectBycheckdateANDbusinesstype(checkdate,businesstype);
	}

}
