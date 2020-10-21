package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class BankAccount {
	public long accountNumber;
	public double balance, interestRate, futureBalance;
	public static SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
	public static Date accountOpenedOn;
	
	
	BankAccount(){
	}
	
	BankAccount(double balance, double interestRate){
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	BankAccount(double balance, double interestRate, java.util.Date accountOpenedOn) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = (Date) accountOpenedOn;
				
	}
	
	BankAccount(long accountNumber, double balance, double interestRate){
		this.accountNumber = new Random().nextLong();
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	BankAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn) {
		
	}
	
	java.util.Date getOpenedOn() {
		return null;
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public long getAccountNumber() {
		return this.accountNumber;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public boolean withdraw(double amount) {
		if(amount < balance && amount > 0) {
			this.balance -= amount;
			return true;
		}else {
			System.out.println("Insufficient funds. Try again.");
			return false;
		}
	}
	
	public boolean deposit(double amount) {
		if(amount > 0) {
			this.balance += amount;
			return true;
		}else {
			System.out.println("Cannot deposit a negative amount.");
			return false;
		}
	}
	
	public double futureValue(int years) {
		futureBalance = (balance * Math.pow(1.0 + interestRate, years));
		return futureBalance;
	}

	/* =================================== Read/Write Data to file =================================== */	
	
	
	static BankAccount readFromString(String accountData) throws ParseException, Exception {
		//SimpleDateFormat dateF = new SimpleDateFormat(accountOpenedOn);
		
		try {
		String[] accountInfo = accountData.split(",");
		long accountNumber = Long.valueOf(accountInfo[0]);
		double balance = Double.valueOf((accountInfo[1]));
		double interestRate = Double.valueOf(accountInfo[2]);
		Date dateOpened = (Date)dateF.parse(accountInfo[3]);
		BankAccount bankAccountInfo = new BankAccount(accountNumber, balance, interestRate, dateOpened);
		
		return bankAccountInfo;
	
		
/*
			//File file = new File("src/test/testMeritBank_good2.txt");
			File file = new File("src/test/testMeritBank_bad2.txt"); // test
	
			FileReader fr = new FileReader(file);
			// FileWriter fw = new FileWriter(file, true);
			// BufferedWriter bw = new BufferedWriter(fw);
			
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line); // Displays file's content to the screen, line by line
			}
			
			*/
			//format.parse();
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException("String was not parsed correctly.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 
	}

	
	public String writeToString() {
		String accountInfo = accountNumber + "," + balance + "," + interestRate + "," + accountOpenedOn;
		return accountInfo;
	}
	/* ============================================================================================== */
	
	
}
