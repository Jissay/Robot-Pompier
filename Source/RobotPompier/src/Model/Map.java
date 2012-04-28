package Model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Observable;


import org.json.JSONArray;
import org.json.JSONException;

import Controller.SimulationController;
import Model.robot.type.RobotType;

public class Map extends Observable {
	
	private int _largeur;
	private int _longueur;
	private ArrayList<ArrayList<Cell>> _cells;
	private Manager _manager;
	
	public Map() {
		_largeur = 0;
		_longueur = 0;
		_cells = new ArrayList<ArrayList<Cell>>();
	}
	
	public Map(JSONArray map) throws JSONException {
		setData(map);
	}
	
	public void setData(JSONArray map) {
		Hashtable<String, Object> hashTableForObservers = new Hashtable<String, Object>();
		_largeur = 0;
		_longueur = 0;
		_cells = new ArrayList<ArrayList<Cell>>();
		setChanged();
		hashTableForObservers.put("type","MapLoading");
		notifyObservers(hashTableForObservers);
		
		_longueur = map.length();
		try {
			for (int i = 0; i < _longueur; i++) {
				ArrayList<Cell> cellsContainer = new ArrayList<Cell>();
				JSONArray row;
					row = map.getJSONArray(i);
				_largeur = row.length();
				for (int j = 0; j < _largeur; j++)
					cellsContainer.add(new Cell(i, j, row.getJSONObject(j)));
				_cells.add(cellsContainer);
			}
		} catch (JSONException e) {
			setChanged();
			hashTableForObservers.put("type", "MapLoadingFailed");
			notifyObservers(hashTableForObservers);
			e.printStackTrace();
		}
		setChanged();
		hashTableForObservers.put("type","MapLoaded");
		notifyObservers(hashTableForObservers);
	}
	
	public boolean isCellBusy(int x, int y) {
		Cell cell = _cells.get(x).get(y);
		return !(null == cell.getRobot() && cell.isOnFire() == 0);
	}
	
	//TODO: définir comment on récupère le type de robot
	public void setRobotAt(int x, int y, String robotTypeName) {
		Cell cell = _cells.get(x).get(y);
		RobotType type = SimulationController.getInstance().getRobotTypeFromName(robotTypeName);
		Robot robot = new Robot();
		if (type != null)
			robot.setRobotType(type);
		cell.setRobot(robot);
		Hashtable<String, Object> args = new Hashtable<String, Object>();
		args.put("type", "SetRobot");
		args.put("url", "/images/unknown-tux-robot-1708.png");
		args.put("x", x);
		args.put("y", y);
		setChanged();
		notifyObservers(args);
	}
	
	public void setOnFireAt(int x, int y, int fireLevel) {
		Cell cell = _cells.get(x).get(y);
		if (cell.isOnFire() != fireLevel) {
			cell.setOnFire(fireLevel);
			Hashtable<String, Object> args = new Hashtable<String, Object>();
			args.put("type", "SetFire");
			args.put("x", x);
			args.put("y", y);
			args.put("fireLevel", fireLevel);
			setChanged();
			notifyObservers(args);
		}
	}
	
	/* ------------------- */
	/* GETTERS AND SETTERS */
	/* ------------------- */
	public int getLargeur() {
		return _largeur;
	}
	public void setLargeur(int largeur) {
		_largeur = largeur;
	}
	public int getLongueur() {
		return _longueur;
	}
	public void setLongueur(int longueur) {
		_longueur = longueur;
	}
	public ArrayList<ArrayList<Cell>> getCell() {
		return _cells;
	}
	public void setCell(ArrayList<ArrayList<Cell>> cell) {
		_cells = cell;
	}
	public Manager getManager() {
		return _manager;
	}
	public void setManager(Manager manager) {
		_manager = manager;
	}
}