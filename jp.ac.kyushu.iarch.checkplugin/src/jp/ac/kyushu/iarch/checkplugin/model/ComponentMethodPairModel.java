/**
 *
 */
package jp.ac.kyushu.iarch.checkplugin.model;

import java.util.ArrayList;
import java.util.List;

import jp.ac.kyushu.iarch.archdsl.archDSL.AltMethod;
import jp.ac.kyushu.iarch.archdsl.archDSL.OptMethod;
import jp.ac.kyushu.iarch.archdsl.archDSL.SuperMethod;

import org.dom4j.Node;

/**
 * @author fukamachi
 *
 */
// TODO Uncertainな要素を分離し，このクラスを継承したクラスを作成する
public class ComponentMethodPairModel {
	private SuperMethod archMethod = null;
	private ComponentClassPairModel parentModel = null;
	private Node javaMethodNode = null;
	private Node javaClassNode = null;
	private String name = null;
	private boolean isExistJavaNode = false;
	private boolean isOpt = false;
	private boolean isAlt = false;
	private boolean isAltSet = false;
	private boolean isInvocationExist = false;
	private String altMethodName = null;
	private List<ComponentMethodPairModel> altMethodPairSets = new ArrayList<ComponentMethodPairModel>();
	private ComponentMethodPairModel altParentMethodModel = null;

	/**
	 * Method,OptMethodをペアに使うときのコンストラクタ
	 *
	 * @param archMethod
	 *            メソッド本体
	 * @param javaMethodNode
	 *            合致しているJavaのメソッドNode(ない場合はnull)
	 */
	public ComponentMethodPairModel(SuperMethod archMethod,
			Node javaMethodNode, ComponentClassPairModel parentModel) {
		this.archMethod = archMethod;
		this.parentModel = parentModel;
		this.javaMethodNode = javaMethodNode;
		if (javaMethodNode != null) {
			isExistJavaNode = true;
			this.javaClassNode = javaMethodNode.getParent();
		}
		this.name = archMethod.getName();
		if (archMethod instanceof OptMethod) {
			isOpt = true;
		} else {
			isOpt = false;
		}
	}

	/**
	 * AltMethodをペアに使うときのコンストラクタ
	 *
	 * @param altMethodKey
	 *            AltMethod本体
	 * @param methodName
	 *            AltMethod内の要素
	 * @param javaMethodNode
	 *            合致しているJavaのメソッドNode(ない場合はnull)
	 */
	public ComponentMethodPairModel(AltMethod altMethodKey, String methodName,
			Node javaMethodNode, ComponentClassPairModel parentClassModel) {
		this(altMethodKey, javaMethodNode, parentClassModel);
		this.isAlt = true;
		this.altMethodName = methodName;
		this.name = methodName;
	}

	/**
	 * AltMethodSetを作るときのコンストラクタ
	 * @param altMethodKey AltMethodのname
	 * @param altMethodModels AltMethodPairのリスト
	 * @param parentModel クラスペア
	 */
	public ComponentMethodPairModel(AltMethod altMethodKey,
			List<ComponentMethodPairModel> altMethodModels,ComponentClassPairModel parentModel) {
		this.name = altMethodKey.getName();
		this.isAltSet = true;
		this.parentModel = parentModel;
		this.altMethodPairSets = altMethodModels;
		for(ComponentMethodPairModel model : altMethodModels){
			model.setAltParentMethodModel(this);
		}
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

	/**
	 * @return parentModel
	 */
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

	/**
	 * @return isAlt
	 */
	public boolean isAlt() {
		return isAlt;
	}

	/**
	 * @return isAltSet
	 */
	public boolean isAltSet() {
		return isAltSet;
	}

	/**
	 * @return isInvocationExist
	 */
	public boolean isInvocationExist(String name) {
		isInvocationExist = (javaMethodNode
				.selectSingleNode("MethodInvocation[@name='" + name + "']") != null);
		return isInvocationExist;
	}

	/**
	 * @return altMethodPairSets
	 */
	public List<ComponentMethodPairModel> getAltMethodPairSets() {
		return altMethodPairSets;
	}

	/**
	 * @return altParentMethodModel
	 */
	public ComponentMethodPairModel getAltParentMethodModel() {
		return altParentMethodModel;
	}

	/**
	 * @param altParentMethodModel セットする altParentMethodModel
	 */
	public void setAltParentMethodModel(
			ComponentMethodPairModel altParentMethodModel) {
		this.altParentMethodModel = altParentMethodModel;
	}

}
