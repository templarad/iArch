package jp.ac.kyushu.iarch.checkplugin.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fukamachi
 *
 */
public class BehaviorPairModel {
	List<CallPairModel> callModels = new ArrayList<CallPairModel>();
	String name = null;

	public BehaviorPairModel(String name,
			List<CallPairModel> callModels) {
		this.name = name;
		this.callModels = callModels;
	}

	public String getName() {
		return name;
	}

	/**
	 * @return methodModels
	 */
	public List<CallPairModel> getCallModels() {
		return callModels;
	}
}
