/**
 *
 */
package jp.ac.kyushu.iarch.checkplugin.model;

import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;

import org.dom4j.Node;

/**
 * @author fukamachi
 *
 */
public class ComponentClassPairModel {

	private Interface archClass = null;
	private Node javaClassNode = null;
	private boolean isExistJavaNode = false;

	public ComponentClassPairModel(Interface archInterface, Node javaClassNode) {
		this.archClass = archInterface;
		this.javaClassNode = javaClassNode;
		if (javaClassNode != null) {
			this.isExistJavaNode = true;
		}
	}

	public Interface getArchClass() {
		return archClass;
	}

	public Node getJavaClassNode() {
		return javaClassNode;
	}

	public boolean isExistJavaNode() {
		return isExistJavaNode;
	}

}
