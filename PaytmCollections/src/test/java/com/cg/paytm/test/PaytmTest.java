package com.cg.paytm.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.paytm.beans.Customer;
import com.cg.paytm.beans.Wallet;
import com.cg.paytm.exception.InsufficientBalanceException;
import com.cg.paytm.exception.InvalidInputException;
import com.cg.paytm.service.IWalletService;
import com.cg.paytm.service.WalletServiceImpl;

import junit.framework.Assert;
import junit.framework.TestCase;

public class PaytmTest extends TestCase {
	
	IWalletService service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

	@Before
	
		public void initData(){
		
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateAccount() throws InvalidInputException {
		IWalletService walletService = new WalletServiceImpl();
		Customer customer = new Customer();
		Wallet wallet = new Wallet();
		String name = "priya";
		String number = "9848935458";
		BigDecimal amount = new BigDecimal(5000);
		
		customer.setName(name);
		System.out.println(customer.getName());
		customer.setMobileNo(number);
		System.out.println(customer.getMobileNo());
		wallet.setBalance(amount);
		
		
		customer.setWallet(wallet);
		System.out.println(customer.getWallet());
		
		customer = walletService.createAccount(name, number, amount);
		System.out.println(customer);
		
		assertNotSame(null, customer);
	}
	
	

@Test()
	public void testshowBalance() throws InvalidInputException {
	IWalletService walletService = new WalletServiceImpl();
	Customer customer = new Customer();
	Wallet wallet = new Wallet();
	String name = "priya";
	String number = "9848935458";
	BigDecimal amount = new BigDecimal(5000);
	
	customer.setName(name);
	System.out.println(customer.getName());
	customer.setMobileNo(number);
	System.out.println(customer.getMobileNo());
	wallet.setBalance(amount);
	customer.setWallet(wallet);
	customer = walletService.createAccount(name, number, amount);
	
		
		
		Customer cust = walletService.showBalance(number);
		
		assertNotSame(null,cust);
	}
	
	@Test()
	public void testWithdrawAmount() throws InvalidInputException, InsufficientBalanceException {
		IWalletService walletService = new WalletServiceImpl();
		String name = "priya";
		String mobileNumber = "8790116363";
		BigDecimal balance = new BigDecimal("2000");
		System.out.println("entered");
		walletService.createAccount(name, mobileNumber, balance);
		System.out.println(walletService.createAccount(name, mobileNumber, balance));
		
		
		BigDecimal amount = new BigDecimal("1000");
		
		BigDecimal diff = new BigDecimal("1000");
		System.out.println(walletService.withdrawAmount(mobileNumber, amount));
	    assertTrue(amount.compareTo(diff)==0);
	}
	
	@Test
	public void testDepositAmount() throws InvalidInputException {
		boolean output = false;
		IWalletService walletService = new WalletServiceImpl();
		String name = "priya";
		String mobileNumber = "9848935458";
		BigDecimal balance = new BigDecimal("3000");
		
		Customer customer = walletService.createAccount(name, mobileNumber, balance);
		System.out.println(customer.getWallet().getBalance());
		Customer customer1 = walletService.depositAmount(mobileNumber, new BigDecimal("3000"));
		System.out.println(customer1.getWallet().getBalance());
		BigDecimal compare = customer1.getWallet().getBalance();
		BigDecimal compareOne = new BigDecimal("6000");
		int res = compare.compareTo(compareOne);
		if(res == 0) {
			output = true;
		}
		assertTrue(output);
			
		
		
	}
	
	@Test(expected = InvalidInputException.class)
	public void testMobileNumber(String mobileNumber) throws InvalidInputException, InsufficientBalanceException {
		mobileNumber = "1234567890";
		WalletServiceImpl walletService = new WalletServiceImpl();
		walletService.isValid(mobileNumber);
	}
	
	


}
