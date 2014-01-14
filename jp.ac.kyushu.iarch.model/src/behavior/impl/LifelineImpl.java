/**
 */
package behavior.impl;

import behavior.BehaviorExecutionSpecification;
import behavior.BehaviorPackage;
import behavior.BehavioredClassifier;
import behavior.DestructionEvent;
import behavior.Interaction;
import behavior.InteractionFragment;
import behavior.Lifeline;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lifeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavior.impl.LifelineImpl#getCoveredBy <em>Covered By</em>}</li>
 *   <li>{@link behavior.impl.LifelineImpl#getInteraction <em>Interaction</em>}</li>
 *   <li>{@link behavior.impl.LifelineImpl#getEndby <em>Endby</em>}</li>
 *   <li>{@link behavior.impl.LifelineImpl#getActor <em>Actor</em>}</li>
 *   <li>{@link behavior.impl.LifelineImpl#getBehaviorExecution <em>Behavior Execution</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LifelineImpl extends NamedElementImpl implements Lifeline {
	/**
	 * The cached value of the '{@link #getCoveredBy() <em>Covered By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoveredBy()
	 * @generated
	 * @ordered
	 */
	protected EList<InteractionFragment> coveredBy;

	/**
	 * The cached value of the '{@link #getEndby() <em>Endby</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndby()
	 * @generated
	 * @ordered
	 */
	protected DestructionEvent endby;

	/**
	 * The cached value of the '{@link #getActor() <em>Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActor()
	 * @generated
	 * @ordered
	 */
	protected BehavioredClassifier actor;

	/**
	 * The cached value of the '{@link #getBehaviorExecution() <em>Behavior Execution</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorExecution()
	 * @generated
	 * @ordered
	 */
	protected EList<BehaviorExecutionSpecification> behaviorExecution;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LifelineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BehaviorPackage.Literals.LIFELINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InteractionFragment> getCoveredBy() {
		if (coveredBy == null) {
			coveredBy = new EObjectWithInverseResolvingEList.ManyInverse<InteractionFragment>(InteractionFragment.class, this, BehaviorPackage.LIFELINE__COVERED_BY, BehaviorPackage.INTERACTION_FRAGMENT__COVERED);
		}
		return coveredBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interaction getInteraction() {
		if (eContainerFeatureID() != BehaviorPackage.LIFELINE__INTERACTION) return null;
		return (Interaction)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInteraction(Interaction newInteraction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInteraction, BehaviorPackage.LIFELINE__INTERACTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInteraction(Interaction newInteraction) {
		if (newInteraction != eInternalContainer() || (eContainerFeatureID() != BehaviorPackage.LIFELINE__INTERACTION && newInteraction != null)) {
			if (EcoreUtil.isAncestor(this, newInteraction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInteraction != null)
				msgs = ((InternalEObject)newInteraction).eInverseAdd(this, BehaviorPackage.INTERACTION__LIFELINE, Interaction.class, msgs);
			msgs = basicSetInteraction(newInteraction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.LIFELINE__INTERACTION, newInteraction, newInteraction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DestructionEvent getEndby() {
		if (endby != null && endby.eIsProxy()) {
			InternalEObject oldEndby = (InternalEObject)endby;
			endby = (DestructionEvent)eResolveProxy(oldEndby);
			if (endby != oldEndby) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviorPackage.LIFELINE__ENDBY, oldEndby, endby));
			}
		}
		return endby;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DestructionEvent basicGetEndby() {
		return endby;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndby(DestructionEvent newEndby, NotificationChain msgs) {
		DestructionEvent oldEndby = endby;
		endby = newEndby;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorPackage.LIFELINE__ENDBY, oldEndby, newEndby);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndby(DestructionEvent newEndby) {
		if (newEndby != endby) {
			NotificationChain msgs = null;
			if (endby != null)
				msgs = ((InternalEObject)endby).eInverseRemove(this, BehaviorPackage.DESTRUCTION_EVENT__END, DestructionEvent.class, msgs);
			if (newEndby != null)
				msgs = ((InternalEObject)newEndby).eInverseAdd(this, BehaviorPackage.DESTRUCTION_EVENT__END, DestructionEvent.class, msgs);
			msgs = basicSetEndby(newEndby, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.LIFELINE__ENDBY, newEndby, newEndby));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioredClassifier getActor() {
		if (actor != null && actor.eIsProxy()) {
			InternalEObject oldActor = (InternalEObject)actor;
			actor = (BehavioredClassifier)eResolveProxy(oldActor);
			if (actor != oldActor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviorPackage.LIFELINE__ACTOR, oldActor, actor));
			}
		}
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioredClassifier basicGetActor() {
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActor(BehavioredClassifier newActor, NotificationChain msgs) {
		BehavioredClassifier oldActor = actor;
		actor = newActor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorPackage.LIFELINE__ACTOR, oldActor, newActor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActor(BehavioredClassifier newActor) {
		if (newActor != actor) {
			NotificationChain msgs = null;
			if (actor != null)
				msgs = ((InternalEObject)actor).eInverseRemove(this, BehaviorPackage.BEHAVIORED_CLASSIFIER__INCLUDE, BehavioredClassifier.class, msgs);
			if (newActor != null)
				msgs = ((InternalEObject)newActor).eInverseAdd(this, BehaviorPackage.BEHAVIORED_CLASSIFIER__INCLUDE, BehavioredClassifier.class, msgs);
			msgs = basicSetActor(newActor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.LIFELINE__ACTOR, newActor, newActor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehaviorExecutionSpecification> getBehaviorExecution() {
		if (behaviorExecution == null) {
			behaviorExecution = new EObjectContainmentEList<BehaviorExecutionSpecification>(BehaviorExecutionSpecification.class, this, BehaviorPackage.LIFELINE__BEHAVIOR_EXECUTION);
		}
		return behaviorExecution;
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
			case BehaviorPackage.LIFELINE__COVERED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCoveredBy()).basicAdd(otherEnd, msgs);
			case BehaviorPackage.LIFELINE__INTERACTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInteraction((Interaction)otherEnd, msgs);
			case BehaviorPackage.LIFELINE__ENDBY:
				if (endby != null)
					msgs = ((InternalEObject)endby).eInverseRemove(this, BehaviorPackage.DESTRUCTION_EVENT__END, DestructionEvent.class, msgs);
				return basicSetEndby((DestructionEvent)otherEnd, msgs);
			case BehaviorPackage.LIFELINE__ACTOR:
				if (actor != null)
					msgs = ((InternalEObject)actor).eInverseRemove(this, BehaviorPackage.BEHAVIORED_CLASSIFIER__INCLUDE, BehavioredClassifier.class, msgs);
				return basicSetActor((BehavioredClassifier)otherEnd, msgs);
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
			case BehaviorPackage.LIFELINE__COVERED_BY:
				return ((InternalEList<?>)getCoveredBy()).basicRemove(otherEnd, msgs);
			case BehaviorPackage.LIFELINE__INTERACTION:
				return basicSetInteraction(null, msgs);
			case BehaviorPackage.LIFELINE__ENDBY:
				return basicSetEndby(null, msgs);
			case BehaviorPackage.LIFELINE__ACTOR:
				return basicSetActor(null, msgs);
			case BehaviorPackage.LIFELINE__BEHAVIOR_EXECUTION:
				return ((InternalEList<?>)getBehaviorExecution()).basicRemove(otherEnd, msgs);
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
			case BehaviorPackage.LIFELINE__INTERACTION:
				return eInternalContainer().eInverseRemove(this, BehaviorPackage.INTERACTION__LIFELINE, Interaction.class, msgs);
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
			case BehaviorPackage.LIFELINE__COVERED_BY:
				return getCoveredBy();
			case BehaviorPackage.LIFELINE__INTERACTION:
				return getInteraction();
			case BehaviorPackage.LIFELINE__ENDBY:
				if (resolve) return getEndby();
				return basicGetEndby();
			case BehaviorPackage.LIFELINE__ACTOR:
				if (resolve) return getActor();
				return basicGetActor();
			case BehaviorPackage.LIFELINE__BEHAVIOR_EXECUTION:
				return getBehaviorExecution();
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
			case BehaviorPackage.LIFELINE__COVERED_BY:
				getCoveredBy().clear();
				getCoveredBy().addAll((Collection<? extends InteractionFragment>)newValue);
				return;
			case BehaviorPackage.LIFELINE__INTERACTION:
				setInteraction((Interaction)newValue);
				return;
			case BehaviorPackage.LIFELINE__ENDBY:
				setEndby((DestructionEvent)newValue);
				return;
			case BehaviorPackage.LIFELINE__ACTOR:
				setActor((BehavioredClassifier)newValue);
				return;
			case BehaviorPackage.LIFELINE__BEHAVIOR_EXECUTION:
				getBehaviorExecution().clear();
				getBehaviorExecution().addAll((Collection<? extends BehaviorExecutionSpecification>)newValue);
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
			case BehaviorPackage.LIFELINE__COVERED_BY:
				getCoveredBy().clear();
				return;
			case BehaviorPackage.LIFELINE__INTERACTION:
				setInteraction((Interaction)null);
				return;
			case BehaviorPackage.LIFELINE__ENDBY:
				setEndby((DestructionEvent)null);
				return;
			case BehaviorPackage.LIFELINE__ACTOR:
				setActor((BehavioredClassifier)null);
				return;
			case BehaviorPackage.LIFELINE__BEHAVIOR_EXECUTION:
				getBehaviorExecution().clear();
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
			case BehaviorPackage.LIFELINE__COVERED_BY:
				return coveredBy != null && !coveredBy.isEmpty();
			case BehaviorPackage.LIFELINE__INTERACTION:
				return getInteraction() != null;
			case BehaviorPackage.LIFELINE__ENDBY:
				return endby != null;
			case BehaviorPackage.LIFELINE__ACTOR:
				return actor != null;
			case BehaviorPackage.LIFELINE__BEHAVIOR_EXECUTION:
				return behaviorExecution != null && !behaviorExecution.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LifelineImpl
