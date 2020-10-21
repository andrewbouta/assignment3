package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckingAccount extends BankAccount {
	public double openingBalance, interestRate, futureBalance;
	
	CheckingAccount(double openingBalance) {
		super();
		this.openingBalance = openingBalance;
		this.interestRate = 0.0001;
		//this.dateF;
	}
	
	// Create appropriate constructors
	CheckingAccount(long accountNumber, double balance, double interestRate, SimpleDateFormat dateF){
		
	}

	static CheckingAccount readFromString(String accountData) throws ParseException, Exception {
		try {
			SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
			String[]ca = accountData.split(",");
			
			long accountNumber = Long.parseLong(ca[0]);
			double balance = Double.parseDouble(ca[1]);
			double interestRate = Double.parseDouble(ca[2]);
			
			Date date = dateF.parse(ca[3]);
			
			
			//File file = new File("src/test/testMeritBank_good2.txt");
			File file = new File("src/test/testMeritBank_good.txt"); // test
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			CheckingAccount checkingAccInfo = new CheckingAccount(accountNumber, balance, interestRate, dateF);
			
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line); // Displays file's content to the screen, line by line
			}
			br.close();
			fr.close();
			
			//format.parse();
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException("String was not parsed correctly.");
		} catch (FileNotFoundException fnf) {
			throw new FileNotFoundException("File was not found.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public double getBalance() {
		return this.openingBalance;
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public boolean withdraw(double amount) {
		if (amount < openingBalance && amount > 0) {
			openingBalance -= amount;
			return true;
		} else {
			System.out.println("Not enough money!!!");
			return false;
		}
	}

	public boolean deposit(double amount) {
		if (amount > 0) {
			openingBalance += amount;
			return true;
		} else {
			System.out.println("Cannot deposit a negative amount");
			return false;
		}
	}

	public double futureValue(int years) {
		futureBalance = (openingBalance * Math.pow(1.0 + interestRate, years));
		return futureBalance;
	}

	@Override
	public String toString() {
		return "Checking Account Balance: " + openingBalance + "\r\n" + "Checking Account Interest Rate: "
				+ interestRate + "\r\n" + "Checking Account Balance in 3 years " + futureBalance;
	}
}