package IHM;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Utils.TimerLabel;


public class SimulationView extends JPanel {
	private static final long serialVersionUID = 1L;
	private TimerLabel labelTimer;
	private JPanel panelTimer;
	
	public SimulationView() {
		labelTimer = new TimerLabel(0);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS ));
		this.add(new JLabel("Statistiques"));
		panelTimer = new JPanel();
		panelTimer.add(new JLabel("Temps écoulé depuis le début de la simulation :"));
	}
	
	public void startTimer() {
		labelTimer.startTimerLabel();
		panelTimer.add(labelTimer);
		this.add(panelTimer);
	}
	
	public void stopTimer() {
		labelTimer.stopTimerLabel();
	}
}