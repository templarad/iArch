/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLFactory
 * @model kind="package"
 * @generated
 */
public interface ArchDSLPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "archDSL";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.ac.jp/kyushu/iarch/archdsl/ArchDSL";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "archDSL";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ArchDSLPackage eINSTANCE = jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl.init();

  /**
   * The meta object id for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ModelImpl
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Interfaces</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__INTERFACES = 0;

  /**
   * The feature id for the '<em><b>Uinterfaces</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__UINTERFACES = 1;

  /**
   * The feature id for the '<em><b>Behaviors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__BEHAVIORS = 2;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.UncertainInterfaceImpl <em>Uncertain Interface</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.UncertainInterfaceImpl
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getUncertainInterface()
   * @generated
   */
  int UNCERTAIN_INTERFACE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNCERTAIN_INTERFACE__NAME = 0;

  /**
   * The feature id for the '<em><b>Super Interface</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNCERTAIN_INTERFACE__SUPER_INTERFACE = 1;

  /**
   * The feature id for the '<em><b>Altmethods</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNCERTAIN_INTERFACE__ALTMETHODS = 2;

  /**
   * The feature id for the '<em><b>Optmethods</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNCERTAIN_INTERFACE__OPTMETHODS = 3;

  /**
   * The number of structural features of the '<em>Uncertain Interface</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNCERTAIN_INTERFACE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.InterfaceImpl <em>Interface</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.InterfaceImpl
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getInterface()
   * @generated
   */
  int INTERFACE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE__NAME = 0;

  /**
   * The feature id for the '<em><b>Methods</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE__METHODS = 1;

  /**
   * The number of structural features of the '<em>Interface</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.MethodImpl <em>Method</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.MethodImpl
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getMethod()
   * @generated
   */
  int METHOD = 3;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__NAME = 1;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__PARAM = 2;

  /**
   * The number of structural features of the '<em>Method</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.AltMethodImpl <em>Alt Method</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.AltMethodImpl
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getAltMethod()
   * @generated
   */
  int ALT_METHOD = 4;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALT_METHOD__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALT_METHOD__NAME = 1;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALT_METHOD__PARAM = 2;

  /**
   * The number of structural features of the '<em>Alt Method</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALT_METHOD_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.OptMethodImpl <em>Opt Method</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.OptMethodImpl
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getOptMethod()
   * @generated
   */
  int OPT_METHOD = 5;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPT_METHOD__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPT_METHOD__NAME = 1;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPT_METHOD__PARAM = 2;

  /**
   * The number of structural features of the '<em>Opt Method</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPT_METHOD_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.ParamImpl <em>Param</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ParamImpl
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getParam()
   * @generated
   */
  int PARAM = 6;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM__NAME = 1;

  /**
   * The number of structural features of the '<em>Param</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.BehaviorImpl <em>Behavior</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.BehaviorImpl
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getBehavior()
   * @generated
   */
  int BEHAVIOR = 7;

  /**
   * The feature id for the '<em><b>Interface</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR__INTERFACE = 0;

  /**
   * The feature id for the '<em><b>Call</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR__CALL = 1;

  /**
   * The feature id for the '<em><b>End</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR__END = 2;

  /**
   * The number of structural features of the '<em>Behavior</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_FEATURE_COUNT = 3;


  /**
   * Returns the meta object for class '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Model#getInterfaces <em>Interfaces</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Interfaces</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Model#getInterfaces()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Interfaces();

  /**
   * Returns the meta object for the containment reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Model#getU_interfaces <em>Uinterfaces</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Uinterfaces</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Model#getU_interfaces()
   * @see #getModel()
   * @generated
   */
  EReference getModel_U_interfaces();

  /**
   * Returns the meta object for the containment reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Model#getBehaviors <em>Behaviors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Behaviors</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Model#getBehaviors()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Behaviors();

  /**
   * Returns the meta object for class '{@link jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface <em>Uncertain Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Uncertain Interface</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface
   * @generated
   */
  EClass getUncertainInterface();

  /**
   * Returns the meta object for the attribute '{@link jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface#getName()
   * @see #getUncertainInterface()
   * @generated
   */
  EAttribute getUncertainInterface_Name();

  /**
   * Returns the meta object for the reference '{@link jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface#getSuperInterface <em>Super Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Super Interface</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface#getSuperInterface()
   * @see #getUncertainInterface()
   * @generated
   */
  EReference getUncertainInterface_SuperInterface();

  /**
   * Returns the meta object for the containment reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface#getAltmethods <em>Altmethods</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Altmethods</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface#getAltmethods()
   * @see #getUncertainInterface()
   * @generated
   */
  EReference getUncertainInterface_Altmethods();

  /**
   * Returns the meta object for the containment reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface#getOptmethods <em>Optmethods</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Optmethods</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface#getOptmethods()
   * @see #getUncertainInterface()
   * @generated
   */
  EReference getUncertainInterface_Optmethods();

  /**
   * Returns the meta object for class '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Interface <em>Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interface</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Interface
   * @generated
   */
  EClass getInterface();

  /**
   * Returns the meta object for the attribute '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Interface#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Interface#getName()
   * @see #getInterface()
   * @generated
   */
  EAttribute getInterface_Name();

  /**
   * Returns the meta object for the containment reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Interface#getMethods <em>Methods</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Methods</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Interface#getMethods()
   * @see #getInterface()
   * @generated
   */
  EReference getInterface_Methods();

  /**
   * Returns the meta object for class '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Method <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Method
   * @generated
   */
  EClass getMethod();

  /**
   * Returns the meta object for the attribute '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Method#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Method#getType()
   * @see #getMethod()
   * @generated
   */
  EAttribute getMethod_Type();

  /**
   * Returns the meta object for the attribute '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Method#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Method#getName()
   * @see #getMethod()
   * @generated
   */
  EAttribute getMethod_Name();

  /**
   * Returns the meta object for the containment reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Method#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Param</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Method#getParam()
   * @see #getMethod()
   * @generated
   */
  EReference getMethod_Param();

  /**
   * Returns the meta object for class '{@link jp.ac.kyushu.iarch.archdsl.archDSL.AltMethod <em>Alt Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alt Method</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.AltMethod
   * @generated
   */
  EClass getAltMethod();

  /**
   * Returns the meta object for the attribute list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.AltMethod#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Type</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.AltMethod#getType()
   * @see #getAltMethod()
   * @generated
   */
  EAttribute getAltMethod_Type();

  /**
   * Returns the meta object for the attribute list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.AltMethod#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Name</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.AltMethod#getName()
   * @see #getAltMethod()
   * @generated
   */
  EAttribute getAltMethod_Name();

  /**
   * Returns the meta object for the containment reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.AltMethod#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Param</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.AltMethod#getParam()
   * @see #getAltMethod()
   * @generated
   */
  EReference getAltMethod_Param();

  /**
   * Returns the meta object for class '{@link jp.ac.kyushu.iarch.archdsl.archDSL.OptMethod <em>Opt Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Opt Method</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.OptMethod
   * @generated
   */
  EClass getOptMethod();

  /**
   * Returns the meta object for the attribute '{@link jp.ac.kyushu.iarch.archdsl.archDSL.OptMethod#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.OptMethod#getType()
   * @see #getOptMethod()
   * @generated
   */
  EAttribute getOptMethod_Type();

  /**
   * Returns the meta object for the attribute '{@link jp.ac.kyushu.iarch.archdsl.archDSL.OptMethod#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.OptMethod#getName()
   * @see #getOptMethod()
   * @generated
   */
  EAttribute getOptMethod_Name();

  /**
   * Returns the meta object for the containment reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.OptMethod#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Param</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.OptMethod#getParam()
   * @see #getOptMethod()
   * @generated
   */
  EReference getOptMethod_Param();

  /**
   * Returns the meta object for class '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Param <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Param</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Param
   * @generated
   */
  EClass getParam();

  /**
   * Returns the meta object for the attribute '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Param#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Param#getType()
   * @see #getParam()
   * @generated
   */
  EAttribute getParam_Type();

  /**
   * Returns the meta object for the attribute '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Param#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Param#getName()
   * @see #getParam()
   * @generated
   */
  EAttribute getParam_Name();

  /**
   * Returns the meta object for class '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Behavior <em>Behavior</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Behavior
   * @generated
   */
  EClass getBehavior();

  /**
   * Returns the meta object for the reference '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Behavior#getInterface <em>Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Interface</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Behavior#getInterface()
   * @see #getBehavior()
   * @generated
   */
  EReference getBehavior_Interface();

  /**
   * Returns the meta object for the reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Behavior#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Call</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Behavior#getCall()
   * @see #getBehavior()
   * @generated
   */
  EReference getBehavior_Call();

  /**
   * Returns the meta object for the reference '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Behavior#getEnd <em>End</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>End</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Behavior#getEnd()
   * @see #getBehavior()
   * @generated
   */
  EReference getBehavior_End();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ArchDSLFactory getArchDSLFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ModelImpl
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Interfaces</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__INTERFACES = eINSTANCE.getModel_Interfaces();

    /**
     * The meta object literal for the '<em><b>Uinterfaces</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__UINTERFACES = eINSTANCE.getModel_U_interfaces();

    /**
     * The meta object literal for the '<em><b>Behaviors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__BEHAVIORS = eINSTANCE.getModel_Behaviors();

    /**
     * The meta object literal for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.UncertainInterfaceImpl <em>Uncertain Interface</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.UncertainInterfaceImpl
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getUncertainInterface()
     * @generated
     */
    EClass UNCERTAIN_INTERFACE = eINSTANCE.getUncertainInterface();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNCERTAIN_INTERFACE__NAME = eINSTANCE.getUncertainInterface_Name();

    /**
     * The meta object literal for the '<em><b>Super Interface</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNCERTAIN_INTERFACE__SUPER_INTERFACE = eINSTANCE.getUncertainInterface_SuperInterface();

    /**
     * The meta object literal for the '<em><b>Altmethods</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNCERTAIN_INTERFACE__ALTMETHODS = eINSTANCE.getUncertainInterface_Altmethods();

    /**
     * The meta object literal for the '<em><b>Optmethods</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNCERTAIN_INTERFACE__OPTMETHODS = eINSTANCE.getUncertainInterface_Optmethods();

    /**
     * The meta object literal for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.InterfaceImpl <em>Interface</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.InterfaceImpl
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getInterface()
     * @generated
     */
    EClass INTERFACE = eINSTANCE.getInterface();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERFACE__NAME = eINSTANCE.getInterface_Name();

    /**
     * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERFACE__METHODS = eINSTANCE.getInterface_Methods();

    /**
     * The meta object literal for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.MethodImpl <em>Method</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.MethodImpl
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getMethod()
     * @generated
     */
    EClass METHOD = eINSTANCE.getMethod();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METHOD__TYPE = eINSTANCE.getMethod_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METHOD__NAME = eINSTANCE.getMethod_Name();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD__PARAM = eINSTANCE.getMethod_Param();

    /**
     * The meta object literal for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.AltMethodImpl <em>Alt Method</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.AltMethodImpl
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getAltMethod()
     * @generated
     */
    EClass ALT_METHOD = eINSTANCE.getAltMethod();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ALT_METHOD__TYPE = eINSTANCE.getAltMethod_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ALT_METHOD__NAME = eINSTANCE.getAltMethod_Name();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALT_METHOD__PARAM = eINSTANCE.getAltMethod_Param();

    /**
     * The meta object literal for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.OptMethodImpl <em>Opt Method</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.OptMethodImpl
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getOptMethod()
     * @generated
     */
    EClass OPT_METHOD = eINSTANCE.getOptMethod();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPT_METHOD__TYPE = eINSTANCE.getOptMethod_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPT_METHOD__NAME = eINSTANCE.getOptMethod_Name();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPT_METHOD__PARAM = eINSTANCE.getOptMethod_Param();

    /**
     * The meta object literal for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.ParamImpl <em>Param</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ParamImpl
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getParam()
     * @generated
     */
    EClass PARAM = eINSTANCE.getParam();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAM__TYPE = eINSTANCE.getParam_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAM__NAME = eINSTANCE.getParam_Name();

    /**
     * The meta object literal for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.BehaviorImpl <em>Behavior</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.BehaviorImpl
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getBehavior()
     * @generated
     */
    EClass BEHAVIOR = eINSTANCE.getBehavior();

    /**
     * The meta object literal for the '<em><b>Interface</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR__INTERFACE = eINSTANCE.getBehavior_Interface();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR__CALL = eINSTANCE.getBehavior_Call();

    /**
     * The meta object literal for the '<em><b>End</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR__END = eINSTANCE.getBehavior_End();

  }

} //ArchDSLPackage
