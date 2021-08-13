package edu.group9.bank.service;

import edu.group9.bank.beans.LoginForm;
import edu.group9.bank.beans.UserValueBean;
import edu.group9.bank.repository.UserDetailsRepo;

/**
 * This is an Implementation for login Service
 * @author Group9(Ankita, Doshi Pratik, Duraipandi Vasanth, Kaur Awalpreet, Pabbathi Vishnuvardhan Reddy)
 *
 */
public class LoginServiceImpl implements LoginService {
	/**
	 *This method is a service layer method used to retreive login details
	 */
	@Override
	public UserValueBean getUserDetails(LoginForm loginForm) {
		UserDetailsRepo userDetailsRepo=new UserDetailsRepo();
		
		return userDetailsRepo.fetchUserDetails(loginForm);
	}

}
