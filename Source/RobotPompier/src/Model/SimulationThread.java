package Model;

import java.util.HashSet;

public class SimulationThread extends Thread {
	private boolean _running = true;
	private Simulation _context;
	
	public SimulationThread(Simulation context) {
		_context = context;
	}
	
	@Override
	public void run() {
		while (_running) {
			// Chaque robot vérifie si la case qu'il doit éteindre est encore en feu ou non
			HashSet<Robot> robots = (HashSet<Robot>) _context.getRobotList();
			for (Robot r : robots)
				r.checkDestinationStillOnFire();
			
			for (Robot r : robots)
				r.work();
			
			_context.getManager().checkForFire();
		}
	}
	
	public void halt() {
		_running = false;
		interrupt();
	}
}
