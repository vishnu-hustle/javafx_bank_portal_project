package edu.group9.bank.pages;

import edu.group9.bank.beans.UserValueBean;

/**
 * Deletes all the instances holding previous data of customer
 * @author Group9(Ankita, Doshi Pratik, Duraipandi Vasanth, Kaur Awalpreet, Pabbathi Vishnuvardhan Reddy)
 *
 *
 */
public class ClearData {
	
	/**
	 * this method clears the old data
	 */
	public static void clear() {
		HomePage.deleteInstance();
		AccountDetails.deleteInstance();
		CashTransaction.deleteInstance();
		CustomerProfile.deleteInstance();
		FundTransfer.deleteInstance();
		UserValueBean.deleteInstance();
	}

}
