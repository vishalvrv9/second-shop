package controllers;

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
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import models.Product;
import models.User;
import session.UserSession;
import utils.ApprovalQueue;
import utils.ConnectionUtil;

public class AdminDashboardController implements Initializable {

	Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	private List<Product> sellerQueue;
	private List<User> userAuthQueue;

	@FXML
	private Button btnOverview;

	@FXML
	private Label lblError;

	@FXML
	private Button btnApproveUsers;

	@FXML
	private Button btnApproveSellers;

	@FXML
	private Button btnLogout;

	@FXML
	private Pane overviewPane;

	@FXML
	private Pane approveUsersPane;

	@FXML
	private Pane approveSellersPane;

	@FXML
	private VBox unapprovedSellerList;

	public AdminDashboardController() {
		con = ConnectionUtil.connectToDB();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ApprovalQueue approvalQueue = ApprovalQueue.getInstance();
		userAuthQueue = approvalQueue.getUserAuthQueue();
		sellerQueue = approvalQueue.getSellerQueue();
		System.out.println(userAuthQueue);
		System.out.println(sellerQueue);
	}

	public void handleClicks(ActionEvent actionEvent) {
		if (actionEvent.getSource() == btnOverview) {
			overviewPane.setStyle("-fx-background-color : #1620A1");

			overviewPane.toFront();
		}
		if (actionEvent.getSource() == btnApproveUsers) {
			approveUsersPane.setStyle("-fx-background-color : #53639F");
			approveUsersPane.toFront();
		}
		if (actionEvent.getSource() == btnApproveSellers) {
			approveSellersPane.setStyle("-fx-background-color : #02030A");
			populateSellerQueue(unapprovedSellerList);
			approveSellersPane.toFront();
		}
		if (actionEvent.getSource() == btnLogout) {
			System.out.println("Logout admin");

		}
	}

	private void populateSellerQueue(VBox itemList) {
		HBox[] nodes = new HBox[sellerQueue.size()];
		for (int i = 0; i < nodes.length; i++) {
			try {
				Product currentProduct = sellerQueue.get(i);
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
				Button approveSell = new Button();
				approveSell.setText("Approve");
				approveSell.setId(String.valueOf(currentProduct.getId()));
				approveSell.setOnAction(event -> {
					System.out.println("Approved sell");
					String status = markProductAsApprovedOnDB(currentProduct);
					ApprovalQueue.getInstance().getSellerQueue().remove(currentProduct);
					if("Success".equals(status)) {
						approveSell.setDisable(true);
					}
				});
				approveSell.setMinWidth(Region.USE_PREF_SIZE);
				nodes[i].getChildren().add(approveSell);
				itemList.getChildren().add(nodes[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void setLblError(Color color, String text) {
		lblError.setTextFill(color);
		lblError.setText(text);
		System.out.println(text);
	}

	private String markProductAsApprovedOnDB(Product product) {
		String sqlQuery = "update products set isApproved = 1 where productid= ?";

		String status = "IN_PROGRESS";
		try {
			preparedStatement = con.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, product.getId());
			int isRegistered = preparedStatement.executeUpdate();
			System.out.println("ResultSet: " + isRegistered);

			if (isRegistered > 0) {
				setLblError(Color.GREEN, "Product approved..Redirecting..");
				status = "Success";

			} else {
				setLblError(Color.TOMATO, "There was a problem while approving. Please try after sometime.");
				status = "Failure";
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();

		}
		return status;

	}
}
