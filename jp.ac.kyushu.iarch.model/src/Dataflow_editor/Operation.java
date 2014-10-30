/**
 */
package Dataflow_editor;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Dataflow_editor.Operation#getEReference0 <em>EReference0</em>}</li>
 *   <li>{@link Dataflow_editor.Operation#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link Dataflow_editor.Operation#isIsUnique <em>Is Unique</em>}</li>
 *   <li>{@link Dataflow_editor.Operation#getLower <em>Lower</em>}</li>
 *   <li>{@link Dataflow_editor.Operation#getUpper <em>Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @see Dataflow_editor.Dataflow_editorPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends NameSpace {
	/**
	 * Returns the value of the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference0</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference0</em>' reference.
	 * @see #setEReference0(NameSpace)
	 * @see Dataflow_editor.Dataflow_editorPackage#getOperation_EReference0()
	 * @model
	 * @generated
	 */
	NameSpace getEReference0();

	/**
	 * Sets the value of the '{@link Dataflow_editor.Operation#getEReference0 <em>EReference0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference0</em>' reference.
	 * @see #getEReference0()
	 * @generated
	 */
	void setEReference0(NameSpace value);

	/**
	 * Returns the value of the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Ordered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Ordered</em>' attribute.
	 * @see #setIsOrdered(boolean)
	 * @see Dataflow_editor.Dataflow_editorPackage#getOperation_IsOrdered()
	 * @model
	 * @generated
	 */
	boolean isIsOrdered();

	/**
	 * Sets the value of the '{@link Dataflow_editor.Operation#isIsOrdered <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ordered</em>' attribute.
	 * @see #isIsOrdered()
	 * @generated
	 */
	void setIsOrdered(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Unique</em>' attribute.
	 * @see #setIsUnique(boolean)
	 * @see Dataflow_editor.Dataflow_editorPackage#getOperation_IsUnique()
	 * @model
	 * @generated
	 */
	boolean isIsUnique();

	/**
	 * Sets the value of the '{@link Dataflow_editor.Operation#isIsUnique <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unique</em>' attribute.
	 * @see #isIsUnique()
	 * @generated
	 */
	void setIsUnique(boolean value);

	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(int)
	 * @see Dataflow_editor.Dataflow_editorPackage#getOperation_Lower()
	 * @model
	 * @generated
	 */
	int getLower();

	/**
	 * Sets the value of the '{@link Dataflow_editor.Operation#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(int value);

	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(int)
	 * @see Dataflow_editor.Dataflow_editorPackage#getOperation_Upper()
	 * @model
	 * @generated
	 */
	int getUpper();

	/**
	 * Sets the value of the '{@link Dataflow_editor.Operation#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(int value);

} // Operation
