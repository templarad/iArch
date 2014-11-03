/**
 */
package Dataflow_editor.impl;

import Dataflow_editor.DataFlow;
import Dataflow_editor.DataStore;
import Dataflow_editor.Dataflow_editorFactory;
import Dataflow_editor.Dataflow_editorPackage;
import Dataflow_editor.External_entity;
import Dataflow_editor.ModelElement;
import Dataflow_editor.Operation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class Dataflow_editorFactoryImpl extends EFactoryImpl implements Dataflow_editorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Dataflow_editorFactory init() {
		try {
			Dataflow_editorFactory theDataflow_editorFactory = (Dataflow_editorFactory)EPackage.Registry.INSTANCE.getEFactory(Dataflow_editorPackage.eNS_URI);
			if (theDataflow_editorFactory != null) {
				return theDataflow_editorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Dataflow_editorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dataflow_editorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Dataflow_editorPackage.MODEL_ELEMENT: return createModelElement();
			case Dataflow_editorPackage.DATA_STORE: return createDataStore();
			case Dataflow_editorPackage.PROCESS: return createProcess();
			case Dataflow_editorPackage.DATA_FLOW: return createDataFlow();
			case Dataflow_editorPackage.EXTERNAL_ENTITY: return createExternal_entity();
			case Dataflow_editorPackage.OPERATION: return createOperation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case Dataflow_editorPackage.STRING:
				return createStringFromString(eDataType, initialValue);
			case Dataflow_editorPackage.INTEGER:
				return createIntegerFromString(eDataType, initialValue);
			case Dataflow_editorPackage.BOOLEAN:
				return createBooleanFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case Dataflow_editorPackage.STRING:
				return convertStringToString(eDataType, instanceValue);
			case Dataflow_editorPackage.INTEGER:
				return convertIntegerToString(eDataType, instanceValue);
			case Dataflow_editorPackage.BOOLEAN:
				return convertBooleanToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement createModelElement() {
		ModelElementImpl modelElement = new ModelElementImpl();
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataStore createDataStore() {
		DataStoreImpl dataStore = new DataStoreImpl();
		return dataStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dataflow_editor.Process createProcess() {
		ProcessImpl process = new ProcessImpl();
		return process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlow createDataFlow() {
		DataFlowImpl dataFlow = new DataFlowImpl();
		return dataFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public External_entity createExternal_entity() {
		External_entityImpl external_entity = new External_entityImpl();
		return external_entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createStringFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer createIntegerFromString(EDataType eDataType, String initialValue) {
		return (Integer)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIntegerToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean createBooleanFromString(EDataType eDataType, String initialValue) {
		return (Boolean)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBooleanToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dataflow_editorPackage getDataflow_editorPackage() {
		return (Dataflow_editorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Dataflow_editorPackage getPackage() {
		return Dataflow_editorPackage.eINSTANCE;
	}

} //Dataflow_editorFactoryImpl
