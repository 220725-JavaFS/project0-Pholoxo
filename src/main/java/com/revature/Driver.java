package com.revature;

import com.revature.controllers.*;
import java.util.Scanner;

public class Driver {
	
	
	public static void main(String[] args) {
		System.out.println("Hello to Ohara Banking!");
		
		Scanner scan = new Scanner(System.in);
		
	    System.out.println("Do you have an account with us?");
	    
	    String answer = scan.nextLine();
	    
	    if(answer.equals("yes")) {
	    	System.out.print("lol");
	    }
//		LoginController log = new LoginController();
//		log.login();
//		
//		RegisterController reg = new RegisterController();
		
	}

}
