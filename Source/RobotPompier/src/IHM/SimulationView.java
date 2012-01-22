/**
 * 
 */
package IHM;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Utils.TimerLabel;


public class SimulationView extends JPanel {
	private static final long serialVersionUID = 1L;
	private TimerLabel labelTimer;
	public SimulationView() {
		labelTimer = new TimerLabel(0);
		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS ));
		this.add(new JLabel("Statistiques"));
		//showTimer();
	}
	
//	public static SimulationController getSimulationController()
//	{
//		return SimulationController;
//	}
	
	public void startTimer()
	{
		labelTimer.startTimerLabel();
		this.add(labelTimer);
	}
	
	public void stopTimer()
	{
		labelTimer.stopTimerLabel();
	}
}