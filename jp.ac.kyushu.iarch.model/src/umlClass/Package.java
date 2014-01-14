/**
 */
package umlClass;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link umlClass.Package#getClassifiers <em>Classifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @see umlClass.UmlClassPackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Classifiers</b></em>' containment reference list.
	 * The list contents are of type {@link umlClass.Classifier}.
	 * It is bidirectional and its opposite is '{@link umlClass.Classifier#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifiers</em>' containment reference list.
	 * @see umlClass.UmlClassPackage#getPackage_Classifiers()
	 * @see umlClass.Classifier#getPackage
	 * @model opposite="package" containment="true"
	 * @generated
	 */
	EList<Classifier> getClassifiers();

} // Package
