import java.awt.Frame;

import Controller.MapController;
import IHM.MainWindow;
import Model.Map;


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
	}
}
