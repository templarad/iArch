/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL.impl;

import java.util.Collection;

import jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage;
import jp.ac.kyushu.iarch.archdsl.archDSL.DFlow;
import jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.StateNotification;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

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
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataflowImpl extends MinimalEObjectImpl.Container implements Dataflow
{
  /**
   * The cached value of the '{@link #getStatenotification() <em>Statenotification</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatenotification()
   * @generated
   * @ordered
   */
  protected EList<StateNotification> statenotification;

  /**
   * The cached value of the '{@link #getGetflow() <em>Getflow</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGetflow()
   * @generated
   * @ordered
   */
  protected EList<DFlow> getflow;

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
  public EList<StateNotification> getStatenotification()
  {
    if (statenotification == null)
    {
      statenotification = new EObjectContainmentEList<StateNotification>(StateNotification.class, this, ArchDSLPackage.DATAFLOW__STATENOTIFICATION);
    }
    return statenotification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DFlow> getGetflow()
  {
    if (getflow == null)
    {
      getflow = new EObjectResolvingEList<DFlow>(DFlow.class, this, ArchDSLPackage.DATAFLOW__GETFLOW);
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
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ArchDSLPackage.DATAFLOW__STATENOTIFICATION:
        return ((InternalEList<?>)getStatenotification()).basicRemove(otherEnd, msgs);
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
      case ArchDSLPackage.DATAFLOW__STATENOTIFICATION:
        return getStatenotification();
      case ArchDSLPackage.DATAFLOW__GETFLOW:
        return getGetflow();
      case ArchDSLPackage.DATAFLOW__CALL:
        return getCall();
      case ArchDSLPackage.DATAFLOW__GET_IF:
        return getGetIf();
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
        getStatenotification().clear();
        getStatenotification().addAll((Collection<? extends StateNotification>)newValue);
        return;
      case ArchDSLPackage.DATAFLOW__GETFLOW:
        getGetflow().clear();
        getGetflow().addAll((Collection<? extends DFlow>)newValue);
        return;
      case ArchDSLPackage.DATAFLOW__CALL:
        getCall().clear();
        getCall().addAll((Collection<? extends Method>)newValue);
        return;
      case ArchDSLPackage.DATAFLOW__GET_IF:
        getGetIf().clear();
        getGetIf().addAll((Collection<? extends Interface>)newValue);
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
        getStatenotification().clear();
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
        return statenotification != null && !statenotification.isEmpty();
      case ArchDSLPackage.DATAFLOW__GETFLOW:
        return getflow != null && !getflow.isEmpty();
      case ArchDSLPackage.DATAFLOW__CALL:
        return call != null && !call.isEmpty();
      case ArchDSLPackage.DATAFLOW__GET_IF:
        return getIf != null && !getIf.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //DataflowImpl
