import java.awt.Frame;
import java.util.ArrayList;

import Controller.MapController;
import IHM.MainWindow;
import Model.Cell;
import Model.Map;
import Model.Robot;
import Model.algorithms.Algorithm;


public class Main {
	public static void main(String[] args) {
		MapController ctrl = new MapController();
		Map map = new Map(10, 10);
		MainWindow w = new MainWindow();
		w.setExtendedState(w.getExtendedState() | Frame.MAXIMIZED_BOTH);
		w.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		w.getMapView().setController(ctrl);
		ctrl.setModel(map);
		ctrl.setView(w.getMapView());
		w.setVisible(true);
		
		// Test algo move forward
		Robot robot = new Robot();
		robot.setCell(new Cell(8, 5));
		Cell cellToReach = new Cell(1,1);
		ArrayList<Cell> test = Algorithm.findBestWay(map, robot, cellToReach);

		System.out.println(test.toString());
	}
}
