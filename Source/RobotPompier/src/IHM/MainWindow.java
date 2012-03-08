package IHM;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class MainWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private RobotModelView robotModelView;
	private EventsView eventsView;
	private MapView mapView;
	private SimulationView simulationView;

	public MainWindow(int width, int height) {
		setTitle("Fire Disaster Simulator");
		getContentPane().setLayout(new BorderLayout());
		JPanel east = new JPanel();
		east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));
		add(east, BorderLayout.EAST);
		simulationView = new SimulationView();
		east.add(simulationView);
		robotModelView = new RobotModelView();
		east.add(robotModelView);
		mapView = new MapView(width, height);
		add(mapView, BorderLayout.CENTER);
		eventsView = new EventsView();
		add(eventsView, BorderLayout.SOUTH);
		createMenuBar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public MapView getMapView() {
		return mapView;
	}

	public void setMapView(MapView mapView) {
		this.mapView = mapView;
	}

	public SimulationView getSimulationView() {
		return simulationView;
	}

	public void setSimulationView(SimulationView simulationView) {
		this.simulationView = simulationView;
	}

	public RobotModelView getRobotModelView() {
		return robotModelView;
	}

	public void setRobotModelView(RobotModelView robotModelView) {
		this.robotModelView = robotModelView;
	}

	public EventsView getEventsView() {
		return eventsView;
	}

	public void setEventsView(EventsView eventsView) {
		this.eventsView = eventsView;
	}

	private void createMenuBar() {
		JMenuBar bar = new JMenuBar();
		
		JMenu simulation = new JMenu("Simulation");
		JMenu help = new JMenu("Aide");
		
		simulation.setMnemonic('s');
		
		JMenuItem run = new JMenuItem("Lancer");
		run.setMnemonic('r');
		run.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		run.getAccessibleContext().setAccessibleDescription("Lance la simulation");
		run.setActionCommand("Run");
		run.addActionListener(this);
		simulation.add(run);
		JMenuItem stop = new JMenuItem("Arrêter");
		stop.setMnemonic('a');
		stop.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		stop.getAccessibleContext().setAccessibleDescription("Arréte la simulation");
		stop.setActionCommand("Stop");
		stop.addActionListener(this);
		simulation.add(stop);
		simulation.addSeparator();
		JMenuItem quit = new JMenuItem("Quitter");
		quit.setMnemonic('q');
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		quit.getAccessibleContext().setAccessibleDescription("Quitte l'application");
		quit.setActionCommand("Quit");
		quit.addActionListener(this);
		simulation.add(quit);
		
		JMenuItem about = new JMenuItem("A propos");
		about.setMnemonic('p');
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		about.getAccessibleContext().setAccessibleDescription("Affiche les informations concernant le logiciel");
		about.setActionCommand("Propos");
		about.addActionListener(this);
		help.add(about);
		
		bar.add(simulation);
		bar.add(help);
		setJMenuBar(bar);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Quit"))
			System.exit(0);
		else if (arg0.getActionCommand().equals("Run"))
			getSimulationView().startTimer();
		else if (arg0.getActionCommand().equals("Stop"))
			getSimulationView().stopTimer();
		else if (arg0.getActionCommand().equals("Propos"))
			new AboutDialog();
	}
}