/**
 */
package behavior;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Occurrence Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavior.MessageOccurrenceSpecification#getEvent <em>Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavior.BehaviorPackage#getMessageOccurrenceSpecification()
 * @model
 * @generated
 */
public interface MessageOccurrenceSpecification extends OccurrenceSpecification, MessageEnd {
	/**
	 * Returns the value of the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' reference.
	 * @see #setEvent(Event)
	 * @see behavior.BehaviorPackage#getMessageOccurrenceSpecification_Event()
	 * @model required="true"
	 * @generated
	 */
	Event getEvent();

	/**
	 * Sets the value of the '{@link behavior.MessageOccurrenceSpecification#getEvent <em>Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' reference.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(Event value);

} // MessageOccurrenceSpecification
