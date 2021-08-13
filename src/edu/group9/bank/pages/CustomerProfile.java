package edu.group9.bank.pages;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.group9.bank.beans.CustomerDetailsValueBean;
import edu.group9.bank.beans.UserValueBean;
import edu.group9.bank.service.UpdateService;
import edu.group9.bank.service.UpdateServiceImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * @author Group9(Ankita, Doshi Pratik, Duraipandi Vasanth, Kaur Awalpreet, Pabbathi Vishnuvardhan Reddy)
 *
 * This page displays the CustomerProfile level details in the UI
 *
 */
public class CustomerProfile {
	private Stage primaryStage;

	private static CustomerProfile instance = new CustomerProfile();
	/**
	 * @return the instance if available else create a new instance
	 */
	public static CustomerProfile getInstance() {
		if (instance == null) {
			instance = new CustomerProfile();
		}
		return instance;
	}
	/**
	 * deletes the instance having previous data by instantiating new object
	 */
	public static void deleteInstance() {
		instance = new CustomerProfile();
	}
	/**
	 * This method set the UI scene with the required feilds
	 * @param primaryStage
	 * @param userValueBean
	 */
	public void setScene(Stage primaryStage, UserValueBean userValueBean) {
		this.primaryStage = primaryStage;

		GridPane gridPane = new GridPane();
		ScrollPane scrollPane = new ScrollPane(gridPane);
		scrollPane.setFitToWidth(true);
		scrollPane.setMaxHeight(600);
		scrollPane.setMaxWidth(1500);
		scrollPane.setMinSize(0, 0);
		scrollPane.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		Group childDisplay = new Group(scrollPane);
		final Scene scene = new Scene(childDisplay, 1500, 600);

		setGrid(primaryStage, gridPane, userValueBean);
		childDisplay.getChildren().add(gridPane);
		scene.setRoot(childDisplay);

		scene.getStylesheets().add(CustomerProfile.class.getResource("style.css").toExternalForm());
		primaryStage.setScene(scene);
	}
	/**
	 * This method sets the grid of the UI with required elements
	 * @param primaryStage
	 * @param gridPane
	 * @param userValueBean
	 */
	public void setGrid(Stage primaryStage, GridPane gridPane, UserValueBean userValueBean) {
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(5, 0, 20, 10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		ColumnConstraints columnOneConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnOneConstraints.setHalignment(HPos.RIGHT);
		ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnTwoConstrains.setHgrow(Priority.ALWAYS);
		ColumnConstraints columnThreeConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnThreeConstrains.setHgrow(Priority.ALWAYS);
		ColumnConstraints columnfourConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnfourConstrains.setHgrow(Priority.ALWAYS);
		ColumnConstraints columnFiveConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnFiveConstrains.setHgrow(Priority.ALWAYS);
		ColumnConstraints columnSixConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnFiveConstrains.setHgrow(Priority.ALWAYS);
		gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains, columnThreeConstrains,
				columnfourConstrains, columnFiveConstrains, columnSixConstrains);
		addMenuUIControls(gridPane, primaryStage, userValueBean);
		addBodyUIControls(gridPane, primaryStage, userValueBean);
	}
	/**
	 * This method adds the MENU buttons to the UI
	 * @param gridPane
	 * @param primaryStage
	 * @param userValueBean
	 */
	private void addMenuUIControls(GridPane gridPane, Stage primaryStage, UserValueBean userValueBean) {
		Button homeButton = new Button("Home");
		homeButton.setPrefHeight(40);
		homeButton.setDefaultButton(true);
		homeButton.setPrefWidth(150);
		gridPane.add(homeButton, 0, 1);
		GridPane.setHalignment(homeButton, HPos.CENTER);
		GridPane.setMargin(homeButton, new Insets(20, 0, 20, 0));
		homeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				HomePage hp = HomePage.getInstance();
				hp.setScene(primaryStage, userValueBean);

			}
		});

		Button cpButton = new Button("Customer Profile");
		cpButton.setPrefHeight(40);
		cpButton.setDefaultButton(true);
		cpButton.setPrefWidth(150);
		gridPane.add(cpButton, 1, 1);
		GridPane.setHalignment(cpButton, HPos.CENTER);
		GridPane.setMargin(cpButton, new Insets(20, 0, 20, 0));
		cpButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				CustomerProfile cp = CustomerProfile.getInstance();
				cp.setScene(primaryStage, userValueBean);
			}
		});

		Button accDetailsButton = new Button("Account Details");
		accDetailsButton.setPrefHeight(40);
		accDetailsButton.setDefaultButton(true);
		accDetailsButton.setPrefWidth(150);
		gridPane.add(accDetailsButton, 2, 1);
		GridPane.setHalignment(accDetailsButton, HPos.CENTER);
		GridPane.setMargin(accDetailsButton, new Insets(20, 0, 20, 0));
		accDetailsButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				AccountDetails ad = AccountDetails.getInstance();
				ad.setScene(primaryStage, userValueBean);
			}
		});

		Button cashTransferButton = new Button("Cash Transaction");
		cashTransferButton.setPrefHeight(40);
		cashTransferButton.setDefaultButton(true);
		cashTransferButton.setPrefWidth(150);
		gridPane.add(cashTransferButton, 3, 1);
		GridPane.setHalignment(cashTransferButton, HPos.CENTER);
		GridPane.setMargin(cashTransferButton, new Insets(20, 0, 20, 0));
		cashTransferButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				CashTransaction ct = CashTransaction.getInstance();
				ct.setScene(primaryStage, userValueBean);
			}
		});

		Button fundTransferButton = new Button("Fund Transfer");
		fundTransferButton.setPrefHeight(40);
		fundTransferButton.setDefaultButton(true);
		fundTransferButton.setPrefWidth(150);
		gridPane.add(fundTransferButton, 4, 1);
		GridPane.setHalignment(fundTransferButton, HPos.CENTER);
		GridPane.setMargin(fundTransferButton, new Insets(20, 0, 20, 0));

		fundTransferButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				FundTransfer ft = FundTransfer.getInstance();
				ft.setScene(primaryStage, userValueBean);
			}
		});

		Button logout = new Button("Logout");
		logout.setPrefHeight(40);
		logout.setDefaultButton(true);
		logout.setPrefWidth(150);
		gridPane.add(logout, 5, 1);
		GridPane.setHalignment(logout, HPos.CENTER);
		GridPane.setMargin(logout, new Insets(20, 0, 20, 0));

		logout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Logout Successful!",
						"Logout Successful!");
				ClearData.clear();
				LoginPage lp = new LoginPage(primaryStage);
				lp.login();

			}

		});
	}
	/**
	 * This Method add the body level elements to the GRID
	 * @param gridPane
	 * @param primaryStage
	 * @param userValueBean
	 */
	private void addBodyUIControls(GridPane gridPane, Stage primaryStage, UserValueBean userValueBean) {
		Label headerLabel = new Label("");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		gridPane.add(headerLabel, 0, 2, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

		Label firstNameLabel = new Label("First Name : ");
		gridPane.add(firstNameLabel, 1, 3);
		TextField firstNameField = new TextField();
		firstNameField.setPrefHeight(40);
		gridPane.add(firstNameField, 2, 3);

		Label lastNameLabel = new Label("Last Name : ");
		gridPane.add(lastNameLabel, 1, 4);
		TextField lastNameField = new TextField();
		lastNameField.setPrefHeight(40);
		gridPane.add(lastNameField, 2, 4);

		Label addressLabel = new Label("Address : ");
		gridPane.add(addressLabel, 1, 5);
		TextField addressField = new TextField();
		addressField.setPrefHeight(40);
		gridPane.add(addressField, 2, 5);

		Label dateOfBirth = new Label("Date Of Birth : ");
		gridPane.add(dateOfBirth, 1, 6);
		DatePicker dateOfBirthField = new DatePicker();
		dateOfBirthField.setDayCellFactory(param -> new DateCell() {
			@Override
			public void updateItem(LocalDate date, boolean empty) {
				super.updateItem(date, empty);
				setDisable(empty || date.compareTo(LocalDate.now()) > 0);
			}
		});
		dateOfBirthField.setPrefHeight(40);
		gridPane.add(dateOfBirthField, 2, 6);

		Label emailLabel = new Label("Email ID : ");
		gridPane.add(emailLabel, 1, 7);
		TextField emailField = new TextField();
		emailField.setPrefHeight(40);
		gridPane.add(emailField, 2, 7);

		Label userNameLabel = new Label("Username : ");
		gridPane.add(userNameLabel, 1, 8);
		TextField userNameField = new TextField();
		userNameField.setPrefHeight(40);
		gridPane.add(userNameField, 2, 8);

		Label phoneNumberLabel = new Label("Phone Number : ");
		gridPane.add(phoneNumberLabel, 1, 9);
		TextField phoneNumberFeild = new TextField();
		phoneNumberFeild.setPrefHeight(40);
		gridPane.add(phoneNumberFeild, 2, 9);

		Button submitButton = new Button("Update");
		submitButton.setPrefHeight(40);
		submitButton.setDefaultButton(true);
		submitButton.setPrefWidth(100);
		gridPane.add(submitButton, 0, 10, 3, 1);
		GridPane.setHalignment(submitButton, HPos.RIGHT);
		GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));
		CustomerDetailsValueBean customerProfile = (CustomerDetailsValueBean) userValueBean
				.getCustomerDetailsValueBean();
		firstNameField.setText(customerProfile.getFirstName());
		lastNameField.setText(customerProfile.getLastName());
		addressField.setText(customerProfile.getAddress());
		
		
		LocalDate lDate = LocalDate.parse(customerProfile.getDateOfBirth());
		dateOfBirthField.setValue(lDate);
		emailField.setText(customerProfile.getEmail());
		userNameField.setText(customerProfile.getUserName());
		phoneNumberFeild.setText(customerProfile.getPhoneNumber());

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
					customerProfile.setFirstName(firstNameField.getText());
					customerProfile.setLastName(lastNameField.getText());
					customerProfile.setAddress(addressField.getText());
					customerProfile.setDateOfBirth(dateOfBirthField.getValue().toString());
					customerProfile.setEmail(emailField.getText());
					customerProfile.setUserName(userNameField.getText());
					customerProfile.setPhoneNumber(phoneNumberFeild.getText());
					userValueBean.setCustomerDetailsValueBean(customerProfile);
					UpdateService updateService = new UpdateServiceImpl();
					if (updateService.updateCustomerDetails(userValueBean)) {
						HomePage hp = HomePage.getInstance();
						hp.setScene(primaryStage, userValueBean);
						showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(),
								"Updated Successfully!", "Updated Successfully! " + firstNameField.getText());
					} else {
						showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Update failed!",
								"Update failed!");
					}
				} catch (Exception e) {
					e.printStackTrace();
					showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Update failed!",
							"Update failed!");
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
