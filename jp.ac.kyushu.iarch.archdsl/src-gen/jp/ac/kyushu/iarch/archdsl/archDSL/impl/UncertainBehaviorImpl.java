/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL.impl;

import java.util.Collection;

import jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.SuperCall;
import jp.ac.kyushu.iarch.archdsl.archDSL.UncertainBehavior;

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
 * An implementation of the model object '<em><b>Uncertain Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.UncertainBehaviorImpl#getName <em>Name</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.UncertainBehaviorImpl#getSuperInterface <em>Super Interface</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.UncertainBehaviorImpl#getCall <em>Call</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.UncertainBehaviorImpl#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UncertainBehaviorImpl extends MinimalEObjectImpl.Container implements UncertainBehavior
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
   * The cached value of the '{@link #getCall() <em>Call</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCall()
   * @generated
   * @ordered
   */
  protected EList<SuperCall> call;

  /**
   * The cached value of the '{@link #getEnd() <em>End</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnd()
   * @generated
   * @ordered
   */
  protected Interface end;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UncertainBehaviorImpl()
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
    return ArchDSLPackage.Literals.UNCERTAIN_BEHAVIOR;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ArchDSLPackage.UNCERTAIN_BEHAVIOR__NAME, oldName, name));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchDSLPackage.UNCERTAIN_BEHAVIOR__SUPER_INTERFACE, oldSuperInterface, superInterface));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ArchDSLPackage.UNCERTAIN_BEHAVIOR__SUPER_INTERFACE, oldSuperInterface, superInterface));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SuperCall> getCall()
  {
    if (call == null)
    {
      call = new EObjectContainmentEList<SuperCall>(SuperCall.class, this, ArchDSLPackage.UNCERTAIN_BEHAVIOR__CALL);
    }
    return call;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Interface getEnd()
  {
    if (end != null && end.eIsProxy())
    {
      InternalEObject oldEnd = (InternalEObject)end;
      end = (Interface)eResolveProxy(oldEnd);
      if (end != oldEnd)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchDSLPackage.UNCERTAIN_BEHAVIOR__END, oldEnd, end));
      }
    }
    return end;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Interface basicGetEnd()
  {
    return end;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnd(Interface newEnd)
  {
    Interface oldEnd = end;
    end = newEnd;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ArchDSLPackage.UNCERTAIN_BEHAVIOR__END, oldEnd, end));
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
      case ArchDSLPackage.UNCERTAIN_BEHAVIOR__CALL:
        return ((InternalEList<?>)getCall()).basicRemove(otherEnd, msgs);
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
      case ArchDSLPackage.UNCERTAIN_BEHAVIOR__NAME:
        return getName();
      case ArchDSLPackage.UNCERTAIN_BEHAVIOR__SUPER_INTERFACE:
        if (resolve) return getSuperInterface();
        return basicGetSuperInterface();
      case ArchDSLPackage.UNCERTAIN_BEHAVIOR__CALL:
        return getCall();
      case ArchDSLPackage.UNCERTAIN_BEHAVIOR__END:
        if (resolve) return getEnd();
        return basicGetEnd();
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
      case ArchDSLPackage.UNCERTAIN_BEHAVIOR__NAME:
        setName((String)newValue);
        return;
      case ArchDSLPackage.UNCERTAIN_BEHAVIOR__SUPER_INTERFACE:
        setSuperInterface((Interface)newValue);
        return;
      case ArchDSLPackage.UNCERTAIN_BEHAVIOR__CALL:
        getCall().clear();
        getCall().addAll((Collection<? extends SuperCall>)newValue);
        return;
      case ArchDSLPackage.UNCERTAIN_BEHAVIOR__END:
        setEnd((Interface)newValue);
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
      case ArchDSLPackage.UNCERTAIN_BEHAVIOR__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ArchDSLPackage.UNCERTAIN_BEHAVIOR__SUPER_INTERFACE:
        setSuperInterface((Interface)null);
        return;
      case ArchDSLPackage.UNCERTAIN_BEHAVIOR__CALL:
        getCall().clear();
        return;
      case ArchDSLPackage.UNCERTAIN_BEHAVIOR__END:
        setEnd((Interface)null);
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
      case ArchDSLPackage.UNCERTAIN_BEHAVIOR__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ArchDSLPackage.UNCERTAIN_BEHAVIOR__SUPER_INTERFACE:
        return superInterface != null;
      case ArchDSLPackage.UNCERTAIN_BEHAVIOR__CALL:
        return call != null && !call.isEmpty();
      case ArchDSLPackage.UNCERTAIN_BEHAVIOR__END:
        return end != null;
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

} //UncertainBehaviorImpl
