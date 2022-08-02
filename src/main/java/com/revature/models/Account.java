package com.revature.models;
import java.util.Scanner;

public class Account {
	private String name;
	private String Account;
	private String Type;
	private long amount;
	
	Scanner sc = new Scanner(System.in);
	
	public void open() {
		System.out.println("");
	}

	public Account(String name, String account, String type, long amount) {
		super();
		this.name = name;
		Account = account;
		Type = type;
		this.amount = amount;
		
	}
	
}
