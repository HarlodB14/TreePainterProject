package Controller;

import javafx.application.Platform;
import javafx.scene.layout.Pane;

public class TreeMoveThread {

	// instance variables
	private boolean running;
	private Controller controller;
	private Thread t;

	// constructor
	public TreeMoveThread(Controller controller) {
		this.controller = controller;
		running = false;
	}

	// Thread method that moves the trees, and relatively slows them.
	public void start() {
		if (!running) {
			running = true;
			t = new Thread(new Runnable() {
				@Override
				public void run() {
					while (running) {
						Platform.runLater(new Runnable() {
							public void run() {
								for (int i = 0; i < controller.getAllTrees().size(); i++) {
									Pane pane = controller.getAllTrees().get(i);
									if (controller.getCurrenXPanePoints().get(i) < -50) {
										pane.getChildren().get(1)
												.setLayoutX(pane.getChildren().get(1).getLayoutX() + 900.0);
										pane.getChildren().get(0)
												.setLayoutX(pane.getChildren().get(0).getLayoutX() + 900.0);
										controller.getCurrenXPanePoints().set(i,
												controller.getCurrenXPanePoints().get(i) + 900.0);
										continue;
									}
									double moveAmount = getMoveAmount(controller.getLowestPanePoints().get(i));
									pane.getChildren().get(1)
											.setLayoutX(pane.getChildren().get(1).getLayoutX() - moveAmount);
									pane.getChildren().get(0)
											.setLayoutX(pane.getChildren().get(0).getLayoutX() - moveAmount);
									controller.getCurrenXPanePoints().set(i,
											controller.getCurrenXPanePoints().get(i) - moveAmount);
								}
							}
						});
						try {
							Thread.sleep(1000 / 24);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
			t.start();
		}
	}

	// method that calculates the amount the tree needs to move
	public double getMoveAmount(double relY) {
		return Math.pow(relY / 300, 3);
	}

	// flag that gets triggered when clicked on play
	public void stop() {
		if (running) {
			running = false;
		}
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

}