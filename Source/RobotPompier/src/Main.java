import IHM.MainWindow;


public class Main {
	public static void main(String[] args) {		
		MainWindow w = new MainWindow();
		//w.setExtendedState(w.getExtendedState() | Frame.MAXIMIZED_BOTH);
		w.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		w.setVisible(true);
	}
}
