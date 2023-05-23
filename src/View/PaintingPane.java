package View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Model.Tree;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PaintingPane extends StackPane {

	// instance variables
	private Rectangle sky;
	private Rectangle ground;
	private LeafTreePainter leafTreePainter;
	private PineTreePainter pineTreePainter;
	private ArrayList<Pane> allTreePanes;
	private ArrayList<Double> lowestPanePoints;
	private ArrayList<Double> currentXPanePoints;

	// constructor
	public PaintingPane() {
		this.setPrefSize(800, 600);
		lowestPanePoints = new ArrayList<>();
		allTreePanes = new ArrayList<>();
		currentXPanePoints = new ArrayList<>();
		leafTreePainter = new LeafTreePainter(this);
		pineTreePainter = new PineTreePainter(this);
		drawSkyGround();
	}

	// method that draws leaftreePaneElements
	public void drawLeafTree(Tree tree) {
		allTreePanes.add(leafTreePainter.drawLeafTree(tree));
	}

	// method that draws PineTreePaneElements
	public void drawPineTree(Tree tree) {
		allTreePanes.add(pineTreePainter.drawPineTree(tree));
	}

	// method that bubblesorts the pane by the lowestPoint
	public void sortPanesByLowestPoint() {
		for (int i = 0; i < allTreePanes.size() - 1; i++) {
			for (int j = 1; j < lowestPanePoints.size() - i - 1; j++) {
				if (lowestPanePoints.get(j) > lowestPanePoints.get(j + 1)) {
					Pane temp = allTreePanes.get(j);
					allTreePanes.set(j, allTreePanes.get(j + 1));
					allTreePanes.set(j + 1, temp);
					double tempPoints = lowestPanePoints.get(j);
					lowestPanePoints.set(j, lowestPanePoints.get(j + 1));
					lowestPanePoints.set(j + 1, tempPoints);
					double tempX = currentXPanePoints.get(j);
					currentXPanePoints.set(j, currentXPanePoints.get(j + 1));
					currentXPanePoints.set(j + 1, tempX);
				}
			}
		}
	}

	// method that draws all the trees
	public void drawAllTrees() {
		for (Pane pane : allTreePanes) {
			this.getChildren().remove(pane);
		}
		sortPanesByLowestPoint();
		for (Pane pane : allTreePanes) {
			this.getChildren().add(pane);
		}
	}

	// method that draws the ground and the sky
	public void drawSkyGround() {
		VBox vbox = new VBox();
		sky = new Rectangle(800, 300);
		sky.setFill(Color.SKYBLUE);
		ground = new Rectangle(800, 300);
		ground.setFill(Color.ORANGE);
		vbox.getChildren().addAll(sky, ground);
		this.getChildren().addAll(vbox);
	}

	// method that removes the panes from the list and the lists where the
	// coordinasted are being kept from
	public void clearAll() {
		getChildren().removeAll(allTreePanes);
		allTreePanes.clear();
		lowestPanePoints.clear();
		currentXPanePoints.clear();
	}

	public ArrayList<Pane> getAllTrees() {
		return allTreePanes;
	}

	public ArrayList<Double> getLowestPanePoints() {
		return lowestPanePoints;
	}

	public void setLowestPanePoints(ArrayList<Double> lowestPanePoints) {
		this.lowestPanePoints = lowestPanePoints;
	}

	public ArrayList<Double> getCurrentXPanePoints() {
		return currentXPanePoints;
	}

	public void setCurrentXPanePoints(ArrayList<Double> currentXPanePoints) {
		this.currentXPanePoints = currentXPanePoints;
	}

}
