/**
 *
 */
package jp.ac.kyushu.iarch.checkplugin.model;

import java.util.ArrayList;
import java.util.List;

import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;

import org.dom4j.Node;

/**
 * @author fukamachi
 *
 */
public class ComponentClassPairModel {

	private Interface archInterface = null;
	private Node javaClassNode = null;
	private boolean isExistJavaNode = false;
	private String name = null;
	public List<ComponentMethodPairModel> methodPairsList = new ArrayList<ComponentMethodPairModel>();

	public ComponentClassPairModel(Interface archInterface, Node javaClassNode) {
		this.archInterface = archInterface;
		this.javaClassNode = javaClassNode;
		this.name = archInterface.getName();
		if (javaClassNode != null) {
			this.isExistJavaNode = true;
		}
	}

	public boolean overrideMethodPairModel(ComponentMethodPairModel newModel) {
		for (ComponentMethodPairModel methodPairModel : methodPairsList) {
			if (newModel.isAlt()) {
				if (newModel.getAltMethodName().equals(
						methodPairModel.getArchMethod().getName())) {
					methodPairsList.set(
							methodPairsList.indexOf(methodPairModel), newModel);
					return true;
				}
			} else {
				if (newModel.getArchMethod().getName().equals(
						methodPairModel.getArchMethod().getName())) {
					methodPairsList.set(
							methodPairsList.indexOf(methodPairModel), newModel);
					return true;
				}
			}
		}
		methodPairsList.add(newModel);
		return false;
	}

	public Interface getArchInterface() {
		return archInterface;
	}

	public Node getJavaClassNode() {
		return javaClassNode;
	}

	public String getName() {
		return name;
	}

	public boolean isExistJavaNode() {
		return isExistJavaNode;
	}

}
