package com.cg.paytm.repo;

import java.util.HashMap;
import java.util.Map;

import com.cg.paytm.beans.Customer;

public class WalletRepoImpl implements IWalletRepo{
private Map<String, Customer> data; 
	
	public WalletRepoImpl() 
	{
		data = new HashMap<String, Customer>();
	}
	

	public boolean save(Customer customer) {
		
		if(data.get(customer.getMobileNo()) == null) {
			data.put(customer.getMobileNo(), customer);
			return true;
		}
		return false;
		
	}

	public Customer findOne(String mobileNo) {
		// TODO Auto-generated method stub
		if(data.get(mobileNo) != null) {
			return data.get(mobileNo);
		}
		return null;
	}

	public void remove(String mobileNo) {
		// TODO Auto-generated method stub
		data.remove(mobileNo);
		
	}

}
