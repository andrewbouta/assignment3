package com.meritamerica.assignment3;

public class MeritAmericaBankApp {

	public static void main(String[] args) {
		MeritBank.readFromFile("src/test/testMeritBank_good.txt");
		CDOffering[] CDOfferings = new CDOffering[5];
		
		MeritBank.setCDOfferings(CDOfferings);
		
		CDOfferings[0] = new CDOffering(1,1.8/100);
    	CDOfferings[1] = new CDOffering(2,1.9/100);
    	CDOfferings[2] = new CDOffering(3,2.0/100);
    	CDOfferings[3] = new CDOffering(5,2.5/100);
    	CDOfferings[4] = new CDOffering(10,2.2/100);
		
		AccountHolder ah1 = new AccountHolder();
		
		CheckingAccount ca1 = new CheckingAccount(1000);
		SavingsAccount sa1 = new SavingsAccount(10000);
		
		CheckingAccount ca2 = new CheckingAccount(5000);
		SavingsAccount sa2 = new SavingsAccount(50000);
		
		CheckingAccount ca3 = new CheckingAccount(50000);
		SavingsAccount sa3 = new SavingsAccount(500000);// Will not add. Constraint met.
	
		CheckingAccount ca4 = new CheckingAccount(5000);
		SavingsAccount sa4 = new SavingsAccount(50000);
		
		ah1.addCheckingAccount(ca1);
		ah1.addSavingsAccount(sa1);
		
		ah1.addCheckingAccount(ca2);
		ah1.addSavingsAccount(sa2);
		
		ah1.addCheckingAccount(ca3);
		ah1.addSavingsAccount(sa3);
		
		ah1.addCheckingAccount(ca4);
		ah1.addSavingsAccount(sa4);
		
		
		ah1.printAccountBalances();
		
		MeritBank.getCDOfferings();
		ah1.addCDAccount(MeritBank.getBestCDOffering(ah1.getCombinedBalance()), ah1.getCombinedBalance());
		
		MeritBank.addAccountHolder(ah1);
		
		AccountHolder ah2 = new AccountHolder();
		
		ah2.addCheckingAccount(1000);
		ah2.addSavingsAccount(10000);
		
		MeritBank.getCDOfferings();
		ah2.addCDAccount(MeritBank.getSecondBestCDOffering(ah2.getCombinedBalance()), ah2.getCombinedBalance());
		
		MeritBank.addAccountHolder(ah2);
		
		MeritBank.clearCDOfferings();
		
		AccountHolder ah3 = new AccountHolder();
		
		try {
			ah3.addCDAccount(MeritBank.getSecondBestCDOffering(ah3.getCombinedBalance()), ah3.getCombinedBalance());
		}catch(Exception e) {
			System.out.println("Cannot add CDAccount");
		}
		
		ah3.addCheckingAccount(1000);
		ah3.addSavingsAccount(10000);
		
		MeritBank.addAccountHolder(ah3);
		
		System.out.println(MeritBank.totalBalances());
	}
	
}
	/* Save data to file, and to be able to read the data from the file
	* 1.) Merit Bank - List of Account Holders, List of CD Offerings, Next acc number
	* 2.) CD Offering - Description, Term, Interest Rate
	* 3.) A.H. - Account Holder details, Current Balance, Interest Rate, Date acc opened
	* 4.) Checking Acc - Acc number, Current Balance, Interest Rate, Date acc opened
	* 5.) Savings Acc - Acc number, Current Balance, Interest Rate, Date acc opened
	* 6.) CD Acc - Acc number, Openeing Balance, Term, Interest rate, Date acc opened
	* 
	*Note: when reading from file, the data should overwrite the MeritBank data such that previous 
	*  data no longer exists, only the data read from the file should exist.

	Note: we will not be using Java Serialization since Merit America Bank wants other 
	(possibly non-Java) applications to be able to parse this file.

	Finally, after reading the file, Merit America Bank would like the list of account holders 
	displayed in ascending order of their total balances.
	*/
	
	
	/* Expectations
	 *  1) Functionality from prior assignments should still work except where amended for this assignment’s requirements
	 *  2) Write your own unit tests for all of the requirements in this assignment (think about edge cases)
	 *  3) Code should be readable. For example: use meaningful variable names, use proper naming conventions, properly indent code, comment your code
	 *  4) Use the “this” keyword to reference instance variables/methods
	 *  5.) Utilize exception handling (try/catch/throws) to properly handle errors


	 */
