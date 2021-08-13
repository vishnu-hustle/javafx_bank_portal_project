package edu.group9.bank.service;

import edu.group9.bank.beans.RegistrationFormBean;
import edu.group9.bank.repository.RegistrationDbRepo;
/**
 * This is an Implementation for RegistrationService
 * @author Group9(Ankita, Doshi Pratik, Duraipandi Vasanth, Kaur Awalpreet, Pabbathi Vishnuvardhan Reddy)
 *
 */
public class RegistrationServiceImpl implements RegistrationService{

	/**
	 *This method is a service layer method used to register the new user
	 */
	@Override
	public boolean createNewUser(RegistrationFormBean registrationFormBean) {
		
		RegistrationDbRepo registrationDbRepo=new RegistrationDbRepo();
		registrationDbRepo.createUser(registrationFormBean);
		return true;
	}

}
