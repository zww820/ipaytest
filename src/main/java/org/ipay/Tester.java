package org.ipay;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.ipay.dao.T_channel_bill_detailsMapper;
import org.ipay.enums.ChannelBillEnum;
import org.ipay.enums.PayOrder;
import org.ipay.server.T_channel_bill_detailsServer;
import org.ipay.utils.Randparams;
import org.testng.annotations.Test;
import org.ipay.model.T_channel_bill_details;


public class Tester extends BaseCode{
	
	@Resource
	private T_channel_bill_detailsServer t_channel_bill_detailsServer;
	@Resource
	private T_channel_bill_detailsMapper t_channel_bill_detailsMapper;
	@Resource
	private Randparams randparams;

	@Test
	public void AAA(){
		System.out.println(t_channel_bill_detailsServer.selectByid(new BigDecimal(93)));
		System.out.println(ChannelBillEnum.BUSINESS_TYPE.getText());
		System.out.println(PayOrder.PAY_FAILURE.gettext());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = null;
		try {
			date = sdf.parse("2017-08-15 16:59:18");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<T_channel_bill_details> lis=new ArrayList<T_channel_bill_details>();
		lis=t_channel_bill_detailsMapper.selectBycheckdate("20170713");
		Iterator It=lis.iterator();
		while(It.hasNext()){
			System.out.println(((T_channel_bill_details) It.next()).getCHECK_DATE());
		}
//		System.out.println(t_channel_bill_detailsMapper.selectByPrimaryKey(new BigDecimal(93)));
		System.out.println(randparams.randomMoney(6));
	}

}
