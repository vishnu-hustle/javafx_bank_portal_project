package edu.group9.bank.service;

import edu.group9.bank.beans.LoginForm;
import edu.group9.bank.beans.UserValueBean;

/**
 * This is an inteface for login Service
 * @author Group9(Ankita, Doshi Pratik, Duraipandi Vasanth, Kaur Awalpreet, Pabbathi Vishnuvardhan Reddy)
 *
 *
 */
public interface LoginService {

	public UserValueBean getUserDetails(LoginForm loginForm);
}
