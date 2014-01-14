/**
 */
package behavior;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Destruction Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavior.DestructionEvent#getEnd <em>End</em>}</li>
 *   <li>{@link behavior.DestructionEvent#getInteraction <em>Interaction</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavior.BehaviorPackage#getDestructionEvent()
 * @model
 * @generated
 */
public interface DestructionEvent extends Event {
	/**
	 * Returns the value of the '<em><b>End</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link behavior.Lifeline#getEndby <em>Endby</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' reference.
	 * @see #setEnd(Lifeline)
	 * @see behavior.BehaviorPackage#getDestructionEvent_End()
	 * @see behavior.Lifeline#getEndby
	 * @model opposite="endby" required="true"
	 * @generated
	 */
	Lifeline getEnd();

	/**
	 * Sets the value of the '{@link behavior.DestructionEvent#getEnd <em>End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' reference.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(Lifeline value);

	/**
	 * Returns the value of the '<em><b>Interaction</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link behavior.Interaction#getDestructionevent <em>Destructionevent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interaction</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interaction</em>' container reference.
	 * @see #setInteraction(Interaction)
	 * @see behavior.BehaviorPackage#getDestructionEvent_Interaction()
	 * @see behavior.Interaction#getDestructionevent
	 * @model opposite="destructionevent" transient="false"
	 * @generated
	 */
	Interaction getInteraction();

	/**
	 * Sets the value of the '{@link behavior.DestructionEvent#getInteraction <em>Interaction</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interaction</em>' container reference.
	 * @see #getInteraction()
	 * @generated
	 */
	void setInteraction(Interaction value);

} // DestructionEvent
