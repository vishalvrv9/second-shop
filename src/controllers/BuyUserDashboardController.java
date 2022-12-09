package controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import models.Product;
import session.UserSession;
import utils.ConnectionUtil;
import utils.PaneRouter;

public class BuyUserDashboardController implements Initializable {
	/// --
	Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	List<Product> products;
	ObservableList<Product> productsInCart;

	@FXML
	private ComboBox<String> userIntent;

	@FXML
	private Label lblStatus;

	@FXML
	private Button btnRedirectToCart;
	@FXML
	private Button btnCheckout;

	@FXML
	private Button btnUserIntent;
	@FXML
	private ScrollPane inventoryScrollPane;

	@FXML
	private VBox productCatalog;

	public BuyUserDashboardController() {
		con = ConnectionUtil.connectToDB();
		products = new ArrayList<>();

	}

	@FXML
	public void handleRedirectToCart(ActionEvent event) {
		System.out.println("This is handleGoToCart");
		PaneRouter.route(this, event, "/fxml/UserCart.fxml");
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		userIntent.getItems().addAll("Buy", "Sell", "Logout");
		if(products.isEmpty()) {			
			products = loadProductCatalog();
		}
		for (Product prod : products) {
			System.out.println(prod.toString());
		}
		populateScrollPane(productCatalog);
//		populateScrollPane(cartItems);
//		productsInCart.addListener((ListChangeListener) e -> {
//			System.out.println("List Changed"); 
//		});

	}

	private void setLblError(Color color, String text) {
		lblStatus.setTextFill(color);
		lblStatus.setText(text);
		System.out.println(text);
	}

	private List<Product> loadProductCatalog() {
		String sqlQuery = "select * from products where isApproved=1";
		try {
			preparedStatement = con.prepareStatement(sqlQuery);

			resultSet = preparedStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
				setLblError(Color.TOMATO, "Inventory is Empty. Come back Later.");
			} else {
				System.out.println(resultSet.toString());
				setLblError(Color.GREEN, "Loading Products...");
				while (resultSet.next()) {
					Product prod = new Product();
					prod.setId(resultSet.getInt("productid"));
					prod.setName(resultSet.getString("name"));
					prod.setImage(resultSet.getString("image"));
					prod.setType(resultSet.getString("type"));
					prod.setPostedBy(resultSet.getString("postedBy"));
					prod.setSize(resultSet.getString("size"));
					prod.setPrice(resultSet.getDouble("price"));

					products.add(prod);
				}
			}
			setLblError(Color.BLACK, "This is our Product Inventory!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.err.println(ex.getMessage());
		}

		return products;
	}
	private void populateScrollPane(VBox itemList) {
		HBox[] nodes = new HBox[products.size()];
		for (int i = 0; i < nodes.length; i++) {
			try {
				Product currentProduct = products.get(i);
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
				productName.setMinWidth(Region.USE_PREF_SIZE);
//				productName.setWrapText(true);
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

				// inject button to Hbox
				Button addToCart = new Button();
				addToCart.setText("Add To Cart");
				addToCart.setId(String.valueOf(currentProduct.getId()));
				addToCart.setOnAction(event -> {
					System.out.println("Add to cart clicked");
					UserSession.getInstance().getUserCart().add(currentProduct);
				});
				addToCart.setMinWidth(Region.USE_PREF_SIZE);
				nodes[i].getChildren().add(addToCart);
				itemList.getChildren().add(nodes[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
