package Model;

import java.util.Set;

public class Manager {
	private Set<Robot>	_robot;
	private Map			_map;
	private Simulation	_simulation;

	public Simulation getSimulation() {
		return _simulation;
	}

	public void setSimulation(Simulation simulation) {
		_simulation = simulation;
	}

	public Set<Robot> getRobot() {
		return _robot;
	}

	public void setRobot(Set<Robot> robot) {
		_robot = robot;
	}

	public Map getMap() {
		return _map;
	}

	public void setMap(Map map) {
		_map = map;
	}
}