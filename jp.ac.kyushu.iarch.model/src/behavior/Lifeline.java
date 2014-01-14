/**
 */
package behavior;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lifeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavior.Lifeline#getCoveredBy <em>Covered By</em>}</li>
 *   <li>{@link behavior.Lifeline#getInteraction <em>Interaction</em>}</li>
 *   <li>{@link behavior.Lifeline#getEndby <em>Endby</em>}</li>
 *   <li>{@link behavior.Lifeline#getActor <em>Actor</em>}</li>
 *   <li>{@link behavior.Lifeline#getBehaviorExecution <em>Behavior Execution</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavior.BehaviorPackage#getLifeline()
 * @model
 * @generated
 */
public interface Lifeline extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Covered By</b></em>' reference list.
	 * The list contents are of type {@link behavior.InteractionFragment}.
	 * It is bidirectional and its opposite is '{@link behavior.InteractionFragment#getCovered <em>Covered</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Covered By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Covered By</em>' reference list.
	 * @see behavior.BehaviorPackage#getLifeline_CoveredBy()
	 * @see behavior.InteractionFragment#getCovered
	 * @model opposite="covered"
	 * @generated
	 */
	EList<InteractionFragment> getCoveredBy();

	/**
	 * Returns the value of the '<em><b>Interaction</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link behavior.Interaction#getLifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interaction</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interaction</em>' container reference.
	 * @see #setInteraction(Interaction)
	 * @see behavior.BehaviorPackage#getLifeline_Interaction()
	 * @see behavior.Interaction#getLifeline
	 * @model opposite="lifeline" required="true" transient="false"
	 * @generated
	 */
	Interaction getInteraction();

	/**
	 * Sets the value of the '{@link behavior.Lifeline#getInteraction <em>Interaction</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interaction</em>' container reference.
	 * @see #getInteraction()
	 * @generated
	 */
	void setInteraction(Interaction value);

	/**
	 * Returns the value of the '<em><b>Endby</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link behavior.DestructionEvent#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endby</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endby</em>' reference.
	 * @see #setEndby(DestructionEvent)
	 * @see behavior.BehaviorPackage#getLifeline_Endby()
	 * @see behavior.DestructionEvent#getEnd
	 * @model opposite="end" required="true"
	 * @generated
	 */
	DestructionEvent getEndby();

	/**
	 * Sets the value of the '{@link behavior.Lifeline#getEndby <em>Endby</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endby</em>' reference.
	 * @see #getEndby()
	 * @generated
	 */
	void setEndby(DestructionEvent value);

	/**
	 * Returns the value of the '<em><b>Actor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link behavior.BehavioredClassifier#getInclude <em>Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor</em>' reference.
	 * @see #setActor(BehavioredClassifier)
	 * @see behavior.BehaviorPackage#getLifeline_Actor()
	 * @see behavior.BehavioredClassifier#getInclude
	 * @model opposite="include" required="true"
	 * @generated
	 */
	BehavioredClassifier getActor();

	/**
	 * Sets the value of the '{@link behavior.Lifeline#getActor <em>Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actor</em>' reference.
	 * @see #getActor()
	 * @generated
	 */
	void setActor(BehavioredClassifier value);

	/**
	 * Returns the value of the '<em><b>Behavior Execution</b></em>' containment reference list.
	 * The list contents are of type {@link behavior.BehaviorExecutionSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior Execution</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Execution</em>' containment reference list.
	 * @see behavior.BehaviorPackage#getLifeline_BehaviorExecution()
	 * @model containment="true"
	 * @generated
	 */
	EList<BehaviorExecutionSpecification> getBehaviorExecution();

} // Lifeline
