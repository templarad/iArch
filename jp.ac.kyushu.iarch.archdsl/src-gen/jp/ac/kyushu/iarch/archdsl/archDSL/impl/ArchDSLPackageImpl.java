/**
 */
package jp.ac.kyushu.iarch.archdsl.archDSL.impl;

import jp.ac.kyushu.iarch.archdsl.archDSL.AltMethod;
import jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLFactory;
import jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage;
import jp.ac.kyushu.iarch.archdsl.archDSL.Behavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.archdsl.archDSL.OptMethod;
import jp.ac.kyushu.iarch.archdsl.archDSL.Param;
import jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArchDSLPackageImpl extends EPackageImpl implements ArchDSLPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass uncertainInterfaceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass interfaceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass methodEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass altMethodEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass optMethodEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass paramEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ArchDSLPackageImpl()
  {
    super(eNS_URI, ArchDSLFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ArchDSLPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ArchDSLPackage init()
  {
    if (isInited) return (ArchDSLPackage)EPackage.Registry.INSTANCE.getEPackage(ArchDSLPackage.eNS_URI);

    // Obtain or create and register package
    ArchDSLPackageImpl theArchDSLPackage = (ArchDSLPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ArchDSLPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ArchDSLPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theArchDSLPackage.createPackageContents();

    // Initialize created meta-data
    theArchDSLPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theArchDSLPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ArchDSLPackage.eNS_URI, theArchDSLPackage);
    return theArchDSLPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Interfaces()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_U_interfaces()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Behaviors()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUncertainInterface()
  {
    return uncertainInterfaceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUncertainInterface_Name()
  {
    return (EAttribute)uncertainInterfaceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUncertainInterface_SuperInterface()
  {
    return (EReference)uncertainInterfaceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUncertainInterface_Altmethods()
  {
    return (EReference)uncertainInterfaceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUncertainInterface_Optmethods()
  {
    return (EReference)uncertainInterfaceEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInterface()
  {
    return interfaceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInterface_Name()
  {
    return (EAttribute)interfaceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInterface_Methods()
  {
    return (EReference)interfaceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMethod()
  {
    return methodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMethod_Type()
  {
    return (EAttribute)methodEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMethod_Name()
  {
    return (EAttribute)methodEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethod_Param()
  {
    return (EReference)methodEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAltMethod()
  {
    return altMethodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAltMethod_Type()
  {
    return (EAttribute)altMethodEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAltMethod_Name()
  {
    return (EAttribute)altMethodEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAltMethod_Param()
  {
    return (EReference)altMethodEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAltMethod_A_name()
  {
    return (EAttribute)altMethodEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOptMethod()
  {
    return optMethodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOptMethod_Type()
  {
    return (EAttribute)optMethodEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOptMethod_Name()
  {
    return (EAttribute)optMethodEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOptMethod_Param()
  {
    return (EReference)optMethodEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParam()
  {
    return paramEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParam_Type()
  {
    return (EAttribute)paramEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParam_Name()
  {
    return (EAttribute)paramEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBehavior()
  {
    return behaviorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBehavior_Interface()
  {
    return (EReference)behaviorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBehavior_Call()
  {
    return (EReference)behaviorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBehavior_End()
  {
    return (EReference)behaviorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArchDSLFactory getArchDSLFactory()
  {
    return (ArchDSLFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__INTERFACES);
    createEReference(modelEClass, MODEL__UINTERFACES);
    createEReference(modelEClass, MODEL__BEHAVIORS);

    uncertainInterfaceEClass = createEClass(UNCERTAIN_INTERFACE);
    createEAttribute(uncertainInterfaceEClass, UNCERTAIN_INTERFACE__NAME);
    createEReference(uncertainInterfaceEClass, UNCERTAIN_INTERFACE__SUPER_INTERFACE);
    createEReference(uncertainInterfaceEClass, UNCERTAIN_INTERFACE__ALTMETHODS);
    createEReference(uncertainInterfaceEClass, UNCERTAIN_INTERFACE__OPTMETHODS);

    interfaceEClass = createEClass(INTERFACE);
    createEAttribute(interfaceEClass, INTERFACE__NAME);
    createEReference(interfaceEClass, INTERFACE__METHODS);

    methodEClass = createEClass(METHOD);
    createEAttribute(methodEClass, METHOD__TYPE);
    createEAttribute(methodEClass, METHOD__NAME);
    createEReference(methodEClass, METHOD__PARAM);

    altMethodEClass = createEClass(ALT_METHOD);
    createEAttribute(altMethodEClass, ALT_METHOD__TYPE);
    createEAttribute(altMethodEClass, ALT_METHOD__NAME);
    createEReference(altMethodEClass, ALT_METHOD__PARAM);
    createEAttribute(altMethodEClass, ALT_METHOD__ANAME);

    optMethodEClass = createEClass(OPT_METHOD);
    createEAttribute(optMethodEClass, OPT_METHOD__TYPE);
    createEAttribute(optMethodEClass, OPT_METHOD__NAME);
    createEReference(optMethodEClass, OPT_METHOD__PARAM);

    paramEClass = createEClass(PARAM);
    createEAttribute(paramEClass, PARAM__TYPE);
    createEAttribute(paramEClass, PARAM__NAME);

    behaviorEClass = createEClass(BEHAVIOR);
    createEReference(behaviorEClass, BEHAVIOR__INTERFACE);
    createEReference(behaviorEClass, BEHAVIOR__CALL);
    createEReference(behaviorEClass, BEHAVIOR__END);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Interfaces(), this.getInterface(), null, "interfaces", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_U_interfaces(), this.getUncertainInterface(), null, "u_interfaces", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_Behaviors(), this.getBehavior(), null, "behaviors", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(uncertainInterfaceEClass, UncertainInterface.class, "UncertainInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUncertainInterface_Name(), ecorePackage.getEString(), "name", null, 0, 1, UncertainInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUncertainInterface_SuperInterface(), this.getInterface(), null, "superInterface", null, 0, 1, UncertainInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUncertainInterface_Altmethods(), this.getAltMethod(), null, "altmethods", null, 0, -1, UncertainInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUncertainInterface_Optmethods(), this.getOptMethod(), null, "optmethods", null, 0, -1, UncertainInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(interfaceEClass, Interface.class, "Interface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInterface_Name(), ecorePackage.getEString(), "name", null, 0, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInterface_Methods(), this.getMethod(), null, "methods", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(methodEClass, Method.class, "Method", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMethod_Type(), ecorePackage.getEString(), "type", null, 0, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMethod_Name(), ecorePackage.getEString(), "name", null, 0, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMethod_Param(), this.getParam(), null, "param", null, 0, -1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(altMethodEClass, AltMethod.class, "AltMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAltMethod_Type(), ecorePackage.getEString(), "type", null, 0, -1, AltMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAltMethod_Name(), ecorePackage.getEString(), "name", null, 0, 1, AltMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAltMethod_Param(), this.getParam(), null, "param", null, 0, -1, AltMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAltMethod_A_name(), ecorePackage.getEString(), "a_name", null, 0, -1, AltMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(optMethodEClass, OptMethod.class, "OptMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOptMethod_Type(), ecorePackage.getEString(), "type", null, 0, 1, OptMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOptMethod_Name(), ecorePackage.getEString(), "name", null, 0, 1, OptMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOptMethod_Param(), this.getParam(), null, "param", null, 0, -1, OptMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(paramEClass, Param.class, "Param", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getParam_Type(), ecorePackage.getEString(), "type", null, 0, 1, Param.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getParam_Name(), ecorePackage.getEString(), "name", null, 0, 1, Param.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorEClass, Behavior.class, "Behavior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehavior_Interface(), this.getInterface(), null, "interface", null, 0, 1, Behavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehavior_Call(), this.getMethod(), null, "call", null, 0, -1, Behavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehavior_End(), this.getInterface(), null, "end", null, 0, 1, Behavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ArchDSLPackageImpl
