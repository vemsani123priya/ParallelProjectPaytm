package com.cg.paymentwallet.dao;

import java.sql.SQLException;

import com.cg.paymentwallet.bean.Account;

public interface IPaymentWalletDao {
	public boolean loginAccount(String userName,String password) throws ClassNotFoundException, SQLException;
    public boolean addCustomerDetails(Account account) throws ClassNotFoundException, SQLException;
	public float showBalance() throws ClassNotFoundException, SQLException;
	public boolean depositAmount(float amount) throws ClassNotFoundException, SQLException;
	public boolean withdrawAmount(float amount) throws ClassNotFoundException, SQLException;
	public boolean fundTransfer(String accountNumber2, float amount) throws ClassNotFoundException, SQLException;
	public void printTransaction() throws ClassNotFoundException, SQLException;

	

}
