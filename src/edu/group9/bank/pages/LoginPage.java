package edu.group9.bank.pages;

import edu.group9.bank.beans.LoginForm;
import edu.group9.bank.beans.UserValueBean;
import edu.group9.bank.service.LoginService;
import edu.group9.bank.service.LoginServiceImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * This Login page sets the Login ui to the application
 * @author Group9(Ankita, Doshi Pratik, Duraipandi Vasanth, Kaur Awalpreet, Pabbathi Vishnuvardhan Reddy)
 *
 *
 */
public class LoginPage {

	private Stage primary;

	/**
	 * This Constructor sets the stage to local variable
	 * @param primaryStage
	 */
	public LoginPage(Stage primaryStage) {
		this.primary = primaryStage;
	}

	/**
	 * This method sets the Login UI to the Screen
	 */
	public void login() {

		GridPane gridPane = new GridPane();
		final Scene scene = new Scene(gridPane, 1000, 800);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(40, 40, 40, 40));
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		ColumnConstraints columnOneConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnOneConstraints.setHalignment(HPos.RIGHT);
		ColumnConstraints columnTwoConstrains = new ColumnConstraints(100, 100, Double.MAX_VALUE);
		columnTwoConstrains.setHgrow(Priority.ALWAYS);

		gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
		addUIControls(gridPane, scene);

		scene.getStylesheets().add(LoginPage.class.getResource("style.css").toExternalForm());
		this.primary.setScene(scene);

	}

	/**
	 * This method sets the LOGIN fields to the grid
	 * @param gridPane
	 * @param scene
	 */
	private void addUIControls(GridPane gridPane, Scene scene) {
		Label headerLabel = new Label("Welcome");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		gridPane.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

		Label nameLabel = new Label("UserName : ");
		gridPane.add(nameLabel, 0, 1);
		TextField nameField = new TextField();
		nameField.setPrefHeight(40);
		gridPane.add(nameField, 1, 1);

		Label passLabel = new Label("Password : ");
		gridPane.add(passLabel, 0, 2);
		PasswordField pwdInput = new PasswordField();
		pwdInput.setPrefHeight(40);
		gridPane.add(pwdInput, 1, 2);

		Hyperlink newUser = new Hyperlink("New User?");
		newUser.setUnderline(true);
		gridPane.add(newUser, 0, 4);
		Button submitButton = new Button("Submit");
		submitButton.setPrefHeight(40);
		submitButton.setDefaultButton(true);
		submitButton.setPrefWidth(100);
		gridPane.add(submitButton, 1, 4);
		GridPane.setHalignment(submitButton, HPos.RIGHT);
		GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));

		submitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (nameField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your name");
					return;
				}
				if (pwdInput.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your email id");
					return;
				}
				try {
					LoginForm loginForm = new LoginForm();
					loginForm.setUserName(nameField.getText());
					loginForm.setPassword(pwdInput.getText());
					LoginService loginService = new LoginServiceImpl();
					UserValueBean userValueBean = loginService.getUserDetails(loginForm);
					if (userValueBean != null) {
						if(userValueBean.getCustomerDetailsValueBean()!=null && userValueBean.getCustomerDetailsValueBean().getFirstName()!=null)
						{
						showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Login Successful!",
								"Welcome " + userValueBean.getCustomerDetailsValueBean().getFirstName());
						}
						HomePage hp = HomePage.getInstance();
						hp.setScene(primary, userValueBean);
					} else {
						showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Login Unsuccessful!",
								"Login Failed");
					}
				} catch (Exception e) {
					showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Login Unsuccessful!",
							"Login Failed");
				}

			}
		});

		newUser.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				RegistrationForm rf = new RegistrationForm();
				Group display = rf.getForm(primary);
				scene.setRoot(display);

			}
		});
	}
	/**
	 * This Method helps in displaying the alert
	 * @param alertType
	 * @param owner
	 * @param title
	 * @param message
	 */
	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}

}
