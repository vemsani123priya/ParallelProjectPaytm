package com.cg.paytm.repo;

import com.cg.paytm.beans.Customer;

public interface IWalletRepo {
	public boolean save(Customer customer);

	public Customer findOne(String mobileNo);

	public void remove(String mobileNo);

}
