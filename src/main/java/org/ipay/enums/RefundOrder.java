package org.ipay.enums;

/**
 * @author Audience
 * @since 2017年8月24日 上午10:45:56
 */
public enum RefundOrder {
	
	REFUND_STATUS("","退款状态"),
	REFUND_PEND("2","退款中"),
	REFUND_SUCCESS("3","退款成功"),
	REFUND_FAILURE("4","退款失败");
	
	private String value="";
	private String text="";
	
	private RefundOrder(String value,String text){
		this.value=value;
		this.text=text;
	}
	public String getValue(){
		return this.value;
	}
	public String getText(){
		return this.text;
	}
}
