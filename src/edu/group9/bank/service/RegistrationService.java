package edu.group9.bank.service;

import edu.group9.bank.beans.RegistrationFormBean;


/**
 * This is an interface for RegistrationService 
 * @author Group9(Ankita, Doshi Pratik, Duraipandi Vasanth, Kaur Awalpreet, Pabbathi Vishnuvardhan Reddy)
 *
 */
public interface RegistrationService {
	
	public boolean createNewUser(RegistrationFormBean registrationFormBean);

}
