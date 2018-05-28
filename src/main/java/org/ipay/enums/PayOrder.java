package org.ipay.enums;

/**
 * @author Audience
 * @since 2017年8月14日 下午2:43:01
 */
public enum PayOrder {
	/**
	 * 交易状态：2待支付、3交易成功、4交易失败、5交易退款
	 */
	PAY_STATUS("","状态"),
	PAY_WAIT("2","待支付"),
	PAY_SUCCESS("3","交易成功"),
	PAY_FAILURE("4","交易失败"),
	PAY_REFUND("5","交易退款"),
	
	/**
	 * 对账状态：
	 * 0：未对账；1：对平；2：未对平；3：存疑短款；4：存疑长款；
	 * 5：存疑短款转对平；6：存疑长款转对平；7：存疑短款转未对平；8：存疑长款转未对平；
	 * 9：差异短款；10：差异长款；11：差异转对平；99：无需对账
	 */
	RECONCILIATION_STATUS("","对账状态"),
	RECONCILIATION_NO("0","未对账"),
	RECONCILIATION_EQUAL("1","对平"),
	RECONCILIATION_UNEQUAL("2","未对平"),
	RECONCILIATION_SHORT("9","差异短款"),
	RECONCILIATION_LONG("10","差异长款"),
	
	/**
	 * 清算状态
	 * 0：清算成功；1：未清算；2：清算中；3：清算失败
	 */
	CLEARING_STATUS("","状态"),
	CLEARING_SUCCESS("0","清算成功"),
	CLEARING_NO("1","未清算"),
	CLEARING_PENDING("2","清算中"),
	CLEARING_FAILURE("3","清算失败");
	
	private String value;
	private String text;
	private PayOrder(String value,String text){
		this.value=value;
		this.text=text;
	}
	public String getvalue(){
		return value;
	}
	public String gettext(){
		return text;
	}

}
