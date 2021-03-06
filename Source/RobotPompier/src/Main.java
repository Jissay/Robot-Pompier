import java.awt.Frame;

import Controller.MapController;
import IHM.MainWindow;
import Model.Map;
import Model.Simulation;

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
		Simulation simulation = new Simulation();
		
		MainWindow w = new MainWindow(1, 1);
		w.setExtendedState(w.getExtendedState() | Frame.MAXIMIZED_BOTH);
		w.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		MapController.getInstance().setModel(map);
		MapController.getInstance().setView(w.getMapView());
		w.setVisible(true);
		map.addObserver(w.getMapView());
		map.addObserver(w.getEventsView());
		map.addObserver(w.getSimulationView());
		simulation.addObserver(w.getSimulationView());
	}
}
