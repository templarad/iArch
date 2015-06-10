/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL.impl;

import java.util.Collection;

import jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage;
import jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Param;
import jp.ac.kyushu.iarch.archdsl.archDSL.StateNotification;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dataflow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.DataflowImpl#getStatenotification <em>Statenotification</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.DataflowImpl#getGetflow <em>Getflow</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.DataflowImpl#getCall <em>Call</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.DataflowImpl#getGetIf <em>Get If</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.DataflowImpl#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataflowImpl extends MinimalEObjectImpl.Container implements Dataflow
{
  /**
   * The cached value of the '{@link #getStatenotification() <em>Statenotification</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatenotification()
   * @generated
   * @ordered
   */
  protected StateNotification statenotification;

  /**
   * The cached value of the '{@link #getGetflow() <em>Getflow</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGetflow()
   * @generated
   * @ordered
   */
  protected EList<Param> getflow;

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
   * The cached value of the '{@link #getGetIf() <em>Get If</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGetIf()
   * @generated
   * @ordered
   */
  protected EList<Interface> getIf;

  /**
   * The cached value of the '{@link #getEnd() <em>End</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnd()
   * @generated
   * @ordered
   */
  protected StateNotification end;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DataflowImpl()
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
    return ArchDSLPackage.Literals.DATAFLOW;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateNotification getStatenotification()
  {
    if (statenotification != null && statenotification.eIsProxy())
    {
      InternalEObject oldStatenotification = (InternalEObject)statenotification;
      statenotification = (StateNotification)eResolveProxy(oldStatenotification);
      if (statenotification != oldStatenotification)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchDSLPackage.DATAFLOW__STATENOTIFICATION, oldStatenotification, statenotification));
      }
    }
    return statenotification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateNotification basicGetStatenotification()
  {
    return statenotification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatenotification(StateNotification newStatenotification)
  {
    StateNotification oldStatenotification = statenotification;
    statenotification = newStatenotification;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ArchDSLPackage.DATAFLOW__STATENOTIFICATION, oldStatenotification, statenotification));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Param> getGetflow()
  {
    if (getflow == null)
    {
      getflow = new EObjectResolvingEList<Param>(Param.class, this, ArchDSLPackage.DATAFLOW__GETFLOW);
    }
    return getflow;
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
      call = new EObjectResolvingEList<Method>(Method.class, this, ArchDSLPackage.DATAFLOW__CALL);
    }
    return call;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Interface> getGetIf()
  {
    if (getIf == null)
    {
      getIf = new EObjectResolvingEList<Interface>(Interface.class, this, ArchDSLPackage.DATAFLOW__GET_IF);
    }
    return getIf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateNotification getEnd()
  {
    if (end != null && end.eIsProxy())
    {
      InternalEObject oldEnd = (InternalEObject)end;
      end = (StateNotification)eResolveProxy(oldEnd);
      if (end != oldEnd)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchDSLPackage.DATAFLOW__END, oldEnd, end));
      }
    }
    return end;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateNotification basicGetEnd()
  {
    return end;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnd(StateNotification newEnd)
  {
    StateNotification oldEnd = end;
    end = newEnd;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ArchDSLPackage.DATAFLOW__END, oldEnd, end));
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
      case ArchDSLPackage.DATAFLOW__STATENOTIFICATION:
        if (resolve) return getStatenotification();
        return basicGetStatenotification();
      case ArchDSLPackage.DATAFLOW__GETFLOW:
        return getGetflow();
      case ArchDSLPackage.DATAFLOW__CALL:
        return getCall();
      case ArchDSLPackage.DATAFLOW__GET_IF:
        return getGetIf();
      case ArchDSLPackage.DATAFLOW__END:
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
      case ArchDSLPackage.DATAFLOW__STATENOTIFICATION:
        setStatenotification((StateNotification)newValue);
        return;
      case ArchDSLPackage.DATAFLOW__GETFLOW:
        getGetflow().clear();
        getGetflow().addAll((Collection<? extends Param>)newValue);
        return;
      case ArchDSLPackage.DATAFLOW__CALL:
        getCall().clear();
        getCall().addAll((Collection<? extends Method>)newValue);
        return;
      case ArchDSLPackage.DATAFLOW__GET_IF:
        getGetIf().clear();
        getGetIf().addAll((Collection<? extends Interface>)newValue);
        return;
      case ArchDSLPackage.DATAFLOW__END:
        setEnd((StateNotification)newValue);
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
      case ArchDSLPackage.DATAFLOW__STATENOTIFICATION:
        setStatenotification((StateNotification)null);
        return;
      case ArchDSLPackage.DATAFLOW__GETFLOW:
        getGetflow().clear();
        return;
      case ArchDSLPackage.DATAFLOW__CALL:
        getCall().clear();
        return;
      case ArchDSLPackage.DATAFLOW__GET_IF:
        getGetIf().clear();
        return;
      case ArchDSLPackage.DATAFLOW__END:
        setEnd((StateNotification)null);
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
      case ArchDSLPackage.DATAFLOW__STATENOTIFICATION:
        return statenotification != null;
      case ArchDSLPackage.DATAFLOW__GETFLOW:
        return getflow != null && !getflow.isEmpty();
      case ArchDSLPackage.DATAFLOW__CALL:
        return call != null && !call.isEmpty();
      case ArchDSLPackage.DATAFLOW__GET_IF:
        return getIf != null && !getIf.isEmpty();
      case ArchDSLPackage.DATAFLOW__END:
        return end != null;
    }
    return super.eIsSet(featureID);
  }

} //DataflowImpl
