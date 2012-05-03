package Model.robot.type.move;

import Model.ETerrainType;

public class Roues extends MoveType {

	public static final String NAME = "Roues";
	public static final float WEIGHT = 3.5f;
	
	public Roues() {
		super();
		
		this.setName(Roues.NAME);
		this.setWeight(Roues.WEIGHT);
	}
	
	@Override
	public float getCost(float incline, ETerrainType groundType) {
		// TODO Auto-generated method stub
		return 0;
	}

}
