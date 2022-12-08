package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.User;
import utils.ConnectionUtil;
import utils.PaneRouter;

public class LoginController implements Initializable {
	@FXML
	private Label lblErrors;

	@FXML
	private TextField txtUsername;

	@FXML
	private TextField txtPassword;

	@FXML
	private Button btnSignin;

	
	@FXML
	private Button btnSignupRouter;

	@FXML
	private Button btnAdmin;

	/// --
	Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@FXML
	public void handleSignin(MouseEvent event) {

		String routingDashboard = "";
		if (event.getSource() == btnSignin) {
			// login here
			if (logIn(false).equals("Success")) {
				routingDashboard = "/fxml/UserDashboard.fxml";
				PaneRouter.route(this, event, routingDashboard);

			}
		} else if (event.getSource() == btnAdmin) {
			System.out.println("Inside btnAdmin");
			if (logIn(true).equals("Success")) {
				routingDashboard = "/fxml/AdminDashBoard.fxml";
				PaneRouter.route(this, event, routingDashboard);
			}
		}else {
			setLblError(Color.TOMATO, "Invalid Credentials");
		}
	}

	@FXML
	public void routeToSignup(MouseEvent event) {
		try {
//			Node node = (Node) event.getSource();
//			Stage stage = (Stage) btnSignupRouter.getScene().getWindow();
////            stage.setMaximized(true);
//			stage.close();
//			Stage newStage = new Stage();
//			Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/SignupPane.fxml")));
//			newStage.setScene(scene);
//			newStage.show();
			PaneRouter.route(this, event, "/fxml/SignupPane.fxml");

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
		if (con == null) {
			lblErrors.setTextFill(Color.TOMATO);
			lblErrors.setText("Server Error : Check");
		} else {
			lblErrors.setTextFill(Color.GREEN);
			lblErrors.setText("Server is up : Good to go");
		}
	}

	public LoginController() {
		con = ConnectionUtil.connectToDB();
	}

	// use string to check for status
	private String logIn(boolean isAdmin) {
		String status = "Success";
		String username = txtUsername.getText();
		String password = txtPassword.getText();
		if (username.isEmpty() || password.isEmpty()) {
			setLblError(Color.TOMATO, "Empty credentials");
			status = "Error";
		} else {
			// query
			String sqlQuery = isAdmin ? "SELECT * FROM admins Where username = ? and password = ?"
					: "SELECT * FROM users Where username = ? and password = ?";

			try {
				preparedStatement = con.prepareStatement(sqlQuery);
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					setLblError(Color.TOMATO, "Enter Correct Email/Password");
					status = "Error";
				} else {
					System.out.println(resultSet.toString());
					setLblError(Color.GREEN, "Login Successful..Redirecting..");
				}
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());
				status = "Exception";
			}
		}

		return status;
	}

	private void setLblError(Color color, String text) {
		lblErrors.setTextFill(color);
		lblErrors.setText(text);
		System.out.println(text);
	}
	

}
