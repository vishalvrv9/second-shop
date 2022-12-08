package session;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Product;

public class UserSession {
	private static List<Product> userCart = new ArrayList<>();
	
	private static UserSession userSession;
	
	private UserSession() {
		
	}
	
	public static UserSession getInstance() {
		if(userSession != null) {
			return userSession;
		}
		
		return new UserSession();
	}

	public List<Product> getUserCart() {
		return userCart;
	}

	public void setUserCart(List<Product> userCart) {
		UserSession.userCart = userCart;
	}


	@Override
	public String toString() {
		String result = "UserSession []";
		result += "User Cart details: \n";
		for(Product prod: userCart) {
			result+= prod.toString();
		}
		return result;
	}
}
