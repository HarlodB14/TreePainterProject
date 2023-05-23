package View;

import Model.PineTopSize;
import Model.Tree;
import Model.TreeSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class PineTreePainter extends TreePainter {

	// instance variables
	private PaintingPane paintingPane;

	// constructor
	public PineTreePainter(PaintingPane paintingPane) {
		this.paintingPane = paintingPane;
	}

	// method that draws a pineTree with the right values
	public Pane drawPineTree(Tree tree) {
		Pane pineLeafTreePane = new Pane();
		pineLeafTreePane.setLayoutX(tree.getRelX());
		pineLeafTreePane.setLayoutY(tree.getRelY());
		Rectangle trunk = createRectangle(tree);
		paintingPane.getLowestPanePoints().add(tree.getRelY());
		paintingPane.getCurrentXPanePoints().add(tree.getRelX());
		pineLeafTreePane.getChildren().addAll(trunk, createTriangleTop(tree, trunk));
		return pineLeafTreePane;
	}

	// method that draws a straight triangle for the treetop with the right size and
	// values
	public Polygon createTriangleTop(Tree tree, Rectangle rectangle) {
		PineTopSize trianglePoints = getTriangleSize(tree.getSize(), tree.getRelY());
		Color triangleColor = getPineTopColor(tree.getSize());
		Polygon triangleTop = new Polygon(trianglePoints.getPineTopPoints());
		triangleTop.setLayoutX(tree.getRelX() - rectangle.getWidth() / 2);
		triangleTop.setLayoutY(tree.getRelY() - rectangle.getHeight());
		triangleTop.setFill(triangleColor);
		triangleTop.setStroke(Color.BLACK);
		triangleTop.setStrokeWidth(2);
		return triangleTop;
	}

	// method that calculates the right size for the triangle polygonShape
	public PineTopSize getTriangleSize(TreeSize treeSize, double yPos) {
		yPos = Math.pow(yPos / 600, 2);
		double scaleFactor = 0.0;

		switch (treeSize) {
		case S:
			scaleFactor = 1 * yPos;
			break;
		case M:
			scaleFactor = 1.5 * yPos;
			break;
		case L:
			scaleFactor = 2 * yPos;
			break;
		case XL:
			scaleFactor = 2.5 * yPos;
			break;
		case XXL:
			scaleFactor = 3 * yPos;
			break;
		default:
			scaleFactor = 1;
		}
		return new PineTopSize(
				new double[] { 0 - 22 * scaleFactor, 0, 4 * scaleFactor, 0 - 50 * scaleFactor, 30 * scaleFactor, 0 });
	}

	// method that sets a specific color for each different size of pine
	public Color getPineTopColor(TreeSize treeSize) {

		switch (treeSize) {
		case S:
			return Color.SEAGREEN;
		case M:
			return Color.LIGHTGREEN;
		case L:
			return Color.PALEGREEN;
		case XL:
			return Color.SPRINGGREEN;
		case XXL:
			return Color.LIMEGREEN;
		default:
			return Color.MEDIUMAQUAMARINE;
		}

	}

}
