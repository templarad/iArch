/**
 */
package umlClass;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link umlClass.Association#getOwnedEnd <em>Owned End</em>}</li>
 *   <li>{@link umlClass.Association#getMemberEnd <em>Member End</em>}</li>
 *   <li>{@link umlClass.Association#getNavigableOwnedEnd <em>Navigable Owned End</em>}</li>
 *   <li>{@link umlClass.Association#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see umlClass.UmlClassPackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends Classifier, Relationship {
	/**
	 * Returns the value of the '<em><b>Owned End</b></em>' containment reference list.
	 * The list contents are of type {@link umlClass.Property}.
	 * It is bidirectional and its opposite is '{@link umlClass.Property#getOwningAssociation <em>Owning Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned End</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned End</em>' containment reference list.
	 * @see umlClass.UmlClassPackage#getAssociation_OwnedEnd()
	 * @see umlClass.Property#getOwningAssociation
	 * @model opposite="owningAssociation" containment="true"
	 * @generated
	 */
	EList<Property> getOwnedEnd();

	/**
	 * Returns the value of the '<em><b>Member End</b></em>' reference list.
	 * The list contents are of type {@link umlClass.Property}.
	 * It is bidirectional and its opposite is '{@link umlClass.Property#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member End</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member End</em>' reference list.
	 * @see umlClass.UmlClassPackage#getAssociation_MemberEnd()
	 * @see umlClass.Property#getAssociation
	 * @model opposite="association" lower="2"
	 * @generated
	 */
	EList<Property> getMemberEnd();

	/**
	 * Returns the value of the '<em><b>Navigable Owned End</b></em>' reference list.
	 * The list contents are of type {@link umlClass.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Navigable Owned End</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Navigable Owned End</em>' reference list.
	 * @see umlClass.UmlClassPackage#getAssociation_NavigableOwnedEnd()
	 * @model
	 * @generated
	 */
	EList<Property> getNavigableOwnedEnd();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(umlClass.Class)
	 * @see umlClass.UmlClassPackage#getAssociation_Target()
	 * @model required="true"
	 * @generated
	 */
	umlClass.Class getTarget();

	/**
	 * Sets the value of the '{@link umlClass.Association#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(umlClass.Class value);

} // Association
