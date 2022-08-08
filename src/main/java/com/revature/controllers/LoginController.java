package com.revature.controllers;
import java.util.Scanner;

import com.revature.services.LoginService;

public class LoginController {
	
	Scanner scan = new Scanner(System.in);
	LoginService serve = new LoginService();
	
	/**
	 * 
	 */
	public boolean login() {
		//enter username
		System.out.print("Enter Username: ");		
		String username = scan.next().trim();
		
		//enter password
		System.out.print("Enter Password: ");
		String password = scan.next().trim();
		
		//enter role
		System.out.println("What is your role: ");
		String role = scan.next().trim();
		
		
		serve.signin(username, password, role);
		System.out.println("You're successfully logged in!");
		return false;
	}
	
	
}
