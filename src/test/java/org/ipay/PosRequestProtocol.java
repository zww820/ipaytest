package org.ipay;

import java.io.Serializable;
import java.util.Date;

public class PosRequestProtocol implements Serializable{
	
	private static final long serialVersionUID = -5810987207899016891L;

	//终端号
	private String terminalNo;
	
	//商户号
	private String merchantNo;
	
	//店铺编号
	private String shopNo;
	
	//员工编号
	private String empNo;
	
	//金额
	private Double amount;

	//支付码
	private String authCode;
	
	//订单创建开始时间
	private Date startDate;
	
	//订单创建结束时间
	private Date endDate;

	//pos机订单号
	private String posOrderId;

	//pos机商户
	private String posMerchantCode;

	//pos机店铺
	private String posStoreCode;

	//pos机终端
	private String posTerminalNo;

	//pos机的ip
	private String posIp;

	//登录名
	private String loginName;

	//登录密码
	private String password;

	//数据权限(1本人级；2本店铺级；3本商户级)
	private String dataPermission;

	//渠道类型(alipay or wxpay)
	private String channel;

	//退款单号
	private String refundNo;

	//原授权密码
	private String authPwd;

	//新授权密码
	private String newAuthPwd;

	//订单编号
	private String orderNo;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getTerminalNo() {
		return terminalNo;
	}

	public void setTerminalNo(String terminalNo) {
		this.terminalNo = terminalNo;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getShopNo() {
		return shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPosIp() {
		return posIp;
	}

	public void setPosIp(String posIp) {
		this.posIp = posIp;
	}

	public String getPosOrderId() {
		return posOrderId;
	}

	public void setPosOrderId(String posOrderId) {
		this.posOrderId = posOrderId;
	}

	public String getPosMerchantCode() {
		return posMerchantCode;
	}

	public void setPosMerchantCode(String posMerchantCode) {
		this.posMerchantCode = posMerchantCode;
	}

	public String getPosStoreCode() {
		return posStoreCode;
	}

	public void setPosStoreCode(String posStoreCode) {
		this.posStoreCode = posStoreCode;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosTerminalNo() {
		return posTerminalNo;
	}

	public void setPosTerminalNo(String posTerminalNo) {
		this.posTerminalNo = posTerminalNo;
	}

	public String getDataPermission() {
		return dataPermission;
	}

	public void setDataPermission(String dataPermission) {
		this.dataPermission = dataPermission;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}


	public String getRefundNo() {
		return refundNo;
	}

	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}

	public String getAuthPwd() {
		return authPwd;
	}

	public void setAuthPwd(String authPwd) {
		this.authPwd = authPwd;
	}

	public String getNewAuthPwd() {
		return newAuthPwd;
	}

	public void setNewAuthPwd(String newAuthPwd) {
		this.newAuthPwd = newAuthPwd;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
}
