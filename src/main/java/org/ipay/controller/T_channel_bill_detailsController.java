package org.ipay.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.ipay.enums.ChannelBillEnum;
import org.ipay.enums.ChannelEnum;
import org.ipay.enums.PayOrder;
import org.ipay.enums.RefundOrder;
import org.ipay.model.*;
import org.ipay.server.*;
import org.ipay.utils.Constants;
import org.ipay.utils.Randparams;
import org.ipay.utils.StoDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Audience
 * @since 2017年8月17日 上午10:41:40
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Controller
public class T_channel_bill_detailsController {

	private final Logger logger=LoggerFactory.getLogger(this.getClass());

	Randparams randparams=new Randparams();
	@Autowired
	T_channel_bill_detailsServer t_channel_bill_detailsServer;
	@Autowired
	T_pay_orderServer t_pay_orderServer;
	@Autowired
	T_pay_order_refundServer t_pay_order_refundServer;
	@Autowired
	T_ipay_organizationServer t_ipay_organizationServer;
	@Autowired
	T_merchant_basic_infoServer t_merchant_basic_infoServer;
	@Autowired
	T_merchant_rateServer t_merchant_rateServer;
	@Autowired
	T_rate_template_typeServer t_rate_template_typeServer;
	@Autowired
	T_merchantServer t_merchantserver;
	@Autowired
	T_merchant_shopServer t_merchant_shopServer;
	@Autowired
	T_merchant_relatedServer t_merchant_relatedServer;

	T_channel_bill_details t_channel_bill_details=new T_channel_bill_details();
	T_pay_order t_pay_order=new T_pay_order();
	T_pay_order_refund t_pay_order_refund=new T_pay_order_refund();
	T_merchant_related t_merchant_related1;
	T_merchant_related t_merchant_related2;
	StoDate dts=new StoDate();
	long[] merchant_ids=new long[2];
	boolean merchant_idbool=true;
	boolean merchant_idbool2=true;
	int num1;
	int num2;

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
			@RequestParam("date") String date,
			@RequestParam("counts") String counts,Model model
			){
		try{
			logger.info("【对账日期】："+check_date);
			if(StringUtils.isEmpty(counts)){
				counts="1";
			}
			//随机生成机构商户店铺
//			t_ipay_organizationServer.insertData(randparams.randonStoInt(7));
//			for(int i=0;i<2;i++){
//				t_merchantserver.insertData(randparams.randonStoInt(7), randparams.randonStoInt(10));
//				t_rate_template_typeServer.insertData(randparams.randonStoInt(7));
//				t_merchant_basic_infoServer.insertData(Constants.RATE_TMP_TYPE_ID);
//				t_merchant_rateServer.insertData(Constants.RATE_TMP_TYPE_ID, randparams.randomMoney(2),"1");
//				t_merchant_rateServer.insertData(Constants.RATE_TMP_TYPE_ID, randparams.randomMoney(2),"2");
//				t_merchant_shopServer.insertData(Constants.ORG_ID, Constants.MERCHANT_ID, randparams.randonStoInt(10), randparams.randonStoInt(7));
//				merchant_ids[i]=Constants.MERCHANT_ID;
//			}

			List merchantIds=new ArrayList<>();
			merchantIds=t_merchantserver.searchMerchantID();
			logger.info("merchantIds:"+merchantIds);
			int mIds=merchantIds.size();
			if(merchantIds.isEmpty()){
				return null;
			}else {
				num1=(int)(Math.random()*mIds);
				num2=(int)(Math.random()*mIds);
			}

			t_merchant_related1=t_merchant_relatedServer.search((long)merchantIds.get(num1));
			t_merchant_related2=t_merchant_relatedServer.search((long)merchantIds.get(num2));

			Constants.MERCHANT_ID=t_merchant_related1.getMERCHANT_ID();
			Constants.RATE_TMP_TYPE_ID=t_merchant_related1.getRATE_TMP_TYPE_ID();
			Constants.ORG_ID=t_merchant_related1.getORG_ID();
			Constants.MERCHANT_NAME=t_merchant_related1.getMERCHANT_NAME();
			Constants.SHOP_ID=t_merchant_related1.getSHOP_ID();
			Constants.SHOP_NAME=t_merchant_related1.getSHOP_NAME();

			Constants.MERCHANT_ID_2=t_merchant_related2.getMERCHANT_ID();
			Constants.RATE_TMP_TYPE_ID_2=t_merchant_related2.getRATE_TMP_TYPE_ID();
			Constants.ORG_ID_2=t_merchant_related2.getORG_ID();
			Constants.MERCHANT_NAME_2=t_merchant_related2.getMERCHANT_NAME();
			Constants.SHOP_ID_2=t_merchant_related2.getSHOP_ID();
			Constants.SHOP_NAME_2=t_merchant_related2.getSHOP_NAME();
			merchant_ids[0]=Constants.MERCHANT_ID;
			merchant_ids[1]=Constants.MERCHANT_ID_2;

			//临时存储入库数据Map
			Map<Object,String> tmpMap=new HashMap<Object,String>();
			if(StringUtils.isEmpty(check_date)||channel_code.isEmpty()||business_type.isEmpty()||check_status.isEmpty()||StringUtils.isEmpty(date)){
				model.addAttribute("t_channel_bill_details",t_channel_bill_details);
			}else{
				for(int q=0;q<Integer.parseInt(counts);q++){
					//渠道
					for(String i:channel_code){
						//对账状态
						for(String j:check_status){
							//支付类型
							for(String l:getPay_type().keySet()){
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
												tmpMap.get("channel_total_amount"),tmpMap.get("channel_discount_amount"),"", "",tmpMap.get("fee"), k, j, date,l);
									}else{
										//判断是否存在支付流水
										if(tmpMap.values().isEmpty()){
											continue;
										}else{
											//微信退款
											if(i.equals(ChannelEnum.WXPAY.getValue())){
												t_channel_bill_detailsServer.insertData(check_date, i, tmpMap.get("channel_order_no"), tmpMap.get("out_order_no"), 
														tmpMap.get("channel_total_amount"),tmpMap.get("channel_discount_amount"),randparams.randonStoInt(28),randparams.randonStoInt(13),
														tmpMap.get("fee"), k, j, date,l);

											}else{
												//支付宝&银联退款
												t_channel_bill_detailsServer.insertData(check_date, i, tmpMap.get("channel_order_no"), tmpMap.get("out_order_no"), 
														tmpMap.get("channel_total_amount"),tmpMap.get("channel_discount_amount"),"","",
														tmpMap.get("fee"), k, j, date,l);
											}
										}
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
						randparams.randomMoney(7), randparams.randomMoney(7),i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),
						i.getCHANNEL_DISCOUNT_AMOUNT().toString(), i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),
						String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue(),randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
			}else{
				//退款对平
				t_pay_order_refundServer.insertData(i.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), i.getCHANNEL_CODE(), i.getOUT_REFUND_NO(), i.getCHANNEL_REFUND_NO(),
						dts.DtoString(i.getCHANNEL_EXPIRE_TIME()), i.getCHANNEL_ORDER_NO(), i.getOUT_ORDER_NO(), dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),Constants.CHECK_DATE , Constants.CHECK_DATE,
						i.getCHECK_STATUS(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME,i.getPAY_TYPE());
				t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(),i.getOUT_ORDER_NO());
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
						randparams.randomMoney(7), randparams.randomMoney(7),i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),
						i.getCHANNEL_DISCOUNT_AMOUNT().toString(),i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),
						String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue(),randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
			}else{
				//渠道退款单号不匹配
				t_pay_order_refundServer.insertData(i.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), i.getCHANNEL_CODE(), i.getOUT_REFUND_NO(), i.getCHANNEL_REFUND_NO(),
						dts.DtoString(i.getCHANNEL_EXPIRE_TIME()), i.getCHANNEL_ORDER_NO(), i.getOUT_ORDER_NO(), dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),Constants.CHECK_DATE , Constants.CHECK_DATE, 
						i.getCHECK_STATUS(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME,i.getPAY_TYPE());
				t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(),i.getOUT_ORDER_NO());
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
				t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_SUCCESS.getvalue(), 
						randparams.randomMoney(7), randparams.randomMoney(7), randparams.randomMoney(7),randparams.randomMoney(6),randparams.randomMoney(6),i.getCHANNEL_DISCOUNT_AMOUNT().toString(), 
						i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue()
						,randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
			}else{
				//渠道交易金额不匹配
				t_pay_order_refundServer.insertData(randparams.randomMoney(7), RefundOrder.REFUND_SUCCESS.getValue(), i.getCHANNEL_CODE(), i.getOUT_REFUND_NO(), i.getCHANNEL_REFUND_NO(),
						dts.DtoString(i.getCHANNEL_EXPIRE_TIME()), i.getCHANNEL_ORDER_NO(), i.getOUT_ORDER_NO(), dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),Constants.CHECK_DATE , Constants.CHECK_DATE, 
						i.getCHECK_STATUS(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME,i.getPAY_TYPE());
				t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(),i.getOUT_ORDER_NO());
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
				t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_WAIT.getvalue(), 
						randparams.randomMoney(7), randparams.randomMoney(7),i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),i.getCHANNEL_DISCOUNT_AMOUNT().toString(),
						i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue()
						,randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
			}else{
				//退款状态为退款中
				t_pay_order_refundServer.insertData(i.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_PEND.getValue(), i.getCHANNEL_CODE(), i.getOUT_REFUND_NO(), i.getCHANNEL_REFUND_NO(),
						dts.DtoString(i.getCHANNEL_EXPIRE_TIME()), i.getCHANNEL_ORDER_NO(), i.getOUT_ORDER_NO(), dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),Constants.CHECK_DATE , Constants.CHECK_DATE, 
						i.getCHECK_STATUS(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME,i.getPAY_TYPE());
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
				t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_FAILURE.getvalue(), 
						randparams.randomMoney(7), randparams.randomMoney(7),i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),i.getCHANNEL_DISCOUNT_AMOUNT().toString(),
						i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue()
						,randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
			}else{
				//退款状态为退款失败
				t_pay_order_refundServer.insertData(i.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_FAILURE.getValue(), i.getCHANNEL_CODE(), i.getOUT_REFUND_NO(), i.getCHANNEL_REFUND_NO(),
						dts.DtoString(i.getCHANNEL_EXPIRE_TIME()), i.getCHANNEL_ORDER_NO(), i.getOUT_ORDER_NO(), dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),Constants.CHECK_DATE , Constants.CHECK_DATE, 
						i.getCHECK_STATUS(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME,i.getPAY_TYPE());
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
				t_pay_orderServer.insertData(dts.currentDate(),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_SUCCESS.getvalue(), 
						randparams.randomMoney(7), randparams.randomMoney(7),i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),i.getCHANNEL_DISCOUNT_AMOUNT().toString(),
						i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue()
						,randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
			}else{
				//渠道交易时间不匹配
				t_pay_order_refundServer.insertData(i.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), i.getCHANNEL_CODE(), i.getOUT_REFUND_NO(), i.getCHANNEL_REFUND_NO(),
						dts.DtoString(i.getCHANNEL_EXPIRE_TIME()), i.getCHANNEL_ORDER_NO(), i.getOUT_ORDER_NO(), dts.currentDate(),Constants.CHECK_DATE , Constants.CHECK_DATE, i.getCHECK_STATUS(),
						String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME,i.getPAY_TYPE());
				t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(),i.getOUT_ORDER_NO());
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
				//支付状态为支付成功
				t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_SUCCESS.getvalue(), 
						randparams.randomMoney(7), randparams.randomMoney(7), i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),i.getCHANNEL_DISCOUNT_AMOUNT().toString(),
						i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue()
						,randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
			}else{
				//退款-待支付未对平
				t_pay_order_refundServer.insertData(i.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), i.getCHANNEL_CODE(), i.getOUT_REFUND_NO(), i.getCHANNEL_REFUND_NO(),
						dts.DtoString(i.getCHANNEL_EXPIRE_TIME()), i.getCHANNEL_ORDER_NO(), i.getOUT_ORDER_NO(), dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),Constants.CHECK_DATE , Constants.CHECK_DATE, 
						i.getCHECK_STATUS(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME,i.getPAY_TYPE());
				//修改相应支付订单状态为“待支付”
				t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_WAIT.getvalue(),i.getOUT_ORDER_NO());
			}
		}
	}

	/**
	 * 未对平：退款-交易失败
	 */
	@RequestMapping("weiduiping_tuikuanjiaoyishibai")
	private void weiduiping_tuikuanjiaoyishibai(){
		List<T_channel_bill_details> lis=t_channel_bill_detailsServer.selectBycheckdate(Constants.CHECK_DATE);
		for(T_channel_bill_details i:lis){
			//判断交易类型为支付
			if(i.getBUSINESS_TYPE().equals(ChannelBillEnum.BUSINESS_TYPE_PAY.getValue())){
				//支付状态为支付成功
				t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_SUCCESS.getvalue(), 
						randparams.randomMoney(7), randparams.randomMoney(7), i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),i.getCHANNEL_DISCOUNT_AMOUNT().toString(),
						i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue()
						,randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
			}else{
				//退款-交易失败未对平
				t_pay_order_refundServer.insertData(i.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), i.getCHANNEL_CODE(), i.getOUT_REFUND_NO(), i.getCHANNEL_REFUND_NO(),
						dts.DtoString(i.getCHANNEL_EXPIRE_TIME()), i.getCHANNEL_ORDER_NO(), i.getOUT_ORDER_NO(), dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),Constants.CHECK_DATE , Constants.CHECK_DATE, i.getCHECK_STATUS(),
						String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME,i.getPAY_TYPE());
				//修改相应支付订单状态为“交易失败”
				t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_FAILURE.getvalue(),i.getOUT_ORDER_NO());
			}
		}
	}


	/**
	 * 全部各种不同状态数据
	 */
	@RequestMapping("suoyoubutongleixingshuju")
	private void suoyoubutongleixingshuju() throws Exception{
		List<T_channel_bill_details> lis=t_channel_bill_detailsServer.selectBycheckdate(Constants.CHECK_DATE);
		int a=0;
		int b=0;
		int c=0;
		int d=0;
		int e=0;

		int aa=0;
		int bb=0;

		List<T_channel_bill_details> listT=new ArrayList<T_channel_bill_details>();
		String tuikuandaizhifuweiduiping="";
		String tuikuanjiaoyishibaiweiduiping="";
		for(T_channel_bill_details i:lis){
			if(i.getBUSINESS_TYPE().equals(ChannelBillEnum.BUSINESS_TYPE_PAY.getValue())){
				aa+=1;
				a+=1;
				if(a==1){
					//支付对平
					t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_SUCCESS.getvalue(),
							randparams.randomMoney(7), randparams.randomMoney(7),i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),
							i.getCHANNEL_DISCOUNT_AMOUNT().toString(), i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),
							String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue(),randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
					logger.info("支付对平，订单号："+i.getOUT_ORDER_NO());
				}else if(a==2){
					//外部订单不匹配
					t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),randparams.randonStoInt(17), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_SUCCESS.getvalue(),
							randparams.randomMoney(7), randparams.randomMoney(7),i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),i.getCHANNEL_DISCOUNT_AMOUNT().toString(),
							i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue()
							,randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
					logger.info("【支付】外部订单不匹配，渠道流水号："+i.getCHANNEL_ORDER_NO());
				}else if(a==3){
					//渠道交易金额不匹配
					t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_SUCCESS.getvalue(),
							randparams.randomMoney(7), randparams.randomMoney(7), randparams.randomMoney(7),randparams.randomMoney(6),randparams.randomMoney(6),i.getCHANNEL_DISCOUNT_AMOUNT().toString(),
							i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue()
							,randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
					logger.info("【支付】渠道交易金额不匹配，渠道流水号："+i.getCHANNEL_ORDER_NO());
				}else if(a==4){
					//支付状态为待支付
					t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_WAIT.getvalue(),
							randparams.randomMoney(7), randparams.randomMoney(7),i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),i.getCHANNEL_DISCOUNT_AMOUNT().toString(),
							i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue()
							,randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
					logger.info("【支付】支付状态为“待支付”，渠道流水号："+i.getCHANNEL_ORDER_NO());
				}else if(a==5){
					//支付状态为交易失败
					t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_FAILURE.getvalue(),
							randparams.randomMoney(7), randparams.randomMoney(7),i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),i.getCHANNEL_DISCOUNT_AMOUNT().toString(),
							i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue()
							,randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
					logger.info("【支付】支付状态为“交易失败”，渠道流水号："+i.getCHANNEL_ORDER_NO());
				}else if(a==6){
					//渠道交易时间不匹配
					t_pay_orderServer.insertData(dts.currentDate(),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_SUCCESS.getvalue(),
							randparams.randomMoney(7), randparams.randomMoney(7),i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),i.getCHANNEL_DISCOUNT_AMOUNT().toString(),
							i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue()
							,randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
					logger.info("【支付】渠道交易时间不匹配，渠道流水号："+i.getCHANNEL_ORDER_NO());
				}else if(a==7){
					//支付差异短款/长款-渠道订单号不匹配
					t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), randparams.randonStoInt(28),PayOrder.PAY_SUCCESS.getvalue(),
							randparams.randomMoney(7), randparams.randomMoney(7),i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),
							i.getCHANNEL_DISCOUNT_AMOUNT().toString(), i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),
							PayOrder.CLEARING_NO.getvalue(),randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
					logger.info("【支付】渠道订单号不匹配，订单编号："+i.getOUT_ORDER_NO());
				}else if(a==8){
					//支付状态为支付成功,清算状态为“待清算”
					t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_SUCCESS.getvalue(),
							randparams.randomMoney(7), randparams.randomMoney(7), i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),i.getCHANNEL_DISCOUNT_AMOUNT().toString(),
							i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_NO.getvalue()
							,randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
				}else if(a==9){
					//支付状态为支付成功，清算状态为“清算中”
					t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_SUCCESS.getvalue(),
							randparams.randomMoney(7), randparams.randomMoney(7), i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),i.getCHANNEL_DISCOUNT_AMOUNT().toString(),
							i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_PENDING.getvalue()
							,randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
					logger.info("【支付】清算状态为“清算中”，渠道流水号："+i.getCHANNEL_ORDER_NO());
				}else if(a==10){
					//支付状态为支付成功,清算状态为“清算失败”
					t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_SUCCESS.getvalue(),
							randparams.randomMoney(7), randparams.randomMoney(7), i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),i.getCHANNEL_DISCOUNT_AMOUNT().toString(),
							i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_FAILURE.getvalue()
							,randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
					logger.info("【支付】清算状态为“清算失败”，渠道流水号为："+i.getCHANNEL_ORDER_NO());
				}else if(a==11){
					//支付状态为支付成功,清算状态为“清算成功”
					t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_SUCCESS.getvalue(),
							randparams.randomMoney(7), randparams.randomMoney(7), i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),i.getCHANNEL_DISCOUNT_AMOUNT().toString(),
							i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),String.valueOf(Constants.MERCHANT_ID),PayOrder.CLEARING_SUCCESS.getvalue()
							,randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
					logger.info("【支付】清算状态为“清算成功”，渠道流水号为："+i.getCHANNEL_ORDER_NO());
				}else{
					c+=1;
					if(merchant_idbool){
						//支付状态为支付成功
						t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_SUCCESS.getvalue(),
								randparams.randomMoney(7), randparams.randomMoney(7), i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),i.getCHANNEL_DISCOUNT_AMOUNT().toString(),
								i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID),String.valueOf(merchant_ids[0]),PayOrder.CLEARING_NO.getvalue()
								,randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME);
						merchant_idbool=false;
						a=0;
						continue;
					}else{
						//支付状态为支付成功
						t_pay_orderServer.insertData(dts.DtoString(i.getCHANNEL_EXPIRE_TIME()),i.getOUT_ORDER_NO(), i.getCHANNEL_ORDER_NO(),PayOrder.PAY_SUCCESS.getvalue(),
								randparams.randomMoney(7), randparams.randomMoney(7), i.getCHANNEL_TOTAL_AMOUNT().toString(),randparams.randomMoney(6),randparams.randomMoney(6),i.getCHANNEL_DISCOUNT_AMOUNT().toString(),
								i.getCHECK_STATUS(), Constants.CHECK_DATE, i.getCHANNEL_CODE(),i.getFEE().toString(),String.valueOf(Constants.ORG_ID_2),String.valueOf(merchant_ids[1]),PayOrder.CLEARING_NO.getvalue()
								,randparams.randomMoney(6),i.getPAY_TYPE(),String.valueOf(Constants.SHOP_ID_2),Constants.SHOP_NAME_2,Constants.MERCHANT_NAME_2);
						merchant_idbool=true;
						a=0;
						continue;
					}
				}

			}else{
				listT.add(i);				
			}
		}
		for(T_channel_bill_details j:listT) {
			if (t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO()) == null) {
				continue;
			} else {
				bb += 1;
				if (j.getCHANNEL_CODE().equals(ChannelEnum.WXPAY.getValue())) {
					b += 1;
					if (b == 1) {
						//退款对平
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("=========bb:" + bb + "===========b:" + b);
						continue;
					} else if (b == 2) {
						//渠道退款单号不匹配
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】渠道退款单号不匹配，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========b:" + b);
						continue;
					} else if (b == 3) {
						//渠道交易金额不匹配
						t_pay_order_refundServer.insertData(randparams.randomMoney(7), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】渠道交易金额不匹配，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========b:" + b);
						continue;
					} else if (b == 4) {
						//退款状态为退款中
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_PEND.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】退款状态为“退款中”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========b:" + b);
						continue;
					} else if (b == 5) {
						//退款状态为退款失败
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_FAILURE.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】退款状态为“退款失败”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========b:" + b);
						continue;
					} else if (b == 6) {
						//渠道交易时间不匹配
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.currentDate(), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(), String.valueOf(Constants.ORG_ID),
								String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】渠道交易时间不匹配，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========b:" + b);
						continue;
					} else if (b == 7) {
						//退款-待支付未对平
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						tuikuandaizhifuweiduiping = j.getOUT_ORDER_NO();
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(tuikuandaizhifuweiduiping);
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), tuikuandaizhifuweiduiping);
						logger.info("【退款】订单交易表状态为“待支付”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========b:" + b);
						continue;
					} else if (b == 8) {
						//退款-交易失败未对平
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						tuikuanjiaoyishibaiweiduiping = j.getOUT_ORDER_NO();
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(tuikuanjiaoyishibaiweiduiping);
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), tuikuanjiaoyishibaiweiduiping);
						logger.info("【退款】订单交易表状态为“交易失败”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========b:" + b);
						continue;
					} else if (b == 9) {
						//退款差异短款/长款-渠道订单号不匹配
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), randparams.randonStoInt(28), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】渠道订单号不匹配，外部订单号为：" + j.getOUT_ORDER_NO());
						logger.info("=========bb:" + bb + "===========b:" + b);
						continue;
					} else if (b == 10) {
						//退款对平,清算状态为“待清算”
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】清算状态为“待清算”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========b:" + b);
						continue;
					} else if (b == 11) {
						//退款对平,清算状态为“清算失败”
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_FAILURE.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】清算状态为“清算失败”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========b:" + b);
						continue;
					} else if (b == 12) {
						//退款对平,清算状态为“清算中”
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_PENDING.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】清算状态为“清算中”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========b:" + b);
						continue;
					} else {
						//退款对平,清算状态为“清算成功”
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_SUCCESS.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】清算状态为“清算成功”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========b:" + b);
						b = 0;
						continue;
					}

				} else {
					e += 1;
					if (e == 1) {
						//退款对平
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("=========bb:" + bb + "===========e:" + e);
						continue;
					} else if (e == 2) {
						//渠道退款单号不匹配
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】渠道退款单号不匹配，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========e:" + e);
						continue;
					} else if (e == 3) {
						//渠道交易金额不匹配
						t_pay_order_refundServer.insertData(randparams.randomMoney(7), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】渠道交易金额不匹配，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========e:" + e);
						continue;
					} else if (e == 4) {
						//退款状态为退款中
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_PEND.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】退款状态为“退款中”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========e:" + e);
						continue;
					} else if (e == 5) {
						//退款状态为退款失败
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_FAILURE.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】退款状态为“退款失败”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========e:" + e);
						continue;
					} else if (e == 6) {
						//渠道交易时间不匹配
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.currentDate(), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(), String.valueOf(Constants.ORG_ID),
								String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】渠道交易时间不匹配，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========e:" + e);
						continue;
					} else if (e == 7) {
						//退款-待支付未对平
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						tuikuandaizhifuweiduiping = j.getOUT_ORDER_NO();
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(tuikuandaizhifuweiduiping);
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), tuikuandaizhifuweiduiping);
						logger.info("【退款】订单交易表状态为“待支付”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========e:" + e);
						continue;
					} else if (e == 8) {
						//退款-交易失败未对平
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						tuikuanjiaoyishibaiweiduiping = j.getOUT_ORDER_NO();
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(tuikuanjiaoyishibaiweiduiping);
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), tuikuanjiaoyishibaiweiduiping);
						logger.info("【退款】订单交易表状态为“交易失败”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========e:" + e);
						continue;
					} else if (e == 9) {
						//退款差异短款/长款-渠道订单号不匹配
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), randparams.randonStoInt(28), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】渠道订单号不匹配，外部订单号为：" + j.getOUT_ORDER_NO());
						logger.info("=========bb:" + bb + "===========e:" + e);
						continue;
					} else if (e == 10) {
						//退款对平,清算状态为“待清算”
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】清算状态为“待清算”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========e:" + e);
						continue;
					} else if (e == 11) {
						//退款对平,清算状态为“清算失败”
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_FAILURE.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】清算状态为“清算失败”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========e:" + e);
						continue;
					} else if (e == 12) {
						//退款对平,清算状态为“清算中”
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_PENDING.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】清算状态为“清算中”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========e:" + e);
						continue;
					} else if (e == 13) {
						//退款对平,清算状态为“清算成功”
						t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
								dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
								String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_SUCCESS.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
						t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
						t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
						t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
								t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
						logger.info("【退款】清算状态为“清算成功”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
						logger.info("=========bb:" + bb + "===========e:" + e);
						continue;
					} else {
						d += 1;
						if (merchant_idbool2) {
							//退款对平
							t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
									dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
									String.valueOf(Constants.ORG_ID), String.valueOf(merchant_ids[0]), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
							t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
							t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
							t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
									t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
							merchant_idbool2 = false;
							logger.info("=========bb:" + bb + "===========d:" + d);
							e = 0;
							continue;
						} else {
							t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
									dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
									String.valueOf(Constants.ORG_ID), String.valueOf(merchant_ids[1]), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME, j.getPAY_TYPE());
							t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
							t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
							t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
									t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
							merchant_idbool2 = true;
							logger.info("=========bb:" + bb + "===========d:" + d);
							e = 0;
							continue;
						}
					}

				}
			/*
			if(b<=11 && b!=2){
				if (j.getCHANNEL_CODE().equals(ChannelEnum.WXPAY.getValue())) {
					//退款对平
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(),j.getOUT_ORDER_NO());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					continue;
				}else{
					//退款对平
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(),j.getOUT_ORDER_NO());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					continue;
				}
			}else if(b==2||b==12){
				if (j.getCHANNEL_CODE().equals(ChannelEnum.WXPAY.getValue())) {
					//渠道退款单号不匹配
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(),j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】渠道退款单号不匹配，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}else{
					//渠道退款单号不匹配
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(),j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】渠道退款单号不匹配，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}
			}else if(b==13){
				if (j.getCHANNEL_CODE().equals(ChannelEnum.WXPAY.getValue())) {
					//渠道交易金额不匹配
					t_pay_order_refundServer.insertData(randparams.randomMoney(7), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(),j.getOUT_ORDER_NO());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】渠道交易金额不匹配，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}else{
					//渠道交易金额不匹配
					t_pay_order_refundServer.insertData(randparams.randomMoney(7), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(),j.getOUT_ORDER_NO());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】渠道交易金额不匹配，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}
			}else if(b==14){
				if (j.getCHANNEL_CODE().equals(ChannelEnum.WXPAY.getValue())) {
					//退款状态为退款中
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_PEND.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】退款状态为“退款中”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}else{
					//退款状态为退款中
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_PEND.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】退款状态为“退款中”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}
			}else if(b==15){
				if (j.getCHANNEL_CODE().equals(ChannelEnum.WXPAY.getValue())) {
					//退款状态为退款失败
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_FAILURE.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】退款状态为“退款失败”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}else{
					//退款状态为退款失败
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_FAILURE.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】退款状态为“退款失败”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}
			}else if(b==16){
				if (j.getCHANNEL_CODE().equals(ChannelEnum.WXPAY.getValue())) {
					//渠道交易时间不匹配
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.currentDate(), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(), String.valueOf(Constants.ORG_ID),
							String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(),j.getOUT_ORDER_NO());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】渠道交易时间不匹配，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}else{
					//渠道交易时间不匹配
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.currentDate(), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(), String.valueOf(Constants.ORG_ID),
							String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(),j.getOUT_ORDER_NO());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】渠道交易时间不匹配，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}
			}else if(b==17){
				if (j.getCHANNEL_CODE().equals(ChannelEnum.WXPAY.getValue())) {
					//退款-待支付未对平
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					tuikuandaizhifuweiduiping = j.getOUT_ORDER_NO();
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(tuikuandaizhifuweiduiping);
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), tuikuandaizhifuweiduiping);
					logger.info("【退款】订单交易表状态为“待支付”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}else{
					//退款-待支付未对平
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					tuikuandaizhifuweiduiping = j.getOUT_ORDER_NO();
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(tuikuandaizhifuweiduiping);
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), tuikuandaizhifuweiduiping);
					logger.info("【退款】订单交易表状态为“待支付”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}
			}else if(b==18){
				if (j.getCHANNEL_CODE().equals(ChannelEnum.WXPAY.getValue())) {
					//退款-交易失败未对平
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					tuikuanjiaoyishibaiweiduiping = j.getOUT_ORDER_NO();
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(tuikuanjiaoyishibaiweiduiping);
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), tuikuanjiaoyishibaiweiduiping);
					logger.info("【退款】订单交易表状态为“交易失败”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}else{
					//退款-交易失败未对平
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					tuikuanjiaoyishibaiweiduiping = j.getOUT_ORDER_NO();
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(tuikuanjiaoyishibaiweiduiping);
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), tuikuanjiaoyishibaiweiduiping);
					logger.info("【退款】订单交易表状态为“交易失败”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}
			}else if(b==19){
				if (j.getCHANNEL_CODE().equals(ChannelEnum.WXPAY.getValue())) {
					//退款差异短款/长款-渠道订单号不匹配
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), randparams.randonStoInt(28), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(),j.getOUT_ORDER_NO());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】渠道订单号不匹配，外部订单号为：" + j.getOUT_ORDER_NO());
					continue;
				}else{
					//退款差异短款/长款-渠道订单号不匹配
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), randparams.randonStoInt(28), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(),j.getOUT_ORDER_NO());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】渠道订单号不匹配，外部订单号为：" + j.getOUT_ORDER_NO());
					continue;
				}
			}else if(b==20){
				if (j.getCHANNEL_CODE().equals(ChannelEnum.WXPAY.getValue())) {
					//退款对平,清算状态为“待清算”
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】清算状态为“待清算”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}else{
					//退款对平,清算状态为“待清算”
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_NO.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】清算状态为“待清算”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}
			}else if(b==21){
				if (j.getCHANNEL_CODE().equals(ChannelEnum.WXPAY.getValue())) {
					//退款对平,清算状态为“清算失败”
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_FAILURE.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】清算状态为“清算失败”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}else{
					//退款对平,清算状态为“清算失败”
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_FAILURE.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】清算状态为“清算失败”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}
			}else if(b==22){
				if (j.getCHANNEL_CODE().equals(ChannelEnum.WXPAY.getValue())) {
					//退款对平,清算状态为“清算中”
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_PENDING.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】清算状态为“清算中”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}else{
					//退款对平,清算状态为“清算中”
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_PENDING.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】清算状态为“清算中”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}
			}else if(b==23){
				if (j.getCHANNEL_CODE().equals(ChannelEnum.WXPAY.getValue())) {
					//退款对平,清算状态为“清算成功”
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_SUCCESS.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】清算状态为“清算成功”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}else{
					//退款对平,清算状态为“清算成功”
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), randparams.randonStoInt(17), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), Constants.CHECK_DATE, Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID), String.valueOf(Constants.MERCHANT_ID), PayOrder.CLEARING_SUCCESS.getvalue(), String.valueOf(Constants.SHOP_ID), Constants.SHOP_NAME, Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(), j.getOUT_ORDER_NO());
					t_pay_order = t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(),
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(), j.getOUT_ORDER_NO());
					logger.info("【退款】清算状态为“清算成功”，原渠道流水号为：" + j.getCHANNEL_ORDER_NO());
					continue;
				}

			}else {
				d+=1;
				if(merchant_idbool2){
					//退款对平
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()),Constants.CHECK_DATE , Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID),String.valueOf(merchant_ids[0]),PayOrder.CLEARING_NO.getvalue(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(),j.getOUT_ORDER_NO());
					t_pay_order=t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(), 
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(),j.getOUT_ORDER_NO());
					merchant_idbool2=false;
					b=0;
					continue;
				}else{
					t_pay_order_refundServer.insertData(j.getCHANNEL_TOTAL_AMOUNT().toString(), RefundOrder.REFUND_SUCCESS.getValue(), j.getCHANNEL_CODE(), j.getOUT_REFUND_NO(), j.getCHANNEL_REFUND_NO(),
							dts.DtoString(j.getCHANNEL_EXPIRE_TIME()), j.getCHANNEL_ORDER_NO(), j.getOUT_ORDER_NO(), dts.DtoString(j.getCHANNEL_EXPIRE_TIME()),Constants.CHECK_DATE , Constants.CHECK_DATE, j.getCHECK_STATUS(),
							String.valueOf(Constants.ORG_ID),String.valueOf(merchant_ids[1]),PayOrder.CLEARING_NO.getvalue(),String.valueOf(Constants.SHOP_ID),Constants.SHOP_NAME,Constants.MERCHANT_NAME,j.getPAY_TYPE());
					t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_REFUND.getvalue(),j.getOUT_ORDER_NO());
					t_pay_order=t_pay_orderServer.selectjineBycheckdateandorderno(j.getOUT_ORDER_NO());
					t_pay_order_refundServer.updatejineByorderno(t_pay_order.getPLATFORM_AMOUNT(), t_pay_order.getMERCHANT_AMOUNT(), 
							t_pay_order.getCHANNEL_AMOUNT(), t_pay_order.getDISCOUNT(),j.getOUT_ORDER_NO());
					merchant_idbool2=true;
					b=0;
					continue;
				}
			}*/
			}
		}
		t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_WAIT.getvalue(),tuikuandaizhifuweiduiping);
		t_pay_orderServer.updatestatusByorderno(PayOrder.PAY_FAILURE.getvalue(),tuikuanjiaoyishibaiweiduiping);
		logger.info("支付对平总笔数："+c);
		logger.info("退款对平总笔数："+d);
		logger.info("对平总笔数："+(c+d));
		logger.info("支付总笔数："+aa);
		logger.info("退款总笔数："+bb);
		logger.info("总笔数："+(aa+bb));

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
		channel_code.put(ChannelEnum.UNIONPAY.getValue(),ChannelEnum.UNIONPAY.getText());
		return channel_code;
	}

	private Map<String,String> getPay_type(){
		Map<String,String> pay_type=new HashMap<String,String>();
		pay_type.put(ChannelBillEnum.PAY_TYPE_PAYING.getValue(), ChannelBillEnum.PAY_TYPE_PAYING.getText());
		pay_type.put(ChannelBillEnum.PAY_TYPE_PAYED.getValue(), ChannelBillEnum.PAY_TYPE_PAYED.getText());
		pay_type.put(ChannelBillEnum.PAY_TYPE_POSPAYED.getValue(), ChannelBillEnum.PAY_TYPE_POSPAYED.getText());
		pay_type.put(ChannelBillEnum.PAY_TYPE_POSPAYING.getValue(), ChannelBillEnum.PAY_TYPE_POSPAYING.getText());
		pay_type.put(ChannelBillEnum.PAY_TYPE_POSSPEND.getValue(), ChannelBillEnum.PAY_TYPE_POSSPEND.getText());
		return pay_type;
	}

	private Map<String,String> getClearing_status(){
		Map<String,String> clearing_status=new HashMap<String,String>();
		clearing_status.put(PayOrder.CLEARING_SUCCESS.getvalue(), PayOrder.CLEARING_SUCCESS.gettext());
		clearing_status.put(PayOrder.CLEARING_FAILURE.getvalue(), PayOrder.CLEARING_FAILURE.gettext());
		clearing_status.put(PayOrder.CLEARING_NO.getvalue(), PayOrder.CLEARING_NO.gettext());
		clearing_status.put(PayOrder.CLEARING_PENDING.getvalue(), PayOrder.CLEARING_PENDING.gettext());
		return clearing_status;

	}
}
