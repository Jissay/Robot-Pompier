/**
 * 
 */
package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MainWindow extends JFrame implements ActionListener {
	private static final long serialVersionUID = -5464261678769218180L;
	
	public MainWindow() {
		setTitle("Fire Disaster Simulator");
		simulationView = new SimulationView();
		add(simulationView);
		createMenuBar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private MapView mapView;

	public MapView getMapView() {
		// begin-user-code
		return mapView;
		// end-user-code
	}

	public void setMapView(MapView mapView) {
		// begin-user-code
		this.mapView = mapView;
		// end-user-code
	}

	private SimulationView simulationView;

	public SimulationView getSimulationView() {
		// begin-user-code
		return simulationView;
		// end-user-code
	}

	public void setSimulationView(SimulationView simulationView) {
		// begin-user-code
		this.simulationView = simulationView;
		// end-user-code
	}

	private RobotModelView robotModelView;

	public RobotModelView getRobotModelView() {
		// begin-user-code
		return robotModelView;
		// end-user-code
	}

	public void setRobotModelView(RobotModelView robotModelView) {
		// begin-user-code
		this.robotModelView = robotModelView;
		// end-user-code
	}

	private EventsView eventsView;

	public EventsView getEventsView() {
		// begin-user-code
		return eventsView;
		// end-user-code
	}

	public void setEventsView(EventsView eventsView) {
		// begin-user-code
		this.eventsView = eventsView;
		// end-user-code
	}

	private RobotModelView robotModelView2;

	public RobotModelView getRobotModelView2() {
		// begin-user-code
		return robotModelView2;
		// end-user-code
	}

	public void setRobotModelView2(RobotModelView robotModelView2) {
		// begin-user-code
		this.robotModelView2 = robotModelView2;
		// end-user-code
	}
	
	private void createMenuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu simulation = new JMenu("Simulation");
		simulation.setMnemonic('s');
		JMenuItem run = new JMenuItem("Lancer");
		run.setMnemonic('r');
		run.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		run.getAccessibleContext().setAccessibleDescription("Lance la simulation");
		run.setActionCommand("Run");
		run.addActionListener(this);
		simulation.add(run);
		JMenuItem quit = new JMenuItem("Quitter");
		quit.setMnemonic('q');
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		quit.getAccessibleContext().setAccessibleDescription("Quitte l'application");
		quit.setActionCommand("Quit");
		quit.addActionListener(this);
		simulation.add(quit);
		bar.add(simulation);
		setJMenuBar(bar);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Quit"))
			System.exit(0);
		if (arg0.getActionCommand().equals("Run")) {
			// TODO
		}
	}
}