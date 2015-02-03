/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alt Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.AltCall#isOpt <em>Opt</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.AltCall#getA_name <em>Aname</em>}</li>
 * </ul>
 * </p>
 *
 * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getAltCall()
 * @model
 * @generated
 */
public interface AltCall extends SuperCall
{
  /**
   * Returns the value of the '<em><b>Opt</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Opt</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Opt</em>' attribute.
   * @see #setOpt(boolean)
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getAltCall_Opt()
   * @model
   * @generated
   */
  boolean isOpt();

  /**
   * Sets the value of the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.AltCall#isOpt <em>Opt</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opt</em>' attribute.
   * @see #isOpt()
   * @generated
   */
  void setOpt(boolean value);

  /**
   * Returns the value of the '<em><b>Aname</b></em>' reference list.
   * The list contents are of type {@link jp.ac.kyushu.iarch.archdsl.archDSL.SuperMethod}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Aname</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Aname</em>' reference list.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#getAltCall_A_name()
   * @model
   * @generated
   */
  EList<SuperMethod> getA_name();

} // AltCall
