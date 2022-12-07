package utils;

import java.util.ArrayList;
import java.util.List;

import models.Product;
import models.User;

public class ApprovalQueue {
	
	private static List<Product> sellerQueue = new ArrayList<>();
	private static List<User> userAuthQueue = new ArrayList<>();
	
	private static ApprovalQueue queueInstance;
	
	private ApprovalQueue() {
	}
	
	public static ApprovalQueue getInstance() {
		if(queueInstance == null) {
			queueInstance = new ApprovalQueue();
		}
		
		return queueInstance;
	}
	
	public List<Product> getSellerQueue(){
		return sellerQueue;
	}
	

	public List<User> getUserAuthQueue(){
		return userAuthQueue;
	}
	
	
	@Override
	public String toString() {
		String result = "ApprovalQueue \n: ";
		result += "seller queue details: \n";
		for(Product prod: sellerQueue) {
			result+= prod.toString();
		}
		result += "user auth queue details: \n";
		for(User user: userAuthQueue) {
			result += user.toString();
		}
		return result;
	}

}
