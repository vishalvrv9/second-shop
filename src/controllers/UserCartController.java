package controllers;

import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import models.Product;
import session.UserSession;
import utils.ConnectionUtil;
import utils.PaneRouter;

public class UserCartController implements Initializable{
	Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	List<Product> productsInCart;

	@FXML
	private ComboBox<String> userIntent;

	@FXML
	private Button btnUserIntent;
	
	@FXML
	private Label lblStatus;

	@FXML
	private Button btnCheckout;
	
	
	@FXML
	private ScrollPane cartScrollPane;
	
	@FXML
	private VBox itemsInCart;
	
	@FXML
	private Label lblTotalPrice;
	
	@FXML
	private Button btnGoToDashboard;


	public UserCartController() {
		con = ConnectionUtil.connectToDB();
		productsInCart = new ArrayList<>();
		
	}
	
	@FXML
	public void handleClick(ActionEvent event) {
		System.out.println("inside usercart handleclick");
		PaneRouter.route(this, event, "/fxml/UserDashboard.fxml");
	}
	
	@FXML
	public void handleUserIntent(MouseEvent event) {
		System.out.println(event.getSource());
		System.out.println(userIntent.getValue());
		if (("Buy").equals(userIntent.getValue())) {
			PaneRouter.route(this, event, "/fxml/BuyUserDashboard.fxml");
		} else if (("Sell").equals(userIntent.getValue())) {
			PaneRouter.route(this, event, "/fxml/SellUserDashboard.fxml");
		}else if (("Logout").equals(userIntent.getValue())) {
			PaneRouter.route(this, event, "/fxml/LoginPane.fxml");
		}

	}
	
	@FXML
	public void handleCheckout(ActionEvent event) {

		System.out.println("This is handleCheckout");
		PaneRouter.route(this, event, "/fxml/SuccessfulCheckout.fxml");

	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		userIntent.getItems().addAll("Buy", "Sell", "Logout");
		productsInCart = UserSession.getInstance().getUserCart();
		System.out.println("Items in cart: "+ productsInCart.toString());
		populateScrollPane(itemsInCart);
		calculateAndDisplayCartValue();
		
	}
	
	private void setLblError(Color color, String text) {
		lblStatus.setTextFill(color);
		lblStatus.setText(text);
		System.out.println(text);
	}
	
	private void setLblTotalPrice(Color color, String text) {
		lblTotalPrice.setTextFill(color);
		lblTotalPrice.setText(text);
		System.out.println(text);
	}
	private void populateScrollPane(VBox itemList) {
		HBox[] nodes = new HBox[productsInCart.size()];
		for (int i = 0; i < nodes.length; i++) {
			try {
				Product currentProduct = productsInCart.get(i);
				System.out.println("Current product");
				System.out.println(currentProduct.toString());
				// setup HBox to render products
				nodes[i] = new HBox();
				nodes[i].setSpacing(50);
				nodes[i].setPadding(new Insets(20, 20, 20, 20));

				// inject image to HBox
				FileInputStream fis = new FileInputStream(currentProduct.getImage());
				Image productImage = new Image(fis);
				ImageView imageContainer = new ImageView(productImage);
				imageContainer.setFitWidth(200);
				imageContainer.setFitHeight(200);
				imageContainer.setPreserveRatio(true);
				nodes[i].getChildren().add(imageContainer);
				// inject name to HBox
				Label productName = new Label();
				productName.setText(currentProduct.getName());
				productName.setWrapText(true);
				productName.setMinWidth(Region.USE_PREF_SIZE);
				nodes[i].getChildren().add(productName);
				// inject price to Hbox
				Label productPrice = new Label();
				productPrice.setText("$" + currentProduct.getPrice());
				productPrice.setMinWidth(Region.USE_PREF_SIZE);
				nodes[i].getChildren().add(productPrice);
				// inject seller to HBox
				Label postedBy = new Label();
				postedBy.setText(currentProduct.getPostedBy());
				postedBy.setMinWidth(Region.USE_PREF_SIZE);
				nodes[i].getChildren().add(postedBy);
				// inject size to HBox
				Label productSize = new Label();
				productSize.setText(currentProduct.getSize());
				productSize.setMinWidth(Region.USE_PREF_SIZE);
				nodes[i].getChildren().add(productSize);

//				 inject button to Hbox
//				Button removeFromCart = new Button();
//				removeFromCart.setText("Remove");
//				removeFromCart.setId(String.valueOf(currentProduct.getId()));
//				removeFromCart.setOnAction(event -> {
//					System.out.println("Remove clicked");
//					UserSession.getInstance().getUserCart().remove(currentProduct);
//				});
//				nodes[i].getChildren().add(removeFromCart);
				itemList.getChildren().add(nodes[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void calculateAndDisplayCartValue() {
		Double totalPrice=0.0;
		for(Product p : productsInCart) {
			totalPrice += p.getPrice();
		}
		setLblTotalPrice(Color.BLUE, "Total Cart Value: $"+totalPrice);
	}

}
