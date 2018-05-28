package org.ipay.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ipay.enums.ChannelBillEnum;
import org.ipay.enums.ChannelEnum;
import org.ipay.enums.PayOrder;

public class Constants {
	/**
	 * 时间
	 */
	public static Date CURRENT_TIME;
	/**
	 * 汇率模板ID
	 */
	public static long RATE_TMP_TYPE_ID;
	public static long RATE_TMP_TYPE_ID_2;
	/**
	 * 商户号ID
	 */
	public static long MERCHANT_ID;
	public static long MERCHANT_ID_2;
	/**
	 * 商户编号
	 */
	public static String MERCHANT_CODE;
	/**
	 * 商户名称
	 */
	public static String MERCHANT_NAME;
	public static String MERCHANT_NAME_2;
	/**
	 * 商户简称
	 */
	public static String MERCHANT_NAME_SHORT;
	/**
	 * 机构ID
	 */
	public static long ORG_ID;
	public static long ORG_ID_2;
	/**
	 * 机构code
	 */
	public static String ORG_CODE;
	/**
	 * 店铺ID
	 */
	public static long SHOP_ID;
	public static long SHOP_ID_2;
	/**
	 * 店铺名称
	 */
	public static String SHOP_NAME;
	public static String SHOP_NAME_2;
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
