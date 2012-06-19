package Model;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;
import java.util.Timer;

import Model.algorithms.Algorithm;
import Model.algorithms.Astar;
import Model.algorithms.Dijkstra;
import Model.robot.type.RobotType;
import Model.robot.type.RobotTypeFactory;
import Model.robot.type.move.Chenilles;
import Model.robot.type.move.MoveType;
import Model.robot.type.move.Roues;
import Model.robot.type.move.Ventouses;
import Model.robot.type.projector.Jet;
import Model.robot.type.projector.Lance;
import Model.robot.type.projector.ProjectorType;


public class Simulation extends Observable {

	/* ATTRIBUTES */

	private Map _map;
	private Manager _manager;

	private Set<RobotType> _robotModel;
	private Set<Algorithm> _listAlgorithms;
	private Set<MoveType> _listMoveTypes;
	private Set<ProjectorType> _listProjectorTypes;

	private Set<Robot> _robots;

	private Timer _timer;
	private SimulationThread _thread = null;

	/* METHODS */

	public void start() {
		if (isRunning())
			return;
		_thread = new SimulationThread(this);
		_timer.schedule(_thread, 0, 1000);
	}

	public void stop() {
		if (_thread != null) {
			_timer.cancel();
			_timer.purge();
			_thread = null;
		}
	}

	public boolean isRunning() {
		return _thread != null;
	}


	public void moveRobot() {
	}
	
	public Simulation() {
		_manager = new Manager(this);
		
		_timer = new Timer();
		
		_listAlgorithms = new HashSet<Algorithm>();
		_listAlgorithms.add(new Astar());
		_listAlgorithms.add(new Dijkstra());

		_listMoveTypes = new HashSet<MoveType>();
		_listMoveTypes.add(new Chenilles());
		_listMoveTypes.add(new Ventouses());
		_listMoveTypes.add(new Roues());
		
		_listProjectorTypes = new HashSet<ProjectorType>();
		_listProjectorTypes.add(new Lance());
		_listProjectorTypes.add(new Jet());
		
		_robotModel = new HashSet<RobotType>();
		_robotModel.add(RobotTypeFactory.newInstance("Defaut 1", new Chenilles(), new Lance(), new Algorithm(), 15));
		_robotModel.add(RobotTypeFactory.newInstance("Defaut 2", new Ventouses(), new Jet(), new Algorithm(), 20));
		
		_robots = new HashSet<Robot>();
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

	public RobotType getRobotTypeFromName(String name) {
		for (RobotType type : _robotModel)
			if (name.equals(type.getName()))
				return type;
		return null;
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

	public Set<Algorithm> getListAlgorithms() {
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

	public void addRobot(Robot robot) {
		_robots.add(robot);
	}

	public void removeRobot(Robot robot) {
		_robots.remove(robot);
	}
	
	public Set<Robot> getRobotList() {
		return _robots;
	}
}