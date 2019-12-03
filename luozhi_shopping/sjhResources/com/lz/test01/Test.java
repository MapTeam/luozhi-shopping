package com.lz.test01;



import java.rmi.RemoteException;

import com.bank.service.Bank;
import com.bank.service.BankProxy;

public class Test {

	public static void main(String[] args) throws RemoteException {
		Bank bank = new BankProxy();
		System.out.println(bank.verifyBankAccount("1234565555").getMsg());
		
	}

}
