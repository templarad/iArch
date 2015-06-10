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
   * The feature id for the '<em><b>Behaviors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__BEHAVIORS = 1;

  /**
   * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__CONNECTORS = 2;

  /**
   * The feature id for the '<em><b>Dflows</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__DFLOWS = 3;

  /**
   * The feature id for the '<em><b>Statenotificaions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__STATENOTIFICAIONS = 4;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.InterfaceImpl <em>Interface</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.InterfaceImpl
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getInterface()
   * @generated
   */
  int INTERFACE = 1;

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
  int METHOD = 2;

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
   * The meta object id for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.ParamImpl <em>Param</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ParamImpl
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getParam()
   * @generated
   */
  int PARAM = 3;

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
   * The meta object id for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.cParamImpl <em>cParam</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.cParamImpl
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getcParam()
   * @generated
   */
  int CPARAM = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CPARAM__NAME = 0;

  /**
   * The number of structural features of the '<em>cParam</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CPARAM_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.ConnectorImpl <em>Connector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ConnectorImpl
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getConnector()
   * @generated
   */
  int CONNECTOR = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTOR__NAME = 0;

  /**
   * The feature id for the '<em><b>Cparam</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTOR__CPARAM = 1;

  /**
   * The feature id for the '<em><b>Behaviors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTOR__BEHAVIORS = 2;

  /**
   * The number of structural features of the '<em>Connector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTOR_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.BehaviorImpl <em>Behavior</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.BehaviorImpl
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getBehavior()
   * @generated
   */
  int BEHAVIOR = 6;

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
   * The meta object id for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.DFlowImpl <em>DFlow</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.DFlowImpl
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getDFlow()
   * @generated
   */
  int DFLOW = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DFLOW__NAME = 0;

  /**
   * The feature id for the '<em><b>Cparam</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DFLOW__CPARAM = 1;

  /**
   * The feature id for the '<em><b>Dataflows</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DFLOW__DATAFLOWS = 2;

  /**
   * The number of structural features of the '<em>DFlow</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DFLOW_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.DataflowImpl <em>Dataflow</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.DataflowImpl
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getDataflow()
   * @generated
   */
  int DATAFLOW = 8;

  /**
   * The feature id for the '<em><b>Statenotification</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATAFLOW__STATENOTIFICATION = 0;

  /**
   * The feature id for the '<em><b>Getflow</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATAFLOW__GETFLOW = 1;

  /**
   * The feature id for the '<em><b>Call</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATAFLOW__CALL = 2;

  /**
   * The feature id for the '<em><b>Get If</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATAFLOW__GET_IF = 3;

  /**
   * The feature id for the '<em><b>End</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATAFLOW__END = 4;

  /**
   * The number of structural features of the '<em>Dataflow</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATAFLOW_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.StateNotificationImpl <em>State Notification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.StateNotificationImpl
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getStateNotification()
   * @generated
   */
  int STATE_NOTIFICATION = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_NOTIFICATION__NAME = 0;

  /**
   * The number of structural features of the '<em>State Notification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_NOTIFICATION_FEATURE_COUNT = 1;


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
   * Returns the meta object for the containment reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Model#getConnectors <em>Connectors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Connectors</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Model#getConnectors()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Connectors();

  /**
   * Returns the meta object for the containment reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Model#getDflows <em>Dflows</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Dflows</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Model#getDflows()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Dflows();

  /**
   * Returns the meta object for the containment reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Model#getStatenotificaions <em>Statenotificaions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statenotificaions</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Model#getStatenotificaions()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Statenotificaions();

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
   * Returns the meta object for class '{@link jp.ac.kyushu.iarch.archdsl.archDSL.cParam <em>cParam</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>cParam</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.cParam
   * @generated
   */
  EClass getcParam();

  /**
   * Returns the meta object for the attribute '{@link jp.ac.kyushu.iarch.archdsl.archDSL.cParam#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.cParam#getName()
   * @see #getcParam()
   * @generated
   */
  EAttribute getcParam_Name();

  /**
   * Returns the meta object for class '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Connector <em>Connector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Connector</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Connector
   * @generated
   */
  EClass getConnector();

  /**
   * Returns the meta object for the attribute '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Connector#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Connector#getName()
   * @see #getConnector()
   * @generated
   */
  EAttribute getConnector_Name();

  /**
   * Returns the meta object for the containment reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Connector#getCparam <em>Cparam</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Cparam</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Connector#getCparam()
   * @see #getConnector()
   * @generated
   */
  EReference getConnector_Cparam();

  /**
   * Returns the meta object for the containment reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Connector#getBehaviors <em>Behaviors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Behaviors</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Connector#getBehaviors()
   * @see #getConnector()
   * @generated
   */
  EReference getConnector_Behaviors();

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
   * Returns the meta object for class '{@link jp.ac.kyushu.iarch.archdsl.archDSL.DFlow <em>DFlow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DFlow</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.DFlow
   * @generated
   */
  EClass getDFlow();

  /**
   * Returns the meta object for the attribute '{@link jp.ac.kyushu.iarch.archdsl.archDSL.DFlow#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.DFlow#getName()
   * @see #getDFlow()
   * @generated
   */
  EAttribute getDFlow_Name();

  /**
   * Returns the meta object for the containment reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.DFlow#getCparam <em>Cparam</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Cparam</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.DFlow#getCparam()
   * @see #getDFlow()
   * @generated
   */
  EReference getDFlow_Cparam();

  /**
   * Returns the meta object for the containment reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.DFlow#getDataflows <em>Dataflows</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Dataflows</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.DFlow#getDataflows()
   * @see #getDFlow()
   * @generated
   */
  EReference getDFlow_Dataflows();

  /**
   * Returns the meta object for class '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow <em>Dataflow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dataflow</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow
   * @generated
   */
  EClass getDataflow();

  /**
   * Returns the meta object for the reference '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getStatenotification <em>Statenotification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Statenotification</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getStatenotification()
   * @see #getDataflow()
   * @generated
   */
  EReference getDataflow_Statenotification();

  /**
   * Returns the meta object for the reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getGetflow <em>Getflow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Getflow</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getGetflow()
   * @see #getDataflow()
   * @generated
   */
  EReference getDataflow_Getflow();

  /**
   * Returns the meta object for the reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Call</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getCall()
   * @see #getDataflow()
   * @generated
   */
  EReference getDataflow_Call();

  /**
   * Returns the meta object for the reference list '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getGetIf <em>Get If</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Get If</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getGetIf()
   * @see #getDataflow()
   * @generated
   */
  EReference getDataflow_GetIf();

  /**
   * Returns the meta object for the reference '{@link jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getEnd <em>End</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>End</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow#getEnd()
   * @see #getDataflow()
   * @generated
   */
  EReference getDataflow_End();

  /**
   * Returns the meta object for class '{@link jp.ac.kyushu.iarch.archdsl.archDSL.StateNotification <em>State Notification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Notification</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.StateNotification
   * @generated
   */
  EClass getStateNotification();

  /**
   * Returns the meta object for the attribute '{@link jp.ac.kyushu.iarch.archdsl.archDSL.StateNotification#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.StateNotification#getName()
   * @see #getStateNotification()
   * @generated
   */
  EAttribute getStateNotification_Name();

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
     * The meta object literal for the '<em><b>Behaviors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__BEHAVIORS = eINSTANCE.getModel_Behaviors();

    /**
     * The meta object literal for the '<em><b>Connectors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__CONNECTORS = eINSTANCE.getModel_Connectors();

    /**
     * The meta object literal for the '<em><b>Dflows</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__DFLOWS = eINSTANCE.getModel_Dflows();

    /**
     * The meta object literal for the '<em><b>Statenotificaions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__STATENOTIFICAIONS = eINSTANCE.getModel_Statenotificaions();

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
     * The meta object literal for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.cParamImpl <em>cParam</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.cParamImpl
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getcParam()
     * @generated
     */
    EClass CPARAM = eINSTANCE.getcParam();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CPARAM__NAME = eINSTANCE.getcParam_Name();

    /**
     * The meta object literal for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.ConnectorImpl <em>Connector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ConnectorImpl
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getConnector()
     * @generated
     */
    EClass CONNECTOR = eINSTANCE.getConnector();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONNECTOR__NAME = eINSTANCE.getConnector_Name();

    /**
     * The meta object literal for the '<em><b>Cparam</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTOR__CPARAM = eINSTANCE.getConnector_Cparam();

    /**
     * The meta object literal for the '<em><b>Behaviors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTOR__BEHAVIORS = eINSTANCE.getConnector_Behaviors();

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

    /**
     * The meta object literal for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.DFlowImpl <em>DFlow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.DFlowImpl
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getDFlow()
     * @generated
     */
    EClass DFLOW = eINSTANCE.getDFlow();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DFLOW__NAME = eINSTANCE.getDFlow_Name();

    /**
     * The meta object literal for the '<em><b>Cparam</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DFLOW__CPARAM = eINSTANCE.getDFlow_Cparam();

    /**
     * The meta object literal for the '<em><b>Dataflows</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DFLOW__DATAFLOWS = eINSTANCE.getDFlow_Dataflows();

    /**
     * The meta object literal for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.DataflowImpl <em>Dataflow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.DataflowImpl
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getDataflow()
     * @generated
     */
    EClass DATAFLOW = eINSTANCE.getDataflow();

    /**
     * The meta object literal for the '<em><b>Statenotification</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATAFLOW__STATENOTIFICATION = eINSTANCE.getDataflow_Statenotification();

    /**
     * The meta object literal for the '<em><b>Getflow</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATAFLOW__GETFLOW = eINSTANCE.getDataflow_Getflow();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATAFLOW__CALL = eINSTANCE.getDataflow_Call();

    /**
     * The meta object literal for the '<em><b>Get If</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATAFLOW__GET_IF = eINSTANCE.getDataflow_GetIf();

    /**
     * The meta object literal for the '<em><b>End</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATAFLOW__END = eINSTANCE.getDataflow_End();

    /**
     * The meta object literal for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.StateNotificationImpl <em>State Notification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.StateNotificationImpl
     * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getStateNotification()
     * @generated
     */
    EClass STATE_NOTIFICATION = eINSTANCE.getStateNotification();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE_NOTIFICATION__NAME = eINSTANCE.getStateNotification_Name();

  }

} //ArchDSLPackage
