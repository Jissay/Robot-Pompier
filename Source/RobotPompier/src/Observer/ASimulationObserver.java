package Observer;

import java.util.Hashtable;
import java.util.Observable;

import Model.Simulation;

public abstract class ASimulationObserver extends AMapObserver {

	protected abstract void timerUp();
	
	@Override
	public void update(Observable o, Object arg) {
		super.update(o, arg);
		@SuppressWarnings("unchecked")
		Hashtable<String, Object> arguments = (Hashtable<String, Object>) arg;
		if (o instanceof Simulation) {
			if (arguments.get("type") instanceof String) {
				String param = (String) arguments.get("type");
				if ("timerUp".equals(param))
					timerUp();
			}
		}
	}
}
