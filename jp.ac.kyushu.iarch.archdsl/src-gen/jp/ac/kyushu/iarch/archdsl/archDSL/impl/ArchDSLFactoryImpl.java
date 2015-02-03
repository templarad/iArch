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
      case ArchDSLPackage.UNCERTAIN_INTERFACE: return createUncertainInterface();
      case ArchDSLPackage.INTERFACE: return createInterface();
      case ArchDSLPackage.METHOD: return createMethod();
      case ArchDSLPackage.ALT_METHOD: return createAltMethod();
      case ArchDSLPackage.OPT_METHOD: return createOptMethod();
      case ArchDSLPackage.PARAM: return createParam();
      case ArchDSLPackage.BEHAVIOR: return createBehavior();
      case ArchDSLPackage.SUPER_METHOD: return createSuperMethod();
      case ArchDSLPackage.UNCERTAIN_BEHAVIOR: return createUncertainBehavior();
      case ArchDSLPackage.CERTAIN_CALL: return createCertainCall();
      case ArchDSLPackage.OPT_CALL: return createOptCall();
      case ArchDSLPackage.ALT_CALL: return createAltCall();
      case ArchDSLPackage.SUPER_CALL: return createSuperCall();
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
  public UncertainInterface createUncertainInterface()
  {
    UncertainInterfaceImpl uncertainInterface = new UncertainInterfaceImpl();
    return uncertainInterface;
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
  public AltMethod createAltMethod()
  {
    AltMethodImpl altMethod = new AltMethodImpl();
    return altMethod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptMethod createOptMethod()
  {
    OptMethodImpl optMethod = new OptMethodImpl();
    return optMethod;
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
  public SuperMethod createSuperMethod()
  {
    SuperMethodImpl superMethod = new SuperMethodImpl();
    return superMethod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UncertainBehavior createUncertainBehavior()
  {
    UncertainBehaviorImpl uncertainBehavior = new UncertainBehaviorImpl();
    return uncertainBehavior;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CertainCall createCertainCall()
  {
    CertainCallImpl certainCall = new CertainCallImpl();
    return certainCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptCall createOptCall()
  {
    OptCallImpl optCall = new OptCallImpl();
    return optCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AltCall createAltCall()
  {
    AltCallImpl altCall = new AltCallImpl();
    return altCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuperCall createSuperCall()
  {
    SuperCallImpl superCall = new SuperCallImpl();
    return superCall;
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
