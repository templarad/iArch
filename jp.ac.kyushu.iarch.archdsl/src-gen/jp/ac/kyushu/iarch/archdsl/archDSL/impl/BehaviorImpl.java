/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL.impl;

import java.util.Collection;

import jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage;
import jp.ac.kyushu.iarch.archdsl.archDSL.Behavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.BehaviorImpl#getInterface <em>Interface</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.BehaviorImpl#getCall <em>Call</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.BehaviorImpl#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviorImpl extends MinimalEObjectImpl.Container implements Behavior
{
  /**
   * The cached value of the '{@link #getInterface() <em>Interface</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInterface()
   * @generated
   * @ordered
   */
  protected Interface interface_;

  /**
   * The cached value of the '{@link #getCall() <em>Call</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCall()
   * @generated
   * @ordered
   */
  protected EList<Method> call;

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
  protected BehaviorImpl()
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
    return ArchDSLPackage.Literals.BEHAVIOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Interface getInterface()
  {
    if (interface_ != null && interface_.eIsProxy())
    {
      InternalEObject oldInterface = (InternalEObject)interface_;
      interface_ = (Interface)eResolveProxy(oldInterface);
      if (interface_ != oldInterface)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchDSLPackage.BEHAVIOR__INTERFACE, oldInterface, interface_));
      }
    }
    return interface_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Interface basicGetInterface()
  {
    return interface_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInterface(Interface newInterface)
  {
    Interface oldInterface = interface_;
    interface_ = newInterface;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ArchDSLPackage.BEHAVIOR__INTERFACE, oldInterface, interface_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Method> getCall()
  {
    if (call == null)
    {
      call = new EObjectResolvingEList<Method>(Method.class, this, ArchDSLPackage.BEHAVIOR__CALL);
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchDSLPackage.BEHAVIOR__END, oldEnd, end));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ArchDSLPackage.BEHAVIOR__END, oldEnd, end));
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
      case ArchDSLPackage.BEHAVIOR__INTERFACE:
        if (resolve) return getInterface();
        return basicGetInterface();
      case ArchDSLPackage.BEHAVIOR__CALL:
        return getCall();
      case ArchDSLPackage.BEHAVIOR__END:
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
      case ArchDSLPackage.BEHAVIOR__INTERFACE:
        setInterface((Interface)newValue);
        return;
      case ArchDSLPackage.BEHAVIOR__CALL:
        getCall().clear();
        getCall().addAll((Collection<? extends Method>)newValue);
        return;
      case ArchDSLPackage.BEHAVIOR__END:
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
      case ArchDSLPackage.BEHAVIOR__INTERFACE:
        setInterface((Interface)null);
        return;
      case ArchDSLPackage.BEHAVIOR__CALL:
        getCall().clear();
        return;
      case ArchDSLPackage.BEHAVIOR__END:
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
      case ArchDSLPackage.BEHAVIOR__INTERFACE:
        return interface_ != null;
      case ArchDSLPackage.BEHAVIOR__CALL:
        return call != null && !call.isEmpty();
      case ArchDSLPackage.BEHAVIOR__END:
        return end != null;
    }
    return super.eIsSet(featureID);
  }

} //BehaviorImpl
