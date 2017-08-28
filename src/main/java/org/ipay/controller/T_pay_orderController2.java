package org.ipay.controller;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.ipay.enums.ChannelEnum;
import org.ipay.enums.PayOrder;
import org.ipay.model.T_pay_order;
import org.ipay.server.T_pay_orderServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author Audience
 * @since 2017年8月14日 上午10:09:41
 */
//@Controller
public class T_pay_orderController2 {	
	@Resource
	T_pay_orderServer t_pay_orderServer;
	/**
	 * 微信交易订单号表批量生成数据
	 * status：状态、check_status：对账状态、check_date：对账日期、渠道code：channel_code
	 * @return
	 */
	T_pay_order t_pay_order=new T_pay_order();
	@RequestMapping("/T_pay_order")
	public String pay(Model model){
		model.addAttribute("t_pay_order",t_pay_order);
		return "T_pay_order";
	}
	
	@RequestMapping("insert")
	public String wxpayTransaction(@RequestParam("STATUS") String status,
			@RequestParam("CHECK_STATUS") String check_status,
			@RequestParam("CHECK_DATE") String check_date,
			@RequestParam("CHANNEL_CODE") String channel_code,
			@RequestParam("date") String date,Model model){
		System.out.println("status:"+status+",check_status:"+check_status+",check_date:"+check_date+",channel_code:"+channel_code+",date:"+date);
		try{
			if(status.equals(PayOrder.PAY_WAIT.getvalue()) || status.equals("")){
				if(check_status.equals(PayOrder.RECONCILIATION_NO.getvalue()) || status.equals("")){
					//待支付，未对账
					t_pay_orderServer.insertData(date,status,check_status,check_date,channel_code);
				}else if(check_status.equals(PayOrder.RECONCILIATION_EQUAL.getvalue()) || status.equals("")){
					//待支付，对平
					t_pay_orderServer.insertData(date,status, check_status, check_date,channel_code);
				}else if(check_status.equals(PayOrder.RECONCILIATION_UNEQUAL.getvalue()) || status.equals("")){
					//待支付，未对平
					t_pay_orderServer.insertData(date,status, check_status, check_date,channel_code);
				}else if(check_status.equals(PayOrder.RECONCILIATION_SHORT.getvalue()) || status.equals("")){
					//待支付，差异短款
					t_pay_orderServer.insertData(date,status, check_status, check_date,channel_code);
				}
			}else if(status.equals(PayOrder.PAY_SUCCESS.getvalue()) || status.equals("")){
				if(check_status.equals(PayOrder.RECONCILIATION_NO.getvalue()) || status.equals("")){
					//待支付，未对账
					t_pay_orderServer.insertData(date,status, check_status, check_date,channel_code);
				}else if(check_status.equals(PayOrder.RECONCILIATION_EQUAL.getvalue()) || status.equals("")){
					//待支付，对平
					t_pay_orderServer.insertData(date,status, check_status, check_date,channel_code);
				}else if(check_status.equals(PayOrder.RECONCILIATION_UNEQUAL.getvalue()) || status.equals("")){
					//待支付，未对平
					t_pay_orderServer.insertData(date,status, check_status, check_date,channel_code);
				}else if(check_status.equals(PayOrder.RECONCILIATION_SHORT.getvalue()) || status.equals("")){
					//待支付，差异短款
					t_pay_orderServer.insertData(date,status, check_status, check_date,channel_code);
				}
			}else if(status.equals(PayOrder.PAY_FAILURE.getvalue()) || status.equals("")){
				if(check_status.equals(PayOrder.RECONCILIATION_NO.getvalue()) || status.equals("")){
					//待支付，未对账
					t_pay_orderServer.insertData(date,status, check_status, check_date,channel_code);
				}else if(check_status.equals(PayOrder.RECONCILIATION_EQUAL.getvalue()) || status.equals("")){
					//待支付，对平
					t_pay_orderServer.insertData(date,status, check_status, check_date,channel_code);
				}else if(check_status.equals(PayOrder.RECONCILIATION_UNEQUAL.getvalue()) || status.equals("")){
					//待支付，未对平
					t_pay_orderServer.insertData(date,status, check_status, check_date,channel_code);
				}else if(check_status.equals(PayOrder.RECONCILIATION_SHORT.getvalue()) || status.equals("")){
					//待支付，差异短款
					t_pay_orderServer.insertData(date,status, check_status, check_date,channel_code);
				}
			}else if(status.equals(PayOrder.PAY_REFUND.getvalue()) || status.equals("")){
				if(check_status.equals(PayOrder.RECONCILIATION_NO.getvalue()) || status.equals("")){
					//待支付，未对账
					t_pay_orderServer.insertData(date,status, check_status, check_date,channel_code);
				}else if(check_status.equals(PayOrder.RECONCILIATION_EQUAL.getvalue()) || status.equals("")){
					//待支付，对平
					t_pay_orderServer.insertData(date,status, check_status, check_date,channel_code);
				}else if(check_status.equals(PayOrder.RECONCILIATION_UNEQUAL.getvalue()) || status.equals("")){
					//待支付，未对平
					t_pay_orderServer.insertData(date,status, check_status, check_date,channel_code);
				}else if(check_status.equals(PayOrder.RECONCILIATION_SHORT.getvalue()) || status.equals("")){
					//待支付，差异短款
					t_pay_orderServer.insertData(date,status, check_status, check_date,channel_code);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			model.addAttribute("t_pay_order",t_pay_order);
			return "T_pay_order";
		}	
	}
	
	@ModelAttribute("getStatus")
	public Map<String, String> getStatus(){
		Map<String,String> status=new HashMap<String,String>();
		status.put(PayOrder.PAY_WAIT.getvalue(),PayOrder.PAY_WAIT.gettext());
		status.put(PayOrder.PAY_SUCCESS.getvalue(),PayOrder.PAY_SUCCESS.gettext());
		status.put(PayOrder.PAY_STATUS.getvalue(),PayOrder.PAY_STATUS.gettext());
		status.put(PayOrder.PAY_REFUND.getvalue(),PayOrder.PAY_REFUND.gettext());
		status.put(PayOrder.PAY_FAILURE.getvalue(),PayOrder.PAY_FAILURE.gettext());
		return status;
	}
	
	@ModelAttribute("getCheck_status")
	public Map<String,String> getCheck_status(){
		Map<String,String> check_status=new HashMap<String,String>();
		check_status.put(PayOrder.RECONCILIATION_STATUS.getvalue(),PayOrder.RECONCILIATION_STATUS.gettext());
		check_status.put(PayOrder.RECONCILIATION_EQUAL.getvalue(),PayOrder.RECONCILIATION_EQUAL.gettext());
		check_status.put(PayOrder.RECONCILIATION_LONG.getvalue(),PayOrder.RECONCILIATION_LONG.gettext());
		check_status.put(PayOrder.RECONCILIATION_NO.getvalue(),PayOrder.RECONCILIATION_NO.gettext());
		check_status.put(PayOrder.RECONCILIATION_SHORT.getvalue(),PayOrder.RECONCILIATION_SHORT.gettext());
		check_status.put(PayOrder.RECONCILIATION_UNEQUAL.getvalue(),PayOrder.RECONCILIATION_UNEQUAL.gettext());
		return check_status;
	}
	
	@ModelAttribute("getChannel_code")
	public Map<String,String> getChannel_code(){
		Map<String,String> channel_code=new HashMap<String,String>();
		channel_code.put(ChannelEnum.ALIPAY.getValue(),ChannelEnum.ALIPAY.getText());
		channel_code.put(ChannelEnum.WXPAY.getValue(),ChannelEnum.WXPAY.getText());
		return channel_code;
	}
}
