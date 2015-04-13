package jp.ac.kyushu.iarch.checkplugin.model;

import java.util.ArrayList;
import java.util.List;

import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;

import org.dom4j.Element;
import org.dom4j.Node;
import org.eclipse.core.resources.IResource;

/**
 * Java class model for type check.
 * This "Class" is analyzed java source code by AST.
 * @author fukamachi
 * @param lineNumber The class's line number of java source code.
 * @param name The class's name
 * @param resourceFilePath The File path where is written the class.
 * @param methodList The methods' list in this class.
 */
public class JavaClassModel {
	int lineNumber = 0;
	String name;
	IResource projectPath;
	IResource resourceFilePath;
	List<Node> methodNodeList = new ArrayList<Node>();
	Element classModel = null;
	Interface archInterface = null;


	public JavaClassModel(Node javaClass, IResource projectPath) {
		// Constructor
		this.lineNumber = Integer.parseInt(((Element)javaClass).attributeValue("lineNumber").toString());
		this.name = ((Element)javaClass).attributeValue("name");
		this.projectPath = projectPath;
		this.resourceFilePath = projectPath.getProject().getFile("/src/" + ((Element)javaClass).attributeValue("name")+ ".java");
		this.methodNodeList = javaClass.selectNodes("MethodDeclaration");
		this.classModel = (Element)javaClass;
		this.archInterface = null;
	}

	/**
	 * @return lineNumber
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * @return archInterface
	 */
	public Interface getArchInterface() {
		return archInterface;
	}

	/**
	 * @param archInterface archInterfaceをセットします
	 */
	public void setArchInterface(Interface archInterface) {
		this.archInterface = archInterface;
	}

	public Element getJavaClassModel() {
		return classModel;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return resourceFilePath
	 */
	public IResource getResourceFilePath() {
		return resourceFilePath;
	}

	/**
	 * @return methodList
	 */
	public List<Node> getMethodNodeList() {
		return methodNodeList;
	}

	/**
	 * @return projectPath
	 */
	public IResource getProjectPath() {
		return projectPath;
	}

}
