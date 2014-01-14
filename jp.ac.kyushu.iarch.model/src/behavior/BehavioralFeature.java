/**
 */
package behavior;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavioral Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavior.BehavioralFeature#getMethod <em>Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavior.BehaviorPackage#getBehavioralFeature()
 * @model abstract="true"
 * @generated
 */
public interface BehavioralFeature extends Feature, NamedElement {
	/**
	 * Returns the value of the '<em><b>Method</b></em>' reference list.
	 * The list contents are of type {@link behavior.Behavior}.
	 * It is bidirectional and its opposite is '{@link behavior.Behavior#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' reference list.
	 * @see behavior.BehaviorPackage#getBehavioralFeature_Method()
	 * @see behavior.Behavior#getSpecification
	 * @model opposite="specification"
	 * @generated
	 */
	EList<Behavior> getMethod();

} // BehavioralFeature
