package Model;

import java.util.ArrayList;
import java.util.Set;

import Controller.MapController;

public class Manager {
	private Set<Robot>	_robots;
	private Map			_map;
	private Simulation	_simulation;

	private Robot _mostEfficient = null;
	private int _minDistance = Integer.MAX_VALUE;
	
	public Manager(Simulation simulation) {
		_simulation = simulation;
	}
	
	public void checkForFire() {
		for (ArrayList<Cell> line : MapController.getInstance().getModel().getCell())
			for (Cell cell : line) {
				if (cell.isOnFire() > 0) {
					for (Robot r : _simulation.getRobotList()) {
						if (!r.isFree())
							continue;
						
						int distance = r.computeDistance(cell);
						if (distance < _minDistance) {
							_mostEfficient = r;
							_minDistance = distance;
						}
					}
					
					if (_mostEfficient != null)
						_mostEfficient.setDestination(cell);
				}
			}				
	}
	
	public Simulation getSimulation() {
		return _simulation;
	}

	public void setSimulation(Simulation simulation) {
		_simulation = simulation;
	}

	public Set<Robot> getRobot() {
		return _robots;
	}

	public void setRobot(Set<Robot> robot) {
		_robots = robot;
	}

	public Map getMap() {
		return _map;
	}

	public void setMap(Map map) {
		_map = map;
	}
}