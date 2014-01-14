/**
 */
package behavior;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Occurrence Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavior.OccurrenceSpecification#getToAfter <em>To After</em>}</li>
 *   <li>{@link behavior.OccurrenceSpecification#getToBefore <em>To Before</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavior.BehaviorPackage#getOccurrenceSpecification()
 * @model
 * @generated
 */
public interface OccurrenceSpecification extends InteractionFragment {
	/**
	 * Returns the value of the '<em><b>To After</b></em>' reference list.
	 * The list contents are of type {@link behavior.GeneralOrdering}.
	 * It is bidirectional and its opposite is '{@link behavior.GeneralOrdering#getBefore <em>Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To After</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To After</em>' reference list.
	 * @see behavior.BehaviorPackage#getOccurrenceSpecification_ToAfter()
	 * @see behavior.GeneralOrdering#getBefore
	 * @model opposite="before"
	 * @generated
	 */
	EList<GeneralOrdering> getToAfter();

	/**
	 * Returns the value of the '<em><b>To Before</b></em>' reference list.
	 * The list contents are of type {@link behavior.GeneralOrdering}.
	 * It is bidirectional and its opposite is '{@link behavior.GeneralOrdering#getAfter <em>After</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Before</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Before</em>' reference list.
	 * @see behavior.BehaviorPackage#getOccurrenceSpecification_ToBefore()
	 * @see behavior.GeneralOrdering#getAfter
	 * @model opposite="after"
	 * @generated
	 */
	EList<GeneralOrdering> getToBefore();

} // OccurrenceSpecification
