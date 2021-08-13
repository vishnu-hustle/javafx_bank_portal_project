package edu.group9.bank.pages;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.group9.bank.beans.RegistrationFormBean;
import edu.group9.bank.service.RegistrationService;
import edu.group9.bank.service.RegistrationServiceImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
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
 * RegistrationForm sets the form to the UI
 * @author Group9(Ankita, Doshi Pratik, Duraipandi Vasanth, Kaur Awalpreet, Pabbathi Vishnuvardhan Reddy)
 *
 *
 */
public class RegistrationForm {

	/**
	 * Sets the form elements to the group
	 * @param primaryStage
	 * @return Group
	 */
	public Group getForm(Stage primaryStage) {
		Group childDisplay = new Group();
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(40, 40, 40, 40));
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		ColumnConstraints columnOneConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnOneConstraints.setHalignment(HPos.RIGHT);
		ColumnConstraints columnTwoConstrains = new ColumnConstraints(300, 300, Double.MAX_VALUE);
		columnTwoConstrains.setHgrow(Priority.ALWAYS);

		gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
		addUIControls(gridPane, primaryStage);
		childDisplay.getChildren().add(gridPane);
		return childDisplay;
	}
	/**
	 * This method sets the regestration fields to the grid
	 * @param gridPane
	 * @param scene
	 */
	private void addUIControls(GridPane gridPane, Stage primaryStage) {
		Label headerLabel = new Label("Registration Form");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		gridPane.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

		Label firstNameLabel = new Label("First Name : ");
		gridPane.add(firstNameLabel, 0, 1);
		TextField firstNameField = new TextField();
		firstNameField.setPrefHeight(40);
		gridPane.add(firstNameField, 1, 1);

		Label lastNameLabel = new Label("Last Name : ");
		gridPane.add(lastNameLabel, 0, 2);
		TextField lastNameField = new TextField();
		lastNameField.setPrefHeight(40);
		gridPane.add(lastNameField, 1, 2);

		Label addressLabel = new Label("Address : ");
		gridPane.add(addressLabel, 0, 3);
		TextField addressField = new TextField();
		addressField.setPrefHeight(40);
		gridPane.add(addressField, 1, 3);

		Label dateOfBirth = new Label("Date Of Birth : ");
		gridPane.add(dateOfBirth, 0, 4);
		DatePicker dateOfBirthField = new DatePicker();
		dateOfBirthField.setDayCellFactory(param -> new DateCell() {
			@Override
			public void updateItem(LocalDate date, boolean empty) {
				super.updateItem(date, empty);
				setDisable(empty || date.compareTo(LocalDate.now()) > 0);
			}
		});
		dateOfBirthField.setPrefHeight(40);
		gridPane.add(dateOfBirthField, 1, 4);

		Label emailLabel = new Label("Email ID : ");
		gridPane.add(emailLabel, 0, 5);
		TextField emailField = new TextField();
		emailField.setPrefHeight(40);
		gridPane.add(emailField, 1, 5);

		Label userNameLabel = new Label("Username : ");
		gridPane.add(userNameLabel, 0, 6);
		TextField userNameField = new TextField();
		userNameField.setPrefHeight(40);
		gridPane.add(userNameField, 1, 6);

		Label newPasswordLabel = new Label("New Password : ");
		gridPane.add(newPasswordLabel, 0, 7);
		PasswordField newPasswordField = new PasswordField();
		newPasswordField.setPrefHeight(40);
		gridPane.add(newPasswordField, 1, 7);

		Label confirmPasswordLabel = new Label("Confirm Password : ");
		gridPane.add(confirmPasswordLabel, 0, 8);
		PasswordField confirmPasswordField = new PasswordField();
		confirmPasswordField.setPrefHeight(40);
		gridPane.add(confirmPasswordField, 1, 8);

		Label phoneNumberLabel = new Label("Phone Number : ");
		gridPane.add(phoneNumberLabel, 0, 9);
		TextField phoneNumberFeild = new TextField();
		phoneNumberFeild.setPrefHeight(40);
		gridPane.add(phoneNumberFeild, 1, 9);

		Button submitButton = new Button("Submit");
		submitButton.setPrefHeight(40);
		submitButton.setDefaultButton(true);
		submitButton.setPrefWidth(100);
		gridPane.add(submitButton, 0, 10, 2, 1);
		GridPane.setHalignment(submitButton, HPos.RIGHT);
		GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));

		submitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			
				String textRegex = "^[a-zA-Z]*$";
				Pattern textPattern = Pattern.compile(textRegex);
				if (firstNameField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your First name");
					return;
				} else {
					Matcher textMatcher = textPattern.matcher(firstNameField.getText());
					if (!textMatcher.matches()) {
						showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
								"Please enter your valid First name");
						return;
					}
				}
				if (lastNameField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your Last name");
					return;
				} else {
					Matcher textMatcher = textPattern.matcher(lastNameField.getText());
					if (!textMatcher.matches()) {
						showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
								"Please enter your valid last name");
						return;
					}
				}
				if (addressField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your address");
					return;
				}
				LocalDate dateValue = dateOfBirthField.getValue();
				if (dateValue == null || dateValue.toString().equals("")) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your date of Birth");
					return;
				}
				if (emailField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your email id");
					return;
				} else {

					String emailRegex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
					Pattern emailPattern = Pattern.compile(emailRegex);
					Matcher emailMatcher = emailPattern.matcher(emailField.getText());
					if (!emailMatcher.matches()) {
						showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
								"Please enter your valid email id");
						return;
					}

				}
				if (userNameField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your email id");
					return;
				}
				if (newPasswordField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter a new password");
					return;
				}
				if (confirmPasswordField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Confirm feild should not be empty");
					return;
				} else {
					if (!newPasswordField.getText().equals(confirmPasswordField.getText())) {
						showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
								"Passwords don't match, please reneter");
						return;
					}
				}

				if (phoneNumberFeild.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your Phone Number");
					return;
				} else {

					String numRegex = "^[0-9]*$";
					Pattern numPattern = Pattern.compile(numRegex);
					Matcher phoneMatcher = numPattern.matcher(phoneNumberFeild.getText());
					if (!phoneMatcher.matches() || phoneNumberFeild.getText().length() != 10) {
						showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
								"Please enter your 10 digits valid phone number");
						return;
					}
				}
				try {
					
					RegistrationFormBean registrationFormBean = new RegistrationFormBean();
					registrationFormBean.setFirstName(firstNameField.getText());
					registrationFormBean.setLastName(lastNameField.getText());
					registrationFormBean.setAddress(addressField.getText());
					registrationFormBean.setDateOfBirth(dateOfBirthField.getValue().toString());
					registrationFormBean.setEmail(emailField.getText());
					registrationFormBean.setUserName(userNameField.getText());
					registrationFormBean.setNewPassword(newPasswordField.getText());
					registrationFormBean.setPhoneNumber(phoneNumberFeild.getText());
					RegistrationService registrationService = new RegistrationServiceImpl();
					if (registrationService.createNewUser(registrationFormBean)) {
						LoginPage lp = new LoginPage(primaryStage);
						lp.login();
						showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(),
								"Registration Successful!",
								"Registration Successful! Login again " + firstNameField.getText());
					} else {
						showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(),
								"Registration Unsuccessful!", "Registration Unsuccessful! Try again after some time");
					}
				} catch (Exception e) {
					e.printStackTrace();
					showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(),
							"Registration Unsuccessful!", "Registration Unsuccessful! Try again after some time");
				}

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
