package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


// acc #, current bal, interestRate, date opened
public class SavingsAccount extends BankAccount {
	public double openingBalance, interestRate, futureBalance;

	SavingsAccount(double openingBalance) {
		super();
		this.openingBalance = openingBalance;
		this.interestRate = 0.01;
	}

	// Create appropriate constructors
	SavingsAccount() {
		
	}
	
	static SavingsAccount readFromString(String accountData) throws ParseException, Exception {
		try {
			// CDAccount cdAccountInfo = accountData.split(",");
			ArrayList<String> accountInfo = new ArrayList<String>(Arrays.asList(accountData.split(",")));
			long accountNumber = Long.parseLong(accountInfo.get(0));
			double balance = Double.parseDouble(accountInfo.get(1));
			double interestRate = Double.parseDouble(accountInfo.get(2));
			//int term = Integer.parseInt(accountInfo.get(3));
			Date dateOpened = Date.valueOf(accountInfo.get(3));
			cdAccountInfo = new CDAccount(accountNumber, balance, interestRate, dateOpened, term);
			
			//File file = new File("src/test/testMeritBank_good2.txt");
			File file = new File("src/test/testMeritBank_bad.txt"); // test
	
			FileReader fr = new FileReader(file);
			// FileWriter fw = new FileWriter(file, true);
			// BufferedWriter bw = new BufferedWriter(fw);
			
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line); // Displays file's content to the screen, line by line
			}
			
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
			System.out.println("Insufficient funds");
			return false;
		}
	}

	public boolean deposit(double amount) {
		if (amount > 0) {
			openingBalance += amount;
			return true;
		} else {
			System.out.println("Negative balance. Please try again.");
			return false;
		}
	}

	public double futureValue(int years) {
		futureBalance = (openingBalance * Math.pow(1.0 + interestRate, years));
		return futureBalance;
	}

	@Override
	public String toString() {
		return "Savings Account Balance: " + openingBalance + "\r\n" + "Savings Account Interest Rate: " + interestRate
				+ "\r\n" + "Savings Account Balance in 3 years " + futureBalance;
	}
}