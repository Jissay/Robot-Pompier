package Controller;

import org.json.JSONArray;
import org.json.JSONException;

import IHM.MapView;
import Model.Cell;
import Model.Map;
import Model.Robot;

public class MapController {
	private MapView					_view;
	private Map						_model;
	private static MapController	_instance;
	
    public static MapController getInstance() {
        if (null == _instance)
            _instance = new MapController();
        return _instance;
    }
    
    private MapController() {}
	
	public MapView getView() {
		return _view;
	}
	
	public void load(JSONArray data) throws JSONException {
		_model.setData(data);
	}
	
	public void reload(){
		_model.reload();
	}
	
	public void setView(MapView view) {
		_view = view;
	}
	
	public Map getModel() {
		return _model;
	}
	
	public void setModel(Map model) {
		_model = model;
	}
	
	public void refresh() {
		_view.refresh();
	}
	
	public boolean isCellBusy(int x, int y) {
		return _model.isCellBusy(x, y);
	}
	
	public boolean containsRobot(int x, int y) {
		return _model.getCell().get(x).get(y).getRobot() != null;
	}
	
	public void removeRobotAt(int x, int y) {
		Cell cell = _model.getCell().get(x).get(y);
		Robot robot = cell.getRobot();
		if (robot != null) {
			_model.removeRobot(cell);
			SimulationController.getInstance().removeRobot(robot);
		}
	}
	
	public boolean isOnFire(int x, int y) {
		return _model.getCell().get(x).get(y).isOnFire() > 0;
	}
	
	public void setRobotAt(int x, int y, String robotTypeName) {
		Robot robot = _model.setRobotAt(x, y, robotTypeName);
		if (robot != null)
			SimulationController.getInstance().addRobot(robot);
	}
	
	public void setOnFireAt(int x, int y, int onFire) {
		_model.setOnFireAt(x, y, onFire);
	}
	
	public int getCellFireLevel(int x, int y) {
		return _model.getCell().get(x).get(y).isOnFire();
	}
	
	public int getLargeur() {
		return _model.getLargeur();
	}
	
	public int getLongueur() {
		return _model.getLongueur();
	}
	
	public void moveRobotToCell(Robot robot, Cell cell) {
		_model.removeRobot(robot.getCell());
		_model.setRobotAt(cell.getX(), cell.getY(), robot);
	}
}