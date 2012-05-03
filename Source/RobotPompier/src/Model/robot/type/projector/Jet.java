package Model.robot.type.projector;

public class Jet extends ProjectorType {

	private static final String NAME = "Jet Propulseur";
	private static final float FLOW = 0.3f;
	private static final float WEIGHT = 1.5f;
	private static final int RANGE = 200;
	
	public Jet() {
		super();
		
		this.setName(Jet.NAME);
		this.setFlow(Jet.FLOW);
		this.setWeight(Jet.WEIGHT);
		this.setRange(Jet.RANGE);
	}
}
