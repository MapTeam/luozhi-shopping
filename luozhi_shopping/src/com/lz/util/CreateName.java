package com.lz.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateName {
	/**
	 * 根据uid和时间戳生成一个string
	 * @param uid
	 * @return
	 */
	public static String createGoodsOrderName(int uid){
		Date date = new Date();
		long times = date.getTime();
		String dateStr = times+""+uid;
		return dateStr;
	}
	
	/**
	 * 根据uid和时间生成一个string
	 * @param uid
	 * @return
	 */
	public static String createOutGoodsId(int uid){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmss");
		String dateStr = sdf.format(date);
		return dateStr+uid;
	}
	
}
