package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import models.Product;
import models.User;

public class ApprovalQueue {

	Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	private static List<Product> sellerQueue = new ArrayList<>();
	private static List<User> userAuthQueue = new ArrayList<>();

	private static ApprovalQueue queueInstance;

	private ApprovalQueue() {
		con = ConnectionUtil.connectToDB();
		fetchPendingSellers();
		fetchPendingUserAdmins();
	}

	public static ApprovalQueue getInstance() {
		if (queueInstance == null) {
			queueInstance = new ApprovalQueue();
		}

		return queueInstance;
	}

	public List<Product> getSellerQueue() {
		return sellerQueue;
	}

	public List<User> getUserAuthQueue() {
		return userAuthQueue;
	}

	private void fetchPendingSellers() {

		String sqlQuery = "select * from products where isApproved=0";
		try {
			preparedStatement = con.prepareStatement(sqlQuery);

			resultSet = preparedStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
				System.out.println("No pending queue orders");
			} else {
				System.out.println(resultSet.toString());
				while (resultSet.next()) {
					Product prod = new Product();
					prod.setId(resultSet.getInt("productid"));
					prod.setName(resultSet.getString("name"));
					prod.setImage(resultSet.getString("image"));
					prod.setType(resultSet.getString("type"));
					prod.setPostedBy(resultSet.getString("postedBy"));
					prod.setSize(resultSet.getString("size"));
					prod.setPrice(resultSet.getDouble("price"));

					sellerQueue.add(prod);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.err.println(ex.getMessage());
		}
	}
	
	private void fetchPendingUserAdmins() {
		String sqlQuery = "select * from admins where isApproved=0";
		try {
			preparedStatement = con.prepareStatement(sqlQuery);

			resultSet = preparedStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
				System.out.println("No pending queue orders");
			} else {
				System.out.println(resultSet.toString());
				while (resultSet.next()) {
					User user = new User();
//					user.setId(resultSet.getInt("adminid"));
					user.setUsername(resultSet.getString("username"));
					user.setPassword(resultSet.getString("password"));
					user.setFirstname(resultSet.getString("firstname"));
					user.setLastname(resultSet.getString("lastname"));
					user.setEmail(resultSet.getString("email"));

					userAuthQueue.add(user);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.err.println(ex.getMessage());
		}
	}

	@Override
	public String toString() {
		String result = "ApprovalQueue \n: ";
		result += "seller queue details: \n";
		for (Product prod : sellerQueue) {
			result += prod.toString();
		}
		result += "user auth queue details: \n";
		for (User user : userAuthQueue) {
			result += user.toString();
		}
		return result;
	}

}
