package com.lz.test01;



import java.rmi.RemoteException;

import com.bank.service.Bank;
import com.bank.service.BankProxy;
import com.lz.util.CreateCode;
import com.lz.util.MailSender;

public class Test {

	public static void main(String[] args) throws RemoteException {
//		Bank bank = new BankProxy();
////		System.out.println(bank.verifyBankAccount("1234565555").getMsg());
//		System.out.println(bank.transferAccounts("123456", "123", "6217002990107872941", 710).getMsg());
		
			MailSender.send("1500908247@qq.com", "LuoZhi-Shopping", CreateCode.CreateVerifyCode());
	}

}
