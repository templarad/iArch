/**
 */
package behavior;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavior.Interaction#getFragment <em>Fragment</em>}</li>
 *   <li>{@link behavior.Interaction#getObject <em>Object</em>}</li>
 *   <li>{@link behavior.Interaction#getDestructionevent <em>Destructionevent</em>}</li>
 *   <li>{@link behavior.Interaction#getLifeline <em>Lifeline</em>}</li>
 *   <li>{@link behavior.Interaction#getMessage <em>Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavior.BehaviorPackage#getInteraction()
 * @model
 * @generated
 */
public interface Interaction extends Behavior, InteractionFragment {
	/**
	 * Returns the value of the '<em><b>Fragment</b></em>' containment reference list.
	 * The list contents are of type {@link behavior.InteractionFragment}.
	 * It is bidirectional and its opposite is '{@link behavior.InteractionFragment#getEnclosingInteraction <em>Enclosing Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragment</em>' containment reference list.
	 * @see behavior.BehaviorPackage#getInteraction_Fragment()
	 * @see behavior.InteractionFragment#getEnclosingInteraction
	 * @model opposite="enclosingInteraction" containment="true"
	 * @generated
	 */
	EList<InteractionFragment> getFragment();

	/**
	 * Returns the value of the '<em><b>Object</b></em>' containment reference list.
	 * The list contents are of type {@link behavior.BehavioredClassifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' containment reference list.
	 * @see behavior.BehaviorPackage#getInteraction_Object()
	 * @model containment="true"
	 * @generated
	 */
	EList<BehavioredClassifier> getObject();

	/**
	 * Returns the value of the '<em><b>Destructionevent</b></em>' containment reference list.
	 * The list contents are of type {@link behavior.DestructionEvent}.
	 * It is bidirectional and its opposite is '{@link behavior.DestructionEvent#getInteraction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destructionevent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destructionevent</em>' containment reference list.
	 * @see behavior.BehaviorPackage#getInteraction_Destructionevent()
	 * @see behavior.DestructionEvent#getInteraction
	 * @model opposite="interaction" containment="true"
	 * @generated
	 */
	EList<DestructionEvent> getDestructionevent();

	/**
	 * Returns the value of the '<em><b>Lifeline</b></em>' containment reference list.
	 * The list contents are of type {@link behavior.Lifeline}.
	 * It is bidirectional and its opposite is '{@link behavior.Lifeline#getInteraction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lifeline</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lifeline</em>' containment reference list.
	 * @see behavior.BehaviorPackage#getInteraction_Lifeline()
	 * @see behavior.Lifeline#getInteraction
	 * @model opposite="interaction" containment="true"
	 * @generated
	 */
	EList<Lifeline> getLifeline();

	/**
	 * Returns the value of the '<em><b>Message</b></em>' containment reference list.
	 * The list contents are of type {@link behavior.Message}.
	 * It is bidirectional and its opposite is '{@link behavior.Message#getInteraction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' containment reference list.
	 * @see behavior.BehaviorPackage#getInteraction_Message()
	 * @see behavior.Message#getInteraction
	 * @model opposite="interaction" containment="true"
	 * @generated
	 */
	EList<Message> getMessage();

} // Interaction
