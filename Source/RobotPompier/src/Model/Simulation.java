package Model;

import java.util.Observable;
import java.util.Set;

import Model.robot.type.RobotType;


public class Simulation extends Observable{
	private Map map;

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	private Set<RobotType> robotModel;

	public Set<RobotType> getRobotModel() {
		return robotModel;
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