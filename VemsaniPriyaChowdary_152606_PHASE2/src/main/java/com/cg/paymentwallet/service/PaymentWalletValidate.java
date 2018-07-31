package com.cg.paymentwallet.service;

import com.cg.paymentwallet.exception.IPaymentWalletException;
import com.cg.paymentwallet.exception.PaytmWalletExceptionImpl;

public class PaymentWalletValidate {
	public boolean validateadharNumber(String adharNumber) {
		// TODO Auto-generated method stub
		if(adharNumber.length()==12)
		{
			return true;
		}
		else {
			return false;
		}
	}

	public boolean validatephoneNumber(String phoneNumber) throws PaytmWalletExceptionImpl {
		// TODO Auto-generated method stub
		if(phoneNumber.length()==10)
		{
			return true;
		}
		else
		{
			throw new PaytmWalletExceptionImpl(IPaymentWalletException.message);
		}
	}
	public boolean validateemail(String email) throws PaytmWalletExceptionImpl {

		if (email.endsWith(".com")) {

			return true;
		}

		else {
			System.err.println("invalid email id");
			throw new PaytmWalletExceptionImpl(IPaymentWalletException.message);

		}
	}

	public boolean validateinitBal(float initBal) throws PaytmWalletExceptionImpl {
		// TODO Auto-generated method stub
		if(initBal >=500)
		{
			return true;
		}
		else
		{
			throw new PaytmWalletExceptionImpl(IPaymentWalletException.message);
		}
		
	}

}
