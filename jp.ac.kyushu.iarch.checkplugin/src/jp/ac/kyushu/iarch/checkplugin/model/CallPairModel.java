package jp.ac.kyushu.iarch.checkplugin.model;

import java.util.ArrayList;
import java.util.List;

import jp.ac.kyushu.iarch.archdsl.archDSL.AltCall;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.OptCall;
import jp.ac.kyushu.iarch.archdsl.archDSL.SuperCall;
import jp.ac.kyushu.iarch.archdsl.archDSL.SuperMethod;
import jp.ac.kyushu.iarch.archdsl.archDSL.impl.MethodImpl;

/**
 *
 * CallとMethoPairModelのペア
 *
 * @author fukamachi
 *
 */
public class CallPairModel {
	List<ComponentClassPairModel> componentClassPairModels = new ArrayList<ComponentClassPairModel>();
	ComponentMethodPairModel methodModel;
	SuperCall methodCall;
	SuperMethod archMethod;
	String name;
	List<ComponentMethodPairModel> altMethodPairSets = new ArrayList<ComponentMethodPairModel>();
	boolean isOpt = false;
	boolean isAlt = false;

	public CallPairModel(
			List<ComponentClassPairModel> componentClassPairModels,
			SuperCall methodCall) {
		this.componentClassPairModels = componentClassPairModels;
		this.methodCall = methodCall;
		this.archMethod = methodCall.getName();
		this.name = archMethod.getName();
		this.methodModel = getMethodPairModelByArchMethod(archMethod);
		if (methodCall instanceof OptCall) {
			this.isOpt = true;
		}
		if (methodCall instanceof AltCall) {
			this.isAlt = true;
			for (SuperMethod altMethod : ((AltCall) methodCall).getA_name()) {
				this.altMethodPairSets
						.add(getMethodPairModelByArchMethod(altMethod));
			}
		}
	}

	public CallPairModel(
			List<ComponentClassPairModel> componentClassPairModels,
			Method methodCall) {
		this.componentClassPairModels = componentClassPairModels;
		this.archMethod = methodCall;
		this.name = archMethod.getName();
		this.methodModel = getMethodPairModelByArchMethod((SuperMethod) archMethod);
	}

	ComponentMethodPairModel getMethodPairModelByArchMethod(
			SuperMethod archMethod) {
		ComponentClassPairModel callClass = null;
		ComponentMethodPairModel callMethod = null;

		for (ComponentClassPairModel classPair : componentClassPairModels) {
			if (archMethod instanceof MethodImpl) {
				if (((Interface) (archMethod.eContainer())).getName().equals(
						classPair.getName())) {
					callClass = classPair;
					break;
				}
			} else {
				System.out
						.println(archMethod.getName()
								+ "CallError: uncertain components are not supported yet.");
				return null;
			}
		}
		for (ComponentMethodPairModel methodPair : callClass.methodPairsList) {
			if (archMethod.getName().equals(methodPair.getName())) {
				callMethod = methodPair;
				break;
			}
		}
		return callMethod;
	}

	/**
	 * @return componentClassPairModels
	 */
	public List<ComponentClassPairModel> getComponentClassPairModels() {
		return componentClassPairModels;
	}

	/**
	 * @return methodModel
	 */
	public ComponentMethodPairModel getMethodModel() {
		return methodModel;
	}

	/**
	 * @return methodCall
	 */
	public SuperCall getMethodCall() {
		return methodCall;
	}

	/**
	 * @return archMethod
	 */
	public SuperMethod getArchMethod() {
		return archMethod;
	}

	/**
	 * @return altCallSets
	 */
	public List<ComponentMethodPairModel> getAltMethodPairSets() {
		return altMethodPairSets;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return isOpt
	 */
	public boolean isOpt() {
		return isOpt;
	}

	/**
	 * @return isAlt
	 */
	public boolean isAlt() {
		return isAlt;
	}

}
