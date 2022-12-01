package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class MainController {
	@FXML
	private Label lblLogin;

	@FXML
	private TextField txtUsername;

	@FXML
	private TextField txtPassword;

	@FXML
	private RadioButton userbutton;

	@FXML
	private RadioButton adminbutton;

	public void Login(ActionEvent event) throws IOException {
		Alert alert;
		// set toggle group to confirm only one button to be selected primarily
		final ToggleGroup group = new ToggleGroup();
		userbutton.setToggleGroup(group);
		userbutton.setSelected(true);
		adminbutton.setToggleGroup(group);

		// admin login
		if (txtUsername.getText().equals("admin") && txtPassword.getText().equals("pass") && adminbutton.isSelected()) {
			lblLogin.setText("Admin Login Success");
			Stage primaryStage = new Stage();

			// if successfully login, open admin system
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("application/AdminSystem.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root, 500, 400);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hi! There is Admin System");
			primaryStage.show();
		}

		// user login
		else if (txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")
				&& userbutton.isSelected()) {
			lblLogin.setText(" User Login Success");
			System.out.println("-----username: "+ txtUsername);
			System.out.println("-----password: "+ txtPassword);
			Stage primaryStage = new Stage();

			// if successfully login, open user system
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("application/UserSystem.fxml"));
			System.out.println("-----loader: "+ loader.toString());
			Parent root = loader.load();
			Scene scene = new Scene(root, 500, 400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hi! There is User System");
			primaryStage.show();
		}

		else {
			// alert warning page for wrong login
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Login failed");
			alert.setContentText("");
			alert.showAndWait();
			lblLogin.setText("Login Failed");
		}
	}

	public void Cancel(ActionEvent event) throws IOException {
		Alert alert = null;
		// alert information for successfully login
		if (txtUsername.getText() != null || txtPassword.getText() != null) {
			alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("login cancled successfully");
			alert.setTitle("information");
			alert.showAndWait();
			lblLogin.setText("Login canceled");
			txtUsername.setText("");
			txtPassword.setText("");
		} else {
			// alert information for invalid input
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("information");
			alert.setContentText("Invalid input");
			alert.showAndWait();
			lblLogin.setText("Invalid input");
		}
	}
}
