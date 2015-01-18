/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL.impl;

import java.util.Collection;

import jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage;
import jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow;
import jp.ac.kyushu.iarch.archdsl.archDSL.Dfa;
import jp.ac.kyushu.iarch.archdsl.archDSL.Dflow;
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
 * An implementation of the model object '<em><b>Dataflow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.DataflowImpl#getDfa <em>Dfa</em>}</li>
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
   * The cached value of the '{@link #getDfa() <em>Dfa</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDfa()
   * @generated
   * @ordered
   */
  protected Dfa dfa;

  /**
   * The cached value of the '{@link #getGetflow() <em>Getflow</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGetflow()
   * @generated
   * @ordered
   */
  protected EList<Dflow> getflow;

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
  protected Interface end;

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
  public Dfa getDfa()
  {
    if (dfa != null && dfa.eIsProxy())
    {
      InternalEObject oldDfa = (InternalEObject)dfa;
      dfa = (Dfa)eResolveProxy(oldDfa);
      if (dfa != oldDfa)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchDSLPackage.DATAFLOW__DFA, oldDfa, dfa));
      }
    }
    return dfa;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Dfa basicGetDfa()
  {
    return dfa;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDfa(Dfa newDfa)
  {
    Dfa oldDfa = dfa;
    dfa = newDfa;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ArchDSLPackage.DATAFLOW__DFA, oldDfa, dfa));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Dflow> getGetflow()
  {
    if (getflow == null)
    {
      getflow = new EObjectResolvingEList<Dflow>(Dflow.class, this, ArchDSLPackage.DATAFLOW__GETFLOW);
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
  public Interface getEnd()
  {
    if (end != null && end.eIsProxy())
    {
      InternalEObject oldEnd = (InternalEObject)end;
      end = (Interface)eResolveProxy(oldEnd);
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
      case ArchDSLPackage.DATAFLOW__DFA:
        if (resolve) return getDfa();
        return basicGetDfa();
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
      case ArchDSLPackage.DATAFLOW__DFA:
        setDfa((Dfa)newValue);
        return;
      case ArchDSLPackage.DATAFLOW__GETFLOW:
        getGetflow().clear();
        getGetflow().addAll((Collection<? extends Dflow>)newValue);
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
      case ArchDSLPackage.DATAFLOW__DFA:
        setDfa((Dfa)null);
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
      case ArchDSLPackage.DATAFLOW__DFA:
        return dfa != null;
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
