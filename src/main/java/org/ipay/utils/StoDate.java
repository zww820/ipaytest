package org.ipay.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Audience
 * @since 2017年8月15日 下午10:19:06
 */
public class StoDate {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public java.sql.Date StoDate(String date) throws ParseException{
		java.util.Date d = null;
		d=sdf.parse(date);
		java.sql.Date sqldate=new java.sql.Date(d.getTime());
		return sqldate;
	}
	
	public String DtoString(Date date){
		return sdf.format(date);
	}
	
	public String currentDate(){
		String str = sdf.format(new Date());
		return str;
	}
	
}
