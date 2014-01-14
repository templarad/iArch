/**
 */
package umlClass.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import umlClass.Classifier;
import umlClass.Generalization;
import umlClass.Property;
import umlClass.UmlClassPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link umlClass.impl.ClassifierImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link umlClass.impl.ClassifierImpl#getRedefinedClassifier <em>Redefined Classifier</em>}</li>
 *   <li>{@link umlClass.impl.ClassifierImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link umlClass.impl.ClassifierImpl#getGeneralization <em>Generalization</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ClassifierImpl extends NamedElementImpl implements Classifier {
	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> attribute;

	/**
	 * The cached value of the '{@link #getRedefinedClassifier() <em>Redefined Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedefinedClassifier()
	 * @generated
	 * @ordered
	 */
	protected Classifier redefinedClassifier;

	/**
	 * The cached value of the '{@link #getGeneralization() <em>Generalization</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralization()
	 * @generated
	 * @ordered
	 */
	protected EList<Generalization> generalization;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmlClassPackage.Literals.CLASSIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getAttribute() {
		if (attribute == null) {
			attribute = new EObjectWithInverseResolvingEList<Property>(Property.class, this, UmlClassPackage.CLASSIFIER__ATTRIBUTE, UmlClassPackage.PROPERTY__CLASSIFIER);
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getRedefinedClassifier() {
		if (redefinedClassifier != null && redefinedClassifier.eIsProxy()) {
			InternalEObject oldRedefinedClassifier = (InternalEObject)redefinedClassifier;
			redefinedClassifier = (Classifier)eResolveProxy(oldRedefinedClassifier);
			if (redefinedClassifier != oldRedefinedClassifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmlClassPackage.CLASSIFIER__REDEFINED_CLASSIFIER, oldRedefinedClassifier, redefinedClassifier));
			}
		}
		return redefinedClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier basicGetRedefinedClassifier() {
		return redefinedClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRedefinedClassifier(Classifier newRedefinedClassifier) {
		Classifier oldRedefinedClassifier = redefinedClassifier;
		redefinedClassifier = newRedefinedClassifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlClassPackage.CLASSIFIER__REDEFINED_CLASSIFIER, oldRedefinedClassifier, redefinedClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public umlClass.Package getPackage() {
		if (eContainerFeatureID() != UmlClassPackage.CLASSIFIER__PACKAGE) return null;
		return (umlClass.Package)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPackage(umlClass.Package newPackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPackage, UmlClassPackage.CLASSIFIER__PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackage(umlClass.Package newPackage) {
		if (newPackage != eInternalContainer() || (eContainerFeatureID() != UmlClassPackage.CLASSIFIER__PACKAGE && newPackage != null)) {
			if (EcoreUtil.isAncestor(this, newPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPackage != null)
				msgs = ((InternalEObject)newPackage).eInverseAdd(this, UmlClassPackage.PACKAGE__CLASSIFIERS, umlClass.Package.class, msgs);
			msgs = basicSetPackage(newPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlClassPackage.CLASSIFIER__PACKAGE, newPackage, newPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Generalization> getGeneralization() {
		if (generalization == null) {
			generalization = new EObjectContainmentWithInverseEList<Generalization>(Generalization.class, this, UmlClassPackage.CLASSIFIER__GENERALIZATION, UmlClassPackage.GENERALIZATION__SPECIFIC);
		}
		return generalization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UmlClassPackage.CLASSIFIER__ATTRIBUTE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttribute()).basicAdd(otherEnd, msgs);
			case UmlClassPackage.CLASSIFIER__PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPackage((umlClass.Package)otherEnd, msgs);
			case UmlClassPackage.CLASSIFIER__GENERALIZATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGeneralization()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UmlClassPackage.CLASSIFIER__ATTRIBUTE:
				return ((InternalEList<?>)getAttribute()).basicRemove(otherEnd, msgs);
			case UmlClassPackage.CLASSIFIER__PACKAGE:
				return basicSetPackage(null, msgs);
			case UmlClassPackage.CLASSIFIER__GENERALIZATION:
				return ((InternalEList<?>)getGeneralization()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case UmlClassPackage.CLASSIFIER__PACKAGE:
				return eInternalContainer().eInverseRemove(this, UmlClassPackage.PACKAGE__CLASSIFIERS, umlClass.Package.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UmlClassPackage.CLASSIFIER__ATTRIBUTE:
				return getAttribute();
			case UmlClassPackage.CLASSIFIER__REDEFINED_CLASSIFIER:
				if (resolve) return getRedefinedClassifier();
				return basicGetRedefinedClassifier();
			case UmlClassPackage.CLASSIFIER__PACKAGE:
				return getPackage();
			case UmlClassPackage.CLASSIFIER__GENERALIZATION:
				return getGeneralization();
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
			case UmlClassPackage.CLASSIFIER__ATTRIBUTE:
				getAttribute().clear();
				getAttribute().addAll((Collection<? extends Property>)newValue);
				return;
			case UmlClassPackage.CLASSIFIER__REDEFINED_CLASSIFIER:
				setRedefinedClassifier((Classifier)newValue);
				return;
			case UmlClassPackage.CLASSIFIER__PACKAGE:
				setPackage((umlClass.Package)newValue);
				return;
			case UmlClassPackage.CLASSIFIER__GENERALIZATION:
				getGeneralization().clear();
				getGeneralization().addAll((Collection<? extends Generalization>)newValue);
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
			case UmlClassPackage.CLASSIFIER__ATTRIBUTE:
				getAttribute().clear();
				return;
			case UmlClassPackage.CLASSIFIER__REDEFINED_CLASSIFIER:
				setRedefinedClassifier((Classifier)null);
				return;
			case UmlClassPackage.CLASSIFIER__PACKAGE:
				setPackage((umlClass.Package)null);
				return;
			case UmlClassPackage.CLASSIFIER__GENERALIZATION:
				getGeneralization().clear();
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
			case UmlClassPackage.CLASSIFIER__ATTRIBUTE:
				return attribute != null && !attribute.isEmpty();
			case UmlClassPackage.CLASSIFIER__REDEFINED_CLASSIFIER:
				return redefinedClassifier != null;
			case UmlClassPackage.CLASSIFIER__PACKAGE:
				return getPackage() != null;
			case UmlClassPackage.CLASSIFIER__GENERALIZATION:
				return generalization != null && !generalization.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClassifierImpl
