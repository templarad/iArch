/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dataflow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getStatenotification <em>Statenotification</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getGetflow <em>Getflow</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getCall <em>Call</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getGetIf <em>Get If</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getDataflow()
 * @model
 * @generated
 */
public interface Dataflow extends EObject
{
  /**
   * Returns the value of the '<em><b>Statenotification</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statenotification</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statenotification</em>' reference.
   * @see #setStatenotification(StateNotification)
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getDataflow_Statenotification()
   * @model
   * @generated
   */
  StateNotification getStatenotification();

  /**
   * Sets the value of the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getStatenotification <em>Statenotification</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Statenotification</em>' reference.
   * @see #getStatenotification()
   * @generated
   */
  void setStatenotification(StateNotification value);

  /**
   * Returns the value of the '<em><b>Getflow</b></em>' reference list.
   * The list contents are of type {@link jp.ac.kyushu.iarch.archdsl.archDSL.Param}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Getflow</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Getflow</em>' reference list.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getDataflow_Getflow()
   * @model
   * @generated
   */
  EList<Param> getGetflow();

  /**
   * Returns the value of the '<em><b>Call</b></em>' reference list.
   * The list contents are of type {@link jp.ac.kyushu.iarch.archdsl.archDSL.Method}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Call</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Call</em>' reference list.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getDataflow_Call()
   * @model
   * @generated
   */
  EList<Method> getCall();

  /**
   * Returns the value of the '<em><b>Get If</b></em>' reference list.
   * The list contents are of type {@link jp.ac.kyushu.iarch.archdsl.archDSL.Interface}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Get If</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Get If</em>' reference list.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getDataflow_GetIf()
   * @model
   * @generated
   */
  EList<Interface> getGetIf();

  /**
   * Returns the value of the '<em><b>End</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End</em>' reference.
   * @see #setEnd(StateNotification)
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getDataflow_End()
   * @model
   * @generated
   */
  StateNotification getEnd();

  /**
   * Sets the value of the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getEnd <em>End</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End</em>' reference.
   * @see #getEnd()
   * @generated
   */
  void setEnd(StateNotification value);

} // Dataflow
