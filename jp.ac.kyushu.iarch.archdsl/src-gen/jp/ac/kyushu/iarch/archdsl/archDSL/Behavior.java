/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.Behavior#getInterface <em>Interface</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.Behavior#getCall <em>Call</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.Behavior#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getBehavior()
 * @model
 * @generated
 */
public interface Behavior extends EObject
{
  /**
   * Returns the value of the '<em><b>Interface</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Interface</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interface</em>' reference.
   * @see #setInterface(Interface)
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getBehavior_Interface()
   * @model
   * @generated
   */
  Interface getInterface();

  /**
   * Sets the value of the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Behavior#getInterface <em>Interface</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Interface</em>' reference.
   * @see #getInterface()
   * @generated
   */
  void setInterface(Interface value);

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
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getBehavior_Call()
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
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getBehavior_End()
   * @model
   * @generated
   */
  Interface getEnd();

  /**
   * Sets the value of the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Behavior#getEnd <em>End</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End</em>' reference.
   * @see #getEnd()
   * @generated
   */
  void setEnd(Interface value);

} // Behavior
