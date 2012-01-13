/**
 * 
 */
package Model;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Marc
 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Wind {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private float _speed;

	/** 
	 * @return _speed
	 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public float get_speed() {
		// begin-user-code
		return _speed;
		// end-user-code
	}

	/** 
	 * @param _speed _speed à définir
	 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void set_speed(float _speed) {
		// begin-user-code
		this._speed = _speed;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private EOrientation eOrientation;

	/** 
	 * @return eOrientation
	 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public EOrientation geteOrientation() {
		// begin-user-code
		return eOrientation;
		// end-user-code
	}

	/** 
	 * @param eOrientation eOrientation à définir
	 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void seteOrientation(EOrientation eOrientation) {
		// begin-user-code
		this.eOrientation = eOrientation;
		// end-user-code
	}
}