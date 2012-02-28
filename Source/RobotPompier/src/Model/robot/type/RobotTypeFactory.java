package Model.robot.type;

public class RobotTypeFactory {
	
	// Factory, creates instances of the robot type
	public RobotType newInstance(String moveType, String projectorType) {
		RobotType robotType = new RobotType(null, null, null, 0);
		return robotType;
	}
	
	public MoveType createMoveType(String nom) {
		MoveType moveType = new MoveType();
		return null;
	}

	public ProjectorType createProjectorType(String nom) {
		return null;
	}
}