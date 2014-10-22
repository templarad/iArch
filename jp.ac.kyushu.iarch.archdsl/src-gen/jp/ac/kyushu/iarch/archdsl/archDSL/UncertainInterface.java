/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uncertain Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface#getName <em>Name</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface#getSuperInterface <em>Super Interface</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface#getAltmethods <em>Altmethods</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface#getOptmethods <em>Optmethods</em>}</li>
 * </ul>
 * </p>
 *
 * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getUncertainInterface()
 * @model
 * @generated
 */
public interface UncertainInterface extends EObject
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
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getUncertainInterface_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface#getName <em>Name</em>}' attribute.
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
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getUncertainInterface_SuperInterface()
   * @model
   * @generated
   */
  Interface getSuperInterface();

  /**
   * Sets the value of the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface#getSuperInterface <em>Super Interface</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Interface</em>' reference.
   * @see #getSuperInterface()
   * @generated
   */
  void setSuperInterface(Interface value);

  /**
   * Returns the value of the '<em><b>Altmethods</b></em>' containment reference list.
   * The list contents are of type {@link jp.ac.kyushu.iarch.archdsl.archDSL.AltMethod}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Altmethods</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Altmethods</em>' containment reference list.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getUncertainInterface_Altmethods()
   * @model containment="true"
   * @generated
   */
  EList<AltMethod> getAltmethods();

  /**
   * Returns the value of the '<em><b>Optmethods</b></em>' containment reference list.
   * The list contents are of type {@link jp.ac.kyushu.iarch.archdsl.archDSL.OptMethod}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Optmethods</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Optmethods</em>' containment reference list.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getUncertainInterface_Optmethods()
   * @model containment="true"
   * @generated
   */
  EList<OptMethod> getOptmethods();

} // UncertainInterface
