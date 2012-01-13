/**
 * 
 */
package Model;

import java.util.Set;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Marc
 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Map {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private float _largeur;

	/** 
	 * @return _largeur
	 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public float get_largeur() {
		// begin-user-code
		return _largeur;
		// end-user-code
	}

	/** 
	 * @param _largeur _largeur à définir
	 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void set_largeur(float _largeur) {
		// begin-user-code
		this._largeur = _largeur;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private float _longueur;

	/** 
	 * @return _longueur
	 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public float get_longueur() {
		// begin-user-code
		return _longueur;
		// end-user-code
	}

	/** 
	 * @param _longueur _longueur à définir
	 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void set_longueur(float _longueur) {
		// begin-user-code
		this._longueur = _longueur;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Set<Cell> cell;

	/** 
	 * @return cell
	 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Set<Cell> getCell() {
		// begin-user-code
		return cell;
		// end-user-code
	}

	/** 
	 * @param cell cell à définir
	 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setCell(Set<Cell> cell) {
		// begin-user-code
		this.cell = cell;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Manager manager;

	/** 
	 * @return manager
	 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Manager getManager() {
		// begin-user-code
		return manager;
		// end-user-code
	}

	/** 
	 * @param manager manager à définir
	 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setManager(Manager manager) {
		// begin-user-code
		this.manager = manager;
		// end-user-code
	}
}