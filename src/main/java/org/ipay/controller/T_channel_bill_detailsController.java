package org.ipay.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.ipay.enums.ChannelBillEnum;
import org.ipay.enums.ChannelEnum;
import org.ipay.enums.PayOrder;
import org.ipay.enums.RefundOrder;
import org.ipay.model.T_channel_bill_details;
import org.ipay.server.T_channel_bill_detailsServer;
import org.ipay.server.T_pay_orderServer;
import org.ipay.server.T_pay_order_refundServer;
import org.ipay.utils.Constants;
import org.ipay.utils.Randparams;
import org.ipay.utils.StoDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Audience
 * @since 2017年8月17日 上午10:41:40
 */
@Controller
public class T_channel_bill_detailsController {

	Randparams randparams=new Randparams();
	@Resource
	T_channel_bill_detailsServer t_channel_bill_detailsServer;
	@Resource
	T_pay_orderServer t_pay_orderServer;
	@Resource
	T_pay_order_refundServer t_pay_order_refundServer;

	T_channel_bill_details t_channel_bill_details=new T_channel_bill_details();
	StoDate dts=new StoDate();
	
	@RequestMapping("T_channel_bill_details")
	public String init(Model model){
		model.addAttribute("t_channel_bill_details",t_channel_bill_details);
		return "T_channel_bill_details";
	}

	@SuppressWarnings("finally")
	@RequestMapping("insertT_channel_bill_details")
	public String Transaction(@RequestParam("CHECK_DATE") String check_date,
			@RequestParam("CHANNEL_CODE") List<String> channel_code,
			@RequestParam("BUSINESS_TYPE") List<String> business_type,
			@RequestParam("CHECK_STATUS") List<String> check_status,
			@RequestParam("date") String date,Model model
			){
		try{
			//临时存储入库数据Map
			Map<Object,String> tmpMap=new HashMap<Object,String>();
			if(check_date.isEmpty()||channel_code.isEmpty()||business_type.isEmpty()||check_status.isEmpty()||date.isEmpty()){
				model.addAttribute("t_channel_bill_details",t_channel_bill_details);
			}else{
				//渠道
				for(String i:channel_code){
					//对账状态
					for(String j:check_status){
						//业务类型
						for(String k:business_type){
							//支付
							if(k.equals(ChannelBillEnum.BUSINESS_TYPE_PAY.getValue())){
								tmpMap.put("channel_order_no", randparams.randonStoInt(28));
								tmpMap.put("out_order_no",randparams.randonStoInt(13));
								tmpMap.put("channel_total_amount",randparams.randomMoney(7));
								tmpMap.put("channel_discount_amount", randparams.randomMoney(5));
								tmpMap.put("fee", randparams.randomMoney(5));
								t_channel_bill_detailsServer.insertData(check_date, i, tmpMap.get("channel_order_no"),tmpMap.get("out_order_no"),
										tmpMap.get("channel_total_amount"),tmpMap.get("channel_discount_amount"),"", "",tmpMap.get("fee"), k, j, date);
							}else{
								//判断是否存在支付流水
								if(tmpMap.values().isEmpty()){
									continue;
								}else{
									//微信退款
									if(i.equals(ChannelEnum.WXPAY.getValue())){
										t_channel_bill_detailsServer.insertData(check_date, i, tmpMap.get("channel_order_no"), tmpMap.get("out_order_no"), 
												tmpMap.get("channel_total_amount"),tmpMap.get("channel_discount_amount"),randparams.randonStoInt(28),randparams.randonStoInt(13),
												tmpMap.get("fee"), k, j, date);
										
									}else{
										//支付宝退款
										t_channel_bill_detailsServer.insertData(check_date, i, tmpMap.get("channel_order_no"), tmpMap.get("out_order_no"), 
												tmpMap.get("channel_total_amount"),tmpMap.get("channel_discount_amount"),"", randparams.randonStoInt(13),
												tmpMap.get("fee"), k, j, date);
									}
								}
							}
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			model.addAttribute("t_channel_bill_details",t_channel_bill_details);
			Constants.CHECK_DATE=check_date;
			Constants.DATE=date;
			return "T_channel_bill_details";
		}
	} 
	
	/**
	 * 对平
	 */
	@RequestMapping("duiping")
	private void duiping(){
		List<T_channel_bill_details> lis=t_channel_bill_detailsServer.selectBycheckdate(Constants.CHECK_DATE);
		for(T_channel_bill_details i:lis){
			//判断交易类型为支付
			if(i.getBUSINESS_TYPE().equals(ChannelBillEnum.BUSINESS_TYPE_PAY.getValue())){
				//支付对平
				t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_SUCCESS.getvalue(), 
						randparams.randomMoney(7), randparams.randomMoney(7), i.getCHANNEL_TOTAL_AMOUNT().toString(), i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),randparams.randomMoney(2));
			}else{
				//退款对平
				t_pay_order_refundServer.insertData(i.getCHANNEL_DISCOUNT_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), i.getCHANNEL_CODE(), i.getOUT_REFUND_NO(), i.getCHANNEL_REFUND_NO(),
						dts.DtoString(i.getCHANNEL_EXPIRE_TIME()), i.getCHANNEL_ORDER_NO(), i.getOUT_ORDER_NO(), dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),Constants.CHECK_DATE , Constants.CHECK_DATE, i.getCHECK_STATUS());
			}
		}
	}
	
	/**
	 * 差异长款：外部订单不匹配
	 */
	@RequestMapping("chayichangkuan_waibudingdan")
	private void chayichangkuan_waibudingdan(){
		List<T_channel_bill_details> lis=t_channel_bill_detailsServer.selectBycheckdate(Constants.CHECK_DATE);
		for(T_channel_bill_details i:lis){
			//判断交易类型为支付
			if(i.getBUSINESS_TYPE().equals(ChannelBillEnum.BUSINESS_TYPE_PAY.getValue())){
				//外部订单不匹配
				t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),randparams.randonStoInt(17), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_SUCCESS.getvalue(), 
						randparams.randomMoney(7), randparams.randomMoney(7), i.getCHANNEL_TOTAL_AMOUNT().toString(), i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),randparams.randomMoney(2));
			}else{
				//渠道退款单号不匹配
				t_pay_order_refundServer.insertData(i.getCHANNEL_DISCOUNT_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), i.getCHANNEL_CODE(), i.getOUT_REFUND_NO(), randparams.randonStoInt(28),
						dts.DtoString(i.getCHANNEL_EXPIRE_TIME()), i.getCHANNEL_ORDER_NO(), i.getOUT_ORDER_NO(), dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),Constants.CHECK_DATE , Constants.CHECK_DATE, i.getCHECK_STATUS());
			}
		}
	}
	
	/**
	 * 未对平：渠道交易金额不匹配
	 */
	@RequestMapping("weiduiping_qudaojiaoyijine")
	private void weiduiping_qudaojiaoyijine(){
		List<T_channel_bill_details> lis=t_channel_bill_detailsServer.selectBycheckdate(Constants.CHECK_DATE);
		for(T_channel_bill_details i:lis){
			//判断交易类型为支付
			if(i.getBUSINESS_TYPE().equals(ChannelBillEnum.BUSINESS_TYPE_PAY.getValue())){
				//渠道交易金额不匹配
				t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),randparams.randonStoInt(17), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_SUCCESS.getvalue(), 
						randparams.randomMoney(7), randparams.randomMoney(7), randparams.randomMoney(7), i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),randparams.randomMoney(2));
			}else{
				//渠道交易金额不匹配
				t_pay_order_refundServer.insertData(randparams.randomMoney(7), RefundOrder.REFUND_SUCCESS.getValue(), i.getCHANNEL_CODE(), i.getOUT_REFUND_NO(), randparams.randonStoInt(28),
						dts.DtoString(i.getCHANNEL_EXPIRE_TIME()), i.getCHANNEL_ORDER_NO(), i.getOUT_ORDER_NO(), dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),Constants.CHECK_DATE , Constants.CHECK_DATE, i.getCHECK_STATUS());
			}
		}
	}
	
	/**
	 * 未对平：待支付
	 * 未对平：退款中
	 */
	@RequestMapping("weiduiping_daizhifu")
	private void weiduiping_daizhifu(){
		List<T_channel_bill_details> lis=t_channel_bill_detailsServer.selectBycheckdate(Constants.CHECK_DATE);
		for(T_channel_bill_details i:lis){
			//判断交易类型为支付
			if(i.getBUSINESS_TYPE().equals(ChannelBillEnum.BUSINESS_TYPE_PAY.getValue())){
				//支付状态为待支付
				t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),randparams.randonStoInt(17), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_WAIT.getvalue(), 
						randparams.randomMoney(7), randparams.randomMoney(7), randparams.randomMoney(7), i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),randparams.randomMoney(2));
			}else{
				//退款状态为退款中
				t_pay_order_refundServer.insertData(randparams.randomMoney(7), RefundOrder.REFUND_PEND.getValue(), i.getCHANNEL_CODE(), i.getOUT_REFUND_NO(), randparams.randonStoInt(28),
						dts.DtoString(i.getCHANNEL_EXPIRE_TIME()), i.getCHANNEL_ORDER_NO(), i.getOUT_ORDER_NO(), dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),Constants.CHECK_DATE , Constants.CHECK_DATE, i.getCHECK_STATUS());
			}
		}
	}
	
	/**
	 * 未对平：交易失败
	 * 未对平：退款失败
	 */
	@RequestMapping("weiduiping_jiaoyishibai")
	private void weiduiping_jiaoyishibai(){
		List<T_channel_bill_details> lis=t_channel_bill_detailsServer.selectBycheckdate(Constants.CHECK_DATE);
		for(T_channel_bill_details i:lis){
			//判断交易类型为支付
			if(i.getBUSINESS_TYPE().equals(ChannelBillEnum.BUSINESS_TYPE_PAY.getValue())){
				//支付状态为交易失败
				t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),randparams.randonStoInt(17), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_FAILURE.getvalue(), 
						randparams.randomMoney(7), randparams.randomMoney(7), randparams.randomMoney(7), i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),randparams.randomMoney(2));
			}else{
				//退款状态为退款失败
				t_pay_order_refundServer.insertData(randparams.randomMoney(7), RefundOrder.REFUND_FAILURE.getValue(), i.getCHANNEL_CODE(), i.getOUT_REFUND_NO(), randparams.randonStoInt(28),
						dts.DtoString(i.getCHANNEL_EXPIRE_TIME()), i.getCHANNEL_ORDER_NO(), i.getOUT_ORDER_NO(), dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),Constants.CHECK_DATE , Constants.CHECK_DATE, i.getCHECK_STATUS());
			}
		}
	}
	
	/**
	 * 未对平：渠道交易时间不匹配
	 */
	@RequestMapping("weiduiping_qudaojiaoyishijian")
	private void weiduiping_qudaojiaoyishijian(){
		List<T_channel_bill_details> lis=t_channel_bill_detailsServer.selectBycheckdate(Constants.CHECK_DATE);
		for(T_channel_bill_details i:lis){
			//判断交易类型为支付
			if(i.getBUSINESS_TYPE().equals(ChannelBillEnum.BUSINESS_TYPE_PAY.getValue())){
				//渠道交易时间不匹配
				t_pay_orderServer.insertData(dts.currentDate(),randparams.randonStoInt(17), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_FAILURE.getvalue(), 
						randparams.randomMoney(7), randparams.randomMoney(7), randparams.randomMoney(7), i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),randparams.randomMoney(2));
			}else{
				//渠道交易时间不匹配
				t_pay_order_refundServer.insertData(randparams.randomMoney(7), RefundOrder.REFUND_FAILURE.getValue(), i.getCHANNEL_CODE(), i.getOUT_REFUND_NO(), randparams.randonStoInt(28),
						dts.currentDate(), i.getCHANNEL_ORDER_NO(), i.getOUT_ORDER_NO(), dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),Constants.CHECK_DATE , Constants.CHECK_DATE, i.getCHECK_STATUS());
			}
		}
	}
	
	/**
	 * 未对平：退款-待支付
	 */
	@RequestMapping("weiduiping_tuikuandaizhifu")
	private void weiduiping_tuikuandaizhifu(){
		List<T_channel_bill_details> lis=t_channel_bill_detailsServer.selectBycheckdate(Constants.CHECK_DATE);
		for(T_channel_bill_details i:lis){
			//判断交易类型为支付
			if(i.getBUSINESS_TYPE().equals(ChannelBillEnum.BUSINESS_TYPE_PAY.getValue())){
				//支付状态为待支付
				t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_WAIT.getvalue(), 
						randparams.randomMoney(7), randparams.randomMoney(7), i.getCHANNEL_TOTAL_AMOUNT().toString(), i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),randparams.randomMoney(2));
			}else{
				//退款对平
				t_pay_order_refundServer.insertData(i.getCHANNEL_DISCOUNT_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), i.getCHANNEL_CODE(), i.getOUT_REFUND_NO(), i.getCHANNEL_REFUND_NO(),
						dts.DtoString(i.getCHANNEL_EXPIRE_TIME()), i.getCHANNEL_ORDER_NO(), i.getOUT_ORDER_NO(), dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),Constants.CHECK_DATE , Constants.CHECK_DATE, i.getCHECK_STATUS());
			}
		}
	}
	
	/**
	 * 未对平：退款-待支付
	 */
	@RequestMapping("weiduiping_tuikuanjiaoyishibai")
	private void weiduiping_tuikuanjiaoyishibai(){
		List<T_channel_bill_details> lis=t_channel_bill_detailsServer.selectBycheckdate(Constants.CHECK_DATE);
		for(T_channel_bill_details i:lis){
			//判断交易类型为支付
			if(i.getBUSINESS_TYPE().equals(ChannelBillEnum.BUSINESS_TYPE_PAY.getValue())){
				//支付状态为交易失败
				t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_FAILURE.getvalue(), 
						randparams.randomMoney(7), randparams.randomMoney(7), i.getCHANNEL_TOTAL_AMOUNT().toString(), i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),randparams.randomMoney(2));
			}else{
				//退款对平
				t_pay_order_refundServer.insertData(i.getCHANNEL_DISCOUNT_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), i.getCHANNEL_CODE(), i.getOUT_REFUND_NO(), i.getCHANNEL_REFUND_NO(),
						dts.DtoString(i.getCHANNEL_EXPIRE_TIME()), i.getCHANNEL_ORDER_NO(), i.getOUT_ORDER_NO(), dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),Constants.CHECK_DATE , Constants.CHECK_DATE, i.getCHECK_STATUS());
			}
		}
	}
	
	@ModelAttribute("getBusiness_type")
	private Map<String, String> getStatus(){
		Map<String,String> status=new HashMap<String,String>();
		status.put(ChannelBillEnum.BUSINESS_TYPE_PAY.getValue(),ChannelBillEnum.BUSINESS_TYPE_PAY.getText());
		status.put(ChannelBillEnum.BUSINESS_TYPE_REFUND.getValue(),ChannelBillEnum.BUSINESS_TYPE_REFUND.getText());
		return status;
	}
	
	@ModelAttribute("getCheck_status")
	private Map<String,String> getCheck_status(){
		Map<String,String> check_status=new HashMap<String,String>();
		check_status.put(PayOrder.RECONCILIATION_EQUAL.getvalue(),PayOrder.RECONCILIATION_EQUAL.gettext());
		check_status.put(PayOrder.RECONCILIATION_LONG.getvalue(),PayOrder.RECONCILIATION_LONG.gettext());
		check_status.put(PayOrder.RECONCILIATION_NO.getvalue(),PayOrder.RECONCILIATION_NO.gettext());
		check_status.put(PayOrder.RECONCILIATION_SHORT.getvalue(),PayOrder.RECONCILIATION_SHORT.gettext());
		check_status.put(PayOrder.RECONCILIATION_UNEQUAL.getvalue(),PayOrder.RECONCILIATION_UNEQUAL.gettext());
		return check_status;
	}
	
	@ModelAttribute("getChannel_code")
	private Map<String,String> getChannel_code(){
		Map<String,String> channel_code=new HashMap<String,String>();
		channel_code.put(ChannelEnum.ALIPAY.getValue(),ChannelEnum.ALIPAY.getText());
		channel_code.put(ChannelEnum.WXPAY.getValue(),ChannelEnum.WXPAY.getText());
		return channel_code;
	}
}
