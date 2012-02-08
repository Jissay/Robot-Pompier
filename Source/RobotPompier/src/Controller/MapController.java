package Controller;

import IHM.MapView;
import Model.Map;

public class MapController {
	private MapView	_view;
	private Map		_model;
	
	public MapView getView() {
		return _view;
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
}