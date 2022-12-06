package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import utils.ConnectionUtil;
import utils.PaneRouter;

public class UserDashboardController implements Initializable{
	
	/// --
	Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	@FXML
	private ComboBox<String> userIntent;
	
	@FXML
	private Label lblStatus;
	
	@FXML 
	private Button btnUserIntent;
	
	public UserDashboardController() {
		con = ConnectionUtil.connectToDB();
	}
	
	@FXML
	public void handleUserIntent(MouseEvent event) {
		System.out.println(event.getSource());
		System.out.println(userIntent.getValue());
		if(("Buy").equals(userIntent.getValue())) {
			PaneRouter.route(this, event, "/fxml/BuyUserDashboard.fxml");
		}else if(("Give Back").equals(userIntent.getValue())) {
			PaneRouter.route(this, event, "/fxml/SellUserDashboard.fxml");
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        userIntent.getItems().addAll("Buy", "Give Back");
        
//        txtGender.getSelectionModel().select("Male");
		
	}
	
	private void setLblError(Color color, String text) {
		lblStatus.setTextFill(color);
		lblStatus.setText(text);
		System.out.println(text);
	}
	

}
