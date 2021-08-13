package edu.group9.bank;

import edu.group9.bank.config.DbConfig;
import edu.group9.bank.pages.LoginPage;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * This is the Main class from where application get started
 * @author Group9(Ankita, Doshi Pratik, Duraipandi Vasanth, Kaur Awalpreet, Pabbathi Vishnuvardhan Reddy)
 *
 *
 */
public class StartFx extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		LoginPage login=new LoginPage(primaryStage);
		login.login();
		primaryStage.setTitle("BANK PORTAL");   
	        primaryStage.show();  
	}

	
	public static void main(String[] args) {
		//DbConfig.setInstance("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@localhost:1521:xe","system", "root");
		DbConfig.setInstance("oracle.jdbc.driver.OracleDriver",args[0],args[1], args[2]);
		launch(args);
	}
	
}
