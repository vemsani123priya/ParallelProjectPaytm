package com.cg.paytm.service;

import java.math.BigDecimal;
import java.util.Map;

import com.cg.paytm.beans.Customer;
import com.cg.paytm.beans.Wallet;
import com.cg.paytm.repo.IWalletRepo;
import com.cg.paytm.repo.WalletRepoImpl;
import com.cg.paytm.exception.IInsufficientBalance;
import com.cg.paytm.exception.IInvalidInput;
import com.cg.paytm.exception.InsufficientBalanceException;
import com.cg.paytm.exception.InvalidInputException;

public class WalletServiceImpl implements IWalletService{
	private IWalletRepo repo;
	
	public WalletServiceImpl() {
		repo = new WalletRepoImpl();
	}


	

	public Customer createAccount(String name, String mobileNo, BigDecimal amount) throws InvalidInputException {
		if(isValid(mobileNo)) {
			Wallet wallet = new Wallet();
			Customer customer = new Customer();
		
			wallet.setBalance(amount);
			customer.setName(name);
			customer.setMobileNo(mobileNo);
			customer.setWallet(wallet);
		
			repo.save(customer);

			return customer;
		}
		else throw new InvalidInputException(IInvalidInput.ERROR2);

	}

	public Customer showBalance(String mobileNo) throws InvalidInputException {
		if(isValid(mobileNo)) {
		Customer customer=repo.findOne(mobileNo);
		if(customer!=null) {
			return customer;
		}
		
		else {
			throw new InvalidInputException(IInvalidInput.ERROR2);
		}
	}else {
		throw new InvalidInputException(IInvalidInput.ERROR2);
	}
	}

	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) throws InvalidInputException, InsufficientBalanceException {
		if(repo.findOne(sourceMobileNo) != null && repo.findOne(targetMobileNo)!=null ) {
		if(isValid(sourceMobileNo) == false || isValid(targetMobileNo) == false) throw new InvalidInputException();
		Customer customer = withdrawAmount(sourceMobileNo, amount);
		depositAmount(targetMobileNo, amount);
		return customer;
		}
		return null;
	}

	public Customer depositAmount(String mobileNo, BigDecimal amount) throws InvalidInputException 
	{
		if(isValid(mobileNo)) 
		{
			if(repo.findOne(mobileNo)!= null) {
			Customer customer = repo.findOne(mobileNo);
			Wallet wallet = customer.getWallet();
			wallet.setBalance(wallet.getBalance().add(amount));
		
			repo.remove(mobileNo);
		
			if(repo.save(customer)) {
				return customer;
			}
			}
			else {
				throw new InvalidInputException(IInvalidInput.ERROR2);
			}
		}
		return null;
	}

	public boolean isValid(String mobileNo) {
		if(mobileNo.matches("[1-9][0-9]{9}")) 
		{
			return true;
		}		
		else 
			return false;
	}

	public Customer withdrawAmount(String mobileNo, BigDecimal amount) throws InvalidInputException, InsufficientBalanceException {
		if(isValid(mobileNo)) 
		{
			
			Customer customer = repo.findOne(mobileNo);
			Wallet wallet = customer.getWallet();
			BigDecimal amountOne = wallet.getBalance();
			
			
			
			
			wallet.setBalance(wallet.getBalance().subtract(amount));
			//System.out.println(wallet.getBalance());
			
		
			
			
		
			repo.remove(mobileNo);
		
			if(repo.save(customer)) {
				return customer;
			}
			return null;
		}
		else throw new InvalidInputException(IInvalidInput.ERROR2);
		
	}
	

}
