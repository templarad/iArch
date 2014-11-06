/**
 */
package Dataflow_editor;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Dataflow_editor.Process#getOwnedOperation <em>Owned Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see Dataflow_editor.Dataflow_editorPackage#getProcess()
 * @model
 * @generated
 */
public interface Process extends Classifier {
	/**
	 * Returns the value of the '<em><b>Owned Operation</b></em>' containment reference list.
	 * The list contents are of type {@link Dataflow_editor.Operation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Operation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Operation</em>' containment reference list.
	 * @see Dataflow_editor.Dataflow_editorPackage#getProcess_OwnedOperation()
	 * @model containment="true"
	 * @generated
	 */
	EList<Operation> getOwnedOperation();

} // Process
