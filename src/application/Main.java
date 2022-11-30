package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("application/Loginfx.fxml"));
            Parent root = loader.load();

            // adds comment to commit to git
			Scene scene = new Scene(root,500,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Second Shop System - best system for helping :) !");
			primaryStage.getIcons().add(new Image("icon.png"));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			// just for testing
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
