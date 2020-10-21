package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class CDOffering {
	
	int term;
	double interestRate;
	
	CDOffering(){
		
	}
	
	CDOffering(int term, double interestRate){
		this.term = term;
		this.interestRate = interestRate;
	}
	
	public int getTerm() {
		return term;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	/* =================================== Read/Write Data to file =================================== */
	public static CDOffering readFromString(String cdOfferingDataString) throws ParseException, Exception {
		CDOffering cdOffering = cdOfferingDataString.split(",");
		try {
			ArrayList<String> CDOffering = new ArrayList<String>(Arrays.asList(CDOfferingDataString.split(",")));
			long accountNumber = Long.parseLong(accountInfo.get(0));
			double balance = Double.parseDouble(accountInfo.get(1));
			double interestRate = Double.parseDouble(accountInfo.get(2));
			//int term = Integer.parseInt(accountInfo.get(3));
			Date dateOpened = Date.valueOf(accountInfo.get(3));
			cdOffering = new CDAccount(accountNumber, balance, interestRate, dateOpened, term);
			}
			
			//format.parse();
		 catch (NumberFormatException nfe) {
			throw new NumberFormatException("String was not parsed correctly.");
		} catch (FileNotFoundException fnf) {
			throw new FileNotFoundException("File was not found.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String writeToString() {
		String accountHolderString = firstName + lastName + String.valueOf(ssn);
		return accountHolderString;
	}
	
}
