package application;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @FXML
    private Button btnView;
    @FXML
    private Label lblTreeNum;
    @FXML
    private Label lblBathNum;
    @FXML
    private TextField txtBuy;
    @FXML
	private  BarChart<String, Number> chart1;
    @FXML
	private  StackedBarChart<String,Number> chart2;
    @FXML
	private NumberAxis yAxis;
	@FXML
	private CategoryAxis xAxis;
	@FXML
	private NumberAxis yAxis1;
	@FXML
	private CategoryAxis xAxis1;
	@FXML
	private TableView tblCart;
	@FXML
	private Button btnDelete;
	@FXML
	private TableColumn tbcItem;
	@FXML
	private TableColumn tbcValue;

	
	
	
	
	ObservableList<Demo> data = FXCollections.observableArrayList();
	ArrayList<String> strings=new ArrayList<>();
	@FXML
	public void initialize() {
		btnDelete.setOnAction(event -> {
			int a=tblCart.getSelectionModel().getSelectedIndex();
			tblCart.getItems().remove(a);
			strings.remove(a);
			bookLabel.setVisible(false);
			laptopLabel.setVisible(false);
			cookiesLabel.setVisible(false);
			redpocketLabel.setVisible(false);
			flowerLabel.setVisible(false);
			toybearLabel.setVisible(false);
			for(int i=0;i<strings.size();i++){
				if(strings.get(i).equals("Book")){
					bookLabel.setVisible(true);
				}else if(strings.get(i).equals("laptop")){
					laptopLabel.setVisible(true);
				}else if(strings.get(i).equals("cookies")){
					cookiesLabel.setVisible(true);
				}else if(strings.get(i).equals("redPocket")){
					redpocketLabel.setVisible(true);
				}else if(strings.get(i).equals("flower")){
					flowerLabel.setVisible(true);
				}else if(strings.get(i).equals("bear")){
					toybearLabel.setVisible(true);
				}
			}
			double flowerprice=24.99;
			double bookprice=5.99;
			double laptopprice=699.99;
			double cookiesprice=3.99;
			double redpocketPrice=10.99;
			double toyBearprice=45.99;
			double totalcost=0;
			for (int i=0;i<1;i++) {
				if(bookLabel.isVisible()) {
					totalcost+=bookprice;
				}if(laptopLabel.isVisible()) {
					totalcost+=laptopprice;
				}if(cookiesLabel.isVisible()) {
					totalcost+=cookiesprice;
				}if(redpocketLabel.isVisible()) {
					totalcost+=redpocketPrice;
				}if(flowerLabel.isVisible()) {
					totalcost+=flowerprice;
				}if(toybearLabel.isVisible()) {
					totalcost+=toyBearprice;
				}totalprice_label.setText(String.valueOf("Total Cost: "+String.format("%.2f", totalcost)));
			}

		});
		tbcItem.setCellValueFactory(new PropertyValueFactory<>("name"));
		tbcValue.setCellValueFactory(new PropertyValueFactory<>("price"));
		tblCart.setItems(data);
		XYChart.Series<String, Number> series1 = new XYChart.Series<>();
		series1.setName("New Colthes");
		series1.getData().add(new XYChart.Data<>("Carbon", 21.1));
		series1.getData().add(new XYChart.Data<>("Energy", 38.8));
		series1.getData().add(new XYChart.Data<>("Water", 78.5));
		XYChart.Series<String, Number> series2 = new XYChart.Series<>();
		series2.setName("Second hand clothes");
		series2.getData().add(new XYChart.Data<>("Carbon", 3.7));
		series2.getData().add(new XYChart.Data<>("Energy", 4.8));
		series2.getData().add(new XYChart.Data<>("Water", 1.2));
		chart1.getData().addAll(series1,series2);

	
		XYChart.Series<String, Number> series3 = new XYChart.Series<>();
		series3.setName("Resale");
		series3.getData().add(new XYChart.Data<>("2017", 3));
		series3.getData().add(new XYChart.Data<>("2019",7));
		series3.getData().add(new XYChart.Data<>("2021",15));
		series3.getData().add(new XYChart.Data<>("2023",27));
		series3.getData().add(new XYChart.Data<>("2025",47));

		XYChart.Series<String, Number> series4 = new XYChart.Series<>();
		series4.setName("Traditional donation");
		series4.getData().add(new XYChart.Data<>("2017", 17));
		series4.getData().add(new XYChart.Data<>("2019",21));
		series4.getData().add(new XYChart.Data<>("2021",21));
		series4.getData().add(new XYChart.Data<>("2023",26));
		series4.getData().add(new XYChart.Data<>("2025",30));
		chart2.getData().addAll(series3,series4);}
	




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
		 bookLabel.setText("books cost $5.99");
		 laptopLabel.setText("laptop cost $699.99");
		 cookiesLabel.setText("Cookies cost $3.99");
		 redpocketLabel.setText("Red Pocket cost $10.99");
		 flowerLabel.setText("Peach Blossom cost $24.99");
		 toybearLabel.setText("Toy Bear cost $45.99");
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
						bookLabel.setVisible(true);
						data.add(new Demo("Book","$5.99"));
						strings.add("Book");
					
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
						laptopLabel.setVisible(true);
						data.add(new Demo("laptop","$669.99"));

						strings.add("laptop");


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
						cookiesLabel.setVisible(true);
						data.add(new Demo("cookies","$3.99"));
						strings.add("cookies");
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
						redpocketLabel.setVisible(true);
						data.add(new Demo("redPocket","$10.99"));

						strings.add("redPocket");

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
						flowerLabel.setVisible(true);
						data.add(new Demo("flower","$24.99"));

						strings.add("flower");

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
						toybearLabel.setVisible(true);
						data.add(new Demo("bear","$45.99"));

						strings.add("bear");

					} 
					catch(Exception e) {
						e.printStackTrace();
					}
					}

				}	
//count total price of item in cart page -------not work 
	        for (int i=0;i<1;i++) {
	        	if(bookLabel.isVisible()) {
	        		totalcost+=bookprice;
	        	}if(laptopLabel.isVisible()) {
	        		totalcost+=laptopprice;
	        	}if(cookiesLabel.isVisible()) {
	        		totalcost+=cookiesprice;
	        	}if(redpocketLabel.isVisible()) {
	        		totalcost+=redpocketPrice;
	        	}if(flowerLabel.isVisible()) {
	        		totalcost+=flowerprice;
	        	}if(toybearLabel.isVisible()) {
	        		totalcost+=toyBearprice;
	        	}totalprice_label.setText(String.valueOf("Total Cost: "+String.format("%.2f", totalcost)));
	        }
	        
	 		}
	 	

        public void clickButton(ActionEvent event) { 
	 
	     if (event.getSource() == btnView){
   	       System.out.println("view");
		 String test = txtBuy.getText();
		 int i = Integer.parseInt(test);
		 lblTreeNum.setText(String.format("%.2f",i*0.2));
		 lblBathNum.setText(String.format("%.2f",i*3.8));				 
    }	
	 }		
}    
	


