package Model.robot.type.projector;

public abstract class ProjectorType {
	
	/* ATTRIBUTES */
	
	private String _name;
	private float _flow;
	private float _weight;
	private int _range;
	
	/* CONSTRUCTORS */
	
	public ProjectorType() { }
	
	/* GETTERS AND SETTERS */
	
	public float getFlow() {
		return _flow;
	}
	public void setFlow(float flow) {
		_flow = flow;
	}
	public int getRange() {
		return _range;
	}
	public void setRange(int range) {
		_range = range;
	}
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
