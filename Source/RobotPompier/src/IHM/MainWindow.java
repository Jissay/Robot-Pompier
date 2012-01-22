/**
 * 
 */
package IHM;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Model.Cell;
import Model.Map;
import Model.Robot;

public class MainWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private RobotModelView robotModelView;
	private EventsView eventsView;
	private MapView mapView;
	private SimulationView simulationView;

	public MainWindow() {
		setTitle("Fire Disaster Simulator");
		getContentPane().setLayout(new BorderLayout());
		JPanel east = new JPanel();
		east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));
		add(east, BorderLayout.EAST);
		simulationView = new SimulationView();
		east.add(simulationView);
		robotModelView = new RobotModelView();
		east.add(robotModelView);
		mapView = new MapView(10, 10);
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
		JMenuItem stop = new JMenuItem("Arréter");
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
		else if (arg0.getActionCommand().equals("Run")) {
			// getSimulationView().startTimer(); Commenté pour prototype
			new Thread(new Runnable() {
				public void run() {
					int valueTimer = 1000;
					while (valueTimer <= 6000) {
						try{
							//do what you want to do before sleeping
							Thread.currentThread().sleep(1000);//sleep for 1000 ms
							//do what you want to do after sleeptig
						} catch(InterruptedException ie){
							//If this thread was intrrupted by nother thread
							ie.printStackTrace();
						}
						refresh(valueTimer);
						valueTimer += 1000;
					}
				}
			}).start();
		} else if (arg0.getActionCommand().equals("Stop")) {
			getSimulationView().stopTimer();
		}
		else if (arg0.getActionCommand().equals("Propos"))
		{
			new AboutDialog();
		}
	}

	/** Code prototype **/

	public void refresh(int value) {
		System.out.println(value);
		if (value == 1000) {
			Map map = mapView.getMapController().getModel();
			int r = 0;
			int c = 0;
			for (ArrayList<Cell> v: map.getCell()) {
				for (Cell cell: v) {
					if (r == 3) {
						if (c == 1) {
							cell.setRobot(null);
						} else if (c == 2) {
							cell.setRobot(new Robot());
							break;
						}
					}
					c++;
				}
				if (c == 2 && r == 3)
					break;
				c = 0;
				r++;
			}
			simulationView.getTimerLabel().setText(String.valueOf(value));
			mapView.refresh();
		} else if (value == 2000) {
			Map map = mapView.getMapController().getModel();
			int r = 0;
			int c = 0;
			for (ArrayList<Cell> v: map.getCell()) {
				for (Cell cell: v) {
					if (r == 3) {
						if (c == 2)
							cell.setRobot(null);
						else if (c == 3) {
							cell.setRobot(new Robot());
						}
					} else if (r == 8 && c == 2) {
						cell.setOnFire(2);
						break;
					}
					c++;
				}
				if (c == 8 && r == 2)
					break;
				c = 0;
				r++;
			}
			simulationView.getTimerLabel().setText(String.valueOf(value));
			mapView.refresh();
		} else if (value == 3000) {
			Map map = mapView.getMapController().getModel();
			int r = 0;
			int c = 0;
			for (ArrayList<Cell> v: map.getCell()) {
				for (Cell cell: v) {
					if (r == 6 && c == 2)
						cell.setRobot(null);
					else if (r == 7 && c == 2) {
						cell.setRobot(new Robot());
						break;
					}
					c++;
				}
				if (c == 7 && r == 2)
					break;
				c = 0;
				r++;
			}
			simulationView.getTimerLabel().setText(String.valueOf(value));
			mapView.refresh();
		} else if (value == 4000) {
			// Pee on fire !! GOBE GOBE GOBE 
		} else if (value == 5000) {
			Map map = mapView.getMapController().getModel();
			int r = 0;
			int c = 0;
			for (ArrayList<Cell> v: map.getCell()) {
				for (Cell cell: v) {
					if (r == 3 && c == 4) {
						cell.setOnFire(0);
						break;
					}
					c++;
				}
				if (c == 4 && r == 3)
					break;
				c = 0;
				r++;
			}
			simulationView.getTimerLabel().setText(String.valueOf(value));
			mapView.refresh();
		} else if (value == 6000) {
			Map map = mapView.getMapController().getModel();
			int r = 0;
			int c = 0;
			for (ArrayList<Cell> v: map.getCell()) {
				for (Cell cell: v) {
					if (r == 8 && c == 2) {
						cell.setOnFire(0);
						break;
					}
					c++;
				}
				if (c == 8 && r == 2)
					break;
				c = 0;
				r++;
			}
			simulationView.getTimerLabel().setText(String.valueOf(value));
			mapView.refresh();
		}
	}
}