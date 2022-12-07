package utils;

import java.util.ArrayList;
import java.util.List;

import models.Product;

public class ApprovalQueue {
	
	private static List<Product> sellerQueue = new ArrayList<>();
	private static List<String> adminAuthQueue = new ArrayList<>();
	
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
	
	public List<String> getAdminAuthQueue(){
		return adminAuthQueue;
	}
	
	

}
