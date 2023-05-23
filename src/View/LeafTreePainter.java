package View;

import Model.Tree;
import Model.TreeSize;
import Model.TreeTrunkSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class LeafTreePainter extends TreePainter {

	// instance variable
	private PaintingPane paintingPane;

	// constructor
	public LeafTreePainter(PaintingPane paintingPane) {
		this.paintingPane = paintingPane;
	}

	// method that creates the leaftree with the right values
	public Pane drawLeafTree(Tree tree) {
		Pane treeLeafPane = new Pane();
		treeLeafPane.setLayoutX(tree.getRelX());
		treeLeafPane.setLayoutY(tree.getRelY());
		Rectangle trunk = createRectangle(tree);
		paintingPane.getLowestPanePoints().add(tree.getRelY());
		paintingPane.getCurrentXPanePoints().add(tree.getRelX());
		treeLeafPane.getChildren().addAll(trunk, createCircle(tree, trunk));
		return treeLeafPane;
	}

	// method that creates the circle for the leafTree
	public Circle createCircle(Tree tree, Rectangle rectangle) {
		double radius = getCircleSize(tree.getSize(), tree.getRelY());
		double xPos = tree.getRelX();
		double yPos = tree.getRelY() - radius - rectangle.getHeight();
		Color circleColor = getCircleColor(tree.getSize());
		Circle treeTop = new Circle(xPos, yPos, radius, circleColor);
		treeTop.setStroke(Color.BLACK);
		treeTop.setStrokeWidth(2);
		return treeTop;
	}

	// method that returns the values of te circle size
	public double getCircleSize(TreeSize treeSize, double yPos) {

		yPos = Math.pow(yPos / 600, 2);

		switch (treeSize) {
		case S:
			return 15 * yPos;
		case M:
			return 30 * yPos;
		case L:
			return 40 * yPos;
		case XL:
			return 50 * yPos;
		case XXL:
			return 60 * yPos;
		default:
			return 0;
		}
	}

	// method that returns the color of a Specific circle depending on size
	public Color getCircleColor(TreeSize treeSize) {

		switch (treeSize) {
		case S:
			return Color.GREENYELLOW;
		case M:
			return Color.GREEN;
		case L:
			return Color.DARKGREEN;
		case XL:
			return Color.FORESTGREEN;
		case XXL:
			return Color.LAWNGREEN;
		default:
			return Color.DARKOLIVEGREEN;
		}

	}

}
