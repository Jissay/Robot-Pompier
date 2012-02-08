package Model;

public class Wind {

	private float _speed;

	public float get_speed() {
		return _speed;
	}

	public void set_speed(float _speed) {
		this._speed = _speed;
	}

	private EOrientation eOrientation;

	public EOrientation geteOrientation() {
		return eOrientation;
	}

	public void seteOrientation(EOrientation eOrientation) {
		this.eOrientation = eOrientation;
	}
}