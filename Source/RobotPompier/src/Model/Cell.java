package Model;

public class Cell {
	
	private Map _map;
	
	private int _isOnFire;
	private int _x;
	private int _y;
	
	private ETerrainType _terrainType;
	
	private Robot _robot;
	
	public Cell() {
		this(0, 0);
	}
	
	public Cell(int x, int y) {
		_x = x;
		_y = y;
	}

	/* ******************* */
	/* GETTERS AND SETTERS */
	/* ******************* */
	
	public Map getMap() {
		return _map;
	}

	public void setMap(Map map) {
		_map = map;
	}

	public int isOnFire() {
		return _isOnFire;
	}

	public void setOnFire(int isOnFire) {
		_isOnFire = isOnFire;
	}

	public int getX() {
		return _x;
	}

	public void setX(int x) {
		_x = x;
	}

	public int getY() {
		return _y;
	}

	public void setY(int y) {
		_y = y;
	}

	public ETerrainType getTerrainType() {
		return _terrainType;
	}

	public void setTerrainType(ETerrainType terrainType) {
		_terrainType = terrainType;
	}

	public Robot getRobot() {
		return _robot;
	}

	public void setRobot(Robot robot) {
		_robot = robot;
	}
	
	
}