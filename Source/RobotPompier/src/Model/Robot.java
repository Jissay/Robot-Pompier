package Model;

public class Robot {
	public static final int WATER_WEIGHT_FACTOR = 1;
	
	private Cell _cell;
	private Cell _destination;
	private EOrientation _orientation;
	private float _waterQuantity;
	private RobotType _robotType;
	private Manager _manager;
	private boolean _isFree;

	public Robot() {
		
	}
	
	public void go(Cell destination) {
		_destination = destination;
		_isFree = false;
	}

	/**
	 * \todo D�cider tu type de retour vers le simulateur
	 */
	public void work() {
		/*if (isAtRange())
			// Excintionner la cellule
		else
		*/	
	}

	private boolean isAtRange() {
		return false;
	}

	public int computeDistance(Cell destination) {
		// Let's do it the simple way !
		int distance = 0;
		 
		distance += (destination.getX() < _cell.getX()) ? _cell.getX() - destination.getX() : destination.getX() - _cell.getX();
		distance += (destination.getY() < _cell.getY()) ? _cell.getY() - destination.getY() : destination.getY() - _cell.getY();

		return distance;
	} 

	public boolean isFree() {
		return _isFree;
	}
	
	public float getWeight() {
		float weight = 0;
		
		weight += _robotType.getProjectorType().weight;
		weight += _robotType.getMoveType().weight;
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
}
