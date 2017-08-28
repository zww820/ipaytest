package org.ipay.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.ipay.enums.ChannelBillEnum;
import org.ipay.enums.ChannelEnum;
import org.ipay.enums.PayOrder;

public class Constants {
	/**
	 * 对账日期
	 */
	public static String CHECK_DATE;
	/**
	 * 渠道代码
	 */
	public static String CHANNEL_CODE;
	/**
	 * 业务类型
	 */
	public static String BUSINESS_TYPE;
	/**
	 * 对账状态
	 */
	public static String CHECK_STATUS;
	/**
	 * 渠道交易时间
	 */
	public static String DATE;
	
	public static List<String> status_list(){
		List<String> sl=new ArrayList<String>();
		sl.add(PayOrder.PAY_WAIT.getvalue());
		sl.add(PayOrder.PAY_SUCCESS.getvalue());
		sl.add(PayOrder.PAY_REFUND.getvalue());
		sl.add(PayOrder.PAY_FAILURE.getvalue());
		return sl;
	}
	
	public static List<String> check_status_list_d(){
		List<String> cslld=new ArrayList<String>();
		cslld.add(PayOrder.RECONCILIATION_EQUAL.getvalue());
		cslld.add(PayOrder.RECONCILIATION_NO.getvalue());
		cslld.add(PayOrder.RECONCILIATION_SHORT.getvalue());
		cslld.add(PayOrder.RECONCILIATION_UNEQUAL.getvalue());
		return cslld;
	}
	
	public static List<String> check_status_list_c(){
		List<String> csllc=new ArrayList<String>();
		csllc.add(PayOrder.RECONCILIATION_EQUAL.getvalue());
		csllc.add(PayOrder.RECONCILIATION_NO.getvalue());
		csllc.add(PayOrder.RECONCILIATION_LONG.getvalue());
		csllc.add(PayOrder.RECONCILIATION_UNEQUAL.getvalue());
		return csllc;
	}
	
	public static List<String> business_type_list(){
		List<String> btl=new ArrayList<String>();
		btl.add(ChannelBillEnum.BUSINESS_TYPE_PAY.getValue());
		btl.add(ChannelBillEnum.BUSINESS_TYPE_REFUND.getValue());
		return btl;
	}
	
	public static List<String> channel_code_list(){
		List<String> ccl=new ArrayList<String>();
		ccl.add(ChannelEnum.WXPAY.getValue());
		ccl.add(ChannelEnum.ALIPAY.getValue());
		return ccl;
	}

}
