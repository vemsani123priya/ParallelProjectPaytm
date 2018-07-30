package com.cg.paytm.demo;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

import com.cg.paytm.beans.Customer;
import com.cg.paytm.beans.Wallet;

import com.cg.paytm.service.IWalletService;
import com.cg.paytm.service.WalletServiceImpl;



public class App
{
	IWalletService service;
	
	App() {
		service = new WalletServiceImpl();
	}
	
	
	public void menu() {
		System.out.println("1) Create Account");
		System.out.println("2) Show Balance");
		System.out.println("3) Deposit Amount");
		System.out.println("4) Fund Transfer");
		System.out.println("5) Exit Application");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your choice");
		int choice = scanner.nextInt();
		
		switch(choice) {
			case 1:
				Customer customer = new Customer();
				Wallet wallet = new Wallet();
			
				
				System.out.print("Enter name: ");
				String name = scanner.next();
				
				System.out.print("Enter mobileNumber: ");
				String mobileNumber = scanner.next();
				
				System.out.print("Enter Amount: ");
				BigDecimal amount = scanner.nextBigDecimal();
				
			customer = service.createAccount(name, mobileNumber, amount);
			System.out.println("Your account has successfully registered");
				break;
				
			case 2:
				System.out.println("Enter mobile number");
				mobileNumber = scanner.next();
				
			customer = service.showBalance(mobileNumber);
			System.out.print("The balance in account " + customer.getName());
			System.out.println(customer.toString());
			System.out.println(" is " + customer.getWallet().getBalance());
				
				break;
			
			case 3:
				System.out.println("Enter mobile number");
				mobileNumber = scanner.next();
				
				System.out.println("Enter amount to be deposited");
				amount = scanner.nextBigDecimal();
				
			customer = service.depositAmount(mobileNumber, amount);
			if(customer != null) {
			System.out.println("Successfully deposited");
			System.out.println("Account balance is: " + customer.getWallet().getBalance());
			System.out.println(customer.toString());
				
			}
			else {
				System.out.println("enter correct number");
			}
				
				break;
			
			
			
			case 4:
				System.out.print("Enter source mobile number: ");
				String sourceMobile = scanner.next();
				
				System.out.print("Enter target mobile number: ");
				String targetMobile = scanner.next();
				
				System.out.println("Enter amount to be transferred");
				amount = scanner.nextBigDecimal();
				
				try 
				{
					
					customer = service.fundTransfer(sourceMobile, targetMobile, amount);
					if(customer!=null) {
					System.out.println("Amount has successfully transferred from account " + customer.getName());
					System.out.println("And now your balance is " + customer.getWallet().getBalance());
					System.out.println(customer.toString());
					}
					else {
						System.out.println("enter correct number");
					}
				} 
				catch (Exception e) {
					System.out.println(e.getMessage());
					//e.printStackTrace();
				}
				
				
				break;
			
			case 5:
				System.out.println("Thank you for using our services");
				System.out.println("Good Bye");
				System.exit(0);
			
			default:
				System.out.println("Please enter valid choice");
				break;
		}
		
		
	}
	
	public static void main(String[] args) 
	{
		App client = new App();
		while(true) {
			try {
				client.menu();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				
			}
		}
	}
	
	
}
