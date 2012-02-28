package Model.robot.type;

import Model.ETerrainType;

public class MoveType {
	
	public static int MOVE_TYPE_1 = 1;
	public static int MOVE_TYPE_2 = 2;
	
	private static final String MOVE_TYPE_1_NAME = "Chenilles";
	private static final float MOVE_TYPE_1_WEIGHT = 2.0f;
	
	private static final String MOVE_TYPE_2_NAME = "Ventouses";
	private static final float MOVE_TYPE_2_WEIGHT = 1.0f;
	
	private String _name = "No Name";
	private float _weight = 0.0f;
	
	/* CONSTRUCTORS */
	public MoveType() { 
		
	}
	
	public MoveType(String name, float weight) {
		_name = name;
		_weight = weight;
	}
	
	// Create Move type with default values of a default type
	public MoveType(int type) {
		if (type == MOVE_TYPE_1) {
			_name = MOVE_TYPE_1_NAME;
			_weight = MOVE_TYPE_1_WEIGHT;
		} else if (type == MOVE_TYPE_2) {
			_name = MOVE_TYPE_2_NAME;
			_weight = MOVE_TYPE_2_WEIGHT;
		}
	}

	
	
	// ???
	public float vitesse(float inclinaison, ETerrainType terrainType) {
		
		return 0.0f;
	}

	/* GETTERS AND SETTERS */
	public float getWeight() {
		return _weight;
	}

	public void setWeight(float weight) {
		_weight = weight;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}
}
