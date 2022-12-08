package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import utils.PaneRouter;

public class GoToDashboardController implements Initializable{
	
	@FXML
	private Button btnGoToDashboard;
	
	
	@FXML
	public void handleClick(ActionEvent event) {
		PaneRouter.route(this, event, "/fxml/UserDashboard.fxml");
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
