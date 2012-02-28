package Model;

public class RobotTypeFactory {

	private RobotType robotModel; // Model used 
	
	// Factory, creates instances of the robot type
	public RobotType newInstance(String moveType, String projectorType) {
		RobotType robotType = new RobotType();
		return robotType;
	}
	
	public RobotType getRobotModel() {
		return robotModel;
	}

	public void setRobotModel(RobotType robotModel) {
		this.robotModel = robotModel;
	}

	public IMoveType createMoveType(String nom) {
		return null;
	}

	public IProjectorType createProjectorType(String nom) {
		return null;
	}
}