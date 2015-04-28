package jp.ac.kyushu.iarch.checkplugin.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fukamachi
 *
 */
public class BehaviorPairModel {
	ComponentClassPairModel classModel = null;
	List<ComponentMethodPairModel> methodModels = new ArrayList();

	public BehaviorPairModel(ComponentClassPairModel classModel,
			List<ComponentMethodPairModel> methodModels) {
		this.classModel = classModel;
		this.methodModels = methodModels;
	}
	/**
	 * @return classModel
	 */
	public ComponentClassPairModel getClassModel() {
		return classModel;
	}
	/**
	 * @param classModel セットする classModel
	 */
	public void setClassModel(ComponentClassPairModel classModel) {
		this.classModel = classModel;
	}
	/**
	 * @return methodModels
	 */
	public List<ComponentMethodPairModel> getMethodModels() {
		return methodModels;
	}
	/**
	 * @param methodModels セットする methodModels
	 */
	public void setMethodModels(List<ComponentMethodPairModel> methodModels) {
		this.methodModels = methodModels;
	}

}
