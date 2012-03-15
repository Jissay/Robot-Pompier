package Controller;

import Model.Simulation;
import Model.algorithms.Algorithm;
import Model.robot.type.MoveType;
import Model.robot.type.ProjectorType;
import Model.robot.type.RobotType;
import Model.robot.type.RobotTypeFactory;

public class RobotTypeController {

	/* CONSTRUCTORS */
	
	public RobotTypeController () {
	}
	
	/* PUBLIC METHODS */
	
	public boolean addRobotType(String typeName, float waterCapacity, String algorithm, String projector_t, String move_t) {
		RobotTypeFactory robotTypeFactory = new RobotTypeFactory();
		Simulation simulation = SimulationController.getInstance().getSimulation();
		
		Algorithm al_toPut = null;
		for (Algorithm al : simulation.getListAlgorithms()) {
			if (al.getName().equals(algorithm)) {
				al_toPut = al;
				break;
			}
		}
		
		ProjectorType pj_toPut = null;
		for (ProjectorType pj : simulation.getListProjectorTypes()) {
			if (pj.getName().equals(projector_t)) {
				pj_toPut = pj;
				break;
			}
		}
		
		MoveType mv_toPut = null;
		for (MoveType mv : simulation.getListMoveTypes()) {
			if (mv.getName().equals(move_t)) {
				mv_toPut = mv;
				break;
			}
		}
		RobotType robotType = robotTypeFactory.newInstance(typeName, mv_toPut, pj_toPut, al_toPut, waterCapacity);
		
		simulation.getRobotModel().add(robotType);
		
		return true;
	}
}
