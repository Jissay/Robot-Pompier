package Model.robot.type.projector;

public class Lance extends ProjectorType {

	private static final String NAME = "Lance";
	private static final float FLOW = 0.5f;
	private static final float WEIGHT = 2.0f;
	private static final int RANGE = 1;
	
	public Lance() {
		super();
		
		this.setName(Lance.NAME);
		this.setFlow(Lance.FLOW);
		this.setWeight(Lance.WEIGHT);
		this.setRange(Lance.RANGE);
	}
}
