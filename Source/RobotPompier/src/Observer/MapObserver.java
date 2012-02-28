package Observer;

import java.util.Observable;
import java.util.Observer;


import Model.Simulation;

public class MapObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Simulation)
		{
			Simulation simulation = (Simulation) o;
			//TODO
		}
	}
}
