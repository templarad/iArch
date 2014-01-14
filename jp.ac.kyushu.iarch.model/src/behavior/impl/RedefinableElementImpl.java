/**
 */
package behavior.impl;

import behavior.BehaviorPackage;
import behavior.Classifier;
import behavior.RedefinableElement;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Redefinable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavior.impl.RedefinableElementImpl#getRedefinitionContext <em>Redefinition Context</em>}</li>
 *   <li>{@link behavior.impl.RedefinableElementImpl#getRedefinableELement <em>Redefinable ELement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RedefinableElementImpl extends NamedElementImpl implements RedefinableElement {
	/**
	 * The cached value of the '{@link #getRedefinitionContext() <em>Redefinition Context</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedefinitionContext()
	 * @generated
	 * @ordered
	 */
	protected EList<Classifier> redefinitionContext;

	/**
	 * The cached value of the '{@link #getRedefinableELement() <em>Redefinable ELement</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedefinableELement()
	 * @generated
	 * @ordered
	 */
	protected EList<RedefinableElement> redefinableELement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RedefinableElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BehaviorPackage.Literals.REDEFINABLE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> getRedefinitionContext() {
		if (redefinitionContext == null) {
			redefinitionContext = new EObjectResolvingEList<Classifier>(Classifier.class, this, BehaviorPackage.REDEFINABLE_ELEMENT__REDEFINITION_CONTEXT);
		}
		return redefinitionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RedefinableElement> getRedefinableELement() {
		if (redefinableELement == null) {
			redefinableELement = new EObjectResolvingEList<RedefinableElement>(RedefinableElement.class, this, BehaviorPackage.REDEFINABLE_ELEMENT__REDEFINABLE_ELEMENT);
		}
		return redefinableELement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BehaviorPackage.REDEFINABLE_ELEMENT__REDEFINITION_CONTEXT:
				return getRedefinitionContext();
			case BehaviorPackage.REDEFINABLE_ELEMENT__REDEFINABLE_ELEMENT:
				return getRedefinableELement();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BehaviorPackage.REDEFINABLE_ELEMENT__REDEFINITION_CONTEXT:
				getRedefinitionContext().clear();
				getRedefinitionContext().addAll((Collection<? extends Classifier>)newValue);
				return;
			case BehaviorPackage.REDEFINABLE_ELEMENT__REDEFINABLE_ELEMENT:
				getRedefinableELement().clear();
				getRedefinableELement().addAll((Collection<? extends RedefinableElement>)newValue);
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
			case BehaviorPackage.REDEFINABLE_ELEMENT__REDEFINITION_CONTEXT:
				getRedefinitionContext().clear();
				return;
			case BehaviorPackage.REDEFINABLE_ELEMENT__REDEFINABLE_ELEMENT:
				getRedefinableELement().clear();
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
			case BehaviorPackage.REDEFINABLE_ELEMENT__REDEFINITION_CONTEXT:
				return redefinitionContext != null && !redefinitionContext.isEmpty();
			case BehaviorPackage.REDEFINABLE_ELEMENT__REDEFINABLE_ELEMENT:
				return redefinableELement != null && !redefinableELement.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RedefinableElementImpl
