/**
 */
package Dataflow_editor.impl;

import Dataflow_editor.DataFlow;
import Dataflow_editor.Dataflow_editorPackage;
import Dataflow_editor.External_entity;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Dataflow_editor.impl.DataFlowImpl#getEntity <em>Entity</em>}</li>
 *   <li>{@link Dataflow_editor.impl.DataFlowImpl#getSource <em>Source</em>}</li>
 *   <li>{@link Dataflow_editor.impl.DataFlowImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataFlowImpl extends ClassifierImpl implements DataFlow {
	/**
	 * The cached value of the '{@link #getEntity() <em>Entity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntity()
	 * @generated
	 * @ordered
	 */
	protected External_entity entity;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Dataflow_editor.Process source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Dataflow_editor.Process target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Dataflow_editorPackage.Literals.DATA_FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public External_entity getEntity() {
		return entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEntity(External_entity newEntity, NotificationChain msgs) {
		External_entity oldEntity = entity;
		entity = newEntity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Dataflow_editorPackage.DATA_FLOW__ENTITY, oldEntity, newEntity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntity(External_entity newEntity) {
		if (newEntity != entity) {
			NotificationChain msgs = null;
			if (entity != null)
				msgs = ((InternalEObject)entity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Dataflow_editorPackage.DATA_FLOW__ENTITY, null, msgs);
			if (newEntity != null)
				msgs = ((InternalEObject)newEntity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Dataflow_editorPackage.DATA_FLOW__ENTITY, null, msgs);
			msgs = basicSetEntity(newEntity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Dataflow_editorPackage.DATA_FLOW__ENTITY, newEntity, newEntity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dataflow_editor.Process getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(Dataflow_editor.Process newSource, NotificationChain msgs) {
		Dataflow_editor.Process oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Dataflow_editorPackage.DATA_FLOW__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Dataflow_editor.Process newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Dataflow_editorPackage.DATA_FLOW__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Dataflow_editorPackage.DATA_FLOW__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Dataflow_editorPackage.DATA_FLOW__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dataflow_editor.Process getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(Dataflow_editor.Process newTarget, NotificationChain msgs) {
		Dataflow_editor.Process oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Dataflow_editorPackage.DATA_FLOW__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Dataflow_editor.Process newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Dataflow_editorPackage.DATA_FLOW__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Dataflow_editorPackage.DATA_FLOW__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Dataflow_editorPackage.DATA_FLOW__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Dataflow_editorPackage.DATA_FLOW__ENTITY:
				return basicSetEntity(null, msgs);
			case Dataflow_editorPackage.DATA_FLOW__SOURCE:
				return basicSetSource(null, msgs);
			case Dataflow_editorPackage.DATA_FLOW__TARGET:
				return basicSetTarget(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Dataflow_editorPackage.DATA_FLOW__ENTITY:
				return getEntity();
			case Dataflow_editorPackage.DATA_FLOW__SOURCE:
				return getSource();
			case Dataflow_editorPackage.DATA_FLOW__TARGET:
				return getTarget();
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
			case Dataflow_editorPackage.DATA_FLOW__ENTITY:
				setEntity((External_entity)newValue);
				return;
			case Dataflow_editorPackage.DATA_FLOW__SOURCE:
				setSource((Dataflow_editor.Process)newValue);
				return;
			case Dataflow_editorPackage.DATA_FLOW__TARGET:
				setTarget((Dataflow_editor.Process)newValue);
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
			case Dataflow_editorPackage.DATA_FLOW__ENTITY:
				setEntity((External_entity)null);
				return;
			case Dataflow_editorPackage.DATA_FLOW__SOURCE:
				setSource((Dataflow_editor.Process)null);
				return;
			case Dataflow_editorPackage.DATA_FLOW__TARGET:
				setTarget((Dataflow_editor.Process)null);
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
			case Dataflow_editorPackage.DATA_FLOW__ENTITY:
				return entity != null;
			case Dataflow_editorPackage.DATA_FLOW__SOURCE:
				return source != null;
			case Dataflow_editorPackage.DATA_FLOW__TARGET:
				return target != null;
		}
		return super.eIsSet(featureID);
	}

} //DataFlowImpl
