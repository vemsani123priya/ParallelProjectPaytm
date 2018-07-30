package com.capgemini.paytm.repo;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.capgemini.paytm.beans.Customer;

public interface WalletRepo {

	public boolean save(Customer customer);	
	public Customer findOne(String mobileNo) throws SQLException;
	public void saveTransaction(String sourceMobileNo, String string) throws SQLException;
	public List getTransaction(String mobileNo) throws SQLException;
	public void updateAmount(Customer customer,BigDecimal amtSub);
}
