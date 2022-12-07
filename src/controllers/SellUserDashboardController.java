package controllers;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import models.Product;
import utils.ApprovalQueue;
import utils.ConnectionUtil;
import utils.PaneRouter;

public class SellUserDashboardController implements Initializable {
	
	private List<String> allowedFormats;
	private String localImagePath;
	Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@FXML
	private TextField productNameInput;
	@FXML
	private Button productImageInput;
	@FXML
	private Label labelProductFileInput;
	@FXML
	private ComboBox<String> productTypeInput;
	@FXML
	private Button btnUserIntent;
	@FXML
	private ComboBox<String> userIntent;
	@FXML
	private TextField productSellerInput;
	@FXML
	private ComboBox<String> productSizeInput;
	@FXML
	private TextField productPriceInput;
	
	public SellUserDashboardController() {
		con = ConnectionUtil.connectToDB();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		userIntent.getItems().addAll("Buy", "Sell");
		productTypeInput.getItems().addAll("Shirt", "Trouser", "Jacket", "Shoes");
		productSizeInput.getItems().addAll("XS", "S", "M", "L", "XL", "XXL");
		allowedFormats = new ArrayList<>();
		allowedFormats.add("*.jpg");
		allowedFormats.add("*.jpeg");
		allowedFormats.add("*.png");
	}
	
	@FXML
	public void handleDonate(ActionEvent event) {
		String productName = productNameInput.getText();
		String productImage = productImageInput.getText();
		String productType = productTypeInput.getValue();
		String productSeller = productSellerInput.getText();
		String productSize = productSizeInput.getValue();
		Double productPrice = Double.parseDouble(productPriceInput.getText());
		Product prospectiveProduct = new Product();
		prospectiveProduct.setName(productName);
		prospectiveProduct.setImage(productImage);
		prospectiveProduct.setType(productType);
		prospectiveProduct.setPostedBy(productSeller);
		prospectiveProduct.setSize(productSize);
		prospectiveProduct.setPrice(productPrice);
		
		//write image file to directory
		// add to admin seller queue
		ApprovalQueue adminQueue = ApprovalQueue.getInstance();
		adminQueue.getSellerQueue().add(prospectiveProduct);
		
		//persist to db
		persistProductToDatabase(prospectiveProduct);
		
	}
	
	@FXML
	public void handleImageUpload(ActionEvent event) {
		System.out.println(event.getSource());
		System.out.println(productTypeInput.getValue());
		System.out.println(productSizeInput.getValue());
//		if (("Buy").equals(userIntent.getValue())) {
//			PaneRouter.route(this, event, "/fxml/BuyUserDashboard.fxml");
//		} else if (("Give Back").equals(userIntent.getValue())) {
//			PaneRouter.route(this, event, "/fxml/SellUserDashboard.fxml");
//		}
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("Images", allowedFormats));
		File file = fc.showOpenDialog(null);
		
		if(file != null) {
			setLblError(Color.GREEN, "Selected File: "+file.getAbsolutePath()+ " (size: "+ file.getAbsolutePath()+")");
			localImagePath = file.getAbsolutePath();
		}

	}
	
	@FXML
	public void handleUserIntent(MouseEvent event) {
		System.out.println(event.getSource());
		System.out.println(userIntent.getValue());
		if (("Buy").equals(userIntent.getValue())) {
			PaneRouter.route(this, event, "/fxml/BuyUserDashboard.fxml");
		} else if (("Sell").equals(userIntent.getValue())) {
			PaneRouter.route(this, event, "/fxml/SellUserDashboard.fxml");
		}

	}
	
	private void setLblError(Color color, String text) {
		labelProductFileInput.setTextFill(color);
		labelProductFileInput.setText(text);
		System.out.println(text);
	}
	
	private String persistProductToDatabase(Product p) {
		String status = "IN_PROGRESS";
		String sqlQuery = "INSERT INTO products (name, image, type, postedBy, size, price) VALUES "
				+ " (?, ?, ?, ?, ?, ?);";
		try {
			preparedStatement = con.prepareStatement(sqlQuery);
			preparedStatement.setString(1, p.getName());
			preparedStatement.setString(2, p.getImage());
			preparedStatement.setString(3, p.getType());
			preparedStatement.setString(4, p.getPostedBy());
			preparedStatement.setString(5, p.getSize());
			preparedStatement.setString(6, String.valueOf(p.getPrice()));
			int isRegistered = preparedStatement.executeUpdate();
			System.out.println("ResultSet: " + isRegistered);
			if (isRegistered > 0) {
				setLblError(Color.GREEN, "Product persisted..Redirecting..");
				

			} else {
				setLblError(Color.TOMATO, "There was a problem while registering User. Please try after sometime.");
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();

		}
		return status;
		
	}

}
