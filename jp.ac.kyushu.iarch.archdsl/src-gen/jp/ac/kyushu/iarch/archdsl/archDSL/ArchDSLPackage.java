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
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 2;

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
   * The meta object id for the '{@link jp.ac.kyushu.iarch.archdsl.archDSL.impl.BehaviorImpl <em>Behavior</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.BehaviorImpl
   * @see jp.ac.kyushu.iarch.archdsl.archDSL.impl.ArchDSLPackageImpl#getBehavior()
   * @generated
   */
  int BEHAVIOR = 4;

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
     * The meta object literal for the '<em><b>Behaviors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__BEHAVIORS = eINSTANCE.getModel_Behaviors();

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
