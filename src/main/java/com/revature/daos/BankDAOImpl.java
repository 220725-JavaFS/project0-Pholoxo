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
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM admins WHERE username='" + username +
					     "' AND PASSWORD = crypt('" + password + "', password);";
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				
				Admin admin = new Admin(
						result.getInt("adminid"),
						result.getString("name"),
						result.getString("password"),
						result.getString("username")
						);
				return admin;
				
				
			} else {
				System.out.println("Wrong username or password");
				AdminController admi = new AdminController();
				admi.adminMenu();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public Customer getCustomer(String username, String password) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM customers WHERE username='" + username +
					     "' AND password = crypt('" + password + "', password);";
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				
				Customer customer = new Customer(
						result.getInt("customerid"),
						result.getString("name"),
						result.getString("password"),
						result.getString("username"),
						null,
						null,
						null
						);
				List<Account> accountList = getAllAccounts(customer.getCustomerID());
				for(Account a: accountList) {
					if(a.getAccountType().equals("checking")) {
						customer.setChecking(a);
					}else if(a.getAccountType().equals("savings")) {
						customer.setSavings(a);
					}else if(a.getAccountType().equals("investment")) {
						customer.setInvestment(a);
					}
				}
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
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM employees WHERE username='" + username +
					     "' AND PASSWORD = crypt('" + password + "', password);";
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				
				Employee employee = new Employee(
						result.getInt("employeeid"),
						result.getString("name"),
						result.getString("password"),
						result.getString("username")
						);
				return employee;
				
				
			} else {
				System.out.println("Wrong username or password");
				EmployeeController employ = new EmployeeController();
				employ.employeeMenu();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account getAccountByID(int customerID, String accounttype) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM accounts WHERE customerid='" + String.valueOf(customerID) +
					     "' AND accounttype = '" + accounttype + "';";
			
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
	public Customer getCustomerByID(int customerID) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM customers WHERE customerid='" + String.valueOf(customerID) + "';";
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				
				Customer customer = new Customer(
						result.getInt("customerid"),
						result.getString("name"),
						result.getString("password"),
						result.getString("username"),
						null,
						null,
						null
						);
				List<Account> accountList = getAllAccounts(customer.getCustomerID());
				for(Account a: accountList) {
					if(a.getAccountType().equals("checking")) {
						customer.setChecking(a);
					}else if(a.getAccountType().equals("savings")) {
						customer.setSavings(a);
					}else if(a.getAccountType().equals("investment")) {
						customer.setInvestment(a);
					}
				}
				return customer;
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
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

	@Override
	public void addCustomer(String name, String password, String username) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO customers (name, password, username)"
					+ "	VALUES (?, crypt(?, gen_salt('bf')), ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0;
			statement.setString(++count, name);
			statement.setString(++count, password);
			statement.setString(++count, username);
			
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void processedApplication(int accountID, String request) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE accounts SET status = '" 
					     + request + "' WHERE accountid = " 
					     + accountID 
					     + ";";
			PreparedStatement statement = conn.prepareStatement(sql);

			
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean ifExists(String username) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM customers WHERE username='" + username + "';";
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				
				Customer customer = new Customer(
						result.getInt("customerid"),
						result.getString("name"),
						result.getString("password"),
						result.getString("username"),
						null,
						null,
						null
						);
				return true;
			} 
		} catch (SQLException e) {
			return false;
		}
		return false;
		
	}
	
	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM customers";
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			List<Customer> customerList = new LinkedList<Customer>();
			
			while(result.next()) { 
				Customer customer = new Customer(
						result.getInt("customerid"),
						result.getString("name"),
						result.getString("password"),
						result.getString("username"),
						null,
						null,
						null
						);
				List<Account> accountList = getAllAccounts(customer.getCustomerID());
				for(Account a: accountList) {
					if(a.getAccountType().equals("checking")) {
						customer.setChecking(a);
					}else if(a.getAccountType().equals("savings")) {
						customer.setSavings(a);
					}else if(a.getAccountType().equals("investment")) {
						customer.setInvestment(a);
					}
				}
				customerList.add(customer);
				
			}
			
			
			return customerList;
			
		}catch(SQLException e) {
			e.printStackTrace();
		} 
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
			
			while(result.next()) { 
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
	public List<Account> getTotalAccounts() {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM accounts";
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			List<Account> accountList = new LinkedList<Account>();
			
			while(result.next()) { 
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
	
}
