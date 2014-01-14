/**
 */
package behavior;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Redefinable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavior.RedefinableElement#getRedefinitionContext <em>Redefinition Context</em>}</li>
 *   <li>{@link behavior.RedefinableElement#getRedefinableELement <em>Redefinable ELement</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavior.BehaviorPackage#getRedefinableElement()
 * @model abstract="true"
 * @generated
 */
public interface RedefinableElement extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Redefinition Context</b></em>' reference list.
	 * The list contents are of type {@link behavior.Classifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Redefinition Context</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Redefinition Context</em>' reference list.
	 * @see behavior.BehaviorPackage#getRedefinableElement_RedefinitionContext()
	 * @model
	 * @generated
	 */
	EList<Classifier> getRedefinitionContext();

	/**
	 * Returns the value of the '<em><b>Redefinable ELement</b></em>' reference list.
	 * The list contents are of type {@link behavior.RedefinableElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Redefinable ELement</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Redefinable ELement</em>' reference list.
	 * @see behavior.BehaviorPackage#getRedefinableElement_RedefinableELement()
	 * @model
	 * @generated
	 */
	EList<RedefinableElement> getRedefinableELement();

} // RedefinableElement
