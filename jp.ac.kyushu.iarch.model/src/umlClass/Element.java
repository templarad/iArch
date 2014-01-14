/**
 */
package umlClass;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link umlClass.Element#getOwner <em>Owner</em>}</li>
 *   <li>{@link umlClass.Element#getOwnedElement <em>Owned Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see umlClass.UmlClassPackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends EObject {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link umlClass.Element#getOwnedElement <em>Owned Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(Element)
	 * @see umlClass.UmlClassPackage#getElement_Owner()
	 * @see umlClass.Element#getOwnedElement
	 * @model opposite="ownedElement"
	 * @generated
	 */
	Element getOwner();

	/**
	 * Sets the value of the '{@link umlClass.Element#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Element value);

	/**
	 * Returns the value of the '<em><b>Owned Element</b></em>' reference list.
	 * The list contents are of type {@link umlClass.Element}.
	 * It is bidirectional and its opposite is '{@link umlClass.Element#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Element</em>' reference list.
	 * @see umlClass.UmlClassPackage#getElement_OwnedElement()
	 * @see umlClass.Element#getOwner
	 * @model opposite="owner"
	 * @generated
	 */
	EList<Element> getOwnedElement();

} // Element
