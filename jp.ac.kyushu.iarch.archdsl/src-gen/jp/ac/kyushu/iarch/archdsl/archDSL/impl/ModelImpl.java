/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL.impl;

import java.util.Collection;

import jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage;
import jp.ac.kyushu.iarch.archdsl.archDSL.Behavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.Connector;
import jp.ac.kyushu.iarch.archdsl.archDSL.DFlow;
import jp.ac.kyushu.iarch.archdsl.archDSL.Data;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.ModelImpl#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.ModelImpl#getBehaviors <em>Behaviors</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.ModelImpl#getConnectors <em>Connectors</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.ModelImpl#getDflows <em>Dflows</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.ModelImpl#getDatas <em>Datas</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getInterfaces() <em>Interfaces</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInterfaces()
   * @generated
   * @ordered
   */
  protected EList<Interface> interfaces;

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
   * The cached value of the '{@link #getConnectors() <em>Connectors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConnectors()
   * @generated
   * @ordered
   */
  protected EList<Connector> connectors;

  /**
   * The cached value of the '{@link #getDflows() <em>Dflows</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDflows()
   * @generated
   * @ordered
   */
  protected EList<DFlow> dflows;

  /**
   * The cached value of the '{@link #getDatas() <em>Datas</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDatas()
   * @generated
   * @ordered
   */
  protected EList<Data> datas;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return ArchDSLPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Interface> getInterfaces()
  {
    if (interfaces == null)
    {
      interfaces = new EObjectContainmentEList<Interface>(Interface.class, this, ArchDSLPackage.MODEL__INTERFACES);
    }
    return interfaces;
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
      behaviors = new EObjectContainmentEList<Behavior>(Behavior.class, this, ArchDSLPackage.MODEL__BEHAVIORS);
    }
    return behaviors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Connector> getConnectors()
  {
    if (connectors == null)
    {
      connectors = new EObjectContainmentEList<Connector>(Connector.class, this, ArchDSLPackage.MODEL__CONNECTORS);
    }
    return connectors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DFlow> getDflows()
  {
    if (dflows == null)
    {
      dflows = new EObjectContainmentEList<DFlow>(DFlow.class, this, ArchDSLPackage.MODEL__DFLOWS);
    }
    return dflows;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Data> getDatas()
  {
    if (datas == null)
    {
      datas = new EObjectContainmentEList<Data>(Data.class, this, ArchDSLPackage.MODEL__DATAS);
    }
    return datas;
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
      case ArchDSLPackage.MODEL__INTERFACES:
        return ((InternalEList<?>)getInterfaces()).basicRemove(otherEnd, msgs);
      case ArchDSLPackage.MODEL__BEHAVIORS:
        return ((InternalEList<?>)getBehaviors()).basicRemove(otherEnd, msgs);
      case ArchDSLPackage.MODEL__CONNECTORS:
        return ((InternalEList<?>)getConnectors()).basicRemove(otherEnd, msgs);
      case ArchDSLPackage.MODEL__DFLOWS:
        return ((InternalEList<?>)getDflows()).basicRemove(otherEnd, msgs);
      case ArchDSLPackage.MODEL__DATAS:
        return ((InternalEList<?>)getDatas()).basicRemove(otherEnd, msgs);
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
      case ArchDSLPackage.MODEL__INTERFACES:
        return getInterfaces();
      case ArchDSLPackage.MODEL__BEHAVIORS:
        return getBehaviors();
      case ArchDSLPackage.MODEL__CONNECTORS:
        return getConnectors();
      case ArchDSLPackage.MODEL__DFLOWS:
        return getDflows();
      case ArchDSLPackage.MODEL__DATAS:
        return getDatas();
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
      case ArchDSLPackage.MODEL__INTERFACES:
        getInterfaces().clear();
        getInterfaces().addAll((Collection<? extends Interface>)newValue);
        return;
      case ArchDSLPackage.MODEL__BEHAVIORS:
        getBehaviors().clear();
        getBehaviors().addAll((Collection<? extends Behavior>)newValue);
        return;
      case ArchDSLPackage.MODEL__CONNECTORS:
        getConnectors().clear();
        getConnectors().addAll((Collection<? extends Connector>)newValue);
        return;
      case ArchDSLPackage.MODEL__DFLOWS:
        getDflows().clear();
        getDflows().addAll((Collection<? extends DFlow>)newValue);
        return;
      case ArchDSLPackage.MODEL__DATAS:
        getDatas().clear();
        getDatas().addAll((Collection<? extends Data>)newValue);
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
      case ArchDSLPackage.MODEL__INTERFACES:
        getInterfaces().clear();
        return;
      case ArchDSLPackage.MODEL__BEHAVIORS:
        getBehaviors().clear();
        return;
      case ArchDSLPackage.MODEL__CONNECTORS:
        getConnectors().clear();
        return;
      case ArchDSLPackage.MODEL__DFLOWS:
        getDflows().clear();
        return;
      case ArchDSLPackage.MODEL__DATAS:
        getDatas().clear();
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
      case ArchDSLPackage.MODEL__INTERFACES:
        return interfaces != null && !interfaces.isEmpty();
      case ArchDSLPackage.MODEL__BEHAVIORS:
        return behaviors != null && !behaviors.isEmpty();
      case ArchDSLPackage.MODEL__CONNECTORS:
        return connectors != null && !connectors.isEmpty();
      case ArchDSLPackage.MODEL__DFLOWS:
        return dflows != null && !dflows.isEmpty();
      case ArchDSLPackage.MODEL__DATAS:
        return datas != null && !datas.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
