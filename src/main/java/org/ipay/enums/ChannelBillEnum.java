package org.ipay.enums;

/**
 * @author Audience
 * @since 2017年8月8日 上午10:42:13
 */
public enum ChannelBillEnum {
	/**
	 * 业务类型（1：支付交易；2：退款交易）
	 */
	BUSINESS_TYPE("","业务类型"),
	BUSINESS_TYPE_PAY("1","支付交易"),
	BUSINESS_TYPE_REFUND("2","退款交易"),
	
	/**
     * 支付类型（1：支付宝扫码收单（商家扫用户）；2：支付宝被扫收单（商家码被用户扫）；
     * 		3：微信扫码收单；4：微信被扫收单。）
     */
	PAY_TYPE("","支付类型"),
	PAY_TYPE_ALIPAYING("1","支付宝扫码收单"),
	PAY_TYPE_ALIPAYED("2","支付宝被扫收单"),
	PAY_TYPE_WXPAYING("3","微信扫码收单"),
	PAY_TYPE_WXPAYED("4","微信被扫收单"),
	
	/**
	 * 下载状态（0：无对账文件；1：下载成功；2：下载失败）
	 */
	LOWNLOAD_STATUS("","下载状态"),
	LOWNLOAD_STATUS_NONE("0","无对账文件"),
	LOWNLOAD_STATUS_SUCCESS("1","下载成功"),
	LOWNLOAD_STATUS_FAIL("2","下载失败");
	
	
	
	private String value;
    private String text;
    
    private ChannelBillEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }
    public String getValue() {
        return value;
    }
    public String getText() {
        return text;
    }

}
