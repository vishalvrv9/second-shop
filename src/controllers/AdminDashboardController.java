package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import models.Product;
import models.User;
import utils.ApprovalQueue;

public class AdminDashboardController implements Initializable{
	
	private List<Product> sellerQueue;
	private List<User> userAuthQueue;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ApprovalQueue approvalQueue = ApprovalQueue.getInstance();
		userAuthQueue = approvalQueue.getUserAuthQueue();
		sellerQueue = approvalQueue.getSellerQueue();
		System.out.println(userAuthQueue);
		System.out.println(sellerQueue);
	}

}
