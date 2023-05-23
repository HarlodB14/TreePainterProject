package View;

import Model.Tree;
import Model.TreeSize;
import Model.TreeTrunkSize;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class TreePainter {

	// method that calculates the correct size for a trunk depending on the format
	public TreeTrunkSize getRectangelSize(TreeSize treeSize, double yPos) {
		yPos = Math.pow(yPos / 600, 2);

		switch (treeSize) {
		case S:
			return new TreeTrunkSize(5 * yPos, 15 * yPos);
		case M:
			return new TreeTrunkSize(10 * yPos, 30 * yPos);
		case L:
			return new TreeTrunkSize(15 * yPos, 45 * yPos);
		case XL:
			return new TreeTrunkSize(20 * yPos, 60 * yPos);
		case XXL:
			return new TreeTrunkSize(25 * yPos, 75 * yPos);
		default:
			return new TreeTrunkSize(0, 0);
		}

	}

	// method that creates a rectangle with the right values
	public Rectangle createRectangle(Tree tree) {
		double width = getRectangelSize(tree.getSize(), tree.getRelY()).getWidth();
		double height = getRectangelSize(tree.getSize(), tree.getRelY()).getHeight();
		double xPos = tree.getRelX() - (width / 2);
		double yPos = tree.getRelY() - height;
		Color trunkColor = Color.SADDLEBROWN;

		Rectangle trunk = new Rectangle(xPos, yPos, width, height);
		trunk.setFill(trunkColor);
		trunk.setStroke(Color.BLACK);
		trunk.setStrokeWidth(2);
		return trunk;
	}

}
