package jp.ac.kyushu.iarch.checkplugin.handler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import jp.ac.kyushu.iarch.archdsl.archDSL.AltCall;
import jp.ac.kyushu.iarch.archdsl.archDSL.AltMethod;
import jp.ac.kyushu.iarch.archdsl.archDSL.Behavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.archdsl.archDSL.OptMethod;
import jp.ac.kyushu.iarch.archdsl.archDSL.SuperCall;
import jp.ac.kyushu.iarch.archdsl.archDSL.SuperMethod;
import jp.ac.kyushu.iarch.archdsl.archDSL.UncertainBehavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface;
import jp.ac.kyushu.iarch.checkplugin.model.BehaviorPairModel;
import jp.ac.kyushu.iarch.checkplugin.model.ComponentClassPairModel;
import jp.ac.kyushu.iarch.checkplugin.model.ComponentMethodPairModel;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclarationStatement;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

import behavior.Connector;

public class ASTSourceCodeChecker{
	private List<ComponentClassPairModel> componentClassPairModels = new ArrayList<ComponentClassPairModel>();
	private List<BehaviorPairModel> behaviorPairModels = new ArrayList<BehaviorPairModel>();

	public void SourceCodeArchifileChecker(Model archiface,	IJavaProject project){

		Document codeXmlDocument = DocumentHelper.createDocument();
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setProject(project);
		IResource javaFileIResource = null;
		// read javafiles and write its info on codeXML.xml
		try {

			String projectName = project.getElementName();

			Element rootElement = codeXmlDocument.addElement("Project");
			rootElement.addAttribute("name", projectName);
			for (IJavaElement element : project.getChildren()) {
				if (element instanceof IPackageFragmentRoot) {

					for (IJavaElement packg : ((IPackageFragmentRoot) element).getChildren()) {

						// element
						final Element pageElement = rootElement.addElement("Package");
						pageElement.addAttribute("name", packg.getElementName());

						if (packg instanceof IPackageFragment)

						{
							IPackageFragment packagefrag = (IPackageFragment) packg;
							for (ICompilationUnit file : packagefrag.getCompilationUnits())

							{
								parser.setSource(file);
								javaFileIResource = file.getResource();
								ASTNode rootnode = parser.createAST(null);
								final CompilationUnit result = (CompilationUnit)rootnode;
								rootnode.accept(new ASTVisitor(true) {
									Element methodElement;
									Element classElement;

									@Override
									public boolean visit(TypeDeclaration node) {
										String nodeType;

										if (node.isInterface() == true) {
											nodeType = "Interface";

										} else {
											nodeType = "Class";
										}
										classElement = pageElement.addElement(nodeType);
										String className = node.getName().toString();
										classElement.addAttribute("name", className);

										List classInterface = node.superInterfaceTypes();
										if (node.isInterface() != true) {
											for (Iterator iterator = classInterface.iterator(); iterator.hasNext();) {
												Type type = (Type) iterator.next();
												Element superInterfaceElement = classElement.addElement("superInterfaceTypes");
												superInterfaceElement.addText(type.toString());
											}
										}
										int lineNumber = result.getLineNumber(node.getStartPosition());
										classElement.addAttribute("lineNumber", String.valueOf(lineNumber));
										int classModifiersNum = node.getModifiers();
										Element modifiersElement = classElement.addElement("ClassModifiers");
										List<String> modifiers = returnModifiers(classModifiersNum);
										for (String str : modifiers) {
											Element modifierElement = modifiersElement.addElement("modifier");
											modifierElement.setText(str);
										}

										System.out.println("class name:" + className);
										System.out.println("class Modifiers:" + classModifiersNum);
										return super.visit(node);
									}

									@Override
									public boolean visit(TypeDeclarationStatement node) {

										return super.visit(node);
									}

									@Override
									public boolean visit(MethodInvocation node) {

										Element methodInvocationElement = methodElement.addElement("MethodInvocation");
										methodInvocationElement.addAttribute("name", node.getName().toString());
										Element mEElement = methodInvocationElement.addElement("InvocationExpression");
										System.out.println("Method Invocation:" + node.getName());
										System.out.println("Method InvocationExpression:" + node.getExpression());
										if ((node.getExpression()) != null)
											mEElement.addText(node.getExpression().toString());

										return super.visit(node);
									}

									// MethodDeclaration
									@Override
									public boolean visit(MethodDeclaration node) {

										String methodName = node.getName().toString();
										Type returnType = node.getReturnType2();
										String methodReturnType;
										if (returnType != null) {
											methodReturnType = returnType.toString();
										} else {
											methodReturnType = "";
										}

										int methodModifiersNum = node.getModifiers();
										// MethodDeclaration
										methodElement = classElement.addElement("MethodDeclaration");
										int lineNumber = result.getLineNumber(node.getStartPosition()) ;
										methodElement.addAttribute("lineNumber", String.valueOf(lineNumber));
										methodElement.addAttribute("name", methodName);
										// Modifiers of
										// MethodDeclaration
										Element modifiersElement = methodElement.addElement("MethodModifiers");
										List<String> modifiers = returnModifiers(methodModifiersNum);
										if (methodReturnType.equals("void") && (!(modifiers.get(0).toString().equals("void"))))
											modifiers.add("void");
										for (String str : modifiers) {
											Element modifierElement = modifiersElement.addElement("modifier");
											modifierElement.setText(str);
										}
										// method parameterType
										if (node.parameters().size() != 0) {
											List<SingleVariableDeclaration> methodParameters = node.parameters();
											Element parameterTypeElement = methodElement.addElement("parameterTypeElement");
											for (SingleVariableDeclaration methodParameter : methodParameters) {
												String fType = methodParameter.toString().split(" ")[0];
												Element parameterType = parameterTypeElement.addElement("parameterType");
												parameterType.setText(fType);
											}
										}

										// method return type
										if (!methodReturnType.equals("void")) {
											Element returnTypeElement = methodElement.addElement("returnType");
											returnTypeElement.setText(methodReturnType);
										}
										System.out.println("Method Define:" + node.getName());
										return super.visit(node);
									}
								});

							}//
						}
					}

				}
			}

			try {
				OutputFormat format = OutputFormat.createPrettyPrint();
				String projectPath = project.getProject().getLocation().toOSString();
				XMLWriter output = new XMLWriter(new FileWriter(new File(projectPath + "/codeXML.xml")), format);
				codeXmlDocument.setXMLEncoding("utf-8");
				output.write(codeXmlDocument);
				output.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			//check with archface
			Element root = codeXmlDocument.getRootElement();
			Element packageElement = (Element) root.selectSingleNode("//Package[@name='']");
			@SuppressWarnings("unchecked")
			List<Element> javaClasses = packageElement.selectNodes("Class");	//list of classes in java source code

			// pairModels Clear.
			pairModelsInit();

			// Interface check
			typeCheckInterface(archiface,packageElement);

			// behaver
			typeCheckBehavior(archiface,packageElement);

			for (Behavior behavior : archiface.getBehaviors()) {

				String interNameString = behavior.getInterface().getName();
				String methodNameLaString = null;
				String classNameL = ((Interface)behavior.getCall().get(0).eContainer()).getName();	//First LastClass is defined first Method's Class
				String outString = null;
				for (Method methodCall : behavior.getCall()) {
					boolean flag2 = false;

					String methodName = methodCall.getName();
					if(null==methodName)continue;//add by AiDi
					String classNameString = ((Interface) methodCall.eContainer()).getName();
					int lineNumber=0;
					Node classNode = null;
					if (classNameL != null) {
						classNode = packageElement.selectSingleNode("Class[@name='" + classNameL + "']");
					}
					if(classNode==null)continue;//add by AiDi
					if (methodNameLaString != null) {
						Node methodDcl = classNode.selectSingleNode("MethodDeclaration[@name='" + methodNameLaString + "']");
						flag2 = (methodDcl.selectSingleNode("MethodInvocation[@name='" + methodName + "']") != null);
						 lineNumber=Integer.parseInt(((Element) methodDcl).attributeValue("lineNumber").toString());
						if (!flag2) {
							IResource st2=javaFileIResource.getProject().getFile("/src/"+classNameL+".java");
							String message = "Behavior  : " + interNameString + " :  " + classNameL + "." + methodNameLaString + " : " + methodName + " " + "is not defined";
							ProblemViewManager.addError1(st2, message, classNameString,lineNumber);
						}
					}

					if (flag2) {
						outString = "Behavior  : " + interNameString + " : " + classNameL + "." + methodNameLaString + " ->" + classNameString + "." + methodName;
					}
					if (outString != null) {
						IResource st2=javaFileIResource.getProject().getFile("/src/"+classNameL+".java");
						ProblemViewManager.addInfo1(st2, outString, classNameL,lineNumber);
					}
					classNameL = classNameString;
					methodNameLaString = methodName;
				}
			}




			//Uncertain Behaviors Check
			for (UncertainBehavior u_behavior : archiface.getU_behaviors()) {
				String uncertainInterfaceName = u_behavior.getName();
				String superInterfaceName = u_behavior.getSuperInterface().getName();
				if(superInterfaceName != null){
					String lastClassName = null;
					if(u_behavior.getCall().get(0).getName().getClass().getSimpleName().equals("MethodImpl")){
						lastClassName = ((Interface)u_behavior.getCall().get(0).getName().eContainer()).getName();
					}else{
						lastClassName = ((UncertainInterface)u_behavior.getCall().get(0).getName().eContainer()).getSuperInterface().getName();
					}
					String lastMethodName = null;
					String lastTypeOfMethod = null;

					for (SuperCall methodCall : u_behavior.getCall()) {
						boolean isMethodInvocationExist = false;
						String typeOfCall = methodCall.getClass().getSimpleName();// CertainCallImpl,OptCallImpl,AltCallImpl
						String typeOfMethod = methodCall.getName().getClass().getSimpleName();	//MethodImpl : Certain Method, OptMethodImpl : Optional Method
						int lineNumber = 0;
						Node classNode = null;
						String currentClassName = null;
						String currentMethodName = methodCall.getName().getName();
						String outputMsg = null;

						if(currentMethodName == null)continue;	//for end of calls
						if(lastClassName != null){
							classNode = packageElement.selectSingleNode("Class[@name='" + lastClassName + "']");
						}
						if(classNode==null)continue;
						if(typeOfMethod.equals("MethodImpl")){
							currentClassName = ((Interface)methodCall.getName().eContainer()).getName();
						}else if(typeOfMethod.equals("OptMethodImpl")){
							currentClassName = ((UncertainInterface)methodCall.getName().eContainer()).getSuperInterface().getName();
						}
						if (lastMethodName != null) {
							Node methodDcl = classNode.selectSingleNode("MethodDeclaration[@name='" + lastMethodName + "']");
							IResource st2=javaFileIResource.getProject().getFile("/src/"+lastClassName+".java");
							if(methodDcl == null){
								ProblemViewManager.addWarning1(st2, lastMethodName + " is not implemented, so this connector can't check.", currentClassName, lineNumber);
								continue;
							}
							isMethodInvocationExist = (methodDcl.selectSingleNode("MethodInvocation[@name='" + currentMethodName + "']") != null);
							lineNumber=Integer.parseInt(((Element) methodDcl).attributeValue("lineNumber").toString());
							if (!isMethodInvocationExist) {
								String errMsg = "Behavior  : " + uncertainInterfaceName + " :  " + lastClassName + "." + lastMethodName + " -> " + currentMethodName + " " + "is not defined.";
								if(typeOfCall.equals("CertainCallImpl")){
									if(!lastTypeOfMethod.equals("OptMethodImpl")){
										ProblemViewManager.addError1(st2, errMsg, currentClassName,lineNumber);
									}
								}else if(typeOfCall.equals("OptCallImpl")){
									ProblemViewManager.addWarning1(st2, errMsg, currentClassName, lineNumber);
									currentClassName = lastClassName;
									currentMethodName = lastMethodName;	/* return to certain method and class(This impl is temporary...)*/
								}else if(typeOfCall.equals("AltCallImpl")){
									AltCall altCall = (AltCall)methodCall;
									for (SuperMethod altMethod : altCall.getA_name()) {// altMethodCallに書かれている2つ目以降のMethodのチェック
										typeOfMethod = altMethod.getClass().getSimpleName();
										if(typeOfMethod.equals("MethodImpl")){
											currentClassName = ((Interface)altMethod.eContainer()).getName();
										}else if(typeOfMethod.equals("OptMethodImpl")){
											currentClassName = ((UncertainInterface)altMethod.eContainer()).getSuperInterface().getName();
										}
										currentMethodName = altMethod.getName();
										isMethodInvocationExist = (methodDcl.selectSingleNode("MethodInvocation[@name='" + currentMethodName + "']") != null);
										if(isMethodInvocationExist)	break;
									}
									if(altCall.isOpt() && !isMethodInvocationExist){
										currentClassName = lastClassName;
										currentMethodName = lastMethodName;	/* return to certain method and class(This impl is temporary...)*/
									}
								}
							}
						}

						if (isMethodInvocationExist) {
							if(!currentMethodName.equals(lastMethodName)){
								outputMsg = "UncertainBehavior  : " + uncertainInterfaceName + " : " + lastClassName + "." + lastMethodName + " -> " + currentClassName + "." + currentMethodName;
							}
						}
						if (outputMsg != null) {
							IResource st2=javaFileIResource.getProject().getFile("/src/"+lastClassName+".java");
							ProblemViewManager.addInfo1(st2, outputMsg, lastClassName,lineNumber);
						}
						lastClassName = currentClassName;
						lastMethodName = currentMethodName;
						lastTypeOfMethod = typeOfMethod;
					}
				}
			}

			ouputErrorMessages(javaFileIResource);

	}


	private void ouputErrorMessages(IResource resource) {
		// tmp compile error output
		for (ComponentClassPairModel pairModel : componentClassPairModels) {
			if(pairModel.isExistJavaNode()){
				ProblemViewManager.addInfo1(resource, pairModel.getName()+" is defined",pairModel.getName(), Integer.parseInt(((Element) pairModel.getJavaClassNode()).attributeValue("lineNumber").toString()));
				for (ComponentMethodPairModel methodModel : pairModel.methodPairsList) {
					if(!methodModel.isAltSet()){
						if(methodModel.isExistJavaNode()){
							ProblemViewManager.addInfo1(resource, methodModel.getName()+" is defined",pairModel.getName(), Integer.parseInt(((Element) pairModel.getJavaClassNode()).attributeValue("lineNumber").toString()));
						}else{
							if(methodModel.isOpt()){
								ProblemViewManager.addWarning1(resource, methodModel.getName()+" is not defined",pairModel.getName(), Integer.parseInt(((Element) pairModel.getJavaClassNode()).attributeValue("lineNumber").toString()));
							}else{
								ProblemViewManager.addError1(resource, methodModel.getName()+" is not defined",pairModel.getName(), Integer.parseInt(((Element) pairModel.getJavaClassNode()).attributeValue("lineNumber").toString()));
							}
						}
					}else{
						boolean isError = true;
						for (ComponentMethodPairModel altMethod : methodModel.getAltMethodPairSets()) {
							if(altMethod.isExistJavaNode()){
								ProblemViewManager.addInfo1(resource, altMethod.getName() + " is not defined", pairModel.getName(), Integer.parseInt(((Element)pairModel.getJavaClassNode()).attributeValue("lineNumber").toString()));
								isError = false;	//AltMethodはひとつでも確立ができればOK
							}
						}
						if(isError){
							ProblemViewManager.addError1(resource, "Component - AltMethod: " + methodModel.getName()+" is not defined",pairModel.getName(), Integer.parseInt(((Element) pairModel.getJavaClassNode()).attributeValue("lineNumber").toString()));
						}
					}
				}
			}else{
				ProblemViewManager.addError1(resource, pairModel.getArchInterface().getName()+" is not defined",pairModel.getArchInterface().getName(), 0);
			}
		}

	}


	/**
	 * Behaviorに記述されたメソッドの該当したメソッドの組み合わせのComponentMethodPairModelをListへ格納します．
	 * Behaviorの成立可否はComponentMethodPairModelのisInvocationExistによって判定します．
	 * @param archiface
	 * @param packageElement
	 */
	private void typeCheckBehavior(Model archiface, Element packageElement) {
		ComponentClassPairModel classPairModel = null;
		List<ComponentMethodPairModel> methodPairModels = new ArrayList<ComponentMethodPairModel>();
		for (jp.ac.kyushu.iarch.archdsl.archDSL.Connector connector : archiface.getConnectors()) {
			for (Behavior behavior : connector.getBehaviors()) {
				for (ComponentClassPairModel cm : componentClassPairModels) {
					if(behavior.getInterface().equals(cm.getName())){
						classPairModel = cm;
						break;
					}
				}
				if(classPairModel != null){
					for (Method methodCall : behavior.getCall()) {
						for (ComponentMethodPairModel methodModel : classPairModel.methodPairsList) {
							if(methodCall.getName().equals(methodModel.getName())){
								methodPairModels.add(methodModel);
								break;
							}
						}
						System.out.println(methodCall.getName() + " is inserted");
					}
					behaviorPairModels.add(new BehaviorPairModel(classPairModel, methodPairModels));
				}
			}
		}
	}


	/**
	 * Archfaceと同じクラス，メソッド名をJavaソースコードから探し，ComponentClassPairModelへ格納します．
	 * @param archiface
	 * @param packageElement
	 */
	private void typeCheckInterface(Model archiface,
			Element packageElement) {
		String archClassName = null;
		Node classNode =  null;
		ComponentClassPairModel classPairModel = null;
		Node methodNode = null;
		ComponentMethodPairModel methodPairModel = null;

		for (Interface archiclass : archiface.getInterfaces()) {
			archClassName = archiclass.getName();
			classNode =  packageElement.selectSingleNode("Class[@name='" + archClassName + "']");
			classPairModel = new ComponentClassPairModel(archiclass, classNode);
			if(classNode != null){
				for (Method archimethod : archiclass.getMethods()) {
					methodNode = classNode.selectSingleNode("MethodDeclaration[@name='" + archimethod.getName() + "']");
					methodPairModel = new ComponentMethodPairModel(archimethod, methodNode,classPairModel);
					// Insert Method Model to class Pair Model
					classPairModel.methodPairsList.add(methodPairModel);
				}
			}
			// uncertain check
			typeCheckUncertainInterface(archiface.getU_interfaces(), classPairModel);
			// Insert Pair Model to static model
			componentClassPairModels.add(classPairModel);
		}
	}


	private ComponentClassPairModel typeCheckUncertainInterface(
			EList<UncertainInterface> u_interfaces,ComponentClassPairModel classPairModel) {
		Interface superInterface = null;
		Node classNode = null;
		Node methodNode = null;
		ComponentMethodPairModel uncertainMethodPairModel = null;

		for (UncertainInterface u_interface :u_interfaces) {
			superInterface = u_interface.getSuperInterface();
			if(superInterface != null){	// if super-interface is not exist, type check should not be done.
				classNode = classPairModel.getJavaClassNode();
				if(((Element)classNode).attributeValue("name").equals(superInterface.getName())){	// this means the class defined by super-interface is exist in java code.
					//optmethods check
					for(OptMethod o_method : u_interface.getOptmethods()){
						methodNode = classNode.selectSingleNode("MethodDeclaration[@name='" + o_method.getName() + "']");
						uncertainMethodPairModel = new ComponentMethodPairModel(o_method, methodNode,classPairModel);
						// insert or override OptMethodPairModel
						classPairModel.overrideMethodPairModel(uncertainMethodPairModel);
					}

					//altmethods check
					for (AltMethod a_method : u_interface.getAltmethods()) {
						List<String> altArchMethodNames = new ArrayList<String>();
						List<ComponentMethodPairModel> altMethodPairModels = new ArrayList<ComponentMethodPairModel>();

						altArchMethodNames.add(a_method.getName());
						altArchMethodNames.addAll(a_method.getA_name());

						for (String altMethodName : altArchMethodNames) {
							methodNode = classNode.selectSingleNode("MethodDeclaration[@name='" + altMethodName + "']");
							uncertainMethodPairModel = new ComponentMethodPairModel(a_method, altMethodName, methodNode, classPairModel);
							altMethodPairModels.add(uncertainMethodPairModel);
						}
						uncertainMethodPairModel = new ComponentMethodPairModel(a_method, altMethodPairModels, classPairModel);
						// insert or override AltMethodPairModel
						classPairModel.overrideMethodPairModel(uncertainMethodPairModel);
					}
				}
			}
		}
		return classPairModel;
	}


	private void pairModelsInit() {
		componentClassPairModels.clear();
	}

	public List<ComponentClassPairModel> getComponentClassPairModels() {
		return componentClassPairModels;
	}

	public List<BehaviorPairModel> getBehaviorPairModels() {
		return behaviorPairModels;
	}

	private List<String> returnModifiers(int ModifiersNum) {
		// It is not all
		List<String> modifiers = new LinkedList<String>();
		String modifier = null;
		if (ModifiersNum == 0)
			modifier = "void";
		if (ModifiersNum == 1)
			modifier = " public";
		if (ModifiersNum == 2)
			modifier = " private";
		if (ModifiersNum == 4)
			if (ModifiersNum == 8)
			modifier = " protective";
			modifier = " static";
		if (ModifiersNum == 0x00000010)
			modifier = " final";
		if (ModifiersNum == 0x00000020)
			modifier = "synchronized";
		if (ModifiersNum == 0x00000040)
			modifier = "  volatile";

		if (ModifiersNum == 0x00000080)
			modifier = " transient";
		if (ModifiersNum == 0x00000100)
			modifier = " native";
		if (ModifiersNum == 0x00000200)
			modifier = "interface";
		if (ModifiersNum == 0x00000400)
			modifier = " abstract";
		if (ModifiersNum == 0x00000800)
			modifier = "strict";
		if (modifier != null)
			modifiers.add(modifier);
		if (ModifiersNum == 9) {
			modifiers.add(" public");
			modifiers.add("  static");
		}

		if (ModifiersNum == 2)
			modifier = " private";
		if (ModifiersNum == 4)
			modifier = " protective";
		if (ModifiersNum == 4)
			modifier = " protective";

		return modifiers;
	}



}