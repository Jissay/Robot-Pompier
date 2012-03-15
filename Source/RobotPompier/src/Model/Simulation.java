package Model;

import java.util.Observable;
import java.util.Set;

import Model.algorithms.Algorithm;
import Model.robot.type.MoveType;
import Model.robot.type.ProjectorType;
import Model.robot.type.RobotType;


public class Simulation extends Observable{
	
	/* ATTRIBUTES */
	
	private Map _map;
	private Manager _manager;
	
	private Set<RobotType> _robotModel;
	private Set<Algorithm> _listAlgorithms;
	private Set<MoveType> _listMoveTypes;
	private Set<ProjectorType> _listProjectorTypes;

	/* METHODS */
	
	public void moveRobot() {
	}
	
	/* GETTERS AND SETTERS */
	
	public Map getMap() {
		return _map;
	}

	public void setMap(Map map) {
		_map = map;
	}

	public Set<RobotType> getRobotModel() {
		return _robotModel;
	}

	public void setRobotModel(Set<RobotType> robotModel) {
		_robotModel = robotModel;
	}

	public Manager getManager() {
		return _manager;
	}

	public void setManager(Manager manager) {
		_manager = manager;
	}

	public Set<Algorithm> get_listAlgorithms() {
		return _listAlgorithms;
	}

	public void setListAlgorithms(Set<Algorithm> listAlgorithms) {
		_listAlgorithms = listAlgorithms;
	}

	public Set<MoveType> getListMoveTypes() {
		return _listMoveTypes;
	}

	public void setListMoveTypes(Set<MoveType> listMoveTypes) {
		_listMoveTypes = listMoveTypes;
	}

	public Set<ProjectorType> getListProjectorTypes() {
		return _listProjectorTypes;
	}

	public void setListProjectorTypes(Set<ProjectorType> listProjectorTypes) {
		_listProjectorTypes = listProjectorTypes;
	}
}