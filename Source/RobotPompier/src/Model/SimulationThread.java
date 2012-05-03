package Model;

import java.util.HashSet;
import java.util.TimerTask;

public class SimulationThread extends TimerTask {
	private Simulation _context;

	public SimulationThread(Simulation context) {
		_context = context;
	}

	@Override
	public void run() {
		// Chaque robot vérifie si la case qu'il doit éteindre est encore en feu ou non
		HashSet<Robot> robots = (HashSet<Robot>) _context.getRobotList();
		for (Robot r : robots)
			r.checkDestinationStillOnFire();

		for (Robot r : robots)
			r.work();

		_context.getManager().checkForFire();
	}
}
