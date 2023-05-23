package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Model.Tree;
import Model.TreeSize;
import Model.TreeType;
import javafx.stage.FileChooser;

public class FileIO {

	// instance variables
	private ArrayList<Tree> allTrees;
	private Controller controller;

	// constructor
	public FileIO(Controller controller) {
		this.controller = controller;
		allTrees = new ArrayList<>();
	}

	// Filereader method
	public void getFileTrees(String fileName) {
		allTrees.clear();
		controller.clearAllTrees();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(":");

				String typeString = parts[0];

				TreeType type = TreeType.valueOf(typeString.toUpperCase());
				TreeSize size = TreeSize.valueOf(parts[1]);
				double x = Double.parseDouble(parts[2]) / 100 * 800;
				double y = Double.parseDouble(parts[3]) / 100 * 600;

				Tree tree = new Tree(size, type, x, y);
				allTrees.add(tree);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		controller.addFileTrees(allTrees);
	}

	// method that retrieves file from within a filechooser
	public void getFile() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File("Resources//paintings"));
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", "*.painting"));
		File selectedFile = fileChooser.showOpenDialog(null);
		if (selectedFile != null) {
			getFileTrees(selectedFile.toString());
		}
	}

	// method that saves drawings which were made
	public void saveFile(ArrayList<Tree> trees) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Painting files", "*.painting"));
		fileChooser.setInitialDirectory(new File("Resources//paintings"));
		File selectedFile = fileChooser.showSaveDialog(null);
		if (selectedFile != null) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(selectedFile))) {
				for (Tree tree : trees) {
					bw.write(tree.getType().toString().toLowerCase() + ":" + tree.getSize() + ":"
							+ tree.getRelX() / 800 * 100 + ":" + tree.getRelY() / 600 * 100);
					bw.newLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
