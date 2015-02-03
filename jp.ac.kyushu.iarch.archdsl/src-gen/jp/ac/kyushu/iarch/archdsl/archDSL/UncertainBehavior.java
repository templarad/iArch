/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uncertain Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.UncertainBehavior#getName <em>Name</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.UncertainBehavior#getSuperInterface <em>Super Interface</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.UncertainBehavior#getCall <em>Call</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.UncertainBehavior#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getUncertainBehavior()
 * @model
 * @generated
 */
public interface UncertainBehavior extends EObject
{
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
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getUncertainBehavior_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.UncertainBehavior#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Super Interface</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Interface</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Interface</em>' reference.
   * @see #setSuperInterface(Interface)
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getUncertainBehavior_SuperInterface()
   * @model
   * @generated
   */
  Interface getSuperInterface();

  /**
   * Sets the value of the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.UncertainBehavior#getSuperInterface <em>Super Interface</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Interface</em>' reference.
   * @see #getSuperInterface()
   * @generated
   */
  void setSuperInterface(Interface value);

  /**
   * Returns the value of the '<em><b>Call</b></em>' containment reference list.
   * The list contents are of type {@link jp.ac.kyushu.iarch.archdsl.archDSL.SuperCall}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Call</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Call</em>' containment reference list.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getUncertainBehavior_Call()
   * @model containment="true"
   * @generated
   */
  EList<SuperCall> getCall();

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
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getUncertainBehavior_End()
   * @model
   * @generated
   */
  Interface getEnd();

  /**
   * Sets the value of the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.UncertainBehavior#getEnd <em>End</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End</em>' reference.
   * @see #getEnd()
   * @generated
   */
  void setEnd(Interface value);

} // UncertainBehavior
