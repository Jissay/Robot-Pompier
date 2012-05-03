package Model.robot.type.move;

import Model.ETerrainType;

public class Chenilles extends MoveType {

	public static final String NAME = "Chenilles";
	public static final float WEIGHT = 2.0f;
	
	public Chenilles() {
		super();
		
		this.setName(Chenilles.NAME);
		this.setWeight(Chenilles.WEIGHT);
	}
	
	@Override
	public float getCost(float incline, ETerrainType groundType) {
		
		return 0;
	}

}
