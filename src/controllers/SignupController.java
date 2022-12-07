package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import utils.ConnectionUtil;
import utils.PaneRouter;

public class SignupController implements Initializable {

	@FXML
	private Label lblErrors;

	@FXML
	private TextField newUsername;

	@FXML
	private TextField newPassword;

	@FXML
	private TextField firstName;

	@FXML
	private TextField lastName;

	@FXML
	private TextField email;

	@FXML
	private Button btnSignup;

	@FXML
	private RadioButton isAdminSignup;

	/// --
	Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@FXML
	public void handleSignup(MouseEvent event) {
		String username = newUsername.getText();
		String password = newPassword.getText();
		String fname = firstName.getText();
		String lname = lastName.getText();
		String emailId = email.getText();
		boolean isAdmin = isAdminSignup.isSelected();

		String dbName = isAdmin ? "secondshop.admins" : "secondshop.users";
		String sqlQuery = "INSERT INTO " + dbName + " (username, password, firstname, lastname, email) VALUES "
				+ " (?, ?, ?,?, ?);";
		if (username.isEmpty() || password.isEmpty() || fname.isEmpty() || lname.isEmpty() || emailId.isEmpty()) {
			setLblError(Color.TOMATO, "Empty fields exist. All are compulsory values");
		} else {
			signupUser(username, password, fname, lname, emailId, dbName, sqlQuery);
			PaneRouter.route(this, event, "/fxml/LoginPane.fxml");
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		if (con == null) {
			lblErrors.setTextFill(Color.TOMATO);
			lblErrors.setText("Server Error : Check");
		} else {
			lblErrors.setTextFill(Color.GREEN);
			lblErrors.setText("Server is up : Good to go");
		}
	}

	public SignupController() {
		con = ConnectionUtil.connectToDB();
	}

	private void signupUser(String username, String password, String fname, String lname, String emailId, String dbName,
			String sqlQuery) {
		try {
			preparedStatement = con.prepareStatement(sqlQuery);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, fname);
			preparedStatement.setString(4, lname);
			preparedStatement.setString(5, emailId);
			int isRegistered = preparedStatement.executeUpdate();
			System.out.println("ResultSet: " + isRegistered);
			if (isRegistered > 0) {
				setLblError(Color.GREEN, "Sign up Successful..Redirecting..");
				

			} else {
				setLblError(Color.TOMATO, "There was a problem while registering User. Please try after sometime.");
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();

		}
	}

	private void setLblError(Color color, String text) {
		lblErrors.setTextFill(color);
		lblErrors.setText(text);
		System.out.println(text);
	}
}
