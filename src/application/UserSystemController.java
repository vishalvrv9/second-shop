 package application;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class UserSystemController implements Initializable{

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
		 
	 
	        if (event.getSource()==button1){
	        	Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("application/Image1.fxml"));
				System.out.println("-----loader: "+ loader.toString());
				Parent root = null;
				try {
					root = loader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(root, 600, 400);

				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.setTitle("Just confirm your order");
				primaryStage.setResizable(false);
				primaryStage.show();
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
	        	Stage primaryStage2 = new Stage();
				FXMLLoader loader2 = new FXMLLoader(getClass().getClassLoader().getResource("application/Image2.fxml"));
				System.out.println("-----loader: "+ loader2.toString());
				Parent root2 = null;
				try {
					root2 = loader2.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(root2, 600, 400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage2.setScene(scene);
				primaryStage2.setTitle("Just confirm your order");
				primaryStage2.setResizable(false);
				primaryStage2.show();
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
	        	Stage primaryStage3 = new Stage();
				FXMLLoader loader3 = new FXMLLoader(getClass().getClassLoader().getResource("application/Image3.fxml"));
				System.out.println("-----loader: "+ loader3.toString());
				Parent root3 = null;
				try {
					root3 = loader3.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene3 = new Scene(root3, 600, 400);

				scene3.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage3.setScene(scene3);
				primaryStage3.setTitle("Just confirm your order");
				primaryStage3.setResizable(false);
				primaryStage3.show();
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
	        	Stage primaryStage4 = new Stage();
				FXMLLoader loader4 = new FXMLLoader(getClass().getClassLoader().getResource("application/Image4.fxml"));
				System.out.println("-----loader: "+ loader4.toString());
				Parent root4 = null;
				try {
					root4 = loader4.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene4 = new Scene(root4, 600, 400);

				scene4.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage4.setScene(scene4);
				primaryStage4.setTitle("Just confirm your order");
				primaryStage4.setResizable(false);
				primaryStage4.show();
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
	        	Stage primaryStage5 = new Stage();
				FXMLLoader loader5 = new FXMLLoader(getClass().getClassLoader().getResource("application/Image5.fxml"));
				System.out.println("-----loader: "+ loader5.toString());
				Parent root5 = null;
				try {
					root5 = loader5.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene5 = new Scene(root5, 600, 400);

				scene5.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage5.setScene(scene5);
				primaryStage5.setTitle("Just confirm your order");
				primaryStage5.setResizable(false);
				primaryStage5.show();
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
	         if(event.getSource()==button6){
	        	Stage primaryStage6 = new Stage();
				FXMLLoader loader6 = new FXMLLoader(getClass().getClassLoader().getResource("application/Image6.fxml"));
				System.out.println("-----loader: "+ loader6.toString());
				Parent root6 = null;
				try {
					root6 = loader6.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene6 = new Scene(root6, 600, 400);
				scene6.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage6.setScene(scene6);
				primaryStage6.setTitle("Just confirm your order");
				primaryStage6.setResizable(false);
				primaryStage6.show();
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

	

	@Override
	public void initialize(URL location, ResourceBundle agr) {
		
	}
}


