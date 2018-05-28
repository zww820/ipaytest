<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<form:form modelAttribute="t_channel_bill_details" method="post" action="insertT_channel_bill_details">
<table>
<tr>
<td><label name="dzrq">对账日期：</label></td>
<td><form:input path="CHECK_DATE"/></td>
</tr>
<tr>
<td><labe name="qddm">渠道代码：</labe></td>
<td>
<input id="checkAllqddm" type="checkbox" />全选
<form:checkboxes path="CHANNEL_CODE" items="${getChannel_code}"/>
</td>
</tr>
<td><label name="ywlx">业务类型：</label></td>
<td>
<input id="checkAllywlx" type="checkbox" />全选
<form:checkboxes path="BUSINESS_TYPE" items="${getBusiness_type}"/>
</td>
<tr>
<td><label name="dzzt">对账状态：</label></td>
<td>
<input id="checkAlldzzt" type="checkbox" />全选
<form:checkboxes path="CHECK_STATUS" items="${getCheck_status}"/>
</td>
</tr>
<tr>
<td><label name="qdjysj">渠道交易时间：</label></td>
<td><input name="date" type="text" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy/MM/dd HH:mm:ss'})"/></td>
</tr>
<tr>
<td><label name="cs">次数：</label></td>
<td><input name="counts" type="text"/></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="提交" /></td>
</tr>
</table>
</form:form>
<div>
<input type="button" id="duiping" value="对平"/>
</div>
<div>
<input type="button" id="chayichangkuan_waibudingdan" value="差异长款：外部订单不匹配"/>
</div>
<div>
<input type="button" id="weiduiping_qudaojiaoyijine" value="未对平：渠道交易金额不匹配"/>
</div>
<div>
<input type="button" id="weiduiping_daizhifu" value="未对平：待支付,退款中"/>
</div>
<div>
<input type="button" id="weiduiping_jiaoyishibai" value="未对平：交易失败，退款失败"/>
</div>
<div>
<input type="button" id="weiduiping_qudaojiaoyishijian" value="未对平：渠道交易时间不匹配"/>
</div>
<div>
<input type="button" id="weiduiping_tuikuandaizhifu" value="未对平：退款-待支付"/>
</div>
<div>
<input type="button" id="weiduiping_tuikuanjiaoyishibai" value="未对平：退款-交易失败"/>
</div>
<div>
<input type="button" id="suoyoubutongleixingshuju" value="全部各种不同状态数据"/>
</div>
</body>
<script type="text/javascript" src="<%=basePath%>js/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.12.3.js"></script> 
<script type="text/javascript">
$(function(){
	$("#duiping").click(function(){
		$.ajax({
			url:'duiping',
			type:'post',
			success:function(data){
				alert("ok");
			}
		});
	}),
	$("#chayichangkuan_waibudingdan").click(function(){
		$.ajax({
			url:'chayichangkuan_waibudingdan',
			type:'post',
			success:function(data){
				alert("ok");
			}
		});
	}),
	$("#weiduiping_qudaojiaoyijine").click(function(){
		$.ajax({
			url:'weiduiping_qudaojiaoyijine',
			type:'post',
			success:function(data){
				alert("ok");
			}
		});
	}),
	$("#weiduiping_daizhifu").click(function(){
		$.ajax({
			url:'weiduiping_daizhifu',
			type:'post',
			success:function(data){
				alert("ok");
			}
		});
	}),
	$("#weiduiping_jiaoyishibai").click(function(){
		$.ajax({
			url:'weiduiping_jiaoyishibai',
			type:'post',
			success:function(data){
				alert("ok");
			}
		});
	}),
	$("#weiduiping_qudaojiaoyishijian").click(function(){
		$.ajax({
			url:'weiduiping_qudaojiaoyishijian',
			type:'post',
			success:function(data){
				alert("ok");
			}
		});
	}),
	$("#weiduiping_tuikuandaizhifu").click(function(){
		$.ajax({
			url:'weiduiping_tuikuandaizhifu',
			type:'post',
			success:function(data){
				alert("ok");
			}
		});
	}),
	$("#weiduiping_tuikuanjiaoyishibai").click(function(){
		$.ajax({
			url:'weiduiping_tuikuanjiaoyishibai',
			type:'post',
			success:function(data){
				alert("ok");
			}
		});
	}),
	$("#suoyoubutongleixingshuju").click(function(){
		$.ajax({
			url:'suoyoubutongleixingshuju',
			type:'post',
			success:function(data){
				alert("ok");
			}
		});
	}),
	$('#checkAllqddm').click(function(){
		var isChecked = $(this).prop("checked");
		$('input[name="CHANNEL_CODE"]').prop("checked", isChecked);
	}),
	$('#checkAllywlx').click(function(){
		var isChecked = $(this).prop("checked");
		$('input[name="BUSINESS_TYPE"]').prop("checked", isChecked);
	}),
	$('#checkAlldzzt').click(function(){
		var isChecked = $(this).prop("checked");
		$('input[name="CHECK_STATUS"]').prop("checked", isChecked);
	});
});
</script>
</html>