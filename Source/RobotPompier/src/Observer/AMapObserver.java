package Observer;

import java.util.Observable;
import java.util.Observer;

import Model.Map;

public abstract class AMapObserver implements Observer {

	protected abstract void mapLoading();
	protected abstract void mapLoaded();
	protected abstract void mapLoadingFailed();
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Map) {
			if (arg instanceof String) {
				String param = (String) arg;
				if ("MapLoading".equals(param))
					mapLoading();
				else if ("MapLoaded".equals(param))
					mapLoaded();
				else if ("MapLoadingFailed".equals(param))
					mapLoadingFailed();
			}
		}
	}
}
