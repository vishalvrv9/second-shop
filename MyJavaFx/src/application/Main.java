package application;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
@Override
public void start(Stage primaryStage) {
	Pane pane = new HBox();
	pane.setPadding(new Insets(10,10,10,10));
	
    Image image = new Image("images/eiei.png");
    pane.getChildren().add(new ImageView(image));
    
   Scene scene = new Scene(pane);

primaryStage.setTitle("MyShowImange");
primaryStage.setScene(scene);
primaryStage.show();
}
public static void main(String[] args) {
	 launch(args);
		}
}
