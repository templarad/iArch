/**
 *
 */
package jp.ac.kyushu.iarch.checkplugin.model;

import jp.ac.kyushu.iarch.archdsl.archDSL.AltMethod;
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
	private ComponentClassPairModel parentModel = null;
	private Node javaMethodNode = null;
	private Node javaClassNode = null;
	private String name = null;
	private boolean isExistJavaNode = false;
	private boolean isOpt = false;
	private boolean isAlt = false;
	private String altMethodName = null;


	/**
	 * Method,OptMethodをペアに使うときのコンストラクタ
	 * @param archMethod メソッド本体
	 * @param javaMethodNode 合致しているJavaのメソッドNode(ない場合はnull)
	 */
	public ComponentMethodPairModel(SuperMethod archMethod, Node javaMethodNode, ComponentClassPairModel parentModel) {
		this.archMethod = archMethod;
		this.parentModel = parentModel;
//		this.archClass = (Interface) archMethod.eContainer();
		this.javaMethodNode = javaMethodNode;
		if (javaMethodNode != null) {
			isExistJavaNode = true;
			this.javaClassNode = javaMethodNode.getParent();
		}
		this.name = archMethod.getName();
		if(archMethod instanceof OptMethod){
			isOpt = true;
		}else{
			isOpt = false;
		}
	}

	/**
	 * AltMethodをペアに使うときのコンストラクタ
	 * @param altMethodKey AltMethod本体
	 * @param methodName AltMethod内でJavaソースと合致している(であろう)メソッド名
	 * @param javaMethodNode 合致しているJavaのメソッドNode(ない場合はnull)
	 */
	public ComponentMethodPairModel(AltMethod altMethodKey,String methodName, Node javaMethodNode,ComponentClassPairModel parentModel) {
		this(altMethodKey,javaMethodNode,parentModel);
		this.isAlt = true;
		this.altMethodName = methodName;
		this.name = methodName;
	}

	/**
	 * @return isAlt
	 */
	public boolean isAlt() {
		return isAlt;
	}

	/**
	 * @return altMethodName
	 */
	public String getAltMethodName() {
		return altMethodName;
	}

	/**
	 * @return archMethod
	 */
	public SuperMethod getArchMethod() {
		return archMethod;
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
	 * @return name
	 */
	public String getName() {
		return name;
	}

	public ComponentClassPairModel getParentModel() {
		return parentModel;
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
