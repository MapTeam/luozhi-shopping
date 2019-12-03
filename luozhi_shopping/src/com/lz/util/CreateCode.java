package com.lz.util;

import java.util.Random;

public class CreateCode {
	//生成一个验证码
	public static String CreateVerifyCode(){
		String code = "";
		Random r = new Random();
		for(int i = 0;i<4;i++){
			code+=r.nextInt(9);
		}
		return code;
	}
	
}
