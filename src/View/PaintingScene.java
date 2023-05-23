package View;

import Controller.Controller;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PaintingScene extends Scene {

	// instance variables
	private BorderPane root;
	private MenuPane menupane;
	private PaintingPane paintingPane;
	private Controller controller;

	// constructor
	public PaintingScene(Controller controller) {
		super(new Pane(), 800, 600);
		this.controller = controller;
		root = new BorderPane();
		menupane = new MenuPane(controller);
		paintingPane = new PaintingPane();
		root.setTop(menupane);
		root.setCenter(paintingPane);
		setRoot(root);
	}

	public PaintingPane getpaintingPane() {
		return paintingPane;
	}

}
