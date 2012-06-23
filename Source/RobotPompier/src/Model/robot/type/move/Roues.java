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
		int coast;
		switch (groundType) {
		case GRASS:
			coast = 2;
			break;
		case SNOW:
			coast = 80;
			break;
		case WATER:
			coast = Integer.MAX_VALUE;
			break;
		case FOREST:
			coast = 100;
			break;
		case ROCK:
			coast = 200;
			break;
		case SWAMP:
			coast = 100;
			break;
		case SAND:
			coast = 60;
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
