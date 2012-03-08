package IHM;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Utils.TimerLabel;


public class SimulationView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private TimerLabel labelTimer;
	private JPanel panelTimer;
	private JPanel panelRobots;
	private JPanel panelFires;
	
	public SimulationView() {
		labelTimer = new TimerLabel(0);
		this.setLayout(new GridLayout(3,1));
		//this.add(new JLabel("Statistiques"));
		
		panelTimer = new JPanel();
		panelRobots = new JPanel();
		panelFires = new JPanel();
		
		panelTimer.add(new JLabel("Temps écoulé depuis le début de la simulation : "));
		panelRobots.add(new JLabel("Nombre de robots sur la map : "));
		panelFires.add(new JLabel("Nombre d'incendies sur la map : "));
		this.add(panelTimer);
		this.add(panelRobots);
		this.add(panelFires);
	}
	
	public void startTimer() {
		labelTimer.startTimerLabel();
		panelTimer.add(labelTimer);
	}
	
	public void stopTimer() {
		labelTimer.stopTimerLabel();
	}
}