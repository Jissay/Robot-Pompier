package Model;

import java.util.ArrayList;
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
	private WayToFollow _wayToFollow;
	
	public Robot() {
		_isFree = true;
		_wayToFollow = null;
	}

	public void go(Cell destination) {
		_wayToFollow = new WayToFollow(_robotType.getAlgorithm().findBestWay(MapController.getInstance().getModel(), this, destination));
		
		_destination = destination;
		_isFree = false;
	}

	public void work() {
		if (_isFree || _destination == null)
			return;
		
		if (_destination.isOnFire() != 0) {
			if (isAtRange()) {
				MapController.getInstance().setOnFireAt(
						_destination.getX(),
						_destination.getY(),
						_destination.isOnFire() -1
						);
			} else {
				if (_wayToFollow.hasNext())
					moveTo(_wayToFollow.next());
			}
		} else
			_isFree = true;
	}
	
	private void moveTo(Cell cell) {
		MapController controller = MapController.getInstance();
		if (!controller.isCellBusy(cell.getX(), cell.getY()))
			MapController.getInstance().moveRobotToCell(this, cell);
	}

	public void checkDestinationStillOnFire() {
		if (_destination != null && _destination.isOnFire() == 0) {
			_isFree = true;
			_destination = null;
		}
	}
	
	private boolean isAtRange() {
		int range = _robotType.getProjectorType().getRange();
		/*if (_cell.getY() == _destination.getY()) {
			int x = _cell.getX();
			int destX = _destination.getX();
			return (x < destX ? destX - x : x - destX) <= range;
		} else if (_cell.getX() == _destination.getX()) {
			int y = _cell.getY();
			int destY = _destination.getY();
			return (y < destY ? destY - y : y - destY) <= range;
		}*/
		
		int distance = (int) Math.floor(
					Math.sqrt(
						(Math.pow((_cell.getX() - _destination.getX()), 2)
						+ Math.pow((_cell.getY() - _destination.getY()), 2)
						)
					)
				);
		return distance <= range;
		/*System.out.println("Distance : " + distance);
		return false;*/
	}

	public int computeDistance(Cell destination) {
		return _robotType.getAlgorithm().findBestWay(MapController.getInstance().getModel(), this, destination).size();
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
	
	private class WayToFollow {
		private ArrayList<Cell> _way;
		
		public WayToFollow(ArrayList<Cell> cells) {
			_way = cells;
		}
		
		public boolean hasNext() {
			return _way.size() > 0;
		}
		
		public Cell next() {
			if (_way.size() == 0)
				return null;
			
			return _way.remove(0);
		}
	}
}
