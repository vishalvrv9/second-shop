package utils;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PaneRouter {
	
	public static void route(Object o, Event event, String destinationRoute) {
		try {

			Node node = (Node) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();
//            stage.setMaximized(true);
			stage.close();
			Scene scene = new Scene(FXMLLoader.load(o.getClass().getResource(destinationRoute)));
			stage.setScene(scene);
			stage.show();

		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println(ex.getMessage());
		}
	}

}
