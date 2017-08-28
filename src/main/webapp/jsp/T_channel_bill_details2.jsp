<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>渠道对账单明细</title>
</head>
<body>
<c:set var="now" value="<%=new java.util.Date()%>" />
<form:form modelAttribute="t_channel_bill_details" method="post" action="insertT_channel_bill_details">
<table>
<tr>
<td><label name="dzrq">对账日期：</label></td>
<td><form:input path="CHECK_DATE"/></td>
</tr>
<tr>
<td><labe name="qddm">渠道代码：</labe></td>
<td>
<form:radiobutton path="CHANNEL_CODE" value="" checked="true"/>全部&emsp;
<form:radiobutton path="CHANNEL_CODE" value="wxpay"/>微信 &emsp;
<form:radiobutton path="CHANNEL_CODE" value="alipay"/>支付宝
</td>
</tr>
<td><label name="ywlx">业务类型：</label></td>
<td>
<form:radiobutton path="BUSINESS_TYPE" value="" checked="true"/>全部&emsp;
<form:radiobutton path="BUSINESS_TYPE" value="1"/>支付交易 &emsp;
<form:radiobutton path="BUSINESS_TYPE" value="2"/>退款交易
</td>
<tr>
<td><label name="dzzt">对账状态：</label></td>
<td>
<form:radiobutton path="CHECK_STATUS" value="" checked="true"/>全部&emsp;
<form:radiobutton path="CHECK_STATUS" value="0"/>未对账&emsp;
<form:radiobutton path="CHECK_STATUS" value="1"/>对平&emsp;
<form:radiobutton path="CHECK_STATUS" value="2"/>未对平&emsp;
<form:radiobutton path="CHECK_STATUS" value="9"/>差异短款
</td>
</tr>
<tr>
<td><label name="qdjysj">渠道交易时间：</label></td>
<td><input name="date" type="text" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy/MM/dd HH:mm:ss'})"/></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="提交" /></td>
</tr>
</table>
</form:form>
</body>
<script type="text/javascript" src="<%=basePath%>js/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.12.3.js"></script> 
</html>