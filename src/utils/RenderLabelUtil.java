package utils;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class RenderLabelUtil {
	
	public static void renderLabelInfo(Label label, Color color, String text) {
		label.setTextFill(color);
		label.setText(text);
		System.out.println(text);
	}

}
