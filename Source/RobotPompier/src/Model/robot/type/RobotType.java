package Model.robot.type;

import Model.algorithms.Algorithm;

public class RobotType {
	
	private String _name;
	private ProjectorType _projectorType;
	private MoveType _moveType;
	private Algorithm _algorithm;
	private float _waterCapacity;

	protected RobotType(ProjectorType projectorType, MoveType moveType, Algorithm algorithm, float waterCapacity) {
		_projectorType = projectorType;
		_moveType = moveType;
		_algorithm = algorithm;
		_waterCapacity = waterCapacity;
	}
	
	/* GETTERS AND SETTERS */

	public String getName() {
		return _name;
	}

	public void setName(String _name) {
		this._name = _name;
	}	
	
	public ProjectorType getProjectorType() {
		return _projectorType;
	}
	
	public void setProjectorType(ProjectorType projectorType) {
		_projectorType = projectorType;
	}

	public MoveType getMoveType() {
		return _moveType;
	}

	public void setMoveType(MoveType moveType) {
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
}
