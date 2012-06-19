package IHM;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Observer.AMapObserver;
import Utils.TimerLabel;


public class SimulationView extends AMapObserver {
	
	private JPanel simulationPanel;
	private JLabel labelRobot;
	private JLabel labelFire;
	private TimerLabel labelTimer;
	private JPanel panelTimer;
	private JPanel panelRobots;
	private JPanel panelFires;
	
	public JPanel getSimulationPanel() {
		return simulationPanel;
	}

	public void setSimulationPanel(JPanel simulationPanel) {
		this.simulationPanel = simulationPanel;
	}
	
	public SimulationView() {
		simulationPanel = new JPanel();
		labelTimer = new TimerLabel(0);
		labelRobot = new JLabel();
		labelFire = new JLabel();
		simulationPanel.setLayout(new GridLayout(3,1));
		
		panelTimer = new JPanel();
		panelRobots = new JPanel();
		panelFires = new JPanel();
		
		panelTimer.add(new JLabel("Temps écoulé depuis le début de la simulation : "));
		panelRobots.add(new JLabel("Nombre de robots sur la map : "));
		panelRobots.add(labelRobot);
		panelFires.add(new JLabel("Nombre d'incendies sur la map : "));
		panelFires.add(labelFire);
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

	@Override
	protected void mapLoading() {
		labelFire.setText("0");
		labelRobot.setText("0");
	}

	@Override
	protected void mapLoaded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void mapLoadingFailed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void mapSetRobot(int x, int y, String url) {
		labelRobot.setText(String.valueOf(Integer.parseInt(labelRobot.getText()) + (null != url ? 1 : -1)));
	}

	@Override
	protected void mapSetFire(int x, int y, int oldLevel, int fireLevel) {
		if (fireLevel == 0) labelFire.setText(String.valueOf(Integer.parseInt(labelFire.getText())-1));
		else if ((fireLevel == 1) && (fireLevel>oldLevel)) labelFire.setText(String.valueOf(Integer.parseInt(labelFire.getText())+1));
	}

	@Override
	protected void mapReloading() {
		labelFire.setText("0");
		labelRobot.setText("0");
	}
}