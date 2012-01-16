/**
 * 
 */
package IHM;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = -5464261678769218180L;
	private MapView mapView;
	
	public MainWindow() {
		setTitle("Fire Disaster Simulator");
	}

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
}