/**
 *
 */
package jp.ac.kyushu.iarch.checkplugin.model;

import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.OptMethod;
import jp.ac.kyushu.iarch.archdsl.archDSL.SuperMethod;

import org.dom4j.Node;

/**
 * @author fukamachi
 *
 */
public class ComponentMethodPairModel {
	private SuperMethod archMethod = null;
	private Interface archClass = null;
	private Node javaMethodNode = null;
	private Node javaClassNode = null;
	private boolean isExistJavaNode = false;
	private boolean isOpt = false;


	public ComponentMethodPairModel(SuperMethod archMethod, Node javaMethodNode) {
		this.archMethod = archMethod;
		this.archClass = (Interface) archMethod.eContainer();
		this.javaMethodNode = javaMethodNode;
		if (javaMethodNode != null) {
			isExistJavaNode = true;
			this.javaClassNode = javaMethodNode.getParent();
		}
		if(archMethod instanceof OptMethod){
			isOpt = true;
		}else{
			isOpt = false;
		}
	}


	/**
	 * @return archMethod
	 */
	public SuperMethod getArchMethod() {
		return archMethod;
	}


	/**
	 * @param archMethod セットする archMethod
	 */
	public void setArchMethod(SuperMethod archMethod) {
		this.archMethod = archMethod;
		if(archMethod instanceof OptMethod){
			isOpt = true;
		}else{
			isOpt = false;
		}
	}


	/**
	 * @return archClass
	 */
	public Interface getArchClass() {
		return archClass;
	}


	/**
	 * @return javaMethodNode
	 */
	public Node getJavaMethodNode() {
		return javaMethodNode;
	}


	/**
	 * @return javaClassNode
	 */
	public Node getJavaClassNode() {
		return javaClassNode;
	}


	/**
	 * @return isExistJavaNode
	 */
	public boolean isExistJavaNode() {
		return isExistJavaNode;
	}


	/**
	 * @return isOpt
	 */
	public boolean isOpt() {
		return isOpt;
	}

}
