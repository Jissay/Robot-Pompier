package IHM;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Observer.ASimulationObserver;
import Utils.TimerLabel;


public class SimulationView extends ASimulationObserver {
	
	private JPanel simulationPanel;
	
	public JPanel getSimulationPanel() {
		return simulationPanel;
	}

	public void setSimulationPanel(JPanel simulationPanel) {
		this.simulationPanel = simulationPanel;
	}

	private TimerLabel labelTimer;
	private JPanel panelTimer;
	private JPanel panelRobots;
	private JPanel panelFires;
	
	public SimulationView() {
		simulationPanel = new JPanel();
		labelTimer = new TimerLabel(0);
		simulationPanel.setLayout(new GridLayout(3,1));
		//this.add(new JLabel("Statistiques"));
		
		panelTimer = new JPanel();
		panelRobots = new JPanel();
		panelFires = new JPanel();
		
		panelTimer.add(new JLabel("Temps écoulé depuis le début de la simulation : "));
		panelRobots.add(new JLabel("Nombre de robots sur la map : "));
		panelFires.add(new JLabel("Nombre d'incendies sur la map : "));
		simulationPanel.add(panelTimer);
		simulationPanel.add(panelRobots);
		simulationPanel.add(panelFires);
	}
	
	public void startTimer() {
		labelTimer.startTimerLabel();
		panelTimer.add(labelTimer);
	}
	
	public void stopTimer() {
		labelTimer.stopTimerLabel();
	}
}