/**
 */
package Dataflow_editor;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Dataflow_editor.DataFlow#getEntity <em>Entity</em>}</li>
 *   <li>{@link Dataflow_editor.DataFlow#getSource <em>Source</em>}</li>
 *   <li>{@link Dataflow_editor.DataFlow#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see Dataflow_editor.Dataflow_editorPackage#getDataFlow()
 * @model
 * @generated
 */
public interface DataFlow extends Classifier {
	/**
	 * Returns the value of the '<em><b>Entity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity</em>' containment reference.
	 * @see #setEntity(External_entity)
	 * @see Dataflow_editor.Dataflow_editorPackage#getDataFlow_Entity()
	 * @model containment="true" required="true"
	 * @generated
	 */
	External_entity getEntity();

	/**
	 * Sets the value of the '{@link Dataflow_editor.DataFlow#getEntity <em>Entity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity</em>' containment reference.
	 * @see #getEntity()
	 * @generated
	 */
	void setEntity(External_entity value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(Dataflow_editor.Process)
	 * @see Dataflow_editor.Dataflow_editorPackage#getDataFlow_Source()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Dataflow_editor.Process getSource();

	/**
	 * Sets the value of the '{@link Dataflow_editor.DataFlow#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Dataflow_editor.Process value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(Dataflow_editor.Process)
	 * @see Dataflow_editor.Dataflow_editorPackage#getDataFlow_Target()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Dataflow_editor.Process getTarget();

	/**
	 * Sets the value of the '{@link Dataflow_editor.DataFlow#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Dataflow_editor.Process value);

} // DataFlow
