/**
 */
package umlClass;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link umlClass.NamedElement#getName <em>Name</em>}</li>
 *   <li>{@link umlClass.NamedElement#isArchpoint <em>Archpoint</em>}</li>
 * </ul>
 * </p>
 *
 * @see umlClass.UmlClassPackage#getNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface NamedElement extends Element {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see umlClass.UmlClassPackage#getNamedElement_Name()
	 * @model dataType="umlClass.String"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link umlClass.NamedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Archpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Archpoint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Archpoint</em>' attribute.
	 * @see #setArchpoint(boolean)
	 * @see umlClass.UmlClassPackage#getNamedElement_Archpoint()
	 * @model dataType="umlClass.Boolean"
	 * @generated
	 */
	boolean isArchpoint();

	/**
	 * Sets the value of the '{@link umlClass.NamedElement#isArchpoint <em>Archpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Archpoint</em>' attribute.
	 * @see #isArchpoint()
	 * @generated
	 */
	void setArchpoint(boolean value);

} // NamedElement
