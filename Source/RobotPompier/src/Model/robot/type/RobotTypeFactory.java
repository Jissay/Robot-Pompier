package Model.robot.type;

import Model.algorithms.Algorithm;
import Model.robot.type.move.MoveType;
import Model.robot.type.projector.ProjectorType;

public class RobotTypeFactory {
	
	// Factory, creates instances of the robot type
	static public RobotType newInstance(String name, MoveType move_t, ProjectorType projector_t, Algorithm algorithm, float waterCapacity) {
		return new RobotType(name, projector_t, move_t, algorithm, waterCapacity);
	}
}