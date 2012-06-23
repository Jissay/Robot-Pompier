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
		int coast;
		switch (groundType) {
		case GRASS:
			coast = 20;
			break;
		case SNOW:
			coast = 2;
			break;
		case WATER:
			coast = Integer.MAX_VALUE;
			break;
		case FOREST:
			coast = 20;
			break;
		case ROCK:
			coast = 40;
			break;
		case SWAMP:
			coast = 20;
			break;
		case SAND:
			coast = 200;
			break;
		case AIR:
			coast = Integer.MAX_VALUE;
			break;
		default:
			coast = 2;
			break;
		}
		
		return coast;
	}
}
