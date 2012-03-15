package Model;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

import Model.robot.type.RobotType;


public class Simulation extends Observable {
	private Map					_map;
	private static Simulation	_instance;
	
	public static Simulation getInstance() {
		if (_instance == null)
			_instance = new Simulation();
		return _instance;
	}

	private Simulation() {
		robotModel = new HashSet<RobotType>();
	}
	
	public Map getMap() {
		return _map;
	}

	public void setMap(Map map) {
		this._map = map;
	}

	private Set<RobotType> robotModel;

	public Set<RobotType> getRobotModel() {
		return robotModel;
	}
	
	public RobotType getRobotTypeFromName(String name) {
		for (RobotType type : robotModel)
			if (name.equals(type.getName()))
				return type;
		return null;
	}

	public void setRobotModel(Set<RobotType> robotModel) {
		this.robotModel = robotModel;
	}

	private Manager manager;

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public void moveRobot() {
	}
}