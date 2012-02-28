package Model.robot.type;

public class ProjectorType {
	
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
	
	private String _name = "No Name";
	private float _flow = 0;
	private float _weight = 0;
	private int _range = 0;
	
	public ProjectorType() { }
	
	public ProjectorType(String name, float flow, float weight, int range) {
		_name = name;
		_flow = flow;
		_weight = weight;
		_range = range;
	}
	
	public ProjectorType(int type) {
		if (type == PROJECTOR_TYPE_1) {
			_name = PROJECTOR_TYPE_1_NAME;
			_flow = PROJECTOR_TYPE_1_FLOW;
			_weight = PROJECTOR_TYPE_1_WEIGHT;
			_range = PROJECTOR_TYPE_1_RANGE;
		} else if (type == PROJECTOR_TYPE_2) {
			_name = PROJECTOR_TYPE_2_NAME;
			_flow = PROJECTOR_TYPE_2_FLOW;
			_weight = PROJECTOR_TYPE_2_WEIGHT;
			_range = PROJECTOR_TYPE_2_RANGE;
		}
	}
	
	/* GETTERS AND SETTERS */
	
	public float get_flow() {
		return _flow;
	}
	public void set_flow(float _flow) {
		this._flow = _flow;
	}
	public int get_range() {
		return _range;
	}
	public void set_range(int _range) {
		this._range = _range;
	}
	public float getWeight() {
		return _weight;
	}
	public void setWeight(float weight) {
		_weight = weight;
	}
}
