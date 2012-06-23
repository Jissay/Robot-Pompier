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
			coast = 1;
			break;
		case SNOW:
			coast = 40;
			break;
		case WATER:
			coast = Integer.MAX_VALUE;
			break;
		case FOREST:
			coast = 50;
			break;
		case ROCK:
			coast = 100;
			break;
		case SWAMP:
			coast = 50;
			break;
		case SAND:
			coast = 30;
			break;
		case AIR:
			coast = Integer.MAX_VALUE;
			break;
		default:
			coast = 0;
			break;
		}
		return coast;
	}
}
