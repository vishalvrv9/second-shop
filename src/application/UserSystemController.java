 package application;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class UserSystemController implements Initializable {

	@FXML
    private Button chart_button;
    @FXML
    private AnchorPane chart_pane;
    @FXML
    private Button checkout_button;
    @FXML
    private Button dashboard_button;
    @FXML
    private ImageView dashboard_image;
    @FXML
    private AnchorPane dashboard_pane;
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image4;
    @FXML
    private ImageView image5;
    @FXML
    private ImageView image6;
    @FXML
    private Label item1;
    @FXML
    private Label item2;
    @FXML
    private Label item3;
    @FXML
    private Label item4;
    @FXML
    private Label item5;
    @FXML
    private Label item6;
    
    @FXML
    private Button item_button;
    @FXML
    private AnchorPane item_pane;
    @FXML
    private Button loggout_button;
    @FXML
    private Label totalprice_label;
    @FXML
    private StackPane userpage;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private AnchorPane pane1;
    @FXML
    private AnchorPane pane2;
    @FXML
    private AnchorPane pane3;
    @FXML
    private AnchorPane pane4;
    @FXML
    private AnchorPane pane5;
    @FXML
    private AnchorPane pane6;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        image1.setImage(new Image((new File("medias/Book.png")).toURI().toString()));
        image2.setImage(new Image((new File("medias/Laptop.png")).toURI().toString()));
        image3.setImage(new Image((new File("medias/Cookies.png")).toURI().toString()));
        image4.setImage(new Image((new File("medias/RedPocket.png")).toURI().toString()));
        image5.setImage(new Image((new File("medias/Flowers.png")).toURI().toString()));
        image6.setImage(new Image((new File("medias/BearToy.png")).toURI().toString()));
	     item_pane.getChildren().addAll(pane1,pane2,pane3,pane4,pane5,pane6);
	     pane1.getChildren().add(image1);
	     pane2.getChildren().add(image2);
	     pane3.getChildren().add(image3);
	     pane4.getChildren().add(image4);
	     pane5.getChildren().add(image5);
	     pane6.getChildren().add(image6);
	     
        
	}
	
	

    
    public void checkOut() {
    	Alert alert=new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation message");
		alert.setContentText("Are you sure to check out? ");
		//condition statement to confirm log out option 
		Optional<ButtonType> option= alert.showAndWait();
		if(option.get().equals(ButtonType.OK)) {
			try {
				Alert alert1=new Alert(AlertType.INFORMATION);
				alert1.setTitle("");
				alert1.setContentText("You have check out your order");
				Optional<ButtonType> option1= alert1.showAndWait();
				if(option1.get().equals(ButtonType.OK))
				System.exit(1);;
			} 
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

    
	public void logout() {
			// alert to confirm log out message
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("Confirmation message");
			alert.setContentText("Are you sure to log out?");
			//condition statement to confirm log out option 
			Optional<ButtonType> option= alert.showAndWait();
			if(option.get().equals(ButtonType.OK)) {
				try {
				// close user page
					System.exit(0);
				} 
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	
	public void switchPage(ActionEvent event) {
		if (event.getSource()==dashboard_button) {
			dashboard_pane.setVisible(true);
			chart_pane.setVisible(false);
			item_pane.setVisible(false);
			
			
		}else if(event.getSource()==item_button) {
			dashboard_pane.setVisible(false);
			item_pane.setVisible(true);
			chart_pane.setVisible(false);
		    imageSelect(event);
		}else if(event.getSource()==chart_button) {
			item_pane.setVisible(false);
			dashboard_pane.setVisible(false);
			chart_pane.setVisible(true);
			}
	}
	
	 public void imageSelect(ActionEvent event) {
		 
	 
	        if (event.getSource()==button1) {
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("Confirmation message");
				alert.setContentText("This one's price is $5.99,are you sure to pick one?");
				//condition statement to confirm log out option 
				Optional<ButtonType> option= alert.showAndWait();
				if(option.get().equals(ButtonType.YES)) {
					try {
						item1.setText("Three Body");
						System.exit(0);
					} 
					catch(Exception e) {
						e.printStackTrace();
					}
					}
				}
	        if(event.getSource()==button2){
				Alert alert2=new Alert(AlertType.INFORMATION);
				alert2.setTitle("Confirmation message");
				alert2.setContentText("This one's price is $669.99,are you sure to pick one?");
				//condition statement to confirm log out option 
				Optional<ButtonType> option= alert2.showAndWait();
				if(option.get().equals(ButtonType.YES)) {
					try {
						item2.setText("iMac");
						System.exit(0);
					} 
					catch(Exception e) {
						e.printStackTrace();
					}
					}
				}
	        
	        if(event.getSource()==button3){
				Alert alert3=new Alert(AlertType.INFORMATION);
				alert3.setTitle("Confirmation message");
				alert3.setContentText("This one's price is $3.99,are you sure to pick one?");
				//condition statement to confirm log out option 
				Optional<ButtonType> option= alert3.showAndWait();
				if(option.get().equals(ButtonType.YES)) {
					try {
						item3.setText("Cookies");
						System.exit(0);
					} 
					catch(Exception e) {
						e.printStackTrace();
					}
					}
				}
	         if(event.getSource()==button4){
				Alert alert4=new Alert(AlertType.INFORMATION);
				alert4.setTitle("Confirmation message");
				alert4.setContentText("This one's price is $10.99,are you sure to pick one?");
				//condition statement to confirm log out option 
				Optional<ButtonType> option= alert4.showAndWait();
				if(option.get().equals(ButtonType.YES)) {
					try {
						item4.setText("Red Pocket");
						System.exit(0);
					} 
					catch(Exception e) {
						e.printStackTrace();
					}
					}
				}
	         if(event.getSource()==button5){
				Alert alert5=new Alert(AlertType.INFORMATION);
				alert5.setTitle("Confirmation message");
				alert5.setContentText("This one's price is $24.99,are you sure to pick one?");
				//condition statement to confirm log out option 
				Optional<ButtonType> option= alert5.showAndWait();
				if(option.get().equals(ButtonType.YES)) {
					try {
						item5.setText("Peach Blossom");
						System.exit(0);
					} 
					catch(Exception e) {
						e.printStackTrace();
					}
					}
				}
	         if(event.getSource()==button6) {
				Alert alert6=new Alert(AlertType.INFORMATION);
				alert6.setTitle("Confirmation message");
				alert6.setContentText("This one's price is $45.99,are you sure to pick one?");
				//condition statement to confirm log out option 
				Optional<ButtonType> option= alert6.showAndWait();
				if(option.get().equals(ButtonType.YES)) {
					try {
						item6.setText("Toy Bear");
						System.exit(0);
					} 
					catch(Exception e) {
						e.printStackTrace();
					}
					}
				}
	 			}

	

	
}


