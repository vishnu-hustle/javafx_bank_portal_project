package edu.group9.bank.service;

import java.util.Map;

import edu.group9.bank.beans.AccountDetailsValueBean;
import edu.group9.bank.beans.AddAccountFormBean;
import edu.group9.bank.beans.CashTransactionFormBean;
import edu.group9.bank.beans.FundTransferFormBean;
import edu.group9.bank.beans.RemoveAccountFormBean;
import edu.group9.bank.beans.UserValueBean;
/**
 * This is an inteface for UpdateService 
  * @author Group9(Ankita, Doshi Pratik, Duraipandi Vasanth, Kaur Awalpreet, Pabbathi Vishnuvardhan Reddy)
 *
 */
public interface UpdateService {
	
	public boolean updateCustomerDetails(UserValueBean userValueBean);
	
	public Map<String, AccountDetailsValueBean> updateCashTransaction(UserValueBean userValueBean,CashTransactionFormBean cashTransactionFormBean);
	
	public Map<String, AccountDetailsValueBean> addAccount(UserValueBean userValueBean, AddAccountFormBean addAccountFormBean);
	
	public Map<String, AccountDetailsValueBean> deleteAccount(UserValueBean userValueBean, RemoveAccountFormBean removeAccountFormBean);

	public Map<String, AccountDetailsValueBean> transferAmount(UserValueBean userValueBean, FundTransferFormBean fundTransferFormBean) throws Exception;

}
