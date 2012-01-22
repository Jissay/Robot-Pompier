/**
 * 
 */
package IHM;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Utils.TimerLabel;


public class SimulationView extends JPanel {
	private static final long serialVersionUID = 1L;
	public SimulationView() {
		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS ));
		this.add(new JLabel("Statistiques"));
		//showTimer();
	}
	
//	public static SimulationController getSimulationController()
//	{
//		return SimulationController;
//	}
	
	public void showTimer()
	{
			JLabel labelTimer = new TimerLabel(0);
			this.add(labelTimer);
	}
}