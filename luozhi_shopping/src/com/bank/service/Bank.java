/**
 * Bank.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bank.service;

public interface Bank extends java.rmi.Remote {
    public com.bank.dto.ReturnMsg verifyBankAccount(java.lang.String cid) throws java.rmi.RemoteException;
    public com.bank.dto.ReturnMsg transferAccounts(java.lang.String zcid, java.lang.String zcpwd, java.lang.String mcid, double money) throws java.rmi.RemoteException;
}
