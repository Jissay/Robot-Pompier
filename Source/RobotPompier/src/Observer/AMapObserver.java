package Observer;

import java.util.Observable;
import java.util.Observer;

import Model.Map;

public abstract class AMapObserver implements Observer {

	protected abstract void mapLoaded();
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Map) {
			if (arg instanceof String) {
				String param = (String) arg;
				if (param == "LoadMap") {
					mapLoaded();
				}
			}
		}
	}
}
