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
			coast = 10;
			break;
		case SNOW:
			coast = 1;
			break;
		case WATER:
			coast = Integer.MAX_VALUE;
			break;
		case FOREST:
			coast = 10;
			break;
		case ROCK:
			coast = 20;
			break;
		case SWAMP:
			coast = 10;
			break;
		case SAND:
			coast = 100;
			break;
		case AIR:
			coast = Integer.MAX_VALUE;
			break;
		default:
			coast = 1;
			break;
		}
		
		return coast;
	}
}
