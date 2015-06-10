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
   * Returns the value of the '<em><b>Statenotification</b></em>' containment reference list.
   * The list contents are of type {@link jp.ac.kyushu.iarch.archdsl.archDSL.StateNotification}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statenotification</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statenotification</em>' containment reference list.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getDataflow_Statenotification()
   * @model containment="true"
   * @generated
   */
  EList<StateNotification> getStatenotification();

  /**
   * Returns the value of the '<em><b>Getflow</b></em>' reference list.
   * The list contents are of type {@link jp.ac.kyushu.iarch.archdsl.archDSL.DFlow}.
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
  EList<DFlow> getGetflow();

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

} // Dataflow
