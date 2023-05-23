package Model;

public class Tree {
	// instance variables
	private TreeSize size;
	private TreeType type;
	private double relX;
	private double relY;
	private int trunkWidth;
	private int trunkHeight;

	// constructor
	public Tree(TreeSize size, TreeType type, double x, double y) {
		this.size = size;
		this.type = type;
		this.relX = x;
		this.relY = y;
		if(x > 100) {
			System.out.println(x);
		}
	}

	public void move(double x) {
		this.relX -= x;
	}

	public TreeSize getSize() {
		return size;
	}

	public void setSize(TreeSize size) {
		this.size = size;
	}

	public TreeType getType() {
		return type;
	}

	public void setType(TreeType type) {
		this.type = type;
	}

	public double getRelX() {
		return relX;
	}

	public void setRelX(double relX) {
		this.relX = relX;
	}

	public double getRelY() {
		return relY;
	}

	public void setRelY(double relY) {
		this.relY = relY;
	}

	public int getTrunkWidth() {
		return trunkWidth;
	}

	public void setTrunkWidth(int trunkWidth) {
		this.trunkWidth = trunkWidth;
	}

	public int getTrunkHeight() {
		return trunkHeight;
	}

	public void setTrunkHeight(int trunkHeight) {
		this.trunkHeight = trunkHeight;
	}

}
