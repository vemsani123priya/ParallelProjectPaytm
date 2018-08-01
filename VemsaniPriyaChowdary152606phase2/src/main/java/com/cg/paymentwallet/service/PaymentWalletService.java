package com.cg.paymentwallet.service;

import java.sql.SQLException;

import com.cg.paymentwallet.bean.Account;
import com.cg.paymentwallet.dao.PaymentWalletDao;

public class PaymentWalletService implements IPaymentWalletService {
	PaymentWalletDao dao = new PaymentWalletDao();

	public boolean loginAccount(String userName, String password) throws ClassNotFoundException, SQLException {
		return dao.loginAccount(userName, password);
	}

	public boolean addCustomerDetails(Account account) throws ClassNotFoundException, SQLException {
		return dao.addCustomerDetails(account);
	}

	public float showBalance() throws ClassNotFoundException, SQLException {
		return dao.showBalance();
	}

	public boolean depositAmount(float amount) throws ClassNotFoundException, SQLException {
		return dao.depositAmount(amount);
	}

	public boolean withdrawAmount(float amount) throws ClassNotFoundException, SQLException {
		return dao.withdrawAmount(amount);
	}

	public boolean fundTransfer(String accountNumber2, float amount) throws ClassNotFoundException, SQLException {
		return dao.fundTransfer(accountNumber2,amount);
	}

	public void printTransaction() throws ClassNotFoundException, SQLException {
		dao.printTransaction();
		
	}

}
