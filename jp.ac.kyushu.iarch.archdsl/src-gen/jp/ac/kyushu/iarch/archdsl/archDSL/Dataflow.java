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
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getDparam <em>Dparam</em>}</li>
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
   * Returns the value of the '<em><b>Dparam</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dparam</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dparam</em>' reference.
   * @see #setDparam(dParam)
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getDataflow_Dparam()
   * @model
   * @generated
   */
  dParam getDparam();

  /**
   * Sets the value of the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getDparam <em>Dparam</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dparam</em>' reference.
   * @see #getDparam()
   * @generated
   */
  void setDparam(dParam value);

  /**
   * Returns the value of the '<em><b>Getflow</b></em>' reference list.
   * The list contents are of type {@link jp.ac.kyushu.iarch.archdsl.archDSL.dParam}.
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
  EList<dParam> getGetflow();

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
   * @see #setEnd(dParam)
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getDataflow_End()
   * @model
   * @generated
   */
  dParam getEnd();

  /**
   * Sets the value of the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getEnd <em>End</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End</em>' reference.
   * @see #getEnd()
   * @generated
   */
  void setEnd(dParam value);

} // Dataflow
