package edu.group9.bank.pages;

import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.group9.bank.beans.AccountDetailsValueBean;
import edu.group9.bank.beans.AddAccountFormBean;
import edu.group9.bank.beans.CashTransactionFormBean;
import edu.group9.bank.beans.FundTransferFormBean;
import edu.group9.bank.beans.UserValueBean;
import edu.group9.bank.service.UpdateService;
import edu.group9.bank.service.UpdateServiceImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
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
 * This page displays the FundTransfer level details in the UI
 *
 */
public class FundTransfer {
	private Stage primaryStage;

	private static FundTransfer instance = new FundTransfer();
	/**
	 * @return the instance if available else create a new instance
	 */
	public static FundTransfer getInstance() {
		if (instance == null) {
			instance = new FundTransfer();
		}
		return instance;
	}
	/**
	 * deletes the instance having previous data by instantiating new object
	 */
	public static void deleteInstance() {
		instance = new FundTransfer();
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

		scene.getStylesheets().add(FundTransfer.class.getResource("style.css").toExternalForm());
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
		addBodyUIControls(gridPane, primaryStage,userValueBean);
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
				ClearData.clear();
				showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Logout Successful!",
						"Logout Successful!");
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
		Label headerLabel = new Label("Accounts");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));
		headerLabel.setUnderline(true);
		gridPane.add(headerLabel, 0, 2);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets(10, 0, 10, 0));

		Label headerLabel2 = new Label("IFSC CODE");
		headerLabel2.setFont(Font.font("Arial", FontWeight.BOLD, 10));
		headerLabel2.setUnderline(true);
		gridPane.add(headerLabel2, 1, 2);
		GridPane.setHalignment(headerLabel2, HPos.CENTER);
		GridPane.setMargin(headerLabel2, new Insets(10, 0, 10, 0));

		Label headerLabel3 = new Label("Branch Name");
		headerLabel3.setFont(Font.font("Arial", FontWeight.BOLD, 10));
		headerLabel3.setUnderline(true);
		gridPane.add(headerLabel3, 2, 2);
		GridPane.setHalignment(headerLabel3, HPos.CENTER);
		GridPane.setMargin(headerLabel3, new Insets(10, 0, 10, 0));

		Label headerLabel4 = new Label("Balance");
		headerLabel4.setFont(Font.font("Arial", FontWeight.BOLD, 10));
		headerLabel4.setUnderline(true);
		gridPane.add(headerLabel4, 3, 2);
		GridPane.setHalignment(headerLabel4, HPos.CENTER);
		GridPane.setMargin(headerLabel4, new Insets(10, 0, 10, 0));

		int i = 3;
		ToggleGroup tgAccounts = new ToggleGroup();
		ToggleGroup tgTransfers = new ToggleGroup();

		for (Entry<String, AccountDetailsValueBean> entry : userValueBean.getAccountDetailsValueBean().entrySet()) {

			AccountDetailsValueBean accountDetailsValueBean = (AccountDetailsValueBean) entry.getValue();
			addAccounts(gridPane, primaryStage, i, tgAccounts, accountDetailsValueBean.getAccountNumber(),
					accountDetailsValueBean.getIfscCode(), accountDetailsValueBean.getBranchName(),
					"$" + accountDetailsValueBean.getBalance());
			i++;
		}
		final int rownum = i;
		FundTransferFormBean fundTransferFormBean=new FundTransferFormBean();
		tgAccounts.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				RadioButton rb = (RadioButton) tgAccounts.getSelectedToggle();
				if (rb != null) {
					String accountNumber = rb.getText();
					fundTransferFormBean.setAccountNumber(accountNumber);
					RadioButton withinAccount = new RadioButton("Within Accounts");
					withinAccount.setFont(Font.font("Arial", FontWeight.BOLD, 24));
					withinAccount.setToggleGroup(tgTransfers);
					gridPane.add(withinAccount, 1, rownum,2,1);
					

					RadioButton otherAccount = new RadioButton("Other Account");
					otherAccount.setFont(Font.font("Arial", FontWeight.BOLD, 24));
					otherAccount.setToggleGroup(tgTransfers);
					gridPane.add(otherAccount, 3, rownum,2,1);
				}
			}
		});
		
		tgTransfers.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				RadioButton rb = (RadioButton) tgTransfers.getSelectedToggle();
				if (rb != null) {
					String type = rb.getText();
					if(type.equalsIgnoreCase("Within Accounts")) {


						transferUI(gridPane, rownum,true);
					
					}else {
						transferUI(gridPane, rownum,false);
					}
				}
			}

			public void transferUI(GridPane gridPane, final int rownum, boolean isWithin) {
				Label accNumberNew = new Label("Account Number : ");
				gridPane.add(accNumberNew, 0, rownum + 2);
				TextField accNumberNewField = new TextField();
				accNumberNewField.setPrefHeight(40);
				gridPane.add(accNumberNewField, 1, rownum + 2);

				Label ifscNew = new Label("IFSC Code : ");
				gridPane.add(ifscNew, 0, rownum + 3);
				TextField ifscNewField = new TextField();
				ifscNewField.setPrefHeight(40);
				gridPane.add(ifscNewField, 1, rownum + 3);

				Label amount = new Label("Amount : ");
				gridPane.add(amount, 0, rownum + 4);
				TextField amountField = new TextField();
				amountField.setPrefHeight(40);
				gridPane.add(amountField, 1, rownum + 4);

				Button submitButton = new Button("Submit");
				submitButton.setPrefHeight(40);
				submitButton.setDefaultButton(true);
				submitButton.setPrefWidth(100);
				gridPane.add(submitButton, 0, rownum + 6, 2, 1);
				GridPane.setHalignment(submitButton, HPos.RIGHT);
				GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));
				submitButton.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						if (accNumberNewField.getText().isEmpty()) {
							showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
									"Please enter your New Account number");
							return;
						} else {

							String numRegex = "^[0-9]*$";
							Pattern numPattern = Pattern.compile(numRegex);
							Matcher numMatcher = numPattern.matcher(accNumberNewField.getText());
							if (!numMatcher.matches()) {
								showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
										"Please enter your valid New Account number");
								return;
							}
						}
						String textRegex = "^[a-zA-Z]*$";
						Pattern textPattern = Pattern.compile(textRegex);
						if (ifscNewField.getText().isEmpty()) {
							showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
									"Please enter your new IFSC code");
							return;
						} 

						if (amountField.getText().isEmpty()) {
							showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
									"Please enter your new Branch name");
							return;
						} else {
							String numRegex = "^(\\d+(\\.\\d{0,2})?|\\.?\\d{1,2})$";
							Pattern numPattern = Pattern.compile(numRegex);
							Matcher numMatcher = numPattern.matcher(amountField.getText());
							if (!numMatcher.matches()) {
								showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
										"Please enter your valid credit amount");
								return;
							}
							Double balance=userValueBean.getAccountDetailsValueBean().get(fundTransferFormBean.getAccountNumber()).getBalance();
							if(balance-Double.parseDouble(amountField.getText())<0) {
								showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
										"Transfer amount should not be greater than current balance");	
								return;
							}
						}
						try {
							fundTransferFormBean.setTransferAccountNumber(accNumberNewField.getText());
							fundTransferFormBean.setTransferIfscCode(ifscNewField.getText());
							fundTransferFormBean.setTransferAmount(Double.parseDouble(amountField.getText()));
							fundTransferFormBean.setWithin(isWithin);
							
							UpdateService updateService = new UpdateServiceImpl();

							userValueBean.setAccountDetailsValueBean(
									updateService.transferAmount(userValueBean, fundTransferFormBean));
							HomePage hp = HomePage.getInstance();
							hp.setScene(primaryStage, userValueBean);
							showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(),
									"Transaction done Successfully!", "Transaction done Successfully! ");

						} catch (Exception e) {
							e.printStackTrace();
							showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(),
									"Transaction failed!", "Transaction failed!(check Transfer account details/ Try again)");
						}
					}
				});
			}
		});

	}
	/**
	 * This method adds the accounts of the customer to the UI
	 * @param gridPane
	 * @param primaryStage
	 * @param row
	 * @param tg
	 * @param accnum
	 * @param ifscCode
	 * @param branchName
	 * @param bal
	 */
	public void addAccounts(GridPane gridPane, Stage primaryStage, int row, ToggleGroup tg, String accnum,
			String ifscCode, String branchName, String bal) {

		RadioButton accNumber = new RadioButton(accnum);
		accNumber.setToggleGroup(tg);
		accNumber.setFont(Font.font("Arial", FontWeight.NORMAL, 24));
		GridPane.setHalignment(accNumber, HPos.CENTER);
		GridPane.setMargin(accNumber, new Insets(10, 0, 10, 0));
		gridPane.add(accNumber, 0, row);

		Label ifsc = new Label(ifscCode);

		ifsc.setFont(Font.font("Arial", FontWeight.NORMAL, 8));
		GridPane.setHalignment(ifsc, HPos.CENTER);
		GridPane.setMargin(ifsc, new Insets(10, 0, 10, 0));
		gridPane.add(ifsc, 1, row);

		Label branch = new Label(branchName);

		branch.setFont(Font.font("Arial", FontWeight.NORMAL, 8));
		GridPane.setHalignment(branch, HPos.CENTER);
		GridPane.setMargin(branch, new Insets(10, 0, 10, 0));
		gridPane.add(branch, 2, row);

		Label accBal = new Label(bal);

		accBal.setFont(Font.font("Arial", FontWeight.NORMAL, 8));
		GridPane.setHalignment(accBal, HPos.CENTER);
		GridPane.setMargin(accBal, new Insets(10, 0, 10, 0));
		gridPane.add(accBal, 3, row);

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
