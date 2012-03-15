package Controller;

import org.json.JSONArray;
import org.json.JSONException;

import IHM.MapView;
import Model.Map;

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
	
	public void setRobotAt(int x, int y, String robotTypeName) {
		_model.setRobotAt(x, y, robotTypeName);
	}
	
	public void setOnFireAt(int x, int y, int onFire) {
		_model.setOnFireAt(x, y, onFire);
	}
	
	public int getCellFireLevel(int x, int y) {
		return _model.getCell().get(x).get(y).isOnFire();
	}
}