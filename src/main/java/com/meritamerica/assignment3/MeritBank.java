package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
// 


public class MeritBank {
	public static int size = 5, numberOfAccountHolders = 0, numberOfCDOfferings = 0;
	public static long[] accountNumbers = new long[size];
	public static AccountHolder[] accountHolders = new AccountHolder[size];
	public static CDOffering[] CDOfferings = new CDOffering[size];
	
	private static long nextAcc = 0;
	private static int counter = 0;
	
	MeritBank(){
		
	}
	
	
	public static void addAccountHolder(AccountHolder accountHolder) {
		if(numberOfAccountHolders == size) {
			size *= 2;
			AccountHolder[] temp = new AccountHolder[size];
			for(int i = 0; i < numberOfAccountHolders; i++) {
				temp[i] = accountHolders[i];
			}
			accountHolders = temp;
			accountHolders[numberOfAccountHolders] = accountHolder;
			numberOfAccountHolders++;
		}else {
			accountHolders[numberOfAccountHolders] = accountHolder;
			numberOfAccountHolders++;
		}
	}
	
	public static AccountHolder[] getAccountHolders() {
		return accountHolders;
	}
	
	public static CDOffering[] getCDOfferings() {
		return CDOfferings;
	}
	
	public static CDOffering getBestCDOffering(double depositAmount) {
		CDAccount temp = new CDAccount(CDOfferings[0], depositAmount);
		CDOffering best = CDOfferings[0];
		for(int i = 1; i < numberOfCDOfferings; i++) {
			if(temp.futureValue(CDOfferings[i].getTerm()) > temp.futureValue(CDOfferings[i - 1].getTerm())) {
				best = CDOfferings[i];
			}
		}
		return best;
	}
	
	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		CDAccount temp = new CDAccount(CDOfferings[0], depositAmount);
		CDOffering secondBest = CDOfferings[0];
		CDOffering best = CDOfferings[0];
		for(int i = 1; i < numberOfCDOfferings; i++) {
			if(temp.futureValue(CDOfferings[i].getTerm()) > temp.futureValue(CDOfferings[i - 1].getTerm())) {
				secondBest = best;
				best = CDOfferings[i];	
			}
		}
		return secondBest;
	}
	
	public static void clearCDOfferings() {
		CDOfferings = null;
	}
	
	public static void setCDOfferings(CDOffering[] offerings) { 
		CDOfferings = offerings;
	}
	
	public static long getNextAccountNumber() {
		return accountNumbers[numberOfAccountHolders];
	}
	
	/* =================================== Read/Write Data to file =================================== */	
	/*
	static boolean readFromFile(String fileName) throws ParseException, Exception {
		
		try {
		File file = new File("src/test/testMeritBank_good.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException("String was not parsed correctly.");
		} catch (FileNotFoundException fnf) {
			throw new FileNotFoundException("File was not found.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	*/
	
	static boolean writeToFile(String fileName) {
		
		try {
			FileWriter fr = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fr);
			File file = new File("src/test/testMeritBank_good.txt"); // test
			
			bw.write(String.valueOf(numberOfAccountHolders));
			bw.newLine();
			
			bw.write(String.valueOf(CDOfferings.length));
			bw.newLine();
			
			for(int i = 0; i < CDOfferings.length; i++) {
				bw.write(CDOfferings[i].writeToString());
				bw.newLine();
			}
			bw.write(String.valueOf(accountHolders.length));
			bw.newLine();
			
			for(int i = 0; i < accountHolders.length; i++) {
				bw.write(accountHolders[i].writeToString());
				bw.newLine();
	
				bw.write(accountHolders[i].getNumberOfCheckingAccounts());
				// Create a for loop for each Checking account
				for(int j = 0; j < accountHolders[i].getNumberOfCheckingAccounts(); j++) {
					bw.write(String.valueOf(accountHolders[i].getCheckingAccounts()[j].writeToString()));
					bw.newLine();					
				}
				// Loop for Savings Accounts
				for(int k = 0; k < accountHolders[i].getNumberOfSavingsAccounts(); k++) {
					bw.write(String.valueOf(accountHolders[i].getSavingsAccounts()[k].writeToString()));
					bw.newLine();					
				}
				// Loop for CD Accounts
				for(int m = 0; m < accountHolders[m].getNumberOfCDAccounts(); m++) {
					bw.write(String.valueOf(accountHolders[i].getCDAccounts()[m].writeToString()));
					bw.newLine();					
				}
			}
			bw.close();
			return true;		
			
		} catch (IOException e) {
			System.out.println("Invalid. Please try again.");
			return false;
		}
		
		
	}/* ============================================================================================== */
	
	// List account holders displayed in ascending order of their total balances (End of Assignment 3)
	static AccountHolder[] sortAccountHolders() {
		Arrays.sort(accountHolders);
		return accountHolders;
	}
	
	static void setNextAccountNumber(long nextAccountNumber) {
		
	}

	public static double totalBalances() {
		double total = 0.0;
		for(int i = 0; i < numberOfAccountHolders; i++) {
			total += (accountHolders[i].getTotalAccountBalances());
		}
		return total;
	}
	
	public String toString() {
		return "AccountHolders: " + accountHolders + 
				"CDOfferings: " + CDOfferings;
	}
	
}