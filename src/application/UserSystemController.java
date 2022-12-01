 package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserSystemController implements Initializable{

	  @FXML
	    private Button addImage;

	    @FXML
	    private AnchorPane applytable;

	    @FXML
	    private AnchorPane clothesImage;

	    @FXML
	    private TextField clothesbrand_in;

	    @FXML
	    private TableColumn<?, ?> clothesbrand_out;

	    @FXML
	    private TextField clothesid_in;

	    @FXML
	    private TableColumn<?, ?> clothesid_out;

	    @FXML
	    private TextField clothesname_in;

	    @FXML
	    private TableColumn<?, ?> clothesname_out;

	    @FXML
	    private TextField clothessize_in;

	    @FXML
	    private TableColumn<?, ?> clothessize_out;

	    @FXML
	    private TextField clothestype_in;

	    @FXML
	    private TableColumn<?, ?> clothestype_out;

	    @FXML
	    private Button useradd;

	    @FXML
	    private Button userapply;

	    @FXML
	    private Button userclear;

	    @FXML
	    private Button userdelete;

	    @FXML
	    private Button userlogout;

	    @FXML
	    private TextField username_in;

	    @FXML
	    private TableColumn<?, ?> username_out;

	    @FXML
	    private Button userupdate;

	    @FXML
	    private Button userview;

	    @FXML
	    private TableView<?> viewtable;
	
	public void logout() {
			// alert to confirm log out message
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("Confirmation message");
			alert.setContentText("Are you sure to log out?");
			//condition statement to confirm log out option 
			Optional<ButtonType> option= alert.showAndWait();
			if(option.get().equals(ButtonType.OK)) {
				try {
				// return back to login page
				FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("application/Loginfx.fxml"));
		        Parent root = loader.load();
		        Stage primaryStage=new Stage();
		          
				Scene scene = new Scene(root,500,400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.setTitle("Second Shop System - best system for helping :) !");
				primaryStage.getIcons().add(new Image("icon.png"));
				primaryStage.show();
				} 
				catch(Exception e) {
					e.printStackTrace();
					
				}
			}
			
		}


	

	@Override
	public void initialize(URL location, ResourceBundle agr) {
		
		
	}
}


