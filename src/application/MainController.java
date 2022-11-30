package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
		
		//set toggle group to confirm only one button to be selected primarily
		final ToggleGroup group = new ToggleGroup();
		userbutton.setToggleGroup(group);
		userbutton.setSelected(true);
		adminbutton.setToggleGroup(group);
		
		// admin login
		if(txtUsername.getText().equals("admin")&&txtPassword.getText().equals("pass")&& adminbutton.isSelected()) {
			lblLogin.setText("Admin Login Success");
			Stage primaryStage=new Stage();
			
		// if successfully login, open admin system
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("application/AdminSystem.fxml"));
            Parent root = loader.load();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hi! There is Admin System");
			primaryStage.show();}
		
		// user login
		else if(txtUsername.getText().equals("user")&&txtPassword.getText().equals("pass")&& userbutton.isSelected()) {
			lblLogin.setText(" User Login Success");
			Stage primaryStage=new Stage();
			
		// if successfully login, open user system
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("application/UserSystem.fxml"));
            Parent root = loader.load();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hi! There is User System");
			primaryStage.show();}
		
		else{
			lblLogin.setText("Login Failed");
		}
	}
	public void Cancel(ActionEvent event) throws IOException{
		if( txtUsername.getText()!=null || txtPassword.getText()!=null) {
			lblLogin.setText("You cancel your login");
			txtUsername.setText("");
			txtPassword.setText("");
		}else{
			lblLogin.setText("invalid input");
		}
	}
}
