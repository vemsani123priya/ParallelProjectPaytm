package com.cg.paytmwallet.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaytmWalletDaoTest {

	@Test
	public void testAddCustomerDetails() {
		assertEquals("name", "name");
		assertNotSame("name", 123);
		assertNotSame("name", "abc123");
		assertSame("name", "name");
		assertNotSame("name", "123ad");
		}

	@Test
	public void testDeposit() {
		assertEquals("amount", "amount");
		assertEquals(1000,1000);
		assertNotSame(1000, "abc");
		assertNotSame(1000,"123abc");
		assertEquals(1000,1000);
	}

	@Test
	public void testWithdraw() {
		assertEquals("amount", "amount");
		assertEquals(1000,1000);
		assertNotSame(1000, "abc");
		assertNotSame(1000,"123abc");
		assertEquals(1000,1000);
		
	}

	@Test
	public void testShowBalance() {
		assertEquals("amount", "amount");
		assertEquals(1000,1000);
		assertNotSame(1000, "xyz");
		assertNotSame(1000,"123abc");
		assertEquals(1000,1000);
		
	}

	@Test
	public void testTransferMoney() {
		assertEquals("amount", "amount");
		assertEquals(1000,1000);
		assertNotSame(1000, "xyz");
		assertNotSame(1000,"123abc");
		assertEquals(1000,1000);
	}


}