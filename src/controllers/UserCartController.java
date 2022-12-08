package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
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
	


	public UserCartController() {

		con = ConnectionUtil.connectToDB();
		productsInCart = new ArrayList<>();
//		productsInCart = UserSession.getInstance().getUserCart();
		System.out.println("Items in cart: "+ productsInCart.toString());
		populateScrollPane(itemsInCart);
		
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
	
	@FXML
	public void handleCheckout(MouseEvent event) {

		System.out.println("This is handleCheckout");

	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		userIntent.getItems().addAll("Buy", "Sell");
		productsInCart = UserSession.getInstance().getUserCart();
		
	}
	
	private void setLblError(Color color, String text) {
		lblStatus.setTextFill(color);
		lblStatus.setText(text);
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
				Image productImage = new Image(currentProduct.getImage());
				ImageView imageContainer = new ImageView(productImage);
				imageContainer.setFitWidth(200);
				imageContainer.setFitHeight(200);
				imageContainer.setPreserveRatio(true);
				nodes[i].getChildren().add(imageContainer);
				// inject name to HBox
				Label productName = new Label();
				productName.setText(currentProduct.getName());
				productName.setWrapText(true);
				nodes[i].getChildren().add(productName);
				// inject price to Hbox
				Label productPrice = new Label();
				productPrice.setText("$" + currentProduct.getPrice());
				nodes[i].getChildren().add(productPrice);
				// inject seller to HBox
				Label postedBy = new Label();
				postedBy.setText(currentProduct.getPostedBy());
				nodes[i].getChildren().add(postedBy);
				// inject size to HBox
				Label productSize = new Label();
				productSize.setText(currentProduct.getSize());
				nodes[i].getChildren().add(productSize);

				// inject button to Hbox
//				Button addToCart = new Button();
//				addToCart.setText("Add To Cart");
//				addToCart.setId(String.valueOf(currentProduct.getId()));
//				addToCart.setOnAction(event -> {
//					System.out.println("Add to cart clicked");
//					UserSession.getInstance().getUserCart().add(currentProduct);
//				});
//				nodes[i].getChildren().add(addToCart);
				itemList.getChildren().add(nodes[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
