package Model;

public class PineTopSize {
	// instance variables
	private static final int valuesAmount = 6;
	private double[] pineTopPoints;

	// constructor
	public PineTopSize(double[] pineTopPoints) {
		this.pineTopPoints = pineTopPoints;
		pineTopPoints = new double[valuesAmount];
	}

	public double[] getPineTopPoints() {
		return pineTopPoints;
	}

}
