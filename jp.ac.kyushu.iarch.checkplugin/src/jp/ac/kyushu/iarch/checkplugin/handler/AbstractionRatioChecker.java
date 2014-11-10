package jp.ac.kyushu.iarch.checkplugin.handler;

import jp.ac.kyushu.iarch.archdsl.archDSL.Behavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.checkplugin.model.AbstractionRatio;
import jp.ac.kyushu.iarch.checkplugin.model.ArchfaceModel;

import org.w3c.dom.*;
import org.apache.xerces.parsers.DOMParser;
import org.eclipse.core.resources.IResource;
/**
 * Count number of Arch points, design points and program points.
 * @author Yamamoto
 * @version 1.0 by Templar
 *
 */
public class AbstractionRatioChecker extends AbstractionRatio {

	public void checkArchface(Model archface, IResource archfile) {
		int i_class_num = 0;
		int i_method_num = 0;
		int i_behavior_num = 0;
		int i_archpoint_num = 0;

		// count class
		for (Interface archiclass : archface.getInterfaces()) {
			i_class_num++;
			i_method_num += archiclass.getMethods().size();
		}

		// Set the number of classes.
		setClassNum(i_class_num);
		// Set the number of methods.
		setMethodNum(i_method_num);

		for (Behavior archclassBehavior : archface.getBehaviors()) {
			String previousInterfaceName = "";
			for (Method method : archclassBehavior.getCall()) {
				Interface nowInterface = (Interface) method.eContainer();
				if (nowInterface.getName().equals(previousInterfaceName)) {// 自分自身でmethodを呼んでいる場合
					i_behavior_num = i_behavior_num + 2;
				} else {
					i_behavior_num++;
					previousInterfaceName = nowInterface.getName();
				}
			}
		}
		setBehaviorNum(i_behavior_num);

		// archpoint数計算
		i_archpoint_num = getMethodNum() + getClassNum() + getBehaviorNum();
		// archpoint数set
		setArchpointNum(i_archpoint_num);
	}

	public void checkXml(IResource xml, Document xmldocument) {
		int i_class_num = 0;
		int i_method_num = 0;
		int i_invocation_point_num = 0;
		int xml_point = 0;
		// class カウント
		/*
		 * NodeList class_nodes = xmldocument.getElementsByTagName("Class"); int
		 * class_nodes_num = class_nodes.getLength(); for(int i = 0;i <
		 * class_nodes_num;i++){ Element xml_class =
		 * (Element)class_nodes.item(i); i_class_num++;
		 * ProblemViewManager.addInfo(xml,
		 * "[xml] class("+i_class_num+") "+xml_class.getAttribute("name"),
		 * "archface"); } setXmlClassNum(i_class_num);
		 * 
		 * //method カウント NodeList method_nodes =
		 * xmldocument.getElementsByTagName("MethodDeclaration"); int
		 * method_nodes_num = method_nodes.getLength(); for(int i = 0;i <
		 * method_nodes_num;i++){ Element xml_method =
		 * (Element)method_nodes.item(i); i_method_num++;
		 * ProblemViewManager.addInfo(xml,
		 * "[xml] method("+i_method_num+") "+xml_method.getAttribute("name"),
		 * "archface"); } setXmlMethodNum(i_method_num);
		 * 
		 * //method呼び出し NodeList invocation_nodes =
		 * xmldocument.getElementsByTagName("MethodInvocation"); int
		 * invocation_nodes_num = invocation_nodes.getLength(); for(int i = 0;i
		 * < invocation_nodes_num;i++){ Element xml_invocation =
		 * (Element)invocation_nodes.item(i); int j = i+1;
		 * ProblemViewManager.addInfo(xml,
		 * "[xml] methodinvocation("+j+") "+xml_invocation.getAttribute("name"),
		 * "archface");
		 * 
		 * i_invocation_point_num++; for(int k = 0;k < method_nodes_num;k++){
		 * Element xml_method = (Element)method_nodes.item(k);
		 * if(xml_invocation.
		 * getAttribute("name").equals(xml_method.getAttribute("name"))){
		 * i_invocation_point_num++; //自分のクラスのmethodの場合+1 break; } } }
		 * setXmlInvocationPointNum(i_invocation_point_num);
		 */
		// class カウント
		NodeList class_nodes = xmldocument.getElementsByTagName("Class");
		for (int i = 0; i < class_nodes.getLength(); i++) {
//			Element xml_class = (Element) class_nodes.item(i);
			i_class_num++;
			// method カウント
			NodeList class_methods = class_nodes.item(i).getChildNodes();
			for (int j = 0; j < class_methods.getLength(); j++) {
				if (class_methods.item(j).getNodeName()
						.equals("MethodDeclaration")) {
//					Element xml_method = (Element) class_methods.item(j);
					i_method_num++;
					// method invocation カウント
					NodeList method_invocations = class_methods.item(j)
							.getChildNodes();
					for (int k = 0; k < method_invocations.getLength(); k++) {
						if (method_invocations.item(k).getNodeName()
								.equals("MethodInvocation")) {
//							Element method_invocation = (Element) method_invocations
//									.item(k);
							i_invocation_point_num++;
							NodeList invocation_childs = method_invocations
									.item(k).getChildNodes();
							for (int l = 0; l < invocation_childs.getLength(); l++) {
								if (invocation_childs.item(l).getNodeName()
										.equals("InvocationExpression")) {
//									Element invocation_class = (Element) invocation_childs
//											.item(l);
								}
							}
						}
					}
				}
			}
		}
		setXmlClassNum(i_class_num);
		setXmlMethodNum(i_method_num);
		setXmlInvocationPointNum(i_invocation_point_num * 2);

		xml_point = getXmlClassNum() + getXmlMethodNum()
				+ getXmlInvocationPointNum();
		setXmlpointNum(xml_point);
		// ProblemViewManager.addInfo(xml,
		// "[xml] ProgramPoint is "+getXmlpointNum(), "archface");
	}

	public void calculateAbstractionRatio(IResource archifile) {
		if (getXmlpointNum() == 0) {
			// ProblemViewManager.addInfo(archifile,
			// "*** cant calculate AbstractionRatio ", "archface");
		} else {
			double x = (double) getArchpointNum() / getXmlpointNum();
			double i_abstraction_ratio = (double) 1 - x;
			setAbstractionRatio(i_abstraction_ratio);
			// ProblemViewManager.addInfo(archifile,
			// "*** AbstractionRatio is "+getAbstractionRatio(), "archface");
		}
	}

	private Document getCodeXml(IResource xml) {
		Document xmldocument = null;
		try {
			DOMParser parser = new DOMParser();
			parser.parse(xml.getLocation().toString());
			xmldocument = parser.getDocument();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmldocument;
	}

	public void execute(IResource archifile, IResource xml) {
		Model archiface = ArchfaceModel.getArchfaceModel(archifile);
		checkArchface(archiface, archifile);
		Document xmldocument = getCodeXml(xml);
		checkXml(xml, xmldocument);
		calculateAbstractionRatio(archifile);
	}
}
