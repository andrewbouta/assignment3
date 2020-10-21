package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import com.meritamerica.assignment3.BankAccount;
import com.meritamerica.assignment3.CDOffering;

public class CDAccount extends BankAccount {
	public CDOffering offering = new CDOffering();
	public static int term;
	public double interestRate;
	public Date startDate = new Date();

	CDAccount(CDOffering offering, double balance) {
		super(MeritBank.getNextAccountNumber(), balance, offering.getInterestRate());
		this.offering = offering;
		this.balance = balance;
		this.term = offering.getTerm();
		this.interestRate = offering.getInterestRate();
	}


	public double getBalance() {
		return this.balance;
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public int getTerm() {
		return offering.getTerm();
	}

	public java.util.Date getStartDate() {
		return this.startDate;
	}

	public long getAccountNumber() {
		return this.accountNumber;
	}

	public double futureValue(int years) {
		futureBalance = (balance * Math.pow(1.0 + interestRate, years));
		return futureBalance;
	}
	
	
	// Create appropriate constructors

	static CDAccount readFromString(String accountData) throws ParseException {
		String[] cdAccountInfo = accountData.split(",");
		CDAccount cdAccountInfo;
		
		// Try catch for testing
		try {
			// CDAccount cdAccountInfo = accountData.split(",");
			ArrayList<String> accountInfo = new ArrayList<String>(Arrays.asList(accountData.split(",")));
			long accountNumber = Long.parseLong(accountInfo.get(0));
			double balance = Double.parseDouble(accountInfo.get(1));
			double interestRate = Double.parseDouble(accountInfo.get(2));
			//int term = Integer.parseInt(accountInfo.get(3));
			long startDate = Date.parse(accountInfo.get(3));
			cdAccountInfo = new CDAccount(accountNumber, balance, interestRate, startDate);
			
			for(String s : accountInfo) {
				System.out.println(s);
			}
			
		//	SimpleDateFormat sdf = new SimpleDateFormat(dateF);
			//File file = new File("src/test/testMeritBank_good.txt");
			File file = new File("src/test/testMeritBank_bad.txt"); 
	
			FileReader fr = new FileReader(file);
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
		return cdAccountInfo;
	}

	

	@Override
	public String writeToString() {
		String accountInfo = String.valueOf(term) + String.valueOf(interestRate);
		return accountInfo;
	}

}