package com.lz.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import com.lz.db.DBConnection1;

public class Md5 {
	private static final Logger log = Logger.getLogger(Md5.class);
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
			log.error(e);
		}
		return pwd;
	}
//	public static void main(String[] args) {
//		System.out.println(Md5.md5("123456"));
//	}
	
}
