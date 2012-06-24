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
		int cost;
		switch (groundType) {
		case GRASS:
			cost = 20;
			break;
		case SNOW:
			cost = 2;
			break;
		case WATER:
			cost = Integer.MAX_VALUE;
			break;
		case FOREST:
			cost = 20;
			break;
		case ROCK:
			cost = 40;
			break;
		case SWAMP:
			cost = 20;
			break;
		case SAND:
			cost = 200;
			break;
		case AIR:
			cost = Integer.MAX_VALUE;
			break;
		default:
			cost = 2;
			break;
		}
		
		return cost;
	}
}
