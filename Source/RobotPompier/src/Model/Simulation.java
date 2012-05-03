package Model;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;
import java.util.Timer;

import Model.algorithms.Algorithm;
import Model.algorithms.Astar;
import Model.algorithms.Dijkstra;
import Model.robot.type.MoveType;
import Model.robot.type.ProjectorType;
import Model.robot.type.RobotType;
import Model.robot.type.RobotTypeFactory;


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

	/* GETTERS AND SETTERS */

	public Simulation() {
		_manager = new Manager(this);
		
		_timer = new Timer();
		
		_listAlgorithms = new HashSet<Algorithm>();
		_listAlgorithms.add(new Astar());
		_listAlgorithms.add(new Dijkstra());

		_listMoveTypes = new HashSet<MoveType>();
		_listMoveTypes.add(new MoveType(0));
		_listMoveTypes.add(new MoveType(1));
		_listMoveTypes.add(new MoveType(2));

		_listProjectorTypes = new HashSet<ProjectorType>();
		_listProjectorTypes.add(new ProjectorType(0));
		_listProjectorTypes.add(new ProjectorType(1));
		_listProjectorTypes.add(new ProjectorType(2));

		_robotModel = new HashSet<RobotType>();
		_robotModel.add(RobotTypeFactory.newInstance("Defaut 1", new MoveType(1), new ProjectorType(1), new Astar(), 15));
		_robotModel.add(RobotTypeFactory.newInstance("Defaut 2", new MoveType(2), new ProjectorType(2), new Dijkstra(), 20));

		_robots = new HashSet<Robot>();
	}

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

	public Set<Robot> getRobotList() {
		return _robots;
	}
}