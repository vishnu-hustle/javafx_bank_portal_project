package edu.group9.bank.service;

import java.util.Map;

import edu.group9.bank.beans.AccountDetailsValueBean;
import edu.group9.bank.beans.AddAccountFormBean;
import edu.group9.bank.beans.CashTransactionFormBean;
import edu.group9.bank.beans.FundTransferFormBean;
import edu.group9.bank.beans.RemoveAccountFormBean;
import edu.group9.bank.beans.UserValueBean;
import edu.group9.bank.repository.UserDetailsRepo;

/**
 * This is an Implementation for UpdateService
 * @author Group9(Ankita, Doshi Pratik, Duraipandi Vasanth, Kaur Awalpreet, Pabbathi Vishnuvardhan Reddy)
 *
 */
public class UpdateServiceImpl implements UpdateService {

	/**
	 *This is service layer method used for updating the customer details
	 */
	@Override
	public boolean updateCustomerDetails(UserValueBean userValueBean) {

		UserDetailsRepo userDetailsRepo = new UserDetailsRepo();

		userDetailsRepo.updateCustomerDetails(userValueBean);

		return true;

	}
	/**
	 *This is service layer method used for updating the cash transaction
	 */
	@Override
	public Map<String, AccountDetailsValueBean> updateCashTransaction(UserValueBean userValueBean,
			CashTransactionFormBean cashTransactionFormBean) {
		UserDetailsRepo userDetailsRepo = new UserDetailsRepo();

		return userDetailsRepo.updateCashTransaction(userValueBean, cashTransactionFormBean);
	}
	/**
	 *This is service layer method used for deleting the customer account
	 */
	@Override
	public Map<String, AccountDetailsValueBean> deleteAccount(UserValueBean userValueBean,
			RemoveAccountFormBean removeAccountFormBean) {
		UserDetailsRepo userDetailsRepo = new UserDetailsRepo();

		return userDetailsRepo.removeAccount(userValueBean, removeAccountFormBean);
	}
	/**
	 *This is service layer method used for adding the customer account
	 */
	@Override
	public Map<String, AccountDetailsValueBean> addAccount(UserValueBean userValueBean,
			AddAccountFormBean addAccountFormBean) {
		UserDetailsRepo userDetailsRepo = new UserDetailsRepo();

		return userDetailsRepo.addAccount(userValueBean, addAccountFormBean);
	}
	/**
	 *This is service layer method used for transferring the amount
	 * @throws Exception 
	 */
	@Override
	public Map<String, AccountDetailsValueBean> transferAmount(UserValueBean userValueBean,
			FundTransferFormBean fundTransferFormBean) throws Exception {
		
		UserDetailsRepo userDetailsRepo = new UserDetailsRepo();

		return userDetailsRepo.transferAmount(userValueBean, fundTransferFormBean);
	}

}
