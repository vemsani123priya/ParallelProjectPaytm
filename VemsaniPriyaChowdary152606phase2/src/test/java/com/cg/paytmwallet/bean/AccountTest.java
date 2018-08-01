package com.cg.paytmwallet.bean;

import static org.junit.Assert.*;

import com.cg.paymentwallet.bean.Account;

import junit.framework.TestCase;

public class AccountTest extends TestCase {

	Account account = new Account();

	public void testGetBalance() {
			
			assertSame(1000, account.getBalance());
			
			assertNotSame("abc", account.getBalance());
			
		}

		
		public void testGetAccountNumber() {
			
			assertNotSame(1, account.getAccountNumber());
			
			assertNull(account.getAccountNumber());
			
		}

}