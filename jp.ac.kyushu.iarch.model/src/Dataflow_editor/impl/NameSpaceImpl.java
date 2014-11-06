/**
 */
package Dataflow_editor.impl;

import Dataflow_editor.Dataflow_editorPackage;
import Dataflow_editor.NameSpace;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Name Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Dataflow_editor.impl.NameSpaceImpl#getName <em>Name</em>}</li>
 *   <li>{@link Dataflow_editor.impl.NameSpaceImpl#isArchpoint <em>Archpoint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NameSpaceImpl extends ModelElementImpl implements NameSpace {
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
	 * The default value of the '{@link #isArchpoint() <em>Archpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isArchpoint()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ARCHPOINT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isArchpoint() <em>Archpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isArchpoint()
	 * @generated
	 * @ordered
	 */
	protected boolean archpoint = ARCHPOINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NameSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Dataflow_editorPackage.Literals.NAME_SPACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Dataflow_editorPackage.NAME_SPACE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isArchpoint() {
		return archpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArchpoint(boolean newArchpoint) {
		boolean oldArchpoint = archpoint;
		archpoint = newArchpoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Dataflow_editorPackage.NAME_SPACE__ARCHPOINT, oldArchpoint, archpoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Dataflow_editorPackage.NAME_SPACE__NAME:
				return getName();
			case Dataflow_editorPackage.NAME_SPACE__ARCHPOINT:
				return isArchpoint();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Dataflow_editorPackage.NAME_SPACE__NAME:
				setName((String)newValue);
				return;
			case Dataflow_editorPackage.NAME_SPACE__ARCHPOINT:
				setArchpoint((Boolean)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case Dataflow_editorPackage.NAME_SPACE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Dataflow_editorPackage.NAME_SPACE__ARCHPOINT:
				setArchpoint(ARCHPOINT_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Dataflow_editorPackage.NAME_SPACE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Dataflow_editorPackage.NAME_SPACE__ARCHPOINT:
				return archpoint != ARCHPOINT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", Archpoint: ");
		result.append(archpoint);
		result.append(')');
		return result.toString();
	}

} //NameSpaceImpl
