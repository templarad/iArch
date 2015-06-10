/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL.impl;

import java.util.Collection;

import jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage;
import jp.ac.kyushu.iarch.archdsl.archDSL.Behavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.Connector;
import jp.ac.kyushu.iarch.archdsl.archDSL.cParam;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.ConnectorImpl#getName <em>Name</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.ConnectorImpl#getCparam <em>Cparam</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.ConnectorImpl#getBehaviors <em>Behaviors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectorImpl extends MinimalEObjectImpl.Container implements Connector
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getCparam() <em>Cparam</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCparam()
   * @generated
   * @ordered
   */
  protected EList<cParam> cparam;

  /**
   * The cached value of the '{@link #getBehaviors() <em>Behaviors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBehaviors()
   * @generated
   * @ordered
   */
  protected EList<Behavior> behaviors;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConnectorImpl()
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
    return ArchDSLPackage.Literals.CONNECTOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ArchDSLPackage.CONNECTOR__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<cParam> getCparam()
  {
    if (cparam == null)
    {
      cparam = new EObjectContainmentEList<cParam>(cParam.class, this, ArchDSLPackage.CONNECTOR__CPARAM);
    }
    return cparam;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Behavior> getBehaviors()
  {
    if (behaviors == null)
    {
      behaviors = new EObjectContainmentEList<Behavior>(Behavior.class, this, ArchDSLPackage.CONNECTOR__BEHAVIORS);
    }
    return behaviors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ArchDSLPackage.CONNECTOR__CPARAM:
        return ((InternalEList<?>)getCparam()).basicRemove(otherEnd, msgs);
      case ArchDSLPackage.CONNECTOR__BEHAVIORS:
        return ((InternalEList<?>)getBehaviors()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case ArchDSLPackage.CONNECTOR__NAME:
        return getName();
      case ArchDSLPackage.CONNECTOR__CPARAM:
        return getCparam();
      case ArchDSLPackage.CONNECTOR__BEHAVIORS:
        return getBehaviors();
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
      case ArchDSLPackage.CONNECTOR__NAME:
        setName((String)newValue);
        return;
      case ArchDSLPackage.CONNECTOR__CPARAM:
        getCparam().clear();
        getCparam().addAll((Collection<? extends cParam>)newValue);
        return;
      case ArchDSLPackage.CONNECTOR__BEHAVIORS:
        getBehaviors().clear();
        getBehaviors().addAll((Collection<? extends Behavior>)newValue);
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
      case ArchDSLPackage.CONNECTOR__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ArchDSLPackage.CONNECTOR__CPARAM:
        getCparam().clear();
        return;
      case ArchDSLPackage.CONNECTOR__BEHAVIORS:
        getBehaviors().clear();
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
      case ArchDSLPackage.CONNECTOR__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ArchDSLPackage.CONNECTOR__CPARAM:
        return cparam != null && !cparam.isEmpty();
      case ArchDSLPackage.CONNECTOR__BEHAVIORS:
        return behaviors != null && !behaviors.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ConnectorImpl
