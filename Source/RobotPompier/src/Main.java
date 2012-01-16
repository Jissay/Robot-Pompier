import java.awt.Frame;

import IHM.MainWindow;


public class Main {
	public static void main(String[] args) {
		MainWindow w = new MainWindow();
		w.setExtendedState(w.getExtendedState() | Frame.MAXIMIZED_BOTH);
		w.setVisible(true);
	}

}
