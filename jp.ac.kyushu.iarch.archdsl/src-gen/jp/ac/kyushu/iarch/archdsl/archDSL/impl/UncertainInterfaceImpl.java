/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL.impl;

import java.util.Collection;

import jp.ac.kyushu.iarch.archdsl.archDSL.AltMethod;
import jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.OptMethod;
import jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface;

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
 * An implementation of the model object '<em><b>Uncertain Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.UncertainInterfaceImpl#getName <em>Name</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.UncertainInterfaceImpl#getSuperInterface <em>Super Interface</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.UncertainInterfaceImpl#getAltmethods <em>Altmethods</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.UncertainInterfaceImpl#getOptmethods <em>Optmethods</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UncertainInterfaceImpl extends MinimalEObjectImpl.Container implements UncertainInterface
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
   * The cached value of the '{@link #getSuperInterface() <em>Super Interface</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperInterface()
   * @generated
   * @ordered
   */
  protected Interface superInterface;

  /**
   * The cached value of the '{@link #getAltmethods() <em>Altmethods</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAltmethods()
   * @generated
   * @ordered
   */
  protected EList<AltMethod> altmethods;

  /**
   * The cached value of the '{@link #getOptmethods() <em>Optmethods</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOptmethods()
   * @generated
   * @ordered
   */
  protected EList<OptMethod> optmethods;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UncertainInterfaceImpl()
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
    return ArchDSLPackage.Literals.UNCERTAIN_INTERFACE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ArchDSLPackage.UNCERTAIN_INTERFACE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Interface getSuperInterface()
  {
    if (superInterface != null && superInterface.eIsProxy())
    {
      InternalEObject oldSuperInterface = (InternalEObject)superInterface;
      superInterface = (Interface)eResolveProxy(oldSuperInterface);
      if (superInterface != oldSuperInterface)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchDSLPackage.UNCERTAIN_INTERFACE__SUPER_INTERFACE, oldSuperInterface, superInterface));
      }
    }
    return superInterface;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Interface basicGetSuperInterface()
  {
    return superInterface;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuperInterface(Interface newSuperInterface)
  {
    Interface oldSuperInterface = superInterface;
    superInterface = newSuperInterface;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ArchDSLPackage.UNCERTAIN_INTERFACE__SUPER_INTERFACE, oldSuperInterface, superInterface));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AltMethod> getAltmethods()
  {
    if (altmethods == null)
    {
      altmethods = new EObjectContainmentEList<AltMethod>(AltMethod.class, this, ArchDSLPackage.UNCERTAIN_INTERFACE__ALTMETHODS);
    }
    return altmethods;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<OptMethod> getOptmethods()
  {
    if (optmethods == null)
    {
      optmethods = new EObjectContainmentEList<OptMethod>(OptMethod.class, this, ArchDSLPackage.UNCERTAIN_INTERFACE__OPTMETHODS);
    }
    return optmethods;
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
      case ArchDSLPackage.UNCERTAIN_INTERFACE__ALTMETHODS:
        return ((InternalEList<?>)getAltmethods()).basicRemove(otherEnd, msgs);
      case ArchDSLPackage.UNCERTAIN_INTERFACE__OPTMETHODS:
        return ((InternalEList<?>)getOptmethods()).basicRemove(otherEnd, msgs);
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
      case ArchDSLPackage.UNCERTAIN_INTERFACE__NAME:
        return getName();
      case ArchDSLPackage.UNCERTAIN_INTERFACE__SUPER_INTERFACE:
        if (resolve) return getSuperInterface();
        return basicGetSuperInterface();
      case ArchDSLPackage.UNCERTAIN_INTERFACE__ALTMETHODS:
        return getAltmethods();
      case ArchDSLPackage.UNCERTAIN_INTERFACE__OPTMETHODS:
        return getOptmethods();
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
      case ArchDSLPackage.UNCERTAIN_INTERFACE__NAME:
        setName((String)newValue);
        return;
      case ArchDSLPackage.UNCERTAIN_INTERFACE__SUPER_INTERFACE:
        setSuperInterface((Interface)newValue);
        return;
      case ArchDSLPackage.UNCERTAIN_INTERFACE__ALTMETHODS:
        getAltmethods().clear();
        getAltmethods().addAll((Collection<? extends AltMethod>)newValue);
        return;
      case ArchDSLPackage.UNCERTAIN_INTERFACE__OPTMETHODS:
        getOptmethods().clear();
        getOptmethods().addAll((Collection<? extends OptMethod>)newValue);
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
      case ArchDSLPackage.UNCERTAIN_INTERFACE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ArchDSLPackage.UNCERTAIN_INTERFACE__SUPER_INTERFACE:
        setSuperInterface((Interface)null);
        return;
      case ArchDSLPackage.UNCERTAIN_INTERFACE__ALTMETHODS:
        getAltmethods().clear();
        return;
      case ArchDSLPackage.UNCERTAIN_INTERFACE__OPTMETHODS:
        getOptmethods().clear();
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
      case ArchDSLPackage.UNCERTAIN_INTERFACE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ArchDSLPackage.UNCERTAIN_INTERFACE__SUPER_INTERFACE:
        return superInterface != null;
      case ArchDSLPackage.UNCERTAIN_INTERFACE__ALTMETHODS:
        return altmethods != null && !altmethods.isEmpty();
      case ArchDSLPackage.UNCERTAIN_INTERFACE__OPTMETHODS:
        return optmethods != null && !optmethods.isEmpty();
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

} //UncertainInterfaceImpl
