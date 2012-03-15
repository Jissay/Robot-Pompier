package Observer;


import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

import Model.Map;

public abstract class AMapObserver implements Observer {

	protected abstract void mapLoading();
	protected abstract void mapLoaded();
	protected abstract void mapLoadingFailed();
	protected abstract void mapSetRobot(int x, int y, String url);
	protected abstract void mapSetFire();
	
	@Override
	public void update(Observable o, Object arg) {
		Hashtable<String, Object> arguments = (Hashtable<String, Object>) arg;
		if (o instanceof Map) {
			if (arguments.get("type") instanceof String) {
				String param = (String) arguments.get("type");
				if ("MapLoading".equals(param))
					mapLoading();
				else if ("MapLoaded".equals(param))
					mapLoaded();
				else if ("MapLoadingFailed".equals(param))
					mapLoadingFailed();
				else if ("SetRobot".equals(param)) {
					String url = (String) arguments.get("url");
					int x = (Integer)arguments.get("x");
					int y = (Integer)arguments.get("y");
					mapSetRobot(x, y, url);
				} else if ("SetFire".equals(param))
					mapSetFire();
			}
		}
	}
}
