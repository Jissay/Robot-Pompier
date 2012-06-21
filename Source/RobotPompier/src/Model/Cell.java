package Model;

import java.util.Collection;
import java.util.HashMap;

import org.json.JSONObject;

public class Cell {
	
	private Map _map;
	
	private int _isOnFire;
	private int _x;
	private int _y;
	private double _height;
	
	private ETerrainType _terrainType;
	
	private Robot _robot;
	
	//TODO: remove
	public Cell() {
		this(0, 0, 0);
	}
	
	//TODO: remove
	public Cell(int x, int y, double height) {
		_x = x;
		_y = y;
		_height = height;
		_terrainType = ETerrainType.GRASS;
		_isOnFire = 0;
	}
	
	public Cell(int x, int y, JSONObject json) {
		_x = x;
		_y = y;
		_isOnFire = 0;
		_height = json.optDouble("height", 0);
		String terrainType = json.optString("type", "grass");
		
		if (terrainType.equals("grass"))
			_terrainType = ETerrainType.GRASS;
		else if (terrainType.equals("snow"))
			_terrainType = ETerrainType.SNOW;
		else if (terrainType.equals("water"))
			_terrainType = ETerrainType.WATER;
		else if (terrainType.equals("forest"))
			_terrainType = ETerrainType.FOREST;
		else if (terrainType.equals("rock"))
			_terrainType = ETerrainType.ROCK;
		else if (terrainType.equals("swamp"))
			_terrainType = ETerrainType.SWAMP;
		else if (terrainType.equals("sand"))
			_terrainType = ETerrainType.SAND;
		else if (terrainType.equals("air"))
			_terrainType = ETerrainType.AIR;
		else
			_terrainType = ETerrainType.GRASS;
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
	
	public double getHeight() {
		return _height;
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
	
	public HashMap<EOrientation, Cell> getCellulesAdjacentes() {
		HashMap<EOrientation, Cell> ret = new HashMap<EOrientation, Cell>();
		if (getX() > 0)
			ret.put(EOrientation.W, _map.getCell().get(getX() - 1).get(getY()));
		
		if (getX() < _map.getLongueur() - 1)
			ret.put(EOrientation.E, _map.getCell().get(getX() + 1).get(getY()));

		if (getY() > 0)
			ret.put(EOrientation.N, _map.getCell().get(getX()).get(getY() - 1));
		
		if (getY() < _map.getLargeur() - 1)
			ret.put(EOrientation.S, _map.getCell().get(getX()).get(getY() + 1));
		
		if (getX() > 0 && getY() > 0)
			ret.put(EOrientation.NW, _map.getCell().get(getX() - 1).get(getY() - 1));
		
		if (getX() > 0 && getY() < _map.getLargeur() - 1)
			ret.put(EOrientation.NE, _map.getCell().get(getX() - 1).get(getY() + 1));
		
		if (getX() < _map.getLongueur() - 1 && getY() > 0)
			ret.put(EOrientation.SW, _map.getCell().get(getX() + 1).get(getY() - 1));
		
		if (getX() < _map.getLongueur() - 1 && getY() < _map.getLargeur() - 1)
			ret.put(EOrientation.SE, _map.getCell().get(getX() + 1).get(getY() + 1));
		
		return ret;
	}
	
	public Collection<Cell> getListCellulesAdjacentes() {
		return getCellulesAdjacentes().values();
	}
	
	public int distance(Cell other) {
		int distance = 0;
	 
		distance += (other.getX() < getX()) ? getX() - other.getX() : other.getX() - getX();
		distance += (other.getY() < getY()) ? getY() - other.getY() : other.getY() - getY();

		return distance;
	}
}