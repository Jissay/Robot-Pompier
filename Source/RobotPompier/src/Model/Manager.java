package Model;

import java.util.Set;

public class Manager {
	
	private Simulation simulation;

	public Simulation getSimulation() {
		return simulation;
	}

	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}

	private Set<Robot> robot;

	public Set<Robot> getRobot() {
		return robot;
	}

	public void setRobot(Set<Robot> robot) {
		this.robot = robot;
	}

	private Map map;

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
}