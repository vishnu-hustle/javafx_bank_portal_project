package edu.group9.bank.pages;

import java.util.Map.Entry;

import edu.group9.bank.beans.AccountDetailsValueBean;
import edu.group9.bank.beans.UserValueBean;
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
import javafx.scene.control.ScrollPane;
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
 * This page displays the HomePage level details in the UI
 *
 */
public class HomePage {
	private static HomePage instance = new HomePage();
	private Stage primaryStage;
	/**
	 * @return the instance if available else create a new instance
	 */
	public static HomePage getInstance() {
		if (instance == null) {
			instance = new HomePage();
		}
		return instance;
	}
	/**
	 * deletes the instance having previous data by instantiating new object
	 */
	public static void deleteInstance() {
		instance = new HomePage();
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

		scene.getStylesheets().add(HomePage.class.getResource("style.css").toExternalForm());
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
		gridPane.setPadding(new Insets(5, 0, 0, 10));
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
				setScene(primaryStage, userValueBean);

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
		for (Entry<String, AccountDetailsValueBean> entry : userValueBean.getAccountDetailsValueBean().entrySet()) {

			AccountDetailsValueBean accountDetailsValueBean = (AccountDetailsValueBean) entry.getValue();
			addAccounts(gridPane, primaryStage, i, accountDetailsValueBean.getAccountNumber(),
					accountDetailsValueBean.getIfscCode(), accountDetailsValueBean.getBranchName(),
					"$" + accountDetailsValueBean.getBalance());
			i++;
		}

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
	public void addAccounts(GridPane gridPane, Stage primaryStage, int row, String accnum, String ifscCode,
			String branchName, String bal) {
		Label accNumber = new Label(accnum);

		accNumber.setFont(Font.font("Arial", FontWeight.NORMAL, 8));
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
