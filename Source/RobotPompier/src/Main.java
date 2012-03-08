import java.awt.Frame;
import java.util.ArrayList;

import Controller.MapController;
import IHM.MainWindow;
import Model.Cell;
import Model.Map;
import Model.Robot;
import Model.algorithms.Algorithm;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		Map map = new Map();
		
		MainWindow w = new MainWindow(1, 1);
		w.setExtendedState(w.getExtendedState() | Frame.MAXIMIZED_BOTH);
		w.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		MapController.getInstance().setModel(map);
		MapController.getInstance().setView(w.getMapView());
		w.setVisible(true);
		map.addObserver(w.getMapView());
		map.addObserver(w.getEventsView());
		
		// Test algo move forward
		Robot robot = new Robot();
		robot.setCell(new Cell(8, 5, 0));
		Cell cellToReach = new Cell(1,1, 0);
		ArrayList<Cell> test = Algorithm.findBestWay(map, robot, cellToReach);

		System.out.println(test.toString());
	}
}
