package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import models.Product;
import models.User;
import utils.ApprovalQueue;

public class AdminDashboardController implements Initializable{
	
	private List<Product> sellerQueue;
	private List<User> userAuthQueue;
	
	@FXML
	private Button btnOverview;
	
	@FXML
	private Button btnApproveUsers;
	
	@FXML
	private Button btnApproveSellers;
	
	@FXML
	private Button btnLogout;
	
	@FXML
	private Pane overviewPane;
	
	@FXML
	private Pane approveUsersPane;
	
	@FXML
	private Pane approveSellersPane;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ApprovalQueue approvalQueue = ApprovalQueue.getInstance();
		userAuthQueue = approvalQueue.getUserAuthQueue();
		sellerQueue = approvalQueue.getSellerQueue();
		System.out.println(userAuthQueue);
		System.out.println(sellerQueue);
	}

    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnOverview) {
            overviewPane.setStyle("-fx-background-color : #1620A1");
            overviewPane.toFront();
        }
        if (actionEvent.getSource() == btnApproveUsers) {
            approveUsersPane.setStyle("-fx-background-color : #53639F");
            approveUsersPane.toFront();
        }
        if (actionEvent.getSource() == btnApproveSellers) {
            approveSellersPane.setStyle("-fx-background-color : #02030A");
            approveSellersPane.toFront();
        }
        if(actionEvent.getSource()==btnLogout)
        {
            System.out.println("Logout admin");
            
        }
    }
}
