package Model.robot.type;

import Model.ETerrainType;

public class MoveType {
	
	/* STATIC VALUES */
	
	public static final String[]	TYPE_NAMES =	{ "Chenilles",	"Ventouses" };
	public static final float[]		TYPE_WEIGHTS =	{ 2.0f,			1.0f };
	
	/* ATTRIBUTES */
	private int		_type;
	
	/* CONSTRUCTOR */
	// Create Move type with default values of a default type
	public MoveType(int type) {
		_type = type;
	}
	
	/**
	 * Indique le coût de déplacement sur une cellule
	 * @param inclinaison Unused
	 * @param terrainType Type de terrain de la cellule à parcourir
	 * @return
	 */
	public float cout(float inclinaison, ETerrainType terrainType) {
		return 1.0f;
	}

	/* GETTERS AND SETTERS */
	public float getWeight() {
		return TYPE_WEIGHTS[_type];
	}

	public String getName() {
		return TYPE_NAMES[_type];
	}
}
