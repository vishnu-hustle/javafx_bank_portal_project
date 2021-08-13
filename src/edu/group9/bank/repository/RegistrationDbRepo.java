package edu.group9.bank.repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import edu.group9.bank.beans.RegistrationFormBean;
import edu.group9.bank.config.DbConfig;
import edu.group9.bank.constants.SqlQueries;

/**
 * @author Group9(Ankita, Doshi Pratik, Duraipandi Vasanth, Kaur Awalpreet, Pabbathi Vishnuvardhan Reddy)
 *
 * RegistrationDbRepo connects with DB and helps in Inserting New User data to the DB
 *
 */
public class RegistrationDbRepo {
	
	/**
	 * This Repository takes the registrationFormBean and inserts the data to the data base
	 * @param registrationFormBean
	 * @return success/failure in inserting data
	 */
	public boolean createUser(RegistrationFormBean registrationFormBean) {
		boolean issSucess=false;
		try {
			DbConfig dbConfig=DbConfig.getInstance();
			Class.forName(dbConfig.getJdbcDriverClassName());
			Connection con = DriverManager.getConnection(dbConfig.getJdbcUrl(), dbConfig.getJdbcUserName(), dbConfig.getJdbcPassword());
			PreparedStatement stmt=con.prepareStatement(SqlQueries.CREATE_USER);
			
			stmt.setString(1,registrationFormBean.getUserName());  
			stmt.setString(2,registrationFormBean.getNewPassword());  
			stmt.setString(3,registrationFormBean.getEmail());  
			stmt.setString(4,registrationFormBean.getFirstName());  
			stmt.setString(5,registrationFormBean.getLastName()); 
			String dateString=registrationFormBean.getDateOfBirth();  
			stmt.setDate(6,java.sql.Date.valueOf(dateString));  
			stmt.setString(7,registrationFormBean.getAddress());  
			stmt.setBigDecimal(8, BigDecimal.valueOf(Long.valueOf(registrationFormBean.getPhoneNumber())));
			
			  
			int i=stmt.executeUpdate();
			if(i==1) {
				issSucess=true;
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
			issSucess=false;
			return issSucess;
		}
		
		return issSucess;
		
	}

}
