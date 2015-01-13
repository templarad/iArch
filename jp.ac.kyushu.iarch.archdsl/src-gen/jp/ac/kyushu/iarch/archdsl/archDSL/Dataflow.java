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
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getDfa <em>Dfa</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getGetflow <em>Getflow</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getCall <em>Call</em>}</li>
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
   * Returns the value of the '<em><b>Dfa</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dfa</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dfa</em>' reference.
   * @see #setDfa(Dfa)
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getDataflow_Dfa()
   * @model
   * @generated
   */
  Dfa getDfa();

  /**
   * Sets the value of the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getDfa <em>Dfa</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dfa</em>' reference.
   * @see #getDfa()
   * @generated
   */
  void setDfa(Dfa value);

  /**
   * Returns the value of the '<em><b>Getflow</b></em>' reference list.
   * The list contents are of type {@link jp.ac.kyushu.iarch.archdsl.archDSL.Dflow}.
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
  EList<Dflow> getGetflow();

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
   * Returns the value of the '<em><b>End</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End</em>' reference.
   * @see #setEnd(Interface)
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getDataflow_End()
   * @model
   * @generated
   */
  Interface getEnd();

  /**
   * Sets the value of the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getEnd <em>End</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End</em>' reference.
   * @see #getEnd()
   * @generated
   */
  void setEnd(Interface value);

} // Dataflow
