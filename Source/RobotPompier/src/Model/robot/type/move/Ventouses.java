package Model.robot.type.move;

import Model.ETerrainType;

public class Ventouses extends MoveType {

	public static final String NAME = "Ventouses";
	public static final float WEIGHT = 1.0f;
	
	public Ventouses() {
		super();
		
		this.setName(Ventouses.NAME);
		this.setWeight(Ventouses.WEIGHT);
	}
	
	@Override
	public float getCost(float incline, ETerrainType groundType) {
		return 0;
	}

}
