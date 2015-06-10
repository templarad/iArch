/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL.impl;

import jp.ac.kyushu.iarch.archdsl.archDSL.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArchDSLFactoryImpl extends EFactoryImpl implements ArchDSLFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ArchDSLFactory init()
  {
    try
    {
      ArchDSLFactory theArchDSLFactory = (ArchDSLFactory)EPackage.Registry.INSTANCE.getEFactory(ArchDSLPackage.eNS_URI);
      if (theArchDSLFactory != null)
      {
        return theArchDSLFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ArchDSLFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArchDSLFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ArchDSLPackage.MODEL: return createModel();
      case ArchDSLPackage.INTERFACE: return createInterface();
      case ArchDSLPackage.METHOD: return createMethod();
      case ArchDSLPackage.PARAM: return createParam();
      case ArchDSLPackage.CPARAM: return createcParam();
      case ArchDSLPackage.CONNECTOR: return createConnector();
      case ArchDSLPackage.BEHAVIOR: return createBehavior();
      case ArchDSLPackage.DFLOW: return createDFlow();
      case ArchDSLPackage.DATAFLOW: return createDataflow();
      case ArchDSLPackage.STATE_NOTIFICATION: return createStateNotification();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Interface createInterface()
  {
    InterfaceImpl interface_ = new InterfaceImpl();
    return interface_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Method createMethod()
  {
    MethodImpl method = new MethodImpl();
    return method;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Param createParam()
  {
    ParamImpl param = new ParamImpl();
    return param;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public cParam createcParam()
  {
    cParamImpl cParam = new cParamImpl();
    return cParam;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Connector createConnector()
  {
    ConnectorImpl connector = new ConnectorImpl();
    return connector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Behavior createBehavior()
  {
    BehaviorImpl behavior = new BehaviorImpl();
    return behavior;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DFlow createDFlow()
  {
    DFlowImpl dFlow = new DFlowImpl();
    return dFlow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Dataflow createDataflow()
  {
    DataflowImpl dataflow = new DataflowImpl();
    return dataflow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateNotification createStateNotification()
  {
    StateNotificationImpl stateNotification = new StateNotificationImpl();
    return stateNotification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArchDSLPackage getArchDSLPackage()
  {
    return (ArchDSLPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ArchDSLPackage getPackage()
  {
    return ArchDSLPackage.eINSTANCE;
  }

} //ArchDSLFactoryImpl
