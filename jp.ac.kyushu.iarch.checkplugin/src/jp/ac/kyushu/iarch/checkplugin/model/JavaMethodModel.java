/**
 *
 */
package jp.ac.kyushu.iarch.checkplugin.model;

import org.dom4j.Element;

/**
 * This class is java method model for type check.
 *
 * @author fukamachi
 * @param lineNumber
 *            The method's line number of java source code.
 * @param name
 *            The method's name
 */
public class JavaMethodModel {
	int lineNumber = 0;
	String name;
	Element methodElement = null;
	Element classElement = null;

	public JavaMethodModel(Element javaMethodElement) {
		// Constructor
		this.lineNumber = Integer.parseInt(javaMethodElement.attributeValue(
				"lineNumber").toString());
		this.name = javaMethodElement.attributeValue("name");
		this.methodElement = javaMethodElement;
		this.classElement = (Element)(javaMethodElement.getParent());	//really?
	}

	/**
	 * @return lineNumber
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return javaMethodElement
	 */
	public Element getJavaMethodElement(){
		return methodElement;
	}

}
