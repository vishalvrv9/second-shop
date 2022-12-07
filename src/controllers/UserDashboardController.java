package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import models.Product;
import utils.ConnectionUtil;
import utils.PaneRouter;

public class UserDashboardController implements Initializable {

	/// --
	Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@FXML
	private ComboBox<String> userIntent;

	@FXML
	private Label lblStatus;

	@FXML
	private Button btnUserIntent;

	@FXML
	private GridPane productCatalog;

	public UserDashboardController() {
		con = ConnectionUtil.connectToDB();

	}

	@FXML
	public void handleUserIntent(MouseEvent event) {
		System.out.println(event.getSource());
		System.out.println(userIntent.getValue());
		if (("Buy").equals(userIntent.getValue())) {
			setLblError(Color.GREEN, "Redirecting to inventory...");
			PaneRouter.route(this, event, "/fxml/BuyUserDashboard.fxml");
		} else if (("Sell").equals(userIntent.getValue())) {
			setLblError(Color.GREEN, "Redirecting to seller page...");
			PaneRouter.route(this, event, "/fxml/SellUserDashboard.fxml");
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		userIntent.getItems().addAll("Buy", "Sell");
	}

	private void setLblError(Color color, String text) {
		lblStatus.setTextFill(color);
		lblStatus.setText(text);
		System.out.println(text);
	}

}
