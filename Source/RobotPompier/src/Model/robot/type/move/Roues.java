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
		int cost;
		switch (groundType) {
		case GRASS:
			cost = 2;
			break;
		case SNOW:
			cost = 80;
			break;
		case WATER:
			cost = Integer.MAX_VALUE;
			break;
		case FOREST:
			cost = 100;
			break;
		case ROCK:
			cost = 200;
			break;
		case SWAMP:
			cost = 100;
			break;
		case SAND:
			cost = 60;
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
