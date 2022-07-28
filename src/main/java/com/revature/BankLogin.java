package com.revature;
import java.util.Scanner;
import com.revature.BankInfo;

public class BankLogin {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//starts the app
		System.out.print("Enter Username: ");
		
		String username = sc.next().trim();
		
		System.out.print("Enter Password: ");
		
		String password = sc.next().trim();
		
		String su = "John";
		
		String sp = "sauce";
		
		
		if(!su.equals(username) || !sp.equals(password)) {
			System.out.println("Incorrect userame or password");
		}
		if(su.equals(username) && sp.equals(password)) {
			System.out.println("correct");
		}
		
	}
}
