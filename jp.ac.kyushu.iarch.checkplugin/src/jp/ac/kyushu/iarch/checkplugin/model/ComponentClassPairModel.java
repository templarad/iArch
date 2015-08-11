package jp.ac.kyushu.iarch.checkplugin.model;

import java.util.ArrayList;
import java.util.List;

import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;

import org.dom4j.Element;
import org.dom4j.Node;
import org.eclipse.core.resources.IResource;

/**
 * ArchfaceとJavaコードのXMLノードのペアを保存するためのモデル．
 * 子にメソッドのペアを持つ．
 * @author fukamachi
 *
 */
public class ComponentClassPairModel {

	private Interface archInterface = null;
	private Node javaClassNode = null;
	private boolean isExistJavaNode = false;
	private String name = null;
	private Node packageNode = null;
	public List<ComponentMethodPairModel> methodPairsList = new ArrayList<ComponentMethodPairModel>();

	public ComponentClassPairModel(Interface archInterface, Node javaClassNode) {
		this.archInterface = archInterface;
		this.javaClassNode = javaClassNode;
		this.name = archInterface.getName();
		this.packageNode = this.javaClassNode.getParent();
		if (javaClassNode != null) {
			this.isExistJavaNode = true;
		}
	}

	public boolean overrideMethodPairModel(ComponentMethodPairModel newModel) {
		for (ComponentMethodPairModel methodPairModel : methodPairsList) {
			if (newModel.isAltSet()) {
				// If model is altset, simply, remove same methods, and add altset model.
				for (ComponentMethodPairModel altMethodModel : newModel.getAltMethodPairSets()) {
					if(altMethodModel.getName().equals(methodPairModel.getName())){
						methodPairsList.remove(methodPairModel);
					}
				}
			} else {
				if (newModel.getArchMethod().getName()
						.equals(methodPairModel.getArchMethod().getName())) {
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

	public IResource getClassPath(IResource resource){
		IResource src;
		if(!this.packageNode.getName().equals("")){
			src = resource.getProject().getFile("/src/"+ ((Element)packageNode).attributeValue("name").toString() + "/" + this.getName() +".java");
		}else{
			src = resource.getProject().getFile("/src/"+ this.getName() +".java");
		}
		if(src == null){
			src = resource;
		}
		return src;
	}

}
