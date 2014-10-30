/**
 */
package Dataflow_editor;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Dataflow_editor.NameSpace#getName <em>Name</em>}</li>
 *   <li>{@link Dataflow_editor.NameSpace#isArchpoint <em>Archpoint</em>}</li>
 * </ul>
 * </p>
 *
 * @see Dataflow_editor.Dataflow_editorPackage#getNameSpace()
 * @model abstract="true"
 * @generated
 */
public interface NameSpace extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Dataflow_editor.Dataflow_editorPackage#getNameSpace_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Dataflow_editor.NameSpace#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Archpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Archpoint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Archpoint</em>' attribute.
	 * @see #setArchpoint(boolean)
	 * @see Dataflow_editor.Dataflow_editorPackage#getNameSpace_Archpoint()
	 * @model
	 * @generated
	 */
	boolean isArchpoint();

	/**
	 * Sets the value of the '{@link Dataflow_editor.NameSpace#isArchpoint <em>Archpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Archpoint</em>' attribute.
	 * @see #isArchpoint()
	 * @generated
	 */
	void setArchpoint(boolean value);

} // NameSpace
