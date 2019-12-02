package com.lz.util;

import java.util.Date;

public class SetGonameUtil {
	public static String GetNewgoname() {
		String newgoname=null;
		Date date=new Date();
		newgoname="L"+date.getYear()+date.getMonth()+date.getDay()+date.getHours()+date.getMinutes()+date.getSeconds();
		return newgoname;
	}

}
