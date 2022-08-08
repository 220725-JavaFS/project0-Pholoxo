package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.models.*;
import com.revature.controllers.*;
import com.revature.utils.ConnectionUtil;

public class BankDAOImpl implements BankDAO{

	

	@Override
	public Admin getAdmin(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomer(String username, String password) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM customers WHERE username='" + username +
					     "' AND PASSWORD = '" + password + "';";
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				
				Customer customer = new Customer(
						result.getInt("customerid"),
						result.getString("name"),
						result.getString("password"),
						result.getString("password"),
						null,
						null,
						null
						);
			
				return customer;
			} else {
				System.out.println("Wrong username or password");
				CustomerController custom = new CustomerController();
				custom.customerMenu();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getEmployee(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccount(int customerID, String accounttype) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM accounts WHERE customerid='" + String.valueOf(customerID) +
					     "' AND accounttype = '" + accounttype + "';";
			System.out.println(sql);
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				Account account = new Account(
						result.getInt("accountid"),
						result.getInt("customerid"),
						result.getString("accounttype"),
						result.getString("status"),
						result.getDouble("amount")
						);
				
				return account;
			} 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	

	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAllAccounts(int customerID) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM accounts WHERE customerid='" + String.valueOf(customerID) + "';";
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			List<Account> accountList = new LinkedList<Account>();
			
			while(result.next()) { //resultSets are cursor based, each time .next is called the cursor moves to the next group of values. 
				//It starts one before so you always need to call next.
				
				Account account = new Account(
						result.getInt("accountid"),
						result.getInt("customerid"),
						result.getString("accounttype"),
						result.getString("status"),
						result.getDouble("amount")
						);
				
				accountList.add(account);
				
			}
			
			
			return accountList;
			
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public void deposit(int customerID, String accounttype, double amount) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE accounts SET amount = " 
					     + amount + " WHERE customerid = " 
					     + String.valueOf(customerID) 
					     + " AND accounttype = '" 
					     + accounttype 
					     + "';";
			PreparedStatement statement = conn.prepareStatement(sql);

			
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void withdraw(int customerID, String accounttype, double amount) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE accounts SET amount = " 
					     + amount + " WHERE customerid = " 
					     + String.valueOf(customerID) 
					     + " AND accounttype = '" 
					     + accounttype 
					     + "';";
			PreparedStatement statement = conn.prepareStatement(sql);

			
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	

	@Override
	public void openAccount(int customerID, String accounttype) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO accounts (customerID, accounttype, status)"
					+ "	VALUES (?, ?, ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0;
			statement.setInt(++count, customerID);
			statement.setString(++count, accounttype);
			if(accounttype.equals("investment")) {
				statement.setString(++count, "pending");
			} else {
				statement.setString(++count, "open");
			}
			
			

			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void closeAccount(int customerID, String accounttype) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "DELETE from accounts WHERE customerid = " 
					     + String.valueOf(customerID) 
					     + " AND accounttype = '" 
					     + accounttype 
					     + "';";
			PreparedStatement statement = conn.prepareStatement(sql);

			
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	

	




}
