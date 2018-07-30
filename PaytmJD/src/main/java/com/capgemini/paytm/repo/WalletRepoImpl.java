package com.capgemini.paytm.repo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;





import com.capgemini.paytm.beans.Customer;
import com.capgemini.paytm.beans.Wallet;
import com.capgemini.paytm.exception.InvalidInputException;

public class WalletRepoImpl implements WalletRepo{
	Connection con=null;
	public WalletRepoImpl() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","Capgemini123");
		con.setAutoCommit(true);
	}	
	@Override
	public boolean save(Customer customer) {
		// TODO Auto-generated method stub
		PreparedStatement p,p1,p2,p3 ;
		try {
			p=con.prepareStatement("select * from customer1 where mobilenumber=?");
			p.setString(1, customer.getMobileNo());
			ResultSet i = p.executeQuery();
			if(i.next())
			{
				p2=con.prepareStatement("update wallet1 set balance = ? where mobilenumber=?");
				p2.setBigDecimal(1,customer.getWallet().getBalance());
				p2.setString(2,customer.getMobileNo());
				p2.executeUpdate();
				p2.close();
				return false;
			}
			p=con.prepareStatement("Insert into customer1 values(?,?)");
				p.setString(1, customer.getMobileNo());
				p.setString(2,customer.getName());
				p.execute();
				p1=con.prepareStatement("Insert into wallet1 values(?,?)");
				p1.setString(1, customer.getMobileNo());
				p1.setBigDecimal(2, customer.getWallet().getBalance());
				p1.execute();
				p3 = con.prepareStatement("Insert into transaction values(?,'Accounted created')");
				p3.setString(1, customer.getMobileNo());
				p3.execute();
				p.close();
				p1.close();
				p3.close();
			
			
		}
	 catch (SQLException e) {
			System.out.println("");
		}
		return true;
	}

	@Override
	public Customer findOne(String mobileNo) throws SQLException {
		PreparedStatement p,p1,p2;
		p=con.prepareStatement("select * from customer1 where mobilenumber=?");
		p.setString(1, mobileNo);
		p1=con.prepareStatement("select * from wallet1 where mobilenumber=?");
		p1.setString(1, mobileNo);
		
		ResultSet r = p.executeQuery();
		ResultSet r1 = p1.executeQuery();
		
		Customer c = new Customer(); 
		while(r.next())
		{
			c.setName(r.getString(1));
			c.setMobileNo(r.getString(2));
		}
		while(r1.next())
			c.setWallet(new Wallet(r1.getBigDecimal(2)));
		if(c.getMobileNo()==null)
		{
			return null;
		}
		else
		{
			return c;
		}
	}
	public void saveTransaction(String mobileNo, String s) throws SQLException 
	{
		PreparedStatement p;
		p=con.prepareStatement("insert into transaction values(?,?)");
		p.setString(1,mobileNo);
		p.setString(2,s);
		p.execute();
		p.close();
	}
	@Override
	public List getTransaction(String mobileNo) throws SQLException {
		PreparedStatement p;
		p=con.prepareStatement("select statement from transaction where mobilenumber=?");
		p.setString(1,mobileNo);
		
		ResultSet rs=p.executeQuery();
		List list=new LinkedList();
		while(rs.next())
		{
			list.add(rs.getString(1));
		}
		p.close();
		return list;
	    }
	
	public void updateAmount(Customer customer,BigDecimal amtSub) {
		PreparedStatement p,p2;
	
		
				try {
					p2=con.prepareStatement("update wallet1 set balance = ? where mobilenumber=?");
					p2.setBigDecimal(1,amtSub);
					System.out.println(customer.getWallet().getBalance());
					p2.setString(2,customer.getMobileNo());
					p2.executeUpdate();
					p2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	
		
	}
}
	
