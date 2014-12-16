/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL.impl;

import java.util.Collection;

import jp.ac.kyushu.iarch.archdsl.archDSL.AltMethod;
import jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage;
import jp.ac.kyushu.iarch.archdsl.archDSL.Param;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alt Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.AltMethodImpl#getType <em>Type</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.AltMethodImpl#getName <em>Name</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.AltMethodImpl#getParam <em>Param</em>}</li>
 *   <li>{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.AltMethodImpl#getA_name <em>Aname</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AltMethodImpl extends MinimalEObjectImpl.Container implements AltMethod
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected EList<String> type;

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
   * The cached value of the '{@link #getParam() <em>Param</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParam()
   * @generated
   * @ordered
   */
  protected EList<Param> param;

  /**
   * The cached value of the '{@link #getA_name() <em>Aname</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getA_name()
   * @generated
   * @ordered
   */
  protected EList<String> a_name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AltMethodImpl()
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
    return ArchDSLPackage.Literals.ALT_METHOD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getType()
  {
    if (type == null)
    {
      type = new EDataTypeEList<String>(String.class, this, ArchDSLPackage.ALT_METHOD__TYPE);
    }
    return type;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ArchDSLPackage.ALT_METHOD__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Param> getParam()
  {
    if (param == null)
    {
      param = new EObjectContainmentEList<Param>(Param.class, this, ArchDSLPackage.ALT_METHOD__PARAM);
    }
    return param;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getA_name()
  {
    if (a_name == null)
    {
      a_name = new EDataTypeEList<String>(String.class, this, ArchDSLPackage.ALT_METHOD__ANAME);
    }
    return a_name;
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
      case ArchDSLPackage.ALT_METHOD__PARAM:
        return ((InternalEList<?>)getParam()).basicRemove(otherEnd, msgs);
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
      case ArchDSLPackage.ALT_METHOD__TYPE:
        return getType();
      case ArchDSLPackage.ALT_METHOD__NAME:
        return getName();
      case ArchDSLPackage.ALT_METHOD__PARAM:
        return getParam();
      case ArchDSLPackage.ALT_METHOD__ANAME:
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
      case ArchDSLPackage.ALT_METHOD__TYPE:
        getType().clear();
        getType().addAll((Collection<? extends String>)newValue);
        return;
      case ArchDSLPackage.ALT_METHOD__NAME:
        setName((String)newValue);
        return;
      case ArchDSLPackage.ALT_METHOD__PARAM:
        getParam().clear();
        getParam().addAll((Collection<? extends Param>)newValue);
        return;
      case ArchDSLPackage.ALT_METHOD__ANAME:
        getA_name().clear();
        getA_name().addAll((Collection<? extends String>)newValue);
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
      case ArchDSLPackage.ALT_METHOD__TYPE:
        getType().clear();
        return;
      case ArchDSLPackage.ALT_METHOD__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ArchDSLPackage.ALT_METHOD__PARAM:
        getParam().clear();
        return;
      case ArchDSLPackage.ALT_METHOD__ANAME:
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
      case ArchDSLPackage.ALT_METHOD__TYPE:
        return type != null && !type.isEmpty();
      case ArchDSLPackage.ALT_METHOD__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ArchDSLPackage.ALT_METHOD__PARAM:
        return param != null && !param.isEmpty();
      case ArchDSLPackage.ALT_METHOD__ANAME:
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
    result.append(" (type: ");
    result.append(type);
    result.append(", name: ");
    result.append(name);
    result.append(", a_name: ");
    result.append(a_name);
    result.append(')');
    return result.toString();
  }

} //AltMethodImpl
