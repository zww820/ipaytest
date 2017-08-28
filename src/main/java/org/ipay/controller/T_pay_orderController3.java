package org.ipay.controller;

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
import org.ipay.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author Audience
 * @param <V>
 * @param <K>
 * @since 2017年8月14日 上午10:09:41
 */
//@Controller
public class T_pay_orderController3 {	
	@Resource
	T_pay_orderServer t_pay_orderServer;
	/**
	 * 微信交易订单号表批量生成数据
	 * status：状态、check_status：对账状态、check_date：对账日期、渠道code：channel_code
	 * @return
	 */
	T_pay_order t_pay_order=new T_pay_order();
	Constants constants=new Constants();
	@RequestMapping("/T_pay_order")
	public String pay(Model model){
		model.addAttribute("t_pay_order",t_pay_order);
		return "T_pay_order";
	}
	
	@RequestMapping("insertT_pay_order")
	public String Transaction(@RequestParam("STATUS") String status,
			@RequestParam("CHECK_STATUS") String check_status,
			@RequestParam("CHECK_DATE") String check_date,
			@RequestParam("CHANNEL_CODE") String channel_code,
			@RequestParam("date") String date,Model model){
		try{
			if(status.equals("")){
				if(check_status.equals("")){
					if(channel_code.equals("")){
						for(String a:constants.status_list()){
							for(String b:constants.check_status_list_d()){
								for(String c:constants.channel_code_list()){
									t_pay_orderServer.insertData(date,a,b,check_date,c);
								}
							}
						}
					}else{
						for(String a:constants.status_list()){
							for(String b:constants.check_status_list_d()){
									t_pay_orderServer.insertData(date,a,b,check_date,channel_code);
							}
						}
					}					
				}else{
					if(channel_code.equals("")){
						for(String a:constants.status_list()){
							for(String c:constants.channel_code_list()){
								t_pay_orderServer.insertData(date,a,channel_code,check_date,c);
							}
						}
					}else{
						for(String a:constants.status_list()){
							t_pay_orderServer.insertData(date,a,channel_code,check_date,channel_code);
						}
					}
				}	
			}else{
				if(check_status.equals("")){
					if(channel_code.equals("")){
						for(String b:constants.check_status_list_d()){
							for(String c:constants.channel_code_list()){
								t_pay_orderServer.insertData(date,status,b,check_date,c);
							}
						}
					}else{
						for(String b:constants.check_status_list_d()){
							t_pay_orderServer.insertData(date,status,b,check_date,channel_code);
						}
					}
				}else{
					if(channel_code.equals("")){
						for(String c:constants.channel_code_list()){
							t_pay_orderServer.insertData(date,status,check_status,check_date,c);
						}
					}else{
						t_pay_orderServer.insertData(date,status,check_status,check_date,channel_code);
					}					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			model.addAttribute("t_pay_order",t_pay_order);
			return "T_pay_order";
		}	
	}
	
	
}
