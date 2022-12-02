 package application;

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

public class UserSystemController {

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
    private Button No1;
    @FXML
    private Button No2;
    @FXML
    private Button No3;
    @FXML
    private Button No4;
    @FXML
    private Button No5;
    @FXML
    private Button No6;
    @FXML
    private Button Yes1;
    @FXML
    private Button Yes2;
    @FXML
    private Button Yes3;
    @FXML
    private Button Yes4;
    @FXML
    private Button Yes5;
    @FXML
    private Button Yes6;
    
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
					
						System.exit(0);
					} 
					catch(Exception e) {
						e.printStackTrace();
					}
					}
				}
	 			}

	

	
}


