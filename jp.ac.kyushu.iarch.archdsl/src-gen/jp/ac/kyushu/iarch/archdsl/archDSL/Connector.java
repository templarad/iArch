/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.Connector#getName <em>Name</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.Connector#getCparam <em>Cparam</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.Connector#getBehaviors <em>Behaviors</em>}</li>
 * </ul>
 * </p>
 *
 * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getConnector()
 * @model
 * @generated
 */
public interface Connector extends EObject
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
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getConnector_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Connector#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Cparam</b></em>' containment reference list.
   * The list contents are of type {@link jp.ac.kyushu.iarch.archdsl.archDSL.cParam}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cparam</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cparam</em>' containment reference list.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getConnector_Cparam()
   * @model containment="true"
   * @generated
   */
  EList<cParam> getCparam();

  /**
   * Returns the value of the '<em><b>Behaviors</b></em>' containment reference list.
   * The list contents are of type {@link jp.ac.kyushu.iarch.archdsl.archDSL.Behavior}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Behaviors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Behaviors</em>' containment reference list.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getConnector_Behaviors()
   * @model containment="true"
   * @generated
   */
  EList<Behavior> getBehaviors();

} // Connector
