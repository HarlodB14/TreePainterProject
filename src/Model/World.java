package Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class World {

	// instance variables
	private ArrayList<Tree> trees;

	// constructor
	public World() {
		trees = new ArrayList<>();
	}

	// method that adds a tree in the list
	public void addTree(Tree tree) {
		trees.add(tree);
	}

	// method that clears all trees
	public void clearAllTrees() {
		trees.clear();
	}

	public ArrayList<Tree> getTrees() {
		return trees;
	}

}
