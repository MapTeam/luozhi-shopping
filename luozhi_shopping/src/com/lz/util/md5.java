package com.lz.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class md5 {
	
	public static String md5(String pwd){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(pwd.getBytes());
			byte[] result  = md.digest();
			StringBuilder sb = new StringBuilder();
			for (byte b : result) {
				sb.append(Integer.toHexString(b));
			}
			pwd = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return pwd;
	}
	
}
