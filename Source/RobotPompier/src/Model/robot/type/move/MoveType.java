package Model.robot.type.move;

import Model.ETerrainType;

public abstract class MoveType {

	/* STATIC VALUES*/
	private String name;
	private float weight;
	
	/* CONSTRUCTOR */
	
	public MoveType() { }
	
	/**
	 * Get cost of a move into a cell
	 * @param incline
	 * @param groundType
	 * @return float
	 */
	abstract public float getCost(float incline, ETerrainType groundType);

	
	/* GETTERS AND SETTERS */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
}
