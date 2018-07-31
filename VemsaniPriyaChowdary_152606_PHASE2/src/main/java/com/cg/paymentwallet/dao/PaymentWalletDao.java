package com.cg.paymentwallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.capgemini.core.util.JdbcUtil;
import com.cg.paymentwallet.bean.Account;
import com.cg.paymentwallet.bean.Customer;

public class PaymentWalletDao implements IPaymentWalletDao {
	JdbcUtil util = new JdbcUtil();
	
	float balance;
	static Customer cust;
	Account acc = new Account();
	static int acn;
	String details;
	int accountNumber ;
	public boolean loginAccount(String userName, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Statement stmt;
		Connection con = util.getConnection();
		
		System.out.println("entered");
		try {
			stmt = con.createStatement();
			String query = "select * from customer2 where userName = userName and password = password";
			stmt.executeQuery(query);
			System.out.println("entered one");
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				userName = rs.getString("userName");
				password = rs.getString("password");

				System.out.println(userName);
				if (userName.equals(userName) && password.equals(password)) {
					acn = rs.getInt("accountNumber");
					return true;

				}
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean addCustomerDetails(Account account) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = util.getConnection();
		Statement st;
		try {
			st = con.createStatement();
			// ResultSet rs = st.executeQuery("select * from paymentwalletdb.customer");

			PreparedStatement ps = con
					.prepareStatement("insert into customer2 values(?,?,?,?,?,?,?,?,?)");
			PreparedStatement ps1 = con.prepareStatement("insert into account values(?,?)");
			ps1.setInt(1, account.getAccountNumber());
			ps1.setFloat(2, account.getBalance());

			ps.setString(1, account.getCus().getName());
			ps.setString(2, account.getCus().getAdharNumber());
			ps.setString(3, account.getCus().getPhoneNumber());
			ps.setString(4, account.getCus().getEmail());
			ps.setInt(5, account.getCus().getAge());
			ps.setString(6, account.getCus().getGender());
			ps.setString(7, account.getCus().getUserName());
			ps.setString(8, account.getCus().getPassword());
			ps.setInt(9, account.getAccountNumber());
			ps.execute();

			ps1.execute();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public float showBalance() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 accountNumber = acn;
		 Connection con = util.getConnection();
		Statement st;
		try {
			st = con.createStatement();
			String query = "select * from account where accountNumber='" + accountNumber + "'";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				balance = rs.getFloat("balance");
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return balance;
	}

	public boolean depositAmount(float amount) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		// acc.setBalance(acc.getBalance()+amount);
		Connection con = util.getConnection();
		try {
			String deposit = " THE AMOUNT" + amount + "IS DEPOSITED" + "\n";
			String insertq = "INSERT INTO transactions2 values(?,?)";
			 accountNumber = acn;
			String query = "update account set balance =balance+? where accountNumber=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setFloat(1, amount);

			ps.setInt(2, accountNumber);
			ps.executeUpdate();
			PreparedStatement ps22= con.prepareStatement(insertq);
			ps22.setInt(2, accountNumber);
			ps22.setString(1, deposit);
			ps22.execute();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public boolean withdrawAmount(float amount) throws ClassNotFoundException, SQLException {
		 accountNumber = acn;
		String query = "select * from account where accountNumber='" + accountNumber + "'";
		Connection con = util.getConnection();
		try {
			String withdraw = " THE AMOUNT" + amount + "IS WITHDRAWED" + "\n";
			String insertq = "INSERT INTO transactions2 values(?,?)";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				balance = rs.getFloat("balance");

			}
			if (balance >= amount) {
				String query1 = "update account set balance=balance-? where accountNumber=?";

				PreparedStatement ps = con.prepareStatement(query1);
				ps.setFloat(1, amount);

				ps.setInt(2, accountNumber);
				ps.executeUpdate();
				PreparedStatement ps22= con.prepareStatement(insertq);
				ps22.setInt(2, accountNumber);
				ps22.setString(1, withdraw);
				ps22.execute();
			

			} else {
				System.out.println("not updated");
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	/*
	 * if(acc.getBalance() >= (amount+500)) {
	 * acc.setBalance(acc.getBalance()-amount); return true; } else {
	 * System.out.println("Minimum balance should be maintained"); } return false; }
	 */

	public boolean fundTransfer( String accountNumber2, float amount) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
accountNumber =acn;
Connection con = util.getConnection();
		try {
			String fdt = "THE AMOUNT\t " + amount + "\t IS TRANSFERRED TO \t" + accountNumber2;
			String insertfund = "insert into transactions2 value(?,?)";

			String query2 = "select * from account where accountNumber = accountNumber";
			Statement st1 = con.createStatement();

			ResultSet rs1 = st1.executeQuery(query2);
			while (rs1.next()) {
				balance = rs1.getFloat("balance");

				if (balance > amount) {
					String query3 = "update account set balance = balance - ? where accountNumber = ?";
					PreparedStatement ps1 = con.prepareStatement(query3);
					ps1.setFloat(1, amount);
					ps1.setInt(2, accountNumber);
					ps1.execute();

				}
			}

			String query = "select * from account where accountNumber='+ accountNumber2 +'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				balance = rs.getFloat("balance");
			}
			String query1 = "update account set balance = balance+? where accountNumber = ?";

			PreparedStatement ps = con.prepareStatement(query1);
			ps.setFloat(1, amount);
			ps.setString(2, accountNumber2);
			ps.execute();
			/*
			 * else { System.out.println("Cannot be transferred"); }
			 */

			PreparedStatement ps2 = con.prepareStatement(insertfund);
			ps2.setString(1, fdt);
			ps2.setInt(2, accountNumber);

			ps2.execute();
			/*
			 * } else { System.out.println("Amount exceeds"); }
			 */
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public void printTransaction() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 accountNumber = acn;
		 Connection con = util.getConnection();
		try {
			Statement st = con.createStatement();
			String query = "select * from transactions2 where accountNumber = '" + accountNumber + "'";

			
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				details = rs.getString("transaction_info");
				System.out.println(details);
				

			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
