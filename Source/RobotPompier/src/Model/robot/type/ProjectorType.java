package Model.robot.type;

public class ProjectorType {
	
	/* STATIC VALUES */
	
	public static int PROJECTOR_TYPE_1 = 1;
	public static int PROJECTOR_TYPE_2 = 2;
	
	private static final String PROJECTOR_TYPE_1_NAME = "Lance";
	private static final float PROJECTOR_TYPE_1_FLOW = 0.5f;
	private static final float PROJECTOR_TYPE_1_WEIGHT = 2.0f;
	private static final int PROJECTOR_TYPE_1_RANGE = 100;

	private static final String PROJECTOR_TYPE_2_NAME = "Jet Propulseur";
	private static final float PROJECTOR_TYPE_2_FLOW = 0.3f;
	private static final float PROJECTOR_TYPE_2_WEIGHT = 1.5f;
	private static final int PROJECTOR_TYPE_2_RANGE = 200;
	
	/* ATTRIBUTES */
	
	private String _name = "No Name";
	private float _flow = 0;
	private float _weight = 0;
	private int _range = 0;
	
	/* CONSTRUCTORS */
	
	public ProjectorType() { }
	
	public ProjectorType(String name, float flow, float weight, int range) {
		setName(name);
		_flow = flow;
		_weight = weight;
		_range = range;
	}
	
	public ProjectorType(int type) {
		if (type == PROJECTOR_TYPE_1) {
			setName(PROJECTOR_TYPE_1_NAME);
			_flow = PROJECTOR_TYPE_1_FLOW;
			_weight = PROJECTOR_TYPE_1_WEIGHT;
			_range = PROJECTOR_TYPE_1_RANGE;
		} else if (type == PROJECTOR_TYPE_2) {
			setName(PROJECTOR_TYPE_2_NAME);
			_flow = PROJECTOR_TYPE_2_FLOW;
			_weight = PROJECTOR_TYPE_2_WEIGHT;
			_range = PROJECTOR_TYPE_2_RANGE;
		}
	}
	
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
