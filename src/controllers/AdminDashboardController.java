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

import utils.ApprovalQueue;
import models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import models.Product;
import utils.ConnectionUtil;
import utils.PaneRouter;
import utils.RenderLabelUtil;

public class AdminDashboardController implements Initializable {

	/// --
	Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	private List<Product> sellerQueue;
	private List<User> userAuthQueue;

	@FXML
	private ComboBox<String> userIntent;

	@FXML
	private Label lblStatus;

	@FXML
	Label approvalStatus;

	@FXML
	private Button btnUserIntent;

	@FXML
	private VBox unapprovedSellerList;

	@FXML
	private VBox unapprovedUserList;

	public AdminDashboardController() {
		con = ConnectionUtil.connectToDB();

	}

	@FXML
	public void handleUserIntent(MouseEvent event) {
		System.out.println(event.getSource());
		System.out.println(userIntent.getValue());
//		if (("Overview").equals(userIntent.getValue())) {
//			setLblError(Color.GREEN, "Redirecting to inventory...");
//			PaneRouter.route(this, event, "/fxml/AdminOverview.fxml");
//		} else 
		if (("Approve Sellers").equals(userIntent.getValue())) {
			setLblError(Color.GREEN, "Redirecting to seller page...");
			PaneRouter.route(this, event, "/fxml/AdminApproveSellers.fxml");
		} else if (("Approve Users").equals(userIntent.getValue())) {
			setLblError(Color.GREEN, "Redirecting to users page...");
			PaneRouter.route(this, event, "/fxml/AdminApproveUsers.fxml");
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		userIntent.getItems().addAll("Overview", "Approve Sellers", "Approve Users");
		ApprovalQueue approvalQueue = ApprovalQueue.getInstance();
		userAuthQueue = approvalQueue.getUserAuthQueue();
		sellerQueue = approvalQueue.getSellerQueue();
		System.out.println(userAuthQueue);
		System.out.println(sellerQueue);
		populateSellerQueue(unapprovedSellerList);
		populateUserQueue(unapprovedUserList);
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
				Button approveSell = new Button();
				approveSell.setText("Approve");
				approveSell.setId(String.valueOf(currentProduct.getId()));
				approveSell.setOnAction(event -> {
					System.out.println("Approved sell");
					String status = markProductAsApprovedOnDB(currentProduct);
					ApprovalQueue.getInstance().getSellerQueue().remove(currentProduct);
					if ("Success".equals(status)) {
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

	private void populateUserQueue(VBox itemList) {
		HBox[] nodes = new HBox[userAuthQueue.size()];
		for (int i = 0; i < nodes.length; i++) {
			try {
				User currentUser = userAuthQueue.get(i);
				// setup HBox to render products
				nodes[i] = new HBox();
				nodes[i].setSpacing(50);
				nodes[i].setPadding(new Insets(20, 20, 20, 20));

				// inject name to HBox
				Label firstname = new Label();
				firstname.setText(currentUser.getFirstname());
				firstname.setMinWidth(Region.USE_PREF_SIZE);
//				productName.setWrapText(true);
				nodes[i].getChildren().add(firstname);
				// inject price to Hbox
				Label lastname = new Label();
				lastname.setText(currentUser.getLastname());
				lastname.setMinWidth(Region.USE_PREF_SIZE);
				nodes[i].getChildren().add(lastname);
				// inject seller to HBox
				Label email = new Label();
				email.setText(currentUser.getEmail());
				email.setMinWidth(Region.USE_PREF_SIZE);
				nodes[i].getChildren().add(email);
				// inject size to HBox
				Label username = new Label();
				username.setText(currentUser.getUsername());
				username.setMinWidth(Region.USE_PREF_SIZE);
				nodes[i].getChildren().add(username);

				// inject button to Hbox
				Button approveUser = new Button();
				approveUser.setText("Approve");
				approveUser.setId(String.valueOf(currentUser.getUsername()));
				approveUser.setOnAction(event -> {
					System.out.println("Approved user");
					String status = markAdminAsAdminOnDB(currentUser);
					ApprovalQueue.getInstance().getUserAuthQueue().remove(currentUser);
					if ("Success".equals(status)) {
						approveUser.setDisable(true);
					}
				});
				approveUser.setMinWidth(Region.USE_PREF_SIZE);
				nodes[i].getChildren().add(approveUser);
				itemList.getChildren().add(nodes[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private String markAdminAsAdminOnDB(User user) {
		String sqlQuery = "update admins set isApproved = 1 where username= ?";

		String status = "IN_PROGRESS";
		try {
			preparedStatement = con.prepareStatement(sqlQuery);
			preparedStatement.setString(1, user.getUsername());
			int isRegistered = preparedStatement.executeUpdate();
			System.out.println("ResultSet: " + isRegistered);

			if (isRegistered > 0) {
				RenderLabelUtil.renderLabelInfo(approvalStatus, Color.GREEN, status);
				status = "Success";

			} else {
				RenderLabelUtil.renderLabelInfo(approvalStatus, Color.TOMATO, status);
				status = "Failure";
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();

		}
		return status;

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
				RenderLabelUtil.renderLabelInfo(approvalStatus, Color.GREEN, "Product approved..Redirecting..");
				status = "Success";

			} else {
				RenderLabelUtil.renderLabelInfo(approvalStatus, Color.TOMATO,
						"There was a problem while approving. Please try after sometime.");
				status = "Failure";
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();

		}
		return status;

	}

	private void setLblError(Color color, String text) {
		lblStatus.setTextFill(color);
		lblStatus.setText(text);
		System.out.println(text);
	}

}
