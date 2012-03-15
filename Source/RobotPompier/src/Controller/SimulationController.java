package Controller;

import Model.Simulation;
import Model.robot.type.RobotType;

public class SimulationController {
	private static SimulationController _instance = null;
	
	private Simulation _simulation;
	
	public static SimulationController getInstance() {
		if (_instance == null)
			_instance = new SimulationController();
		return _instance;
	}
	
	private SimulationController() {
		_simulation = new Simulation();
	}
	
	public RobotType getRobotTypeFromName(String name) {
		return _simulation.getRobotTypeFromName(name);
	}
	
	public static void startSimulation() {
	}

	public void stopSimulation() {
	}
}