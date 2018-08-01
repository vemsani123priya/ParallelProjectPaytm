package com.cg.mypaymentapp.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.service.WalletService;
import com.cg.mypaymentapp.service.WalletServiceImpl;


public class TestClass {

	
	WalletService service;
	
	@Before
	public void initData(){
		 Map<String,Customer> data= new HashMap<String, Customer>();
		 Customer cust1=new Customer("priya", "9848935458",new Wallet(new BigDecimal(8000)));
		 Customer cust2=new Customer("kavitha", "9603116338",new Wallet(new BigDecimal(6000)));
		 Customer cust3=new Customer("ravi kumar", "7661891138",new Wallet(new BigDecimal(7000)));
				
		 data.put("9848935458", cust1);
		 data.put("9603116338", cust2);	
		 data.put("7661891138", cust3);	
			service= new WalletServiceImpl(data);
			
	}

	@Test(expected=InvalidInputException.class)
	public void testCreateAccount1() throws InvalidInputException {
		
		service.createAccount(null, null, null);				
	}

	@Test(expected=InvalidInputException.class)
	public void testCreateAccount2() throws InvalidInputException 
	{
		
	service.createAccount(null, "", null);
	}
	@Test(expected=InvalidInputException.class)
	public void testCreateAccount3() throws InvalidInputException 
	{
		
	service.createAccount("","",null);
	}
	@Test(expected=NullPointerException.class)
	public void testCreateAccount4() throws InvalidInputException 
	{		
	service.createAccount("","",new BigDecimal(0));
	}
	
	@Test(expected=InvalidInputException.class)
	public void testCreateAccount5() throws InvalidInputException 
	{		
	service.createAccount(null,"7661891138",new BigDecimal(9000));
	}
	
	@Test(expected=InvalidInputException.class)
	public void testCreateAccount6() throws InvalidInputException 
	{		
	service.createAccount(null,"",new BigDecimal(0));
	}
	
	@Test
	public void testMobileNumber() {
		boolean output = false;
		if(service.isValidmobile("9848")==0) {
			output=true;
		}
		
		assertTrue(output);
		
	}
	@Test
	public void testName() {
		boolean output = false;
		if(service.isvalid("7654")==0) {
			output=true;
		}
		assertTrue(output);
	}
	
	
	
	
	
	


	
}
