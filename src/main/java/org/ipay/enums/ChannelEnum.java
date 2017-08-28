package org.ipay.enums;

/**
 * @author Audience
 * @since 2017年8月8日 上午11:04:12
 */
public enum ChannelEnum {
    ALIPAY("alipay","支付宝"),
    WXPAY("wxpay","微信");
	
	private String value;
	private String text;
	
	private ChannelEnum(String value,String text){
		this.value=value;
		this.text=text;
	}
	
	public String getValue(){
		return value;
	}
	
	public String getText(){
		return text;
	}

}
