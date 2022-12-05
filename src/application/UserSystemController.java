package application;

import java.time.LocalTime;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class UserSystemController  {

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
    private ImageView imageBook;
    @FXML
    private ImageView imageLaptop;
    @FXML
    private ImageView imageCookies;
    @FXML
    private ImageView imageRedpocket;
    @FXML
    private ImageView imageFlower;
    @FXML
    private ImageView imageBear;
    @FXML
    private Label bookLabel;
    @FXML
    private Label laptopLabel;
    @FXML
    private Label cookiesLabel;
    @FXML
    private Label redpocketLabel;
    @FXML
    private Label flowerLabel;
    @FXML
    private Label toybearLabel;
    
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
    private Button book_button;
    @FXML
    private Button laptop_button;
    @FXML
    private Button cookies_button;
    @FXML
    private Button redPocket_button;
    @FXML
    private Button flower_button;
    @FXML
    private Button bear_button;
    @FXML
    private AnchorPane book_pane;
    @FXML
    private AnchorPane laptop_pane;
    @FXML
    private AnchorPane cookies_pane;
    @FXML
    private AnchorPane redpocket_pane;
    @FXML
    private AnchorPane flower_pane;
    @FXML
    private AnchorPane bear_pane;
    @FXML
    private StackPane user_pane;
    @FXML
    private Label lblTime;
	
// in cart page, check out button can confirm checking out;
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

    // in user system, log out button has log out privilege;
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
	// use 'dashboard',' item','cart' button, user can switch different page of system.
	public void switchPage(ActionEvent event) {
		if (event.getSource()==dashboard_button) {
			dashboard_pane.setVisible(true);
			lblTime.setText(LocalTime.now().toString().substring(0,8));
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
		 double flowerprice=24.99;
		 double bookprice=5.99;
		 double laptopprice=699.99;
		 double cookiesprice=3.99;
		 double redpocketPrice=10.99;
		 double toyBearprice=45.99;
		 double totalcost=0;
		if (event.getSource()==book_button) {
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("Confirmation message");
				alert.setContentText("This one's price is $5.99,are you sure to pick one?");
				//condition statement to confirm log out option 
				Optional<ButtonType> option= alert.showAndWait();
				if(option.get().equals(ButtonType.OK)) {
					try {
						
						totalcost+=bookprice;
						bookLabel.setText("books cost $5.99");
						
					
					} 
					catch(Exception e) {
						e.printStackTrace();
					}
					}
				}
	        if(event.getSource()==laptop_button){
				Alert alert2=new Alert(AlertType.INFORMATION);
				alert2.setTitle("Confirmation message");
				alert2.setContentText("This one's price is $669.99,are you sure to pick one?");
				//condition statement to confirm log out option 
				Optional<ButtonType> option= alert2.showAndWait();
				if(option.get().equals(ButtonType.OK)) {
					try {
						laptopLabel.setText("laptop cost $699.99");
						totalcost+=laptopprice;
						
					} 
					catch(Exception e) {
						e.printStackTrace();
					}
					}
				}
	        
	        if(event.getSource()==cookies_button){
				Alert alert3=new Alert(AlertType.INFORMATION);
				alert3.setTitle("Confirmation message");
				alert3.setContentText("This one's price is $3.99,are you sure to pick one?");
				//condition statement to confirm log out option 
				Optional<ButtonType> option= alert3.showAndWait();
				if(option.get().equals(ButtonType.OK)) {
					try { 
						cookiesLabel.setText("Cookies cost $3.99");
						totalcost+=cookiesprice;
						
					} 
					catch(Exception e) {
						e.printStackTrace();
					}
					}
				}
	        if(event.getSource()==redPocket_button){
				Alert alert4=new Alert(AlertType.INFORMATION);
				alert4.setTitle("Confirmation message");
				alert4.setContentText("This one's price is $10.99,are you sure to pick one?");
				//condition statement to confirm log out option 
				Optional<ButtonType> option= alert4.showAndWait();
				if(option.get().equals(ButtonType.OK)) {
					try { 
						redpocketLabel.setText("Red Pocket cost $10.99");
						totalcost+=redpocketPrice;
						
					} 
					catch(Exception e) {
						e.printStackTrace();
					}
					}
				}
	         if(event.getSource()==flower_button){
				Alert alert5=new Alert(AlertType.INFORMATION);
				alert5.setTitle("Confirmation message");
				alert5.setContentText("This one's price is $24.99,are you sure to pick one?");
				//condition statement to confirm log out option 
				Optional<ButtonType> option= alert5.showAndWait();
				if(option.get().equals(ButtonType.OK)) {
					try { 
						flowerLabel.setText("Peach Blossom cost $24.99");
						totalcost+=flowerprice;
						
					} 
					catch(Exception e) {
						e.printStackTrace();
					}
					}
				}
	         if(event.getSource()==bear_button) {
				Alert alert6=new Alert(AlertType.INFORMATION);
				alert6.setTitle("Confirmation message");
				alert6.setContentText("This one's price is $45.99,are you sure to pick one?");
				//condition statement to confirm log out option 
				Optional<ButtonType> option= alert6.showAndWait();
				if(option.get().equals(ButtonType.OK)) {
					try { 
						toybearLabel.setText("Toy Bear cost $45.99");
						totalcost+=toyBearprice;
						
					} 
					catch(Exception e) {
						e.printStackTrace();
					}
					}

				}	 	totalprice_label.setText("Total Price: "+String.valueOf(totalcost));

	 		}
	 	}

				
	         
	


