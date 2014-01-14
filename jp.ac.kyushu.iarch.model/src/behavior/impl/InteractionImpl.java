/**
 */
package behavior.impl;

import behavior.BehaviorPackage;
import behavior.BehavioredClassifier;
import behavior.DestructionEvent;
import behavior.GeneralOrdering;
import behavior.Interaction;
import behavior.InteractionFragment;
import behavior.Lifeline;
import behavior.Message;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavior.impl.InteractionImpl#getCovered <em>Covered</em>}</li>
 *   <li>{@link behavior.impl.InteractionImpl#getEnclosingInteraction <em>Enclosing Interaction</em>}</li>
 *   <li>{@link behavior.impl.InteractionImpl#getGeneralOrdering <em>General Ordering</em>}</li>
 *   <li>{@link behavior.impl.InteractionImpl#getFragment <em>Fragment</em>}</li>
 *   <li>{@link behavior.impl.InteractionImpl#getObject <em>Object</em>}</li>
 *   <li>{@link behavior.impl.InteractionImpl#getDestructionevent <em>Destructionevent</em>}</li>
 *   <li>{@link behavior.impl.InteractionImpl#getLifeline <em>Lifeline</em>}</li>
 *   <li>{@link behavior.impl.InteractionImpl#getMessage <em>Message</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InteractionImpl extends BehaviorImpl implements Interaction {
	/**
	 * The cached value of the '{@link #getCovered() <em>Covered</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCovered()
	 * @generated
	 * @ordered
	 */
	protected EList<Lifeline> covered;

	/**
	 * The cached value of the '{@link #getGeneralOrdering() <em>General Ordering</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralOrdering()
	 * @generated
	 * @ordered
	 */
	protected GeneralOrdering generalOrdering;

	/**
	 * The cached value of the '{@link #getFragment() <em>Fragment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragment()
	 * @generated
	 * @ordered
	 */
	protected EList<InteractionFragment> fragment;

	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioredClassifier> object;

	/**
	 * The cached value of the '{@link #getDestructionevent() <em>Destructionevent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestructionevent()
	 * @generated
	 * @ordered
	 */
	protected EList<DestructionEvent> destructionevent;

	/**
	 * The cached value of the '{@link #getLifeline() <em>Lifeline</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLifeline()
	 * @generated
	 * @ordered
	 */
	protected EList<Lifeline> lifeline;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected EList<Message> message;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InteractionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BehaviorPackage.Literals.INTERACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Lifeline> getCovered() {
		if (covered == null) {
			covered = new EObjectWithInverseResolvingEList.ManyInverse<Lifeline>(Lifeline.class, this, BehaviorPackage.INTERACTION__COVERED, BehaviorPackage.LIFELINE__COVERED_BY);
		}
		return covered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interaction getEnclosingInteraction() {
		if (eContainerFeatureID() != BehaviorPackage.INTERACTION__ENCLOSING_INTERACTION) return null;
		return (Interaction)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnclosingInteraction(Interaction newEnclosingInteraction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEnclosingInteraction, BehaviorPackage.INTERACTION__ENCLOSING_INTERACTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnclosingInteraction(Interaction newEnclosingInteraction) {
		if (newEnclosingInteraction != eInternalContainer() || (eContainerFeatureID() != BehaviorPackage.INTERACTION__ENCLOSING_INTERACTION && newEnclosingInteraction != null)) {
			if (EcoreUtil.isAncestor(this, newEnclosingInteraction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEnclosingInteraction != null)
				msgs = ((InternalEObject)newEnclosingInteraction).eInverseAdd(this, BehaviorPackage.INTERACTION__FRAGMENT, Interaction.class, msgs);
			msgs = basicSetEnclosingInteraction(newEnclosingInteraction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.INTERACTION__ENCLOSING_INTERACTION, newEnclosingInteraction, newEnclosingInteraction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralOrdering getGeneralOrdering() {
		return generalOrdering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGeneralOrdering(GeneralOrdering newGeneralOrdering, NotificationChain msgs) {
		GeneralOrdering oldGeneralOrdering = generalOrdering;
		generalOrdering = newGeneralOrdering;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorPackage.INTERACTION__GENERAL_ORDERING, oldGeneralOrdering, newGeneralOrdering);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneralOrdering(GeneralOrdering newGeneralOrdering) {
		if (newGeneralOrdering != generalOrdering) {
			NotificationChain msgs = null;
			if (generalOrdering != null)
				msgs = ((InternalEObject)generalOrdering).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorPackage.INTERACTION__GENERAL_ORDERING, null, msgs);
			if (newGeneralOrdering != null)
				msgs = ((InternalEObject)newGeneralOrdering).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorPackage.INTERACTION__GENERAL_ORDERING, null, msgs);
			msgs = basicSetGeneralOrdering(newGeneralOrdering, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.INTERACTION__GENERAL_ORDERING, newGeneralOrdering, newGeneralOrdering));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InteractionFragment> getFragment() {
		if (fragment == null) {
			fragment = new EObjectContainmentWithInverseEList<InteractionFragment>(InteractionFragment.class, this, BehaviorPackage.INTERACTION__FRAGMENT, BehaviorPackage.INTERACTION_FRAGMENT__ENCLOSING_INTERACTION);
		}
		return fragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioredClassifier> getObject() {
		if (object == null) {
			object = new EObjectContainmentEList<BehavioredClassifier>(BehavioredClassifier.class, this, BehaviorPackage.INTERACTION__OBJECT);
		}
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DestructionEvent> getDestructionevent() {
		if (destructionevent == null) {
			destructionevent = new EObjectContainmentWithInverseEList<DestructionEvent>(DestructionEvent.class, this, BehaviorPackage.INTERACTION__DESTRUCTIONEVENT, BehaviorPackage.DESTRUCTION_EVENT__INTERACTION);
		}
		return destructionevent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Lifeline> getLifeline() {
		if (lifeline == null) {
			lifeline = new EObjectContainmentWithInverseEList<Lifeline>(Lifeline.class, this, BehaviorPackage.INTERACTION__LIFELINE, BehaviorPackage.LIFELINE__INTERACTION);
		}
		return lifeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Message> getMessage() {
		if (message == null) {
			message = new EObjectContainmentWithInverseEList<Message>(Message.class, this, BehaviorPackage.INTERACTION__MESSAGE, BehaviorPackage.MESSAGE__INTERACTION);
		}
		return message;
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
			case BehaviorPackage.INTERACTION__COVERED:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCovered()).basicAdd(otherEnd, msgs);
			case BehaviorPackage.INTERACTION__ENCLOSING_INTERACTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEnclosingInteraction((Interaction)otherEnd, msgs);
			case BehaviorPackage.INTERACTION__FRAGMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFragment()).basicAdd(otherEnd, msgs);
			case BehaviorPackage.INTERACTION__DESTRUCTIONEVENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDestructionevent()).basicAdd(otherEnd, msgs);
			case BehaviorPackage.INTERACTION__LIFELINE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLifeline()).basicAdd(otherEnd, msgs);
			case BehaviorPackage.INTERACTION__MESSAGE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMessage()).basicAdd(otherEnd, msgs);
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
			case BehaviorPackage.INTERACTION__COVERED:
				return ((InternalEList<?>)getCovered()).basicRemove(otherEnd, msgs);
			case BehaviorPackage.INTERACTION__ENCLOSING_INTERACTION:
				return basicSetEnclosingInteraction(null, msgs);
			case BehaviorPackage.INTERACTION__GENERAL_ORDERING:
				return basicSetGeneralOrdering(null, msgs);
			case BehaviorPackage.INTERACTION__FRAGMENT:
				return ((InternalEList<?>)getFragment()).basicRemove(otherEnd, msgs);
			case BehaviorPackage.INTERACTION__OBJECT:
				return ((InternalEList<?>)getObject()).basicRemove(otherEnd, msgs);
			case BehaviorPackage.INTERACTION__DESTRUCTIONEVENT:
				return ((InternalEList<?>)getDestructionevent()).basicRemove(otherEnd, msgs);
			case BehaviorPackage.INTERACTION__LIFELINE:
				return ((InternalEList<?>)getLifeline()).basicRemove(otherEnd, msgs);
			case BehaviorPackage.INTERACTION__MESSAGE:
				return ((InternalEList<?>)getMessage()).basicRemove(otherEnd, msgs);
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
			case BehaviorPackage.INTERACTION__ENCLOSING_INTERACTION:
				return eInternalContainer().eInverseRemove(this, BehaviorPackage.INTERACTION__FRAGMENT, Interaction.class, msgs);
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
			case BehaviorPackage.INTERACTION__COVERED:
				return getCovered();
			case BehaviorPackage.INTERACTION__ENCLOSING_INTERACTION:
				return getEnclosingInteraction();
			case BehaviorPackage.INTERACTION__GENERAL_ORDERING:
				return getGeneralOrdering();
			case BehaviorPackage.INTERACTION__FRAGMENT:
				return getFragment();
			case BehaviorPackage.INTERACTION__OBJECT:
				return getObject();
			case BehaviorPackage.INTERACTION__DESTRUCTIONEVENT:
				return getDestructionevent();
			case BehaviorPackage.INTERACTION__LIFELINE:
				return getLifeline();
			case BehaviorPackage.INTERACTION__MESSAGE:
				return getMessage();
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
			case BehaviorPackage.INTERACTION__COVERED:
				getCovered().clear();
				getCovered().addAll((Collection<? extends Lifeline>)newValue);
				return;
			case BehaviorPackage.INTERACTION__ENCLOSING_INTERACTION:
				setEnclosingInteraction((Interaction)newValue);
				return;
			case BehaviorPackage.INTERACTION__GENERAL_ORDERING:
				setGeneralOrdering((GeneralOrdering)newValue);
				return;
			case BehaviorPackage.INTERACTION__FRAGMENT:
				getFragment().clear();
				getFragment().addAll((Collection<? extends InteractionFragment>)newValue);
				return;
			case BehaviorPackage.INTERACTION__OBJECT:
				getObject().clear();
				getObject().addAll((Collection<? extends BehavioredClassifier>)newValue);
				return;
			case BehaviorPackage.INTERACTION__DESTRUCTIONEVENT:
				getDestructionevent().clear();
				getDestructionevent().addAll((Collection<? extends DestructionEvent>)newValue);
				return;
			case BehaviorPackage.INTERACTION__LIFELINE:
				getLifeline().clear();
				getLifeline().addAll((Collection<? extends Lifeline>)newValue);
				return;
			case BehaviorPackage.INTERACTION__MESSAGE:
				getMessage().clear();
				getMessage().addAll((Collection<? extends Message>)newValue);
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
			case BehaviorPackage.INTERACTION__COVERED:
				getCovered().clear();
				return;
			case BehaviorPackage.INTERACTION__ENCLOSING_INTERACTION:
				setEnclosingInteraction((Interaction)null);
				return;
			case BehaviorPackage.INTERACTION__GENERAL_ORDERING:
				setGeneralOrdering((GeneralOrdering)null);
				return;
			case BehaviorPackage.INTERACTION__FRAGMENT:
				getFragment().clear();
				return;
			case BehaviorPackage.INTERACTION__OBJECT:
				getObject().clear();
				return;
			case BehaviorPackage.INTERACTION__DESTRUCTIONEVENT:
				getDestructionevent().clear();
				return;
			case BehaviorPackage.INTERACTION__LIFELINE:
				getLifeline().clear();
				return;
			case BehaviorPackage.INTERACTION__MESSAGE:
				getMessage().clear();
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
			case BehaviorPackage.INTERACTION__COVERED:
				return covered != null && !covered.isEmpty();
			case BehaviorPackage.INTERACTION__ENCLOSING_INTERACTION:
				return getEnclosingInteraction() != null;
			case BehaviorPackage.INTERACTION__GENERAL_ORDERING:
				return generalOrdering != null;
			case BehaviorPackage.INTERACTION__FRAGMENT:
				return fragment != null && !fragment.isEmpty();
			case BehaviorPackage.INTERACTION__OBJECT:
				return object != null && !object.isEmpty();
			case BehaviorPackage.INTERACTION__DESTRUCTIONEVENT:
				return destructionevent != null && !destructionevent.isEmpty();
			case BehaviorPackage.INTERACTION__LIFELINE:
				return lifeline != null && !lifeline.isEmpty();
			case BehaviorPackage.INTERACTION__MESSAGE:
				return message != null && !message.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == InteractionFragment.class) {
			switch (derivedFeatureID) {
				case BehaviorPackage.INTERACTION__COVERED: return BehaviorPackage.INTERACTION_FRAGMENT__COVERED;
				case BehaviorPackage.INTERACTION__ENCLOSING_INTERACTION: return BehaviorPackage.INTERACTION_FRAGMENT__ENCLOSING_INTERACTION;
				case BehaviorPackage.INTERACTION__GENERAL_ORDERING: return BehaviorPackage.INTERACTION_FRAGMENT__GENERAL_ORDERING;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == InteractionFragment.class) {
			switch (baseFeatureID) {
				case BehaviorPackage.INTERACTION_FRAGMENT__COVERED: return BehaviorPackage.INTERACTION__COVERED;
				case BehaviorPackage.INTERACTION_FRAGMENT__ENCLOSING_INTERACTION: return BehaviorPackage.INTERACTION__ENCLOSING_INTERACTION;
				case BehaviorPackage.INTERACTION_FRAGMENT__GENERAL_ORDERING: return BehaviorPackage.INTERACTION__GENERAL_ORDERING;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //InteractionImpl
