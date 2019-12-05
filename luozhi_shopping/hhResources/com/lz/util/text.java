package com.lz.util;

public class text {
	public static void main(String[] args) {
		String a="你是猪";
		
		char[] aa=a.toCharArray();
//		for (int i = 0; i < a.length(); i++) {
//			aa[i]=a.substring(i, i+1);
//		}
		for (int i = 0; i < aa.length; i++) {
			System.out.println(aa[i]);
		}
	}

}
