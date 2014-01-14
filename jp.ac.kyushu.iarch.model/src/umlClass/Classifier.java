/**
 */
package umlClass;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link umlClass.Classifier#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link umlClass.Classifier#getRedefinedClassifier <em>Redefined Classifier</em>}</li>
 *   <li>{@link umlClass.Classifier#getPackage <em>Package</em>}</li>
 *   <li>{@link umlClass.Classifier#getGeneralization <em>Generalization</em>}</li>
 * </ul>
 * </p>
 *
 * @see umlClass.UmlClassPackage#getClassifier()
 * @model abstract="true"
 * @generated
 */
public interface Classifier extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference list.
	 * The list contents are of type {@link umlClass.Property}.
	 * It is bidirectional and its opposite is '{@link umlClass.Property#getClassifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference list.
	 * @see umlClass.UmlClassPackage#getClassifier_Attribute()
	 * @see umlClass.Property#getClassifier
	 * @model opposite="classifier"
	 * @generated
	 */
	EList<Property> getAttribute();

	/**
	 * Returns the value of the '<em><b>Redefined Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Redefined Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Redefined Classifier</em>' reference.
	 * @see #setRedefinedClassifier(Classifier)
	 * @see umlClass.UmlClassPackage#getClassifier_RedefinedClassifier()
	 * @model
	 * @generated
	 */
	Classifier getRedefinedClassifier();

	/**
	 * Sets the value of the '{@link umlClass.Classifier#getRedefinedClassifier <em>Redefined Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Redefined Classifier</em>' reference.
	 * @see #getRedefinedClassifier()
	 * @generated
	 */
	void setRedefinedClassifier(Classifier value);

	/**
	 * Returns the value of the '<em><b>Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link umlClass.Package#getClassifiers <em>Classifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' container reference.
	 * @see #setPackage(umlClass.Package)
	 * @see umlClass.UmlClassPackage#getClassifier_Package()
	 * @see umlClass.Package#getClassifiers
	 * @model opposite="classifiers" transient="false"
	 * @generated
	 */
	umlClass.Package getPackage();

	/**
	 * Sets the value of the '{@link umlClass.Classifier#getPackage <em>Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' container reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(umlClass.Package value);

	/**
	 * Returns the value of the '<em><b>Generalization</b></em>' containment reference list.
	 * The list contents are of type {@link umlClass.Generalization}.
	 * It is bidirectional and its opposite is '{@link umlClass.Generalization#getSpecific <em>Specific</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generalization</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generalization</em>' containment reference list.
	 * @see umlClass.UmlClassPackage#getClassifier_Generalization()
	 * @see umlClass.Generalization#getSpecific
	 * @model opposite="specific" containment="true"
	 * @generated
	 */
	EList<Generalization> getGeneralization();

} // Classifier
