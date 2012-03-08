package Observer;

import java.util.Observable;
import java.util.Observer;

import Controller.MapController;
import IHM.MapView;
import Model.Cell;
import Model.Simulation;

public class AMapObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Simulation)
		{
			Simulation simulation = (Simulation) o;
			if (arg instanceof Cell)
			{
				Cell cell = (Cell) arg;
			}
		}
	}
}
