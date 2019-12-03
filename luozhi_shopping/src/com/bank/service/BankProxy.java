package com.bank.service;

public class BankProxy implements com.bank.service.Bank {
  private String _endpoint = null;
  private com.bank.service.Bank bank = null;
  
  public BankProxy() {
    _initBankProxy();
  }
  
  public BankProxy(String endpoint) {
    _endpoint = endpoint;
    _initBankProxy();
  }
  
  private void _initBankProxy() {
    try {
      bank = (new com.bank.service.BankServiceLocator()).getBank();
      if (bank != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bank)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bank)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bank != null)
      ((javax.xml.rpc.Stub)bank)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.bank.service.Bank getBank() {
    if (bank == null)
      _initBankProxy();
    return bank;
  }
  
  public com.bank.dto.ReturnMsg verifyBankAccount(java.lang.String cid) throws java.rmi.RemoteException{
    if (bank == null)
      _initBankProxy();
    return bank.verifyBankAccount(cid);
  }
  
  public com.bank.dto.ReturnMsg transferAccounts(java.lang.String zcid, java.lang.String zcpwd, java.lang.String mcid, double money) throws java.rmi.RemoteException{
    if (bank == null)
      _initBankProxy();
    return bank.transferAccounts(zcid, zcpwd, mcid, money);
  }
  
  
}