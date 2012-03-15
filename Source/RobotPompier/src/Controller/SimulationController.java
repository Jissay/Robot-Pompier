package Controller;

import Model.Simulation;
import Model.robot.type.RobotType;

public class SimulationController {
	
	/* ATTRIBUTES */
	
	private static SimulationController _instance = null;
	private Simulation _simulation;
	
	/* CONSTRUCTORS */
	
	public static SimulationController getInstance() {
		if (_instance == null)
			_instance = new SimulationController();
		return _instance;
	}
	
	private SimulationController() {
		_simulation = new Simulation();
	}
	
	/* PUBLIC METHODS */
	
	public RobotType getRobotTypeFromName(String name) {
		return _simulation.getRobotTypeFromName(name);
	}
	
	public static void startSimulation() {
	}

	public void stopSimulation() {
	}
	
	/* GETTERS AND SETTERS */
	
	public Simulation getSimulation() {
		return _simulation;
	}

	public void setSimulation(Simulation simulation) {
		_simulation = simulation;
	}
}