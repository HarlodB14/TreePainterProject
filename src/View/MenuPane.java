package View;

import Controller.Controller;
import javafx.application.Platform;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

public class MenuPane extends Pane {

	// instance variables
	private MenuBar menubar;
	private Menu fileMenu;
	private Menu tree;
	private Menu movie;
	private Controller controller;

	// constructor
	public MenuPane(Controller controller) {
		this.controller = controller;
		createMenu();
	}

	// method that creates a menubar with items
	public void createMenu() {
		menubar = new MenuBar();
		fileMenu = new Menu("File");
		tree = new Menu("Tree");
		movie = new Menu("Movie");

		MenuItem load = new MenuItem("load painting...");
		load.setOnAction(e -> controller.getFileIO().getFile());
		MenuItem save = new MenuItem("save painting as");
		save.setOnAction(e -> controller.getFileIO().saveFile(controller.getWorld().getTrees()));
		MenuItem exit = new MenuItem("exit");
		exit.setOnAction(e -> {
			Platform.exit();
		});
		MenuItem addleaf = new MenuItem("add Leaf Tree");
		addleaf.setOnAction(e -> controller.addLeafTree());
		MenuItem addpine = new MenuItem("add Pine Tree");
		addpine.setOnAction(e -> controller.addPineTRee());
		MenuItem addhundred = new MenuItem("add 100 Trees");
		addhundred.setOnAction(e -> controller.addHundredTrees());
		MenuItem clearall = new MenuItem("clear All Trees");
		clearall.setOnAction(e -> controller.clearAllTrees());
		CheckMenuItem play = new CheckMenuItem("play");
		play.setOnAction(e -> {
			controller.toggleThread();
		});

		fileMenu.getItems().addAll(load, save, exit);
		tree.getItems().addAll(addleaf, addpine, addhundred, clearall);
		movie.getItems().add(play);
		menubar.getMenus().addAll(fileMenu, tree, movie);
		menubar.setPrefSize(800, 10);
		this.getChildren().add(menubar);
	}

}
