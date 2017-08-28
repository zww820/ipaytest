package org.ipay.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.ipay.enums.ChannelBillEnum;
import org.ipay.enums.PayOrder;
import org.ipay.enums.RefundOrder;
import org.ipay.model.T_channel_bill_details;
import org.ipay.model.T_pay_order_refund;
import org.ipay.server.T_channel_bill_detailsServer;
import org.ipay.server.T_pay_orderServer;
import org.ipay.server.T_pay_order_refundServer;
import org.ipay.utils.Constants;
import org.ipay.utils.Randparams;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Audience
 * @since 2017年8月17日 上午10:41:40
 */
// @Controller
public class T_channel_bill_detailsController2 {

	@Resource
	T_channel_bill_detailsServer t_channel_bill_detailsServer;
	@Resource
	T_pay_orderServer t_pay_orderServer;
	@Resource
	T_pay_order_refundServer t_pay_order_refundServer;

	T_channel_bill_details t_channel_bill_details = new T_channel_bill_details();

	@RequestMapping("T_channel_bill_details")
	public String init(Model model) {
		model.addAttribute("t_channel_bill_details", t_channel_bill_details);
		return "T_channel_bill_details";
	}

	@SuppressWarnings("finally")
	@RequestMapping("insertT_channel_bill_details")
	public String Transaction(@RequestParam("CHECK_DATE") String check_date,
			@RequestParam("CHANNEL_CODE") String channel_code, @RequestParam("BUSINESS_TYPE") String business_type,
			@RequestParam("CHECK_STATUS") String check_status, @RequestParam("date") String date, Model model) {
		try {
			if (channel_code.equals("")) {
				for (String b : Constants.channel_code_list()) {
					if (business_type.equals("")) {
						for (String c : Constants.business_type_list()) {
							if (check_status.equals("")) {
								for (String a : Constants.check_status_list_c()) {
									t_channel_bill_detailsServer.insertData(check_date, b, c, a, date);
								}
							} else {
								t_channel_bill_detailsServer.insertData(check_date, b, c, check_status, date);
							}
						}
					} else {
						t_channel_bill_detailsServer.insertData(check_date, b, business_type, check_status, date);
					}
				}
			} else {
				t_channel_bill_detailsServer.insertData(check_date, channel_code, business_type, check_status, date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			model.addAttribute("t_channel_bill_details", t_channel_bill_details);
			Constants.CHECK_DATE = check_date;
			Constants.DATE = date;
			return "T_channel_bill_details";
		}
	}

	@SuppressWarnings("unused")
	private void CYCK_dingdan() {
		List<T_channel_bill_details> lis = new ArrayList<T_channel_bill_details>();
		lis = t_channel_bill_detailsServer.selectBycheckdate(Constants.CHECK_DATE);
		for (T_channel_bill_details i : lis) {
			// 判断交易类型为支付
			if (i.getBUSINESS_TYPE().equals(ChannelBillEnum.BUSINESS_TYPE_PAY.getValue())) {
				// 微信&支付宝支付类型对平
				t_pay_orderServer.insertData(i.getCHANNEL_EXPIRE_TIME().toString(), i.getOUT_ORDER_NO(),
						i.getCHANNEL_ORDER_NO(), PayOrder.PAY_SUCCESS.getvalue(), Randparams.randomMoney(7),
						Randparams.randomMoney(7), i.getCHANNEL_TOTAL_AMOUNT().toString(), i.getCHECK_STATUS(),
						Constants.CHECK_DATE, i.getCHANNEL_CODE());
			} else {
				t_pay_order_refundServer.insertData(i.getCHANNEL_DISCOUNT_AMOUNT().toString(),
						RefundOrder.REFUND_SUCCESS.getValue(), i.getCHANNEL_CODE(), i.getOUT_REFUND_NO(),
						i.getCHANNEL_REFUND_NO(), order_pay_time, i.getCHANNEL_ORDER_NO(), order_no, date,
						i.getCHANNEL_EXPIRE_TIME().toString(), Constants.CHECK_DATE, i.getCHECK_STATUS());
			}
		}
	}
}
