package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Main extends Application {

	// define your offsets here
	private double xOffset = 0;
	private double yOffset = 0;

	@Override
	public void start(Stage stage) throws Exception{
//try {
//			
//			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("application/Loginfx.fxml"));
//            Parent root = loader.load();
//
//            // adds comment to commit to git
//			Scene scene = new Scene(root,500,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.setTitle("Second Shop System - best system for helping :) !");
//			primaryStage.getIcons().add(new Image("medias/icon.png"));
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//			
//		}

		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/LoginPane.fxml"));
		stage.initStyle(StageStyle.DECORATED);
		stage.setMaximized(false);

		// grab your root here
		root.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		});

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
//            Parent root = loader.load();
//
//            // adds comment to commit to git
//			Scene scene = new Scene(root,500,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.setTitle("Second Shop System - best system for helping :) !");
//			primaryStage.getIcons().add(new Image("medias/icon.png"));
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//			
//		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
