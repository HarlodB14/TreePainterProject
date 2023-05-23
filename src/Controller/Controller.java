package Controller;

import java.util.ArrayList;
import java.util.Random;

import Model.Tree;
import Model.TreeSize;
import Model.TreeType;
import Model.World;
import View.PaintingPane;
import View.PaintingScene;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Controller {

	// instance variables
	private Stage stage;
	private PaintingScene paintingScene;
	private PaintingPane paintingPane;
	private World world;
	private Random random;
	private TreeMoveThread thread;
	private FileIO fileIO;

	// constructor
	public Controller(Stage stage) {
		this.stage = stage;
		setstage();
		random = new Random();
		world = new World();
		thread = new TreeMoveThread(this);
		fileIO = new FileIO(this);
	}

	// method that adds a leaftree
	public void addLeafTree() {
		random = new Random();

		for (int i = 0; i < 1; i++) {
			double x = random.nextInt(800);
			double y = random.nextInt(265) + 300;

			TreeSize size = TreeSize.values()[random.nextInt(TreeSize.values().length)];
			TreeType type = TreeType.values()[random.nextInt(TreeType.values().length)];
			Tree tree = new Tree(size, type, x, y);
			world.addTree(tree);
			paintingPane.drawLeafTree(tree);
		}
		drawTrees();
	}

	// method that starts the movement thread
	public void toggleThread() {
		if (thread.isRunning()) {
			thread.stop();
		} else {
			thread.start();
		}
	}

	// method that adds a hundredtrees randomly
	public void addHundredTrees() {
		random = new Random();
		int amountOfTrees = 100;

		for (int i = 0; i < amountOfTrees; i++) {
			double x = random.nextInt(800);
			double y = random.nextInt(250) + 300;

			TreeSize size = TreeSize.values()[random.nextInt(TreeSize.values().length)];
			TreeType type = TreeType.values()[random.nextInt(TreeType.values().length)];
			Tree tree = new Tree(size, type, x, y);
			world.addTree(tree);
			if (tree.getType() == TreeType.LEAF) {
				paintingPane.drawLeafTree(tree);
			} else {
				paintingPane.drawPineTree(tree);
			}

		}
		drawTrees();
	}

	// method that adds tree from a loadFile
	public void addFileTrees(ArrayList<Tree> allTrees) {

		for (int i = 0; i < allTrees.size(); i++) {
			world.addTree(allTrees.get(i));
			if (allTrees.get(i).getType() == TreeType.LEAF) {
				paintingPane.drawLeafTree(allTrees.get(i));
			} else {
				paintingPane.drawPineTree(allTrees.get(i));
			}

		}
		drawTrees();
	}

	// method that adds a pineTree
	public void addPineTRee() {
		random = new Random();

		for (int i = 0; i < 1; i++) {
			double x = random.nextInt(800);
			double y = random.nextInt(250) + 300;

			TreeSize size = TreeSize.values()[random.nextInt(TreeSize.values().length)];
			TreeType type = TreeType.values()[random.nextInt(TreeType.values().length)];
			Tree tree = new Tree(size, type, x, y);
			world.addTree(tree);
			paintingPane.drawPineTree(tree);
		}
		drawTrees();
	}

	// method that clears all the trees from the world & pane
	public void clearAllTrees() {
		world.clearAllTrees();
		paintingPane.clearAll();
	}

	// method that draws the trees in correct order
	public void drawTrees() {
		paintingPane.sortPanesByLowestPoint();
		paintingPane.drawAllTrees();
	}

	// method that initializes the pane/scene & stage
	public void setstage() {
		stage.setTitle("PROG4_ASS_Painting_Harlod_Bombala");
		paintingScene = new PaintingScene(this);
		paintingPane = paintingScene.getpaintingPane();
		stage.setScene(paintingScene);
		stage.show();
		setstageonMiddleOfScreen();
	}

	// method that places stage on the middle of the screen
	public void setstageonMiddleOfScreen() {
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		stage.setX((screenBounds.getWidth() - stage.getWidth()) / 2);
		stage.setY((screenBounds.getHeight() - stage.getHeight()) / 2);
	}

	public ArrayList<Pane> getAllTrees() {
		return paintingPane.getAllTrees();
	}

	public ArrayList<Double> getLowestPanePoints() {
		return paintingPane.getLowestPanePoints();
	}

	public TreeMoveThread getThread() {
		return thread;
	}

	public ArrayList<Double> getCurrenXPanePoints() {
		return paintingPane.getCurrentXPanePoints();
	}

	public FileIO getFileIO() {
		return fileIO;
	}

	public World getWorld() {
		return world;
	}

}
