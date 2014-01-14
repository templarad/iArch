/**
 */
package behavior;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavior.Class#getNestedClassifier <em>Nested Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavior.BehaviorPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends BehavioredClassifier {
	/**
	 * Returns the value of the '<em><b>Nested Classifier</b></em>' reference list.
	 * The list contents are of type {@link behavior.Classifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Classifier</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Classifier</em>' reference list.
	 * @see behavior.BehaviorPackage#getClass_NestedClassifier()
	 * @model
	 * @generated
	 */
	EList<Classifier> getNestedClassifier();

} // Class
