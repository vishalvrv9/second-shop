package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
	@FXML
	private Label lblLogin;

	@FXML
	private TextField txtUsername;

	@FXML
	private TextField txtPassword;

	public void Login(ActionEvent event) {
		if (txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")) {
			lblLogin.setText("Login Success");
		}

		else {
			//adding comment to show some test commit
			lblLogin.setText("Login Failed");

		}
	}

}
