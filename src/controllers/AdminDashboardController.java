package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import models.Product;
import utils.ApprovalQueue;

public class AdminDashboardController implements Initializable{
	
	private List<String> adminAuthQueue;
	private List<Product> sellerQueue;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ApprovalQueue approvalQueue = ApprovalQueue.getInstance();
		adminAuthQueue = approvalQueue.getAdminAuthQueue();
		sellerQueue = approvalQueue.getSellerQueue();		
	}

}
