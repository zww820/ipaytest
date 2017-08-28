<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>交易订单号</title>
</head>
<body>
<c:set var="now" value="<%=new java.util.Date()%>" />
<form:form modelAttribute="t_pay_order" method="post" action="insert">
<table>
<tr>
<td><label name="zt">状态：</label></td>
<td><form:select path="STATUS">
<form:options items="${getStatus}"/>
</form:select></td>
</tr>
<tr>
<td><label name="dzzt">对账状态：</label></td>
<td><form:select path="CHECK_STATUS">
<form:options items="${getCheck_status}"/>
</form:select></td>
</tr>
<tr>
<td><label name="dzrq">对账日期：</label></td>
<td><form:input path="CHECK_DATE"></form:input></td>
</tr>
<tr>
<td><label name="zflx">支付类型：</label></td>
<td><form:select path="CHANNEL_CODE">
<form:options items="${getChannel_code}"/>
</form:select></td>
</tr>
<tr>
<td><label name="cjsj">创建时间：</label></td>
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