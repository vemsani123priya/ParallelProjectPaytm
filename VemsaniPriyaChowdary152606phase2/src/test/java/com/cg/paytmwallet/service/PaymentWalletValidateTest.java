package com.cg.paytmwallet.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaymentWalletValidateTest {

	@Test
	public void testValidatename() {
		assertEquals("name", "name");
		assertNotSame("name", 123);
		assertNotSame("name", "abc123");
		assertSame("name", "name");
		assertNotSame("name", "123ad");
	}

	@Test
	public void testValidateadharNumber() {
		assertEquals(343693783, 343693783);
		assertNotSame(343693783, "abc");
		assertNotSame(343693783,"123abc");
		assertNotSame(343693783,1000);

	}

	@Test
	public void testValidatephoneNumber() {
		assertEquals("9666441554","9666441554");
		assertNotSame("9666441554", "abc");
		assertNotSame("9666441554","123abc");
		
	}

	@Test
	public void testValidateemail() {
		assertEquals("abc@gmail.com", "abc@gmail.com");
		assertNotSame("abc@gmail.com", "abc.com");
		assertNotSame("abc@gmail.com", "abcgmail.com");
		assertNotSame("abc@gmail.com", "0123456");
	}

	@Test
	public void testValidateage() {
		assertEquals(21, 21);
		assertNotSame(21,"ab");
		assertNotSame(21, 0);
		assertNotSame(21,500);
	}

	@Test
	public void testValidategender() {
		assertEquals("F", "F");
		assertNotSame("F","ab");
		assertNotSame("F", 0);
		assertNotSame("F", 123);
		assertNotSame("F","a1");
	}


}
