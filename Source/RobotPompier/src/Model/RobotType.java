package Model;

import java.util.Set;

import Model.algorithms.Algorithm;

public class RobotType {
	private Simulation _simulation;
	private IProjectorType _projectorType;
	private IMoveType _moveType;
	private Algorithm _algorithm;
	private float _waterCapacity;
	private Robot _robot;

	public Simulation getSimulation() {
		return _simulation;
	}

	public void setSimulation(Simulation simulation) {
		_simulation = simulation;
	}

	public IProjectorType getProjectorType() {
		return _projectorType;
	}

	public void setProjectorType(IProjectorType projectorType) {
		_projectorType = projectorType;
	}

	public IMoveType getMoveType() {
		return _moveType;
	}

	public void setMoveType(IMoveType moveType) {
		_moveType = moveType;
	}

	public Algorithm getAlgorithm() {
		return _algorithm;
	}

	public void setAlgorithm(Algorithm algorithm) {
		_algorithm = algorithm;
	}

	public float getWaterCapacity() {
		return _waterCapacity;
	}

	public void setWaterCapacity(float waterCapacity) {
		_waterCapacity = waterCapacity;
	}

	public Robot getRobot() {
		return _robot;
	}

	public void setRobot(Robot robot) {
		_robot = robot;
	}
}
