package Model;

import java.util.Observable;

import Controller.MapController;
import Model.robot.type.RobotType;

public class Robot extends Observable {
	public static final int WATER_WEIGHT_FACTOR = 1;

	private Cell _cell;
	private Cell _destination;
	private EOrientation _orientation;
	private float _waterQuantity;
	private RobotType _robotType;
	private Manager _manager;
	private boolean _isFree;

	public Robot() {}

	public void go(Cell destination) {
		_destination = destination;
		_isFree = false;
	}

	public void work() {
		if (_isFree || _destination == null)
			return;
		
		if (_destination.isOnFire() == 0) {
			if (isAtRange()) {
				MapController.getInstance().setOnFireAt(
						_destination.getX(),
						_destination.getY(),
						_destination.isOnFire() -1
						);
			} else {
				// TODO: déplacer le robot en direction de la case _destination
			}
		} else
			_isFree = true;
	}

	public void checkDestinationStillOnFire() {
		if (_destination != null && _destination.isOnFire() == 0) {
			_isFree = true;
			_destination = null;
		}
	}
	
	private boolean isAtRange() {
		int range = _robotType.getProjectorType().getRange();
		if (_cell.getY() == _destination.getY()) {
			int x = _cell.getX();
			int destX = _destination.getX();
			return (x < destX ? destX - x : x - destX) >= range; 
		} else if (_cell.getX() == _destination.getX()) {
			int y = _cell.getY();
			int destY = _destination.getY();
			return (y < destY ? destY - y : y - destY) >= range;
		}
		return false;
	}

	public int computeDistance(Cell destination) {
		return _cell.distance(destination);
	} 

	public boolean isFree() {
		return _isFree;
	}

	public float getWeight() {
		float weight = 0;

		weight += _robotType.getProjectorType().getWeight();
		weight += _robotType.getMoveType().getWeight();
		weight += _waterQuantity * WATER_WEIGHT_FACTOR;

		return weight;
	}

	/** Getters & Setters **/

	public EOrientation getOrientation() {
		return _orientation;
	}

	public void setOrientation(EOrientation orientation) {
		_orientation = orientation;
	}

	public Cell getCell() {
		return _cell;
	}

	public void setCell(Cell cell) {
		_cell = cell;
	}

	public float getWaterQuantity() {
		return _waterQuantity;
	}

	public void setWaterQuantity(float waterQuantity) {
		_waterQuantity = waterQuantity;
	}

	public Manager getManager() {
		return _manager;
	}

	public void setManager(Manager manager) {
		_manager = manager;
	}

	public RobotType getRobotType() {
		return _robotType;
	}

	public void setRobotType(RobotType robotType) {
		_robotType = robotType;
	}
	
	public void setDestination(Cell cell) {
		_destination = cell;
	}
}
