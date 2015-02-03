/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL.impl;

import java.util.Collection;

import jp.ac.kyushu.iarch.archdsl.archDSL.AltCall;
import jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage;
import jp.ac.kyushu.iarch.archdsl.archDSL.SuperMethod;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alt Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.AltCallImpl#isOpt <em>Opt</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.AltCallImpl#getA_name <em>Aname</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AltCallImpl extends SuperCallImpl implements AltCall
{
  /**
   * The default value of the '{@link #isOpt() <em>Opt</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOpt()
   * @generated
   * @ordered
   */
  protected static final boolean OPT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isOpt() <em>Opt</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOpt()
   * @generated
   * @ordered
   */
  protected boolean opt = OPT_EDEFAULT;

  /**
   * The cached value of the '{@link #getA_name() <em>Aname</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getA_name()
   * @generated
   * @ordered
   */
  protected EList<SuperMethod> a_name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AltCallImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArchDSLPackage.Literals.ALT_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isOpt()
  {
    return opt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpt(boolean newOpt)
  {
    boolean oldOpt = opt;
    opt = newOpt;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ArchDSLPackage.ALT_CALL__OPT, oldOpt, opt));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SuperMethod> getA_name()
  {
    if (a_name == null)
    {
      a_name = new EObjectResolvingEList<SuperMethod>(SuperMethod.class, this, ArchDSLPackage.ALT_CALL__ANAME);
    }
    return a_name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ArchDSLPackage.ALT_CALL__OPT:
        return isOpt();
      case ArchDSLPackage.ALT_CALL__ANAME:
        return getA_name();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ArchDSLPackage.ALT_CALL__OPT:
        setOpt((Boolean)newValue);
        return;
      case ArchDSLPackage.ALT_CALL__ANAME:
        getA_name().clear();
        getA_name().addAll((Collection<? extends SuperMethod>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ArchDSLPackage.ALT_CALL__OPT:
        setOpt(OPT_EDEFAULT);
        return;
      case ArchDSLPackage.ALT_CALL__ANAME:
        getA_name().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ArchDSLPackage.ALT_CALL__OPT:
        return opt != OPT_EDEFAULT;
      case ArchDSLPackage.ALT_CALL__ANAME:
        return a_name != null && !a_name.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (opt: ");
    result.append(opt);
    result.append(')');
    return result.toString();
  }

} //AltCallImpl
