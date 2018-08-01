package com.cg.paymentwallet.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.cg.paymentwallet.bean.Account;
import com.cg.paymentwallet.bean.Customer;
import com.cg.paymentwallet.exception.PaytmWalletExceptionImpl;
import com.cg.paymentwallet.service.PaymentWalletService;
import com.cg.paymentwallet.service.PaymentWalletValidate;


public class ClientWallet {
	static boolean b;

		public static void main(String[] args) throws ClassNotFoundException, SQLException, PaytmWalletExceptionImpl {
			int choice = 0;
			float amount;
			PaymentWalletService service = new PaymentWalletService();
			PaymentWalletValidate validate = new PaymentWalletValidate();
			Account account = new Account();


			do {
				int choice1;
				Scanner scan = new Scanner(System.in);
				System.out.println("+--------------WELCOME--------------------+");
				System.out.println("+=========================================+");
				System.out.println("|        1.Create an account              |");
				System.out.println("|        2.If existing user please login  |");
				System.out.println("+=========================================+");

				
				choice= scan.nextInt();
				switch(choice)
				{
				case 1:
					//createAccount();
					Customer wallet = new Customer();
					
					Scanner sc = new Scanner(System.in);
					
					System.out.println("Enter your UserName ");
					String userName = sc.nextLine();
					
					System.out.println("Enter your Password");
					String password = sc.nextLine();
					
					System.out.println("Enter Customer 12 digit Aadhar Number");
					String adharNumber = sc.nextLine();
					
					System.out.println("Enter Customer Name");
					String name = sc.nextLine();
					
					System.out.println("Enter Customer Age");
					int age = sc.nextInt();
					sc.nextLine();
					
					System.out.println("Enter Customer gender");
					String gender = sc.nextLine();
					
					System.out.println("Enter Customer Mobile Number");
					String phoneNumber = sc.nextLine();
					
					
					System.out.println("Enter Customer EmailID");
					String email = sc.nextLine();
					
					
					
					System.out.println("Enter Opening Blanace");
					float balance = sc.nextFloat();
					
					int accountNumber = (int)(Math.random() * 123456+123456);
					
					
					boolean isValidadharNumber = validate.validateadharNumber(adharNumber);
					boolean isValidphoneNumber = validate.validatephoneNumber(phoneNumber);
					boolean isValidemail = validate.validateemail(email);
					//boolean isValidinitBal = validate.validateinitBal(initBal);
					
					if(isValidadharNumber &&  isValidphoneNumber && isValidemail )
					{
						wallet.setUserName(userName);
						wallet.setPassword(password);
						wallet.setAdharNumber(adharNumber);
						wallet.setName(name);
						wallet.setAge(age);
						wallet.setGender(gender);
						account.setBalance(balance);
						wallet.setEmail(email);
						wallet.setPhoneNumber(phoneNumber);
						account.setAccountNumber(accountNumber);
						account.setCus(wallet);
						
						b= service.addCustomerDetails(account);
						if(b)
						{
							
							System.out.println("Account Created Successfully and your Account Number is: "+accountNumber);
							System.out.println("Your UserName is: "+userName);
							System.out.println("Your Password is :"+password);
							
						/*}else
						{
							try {
								throw new NoUserNameFoundException();

							} catch (NoUserNameFoundException e) {
								System.out.println("Account is Not Created");

							}
							
							
						}*/
						}
					
					else
					{
						System.out.println("Enter Phone number correctly in 10 digits");
						System.out.println("Adhar Number should be 12 digits");
						System.out.println("Initial balance should be 500");


					}
					}
					
					break;
					
				case 2:
					
					Scanner s = new Scanner(System.in);
					System.out.println("Enter Your Username");
					userName = s.nextLine();
					System.out.println("Enter Your Password");
					password = s.nextLine();
					
					b= service.loginAccount(userName, password);
					if(b)
					{
						System.out.println("Successful");
					} else {
					
					  System.out.println("Yoy are not a registered user");
					}
					
					if(b)
				
					{
						do {
							
							System.out.println("+=========================================+");
							System.out.println("+           1)Deposit Amount              +");
							System.out.println("+           2)Withdraw Amount             +");
							System.out.println("+           3)Show Balance                +");
							System.out.println("+           4)Transfer Money              +");
							System.out.println("+           5)Print Transactions          +");
							System.out.println("+           6)Exit                        +");
							System.out.println("+=========================================+");

							
							System.out.println("\nHello User......\nEnter Your Choice");
							
							choice1 = scan.nextInt(); 
							
							switch(choice1)
							{
							
							
								
							case 1:
								//depositAmount();
								Scanner scan1 = new Scanner(System.in);
								
								System.out.println("Enter amount to deposit");
								amount = scan1.nextFloat();
								boolean isDeposit = service.depositAmount(amount);
								
								if(isDeposit)
								{
									System.out.println("Amount Deposited in your account");
								}
								break;
								
							case 2 : 
								//withdrawAmount();
								Scanner scan2 = new Scanner(System.in);

								System.out.println("Enter amount to withdraw");
								amount = scan2.nextFloat();
								boolean isWithdraw = service.withdrawAmount(amount);
								
								if(isWithdraw)
								{
									System.out.println("Amount Withdrawed from your account");
								}
								break;
								
							case 3 : 
								//showBalance();
								     balance = service.showBalance();
									System.out.println("Account Balance is: "+balance);
								break;
								
							case 4:
								//fundTransfer();
								Scanner scn = new Scanner(System.in);
								
								
								System.out.println(" Enter Account Number to transfer amount");
								String accountNumber2 = s.next();
								System.out.println("Enter Amount to Transfer");
								amount = scn.nextFloat();
								boolean b1= service.fundTransfer(accountNumber2, amount);
								if(b1)
								{
									System.out.println("Fund Successfully Transfer");
								}
								else
								{
									System.out.println("Enter Correct Input");
								}
								break;
								
							case 5:
								//printTransaction();
								service.printTransaction();
								break;
								
							case 6 : System.exit(0);
								
								break;
							
							
							}
						
						}while(choice1!=7);
						
						
					}
					
					else
					{
						System.out.println("Invalid Login Details..Try Again..");
					}
				break;
				
				
				}
			}while(choice!=3);
		}
}

			
			
				
			
			