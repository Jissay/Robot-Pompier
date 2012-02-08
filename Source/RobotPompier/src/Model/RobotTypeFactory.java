package Model;

public class RobotTypeFactory {

	private RobotType robotModel;

	public RobotType getRobotModel() {
		return robotModel;
	}

	public void setRobotModel(RobotType robotModel) {
		this.robotModel = robotModel;
	}

	public IMoveType createMoveType(String nom) {
		return null;
	}

	public IProjectorType createProjectorType(Object Stringnom) {
		return null;
	}
}