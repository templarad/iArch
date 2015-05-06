package jp.ac.kyushu.iarch.checkplugin.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fukamachi
 * 
 */
public class BehaviorPairModel {
	List<ComponentMethodPairModel> methodModels = new ArrayList();
	String name = null;

	public BehaviorPairModel(String name,List<ComponentMethodPairModel> methodModels) {
		this.methodModels = methodModels;
	}

	/**
	 * @return methodModels
	 */
	public List<ComponentMethodPairModel> getMethodModels() {
		return methodModels;
	}
}
