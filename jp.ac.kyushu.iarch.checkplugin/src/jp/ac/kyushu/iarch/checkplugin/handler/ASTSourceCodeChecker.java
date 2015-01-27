package jp.ac.kyushu.iarch.checkplugin.handler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import jp.ac.kyushu.iarch.archdsl.archDSL.AltMethod;
import jp.ac.kyushu.iarch.archdsl.archDSL.Behavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.archdsl.archDSL.OptMethod;
import jp.ac.kyushu.iarch.archdsl.archDSL.SuperMethod;
import jp.ac.kyushu.iarch.archdsl.archDSL.UncertainBehavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
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

public class ASTSourceCodeChecker{
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
			Element test = (Element) root.selectSingleNode("//Package[@name='']");
			@SuppressWarnings("unchecked")
			List<Element> javaClasses = test.selectNodes("Class");	//list of classes in java source code

			// Interface check
			for (Interface archiclass : archiface.getInterfaces()) {
				String className = archiclass.getName();
				for (Element a : javaClasses) {
					String className2 = a.attributeValue("name");
					int lineNumberClass=Integer.parseInt(a.attributeValue("lineNumber").toString());
					// pick the java methods into JavaMethodList
					if (className.equals(className2)) {
						IResource st2=javaFileIResource.getProject().getFile("/src/"+className+".java");
						ProblemViewManager.addInfo1(st2, "Interface-Class :" + className + " is defined", javaFileIResource.getName(),lineNumberClass);
						@SuppressWarnings("unchecked")
						List<Element> javaMethodList = a.selectNodes("MethodDeclaration");
						//Method check : m is arch method
						for (Method m : archiclass.getMethods()) {
							String methodname = m.getName();
							String methodname2 = null;
							boolean isExist = false;
							for (Element b : javaMethodList) {
								methodname2 = b.attributeValue("name");
								int lineNumberMethod=Integer.parseInt(b.attributeValue("lineNumber").toString());
								if (methodname2.equals(methodname)) {
									ProblemViewManager.addInfo1(st2, "Interface- Method : " + methodname+ " is defined", archiclass.getName(),lineNumberMethod);
									isExist = true;
									break;
								}
							}
							if (!isExist) {
								ProblemViewManager.addError1(st2, "Interface- Method :" + methodname + " is not defined", archiclass.getName(),lineNumberClass);
							}
						}
					}
				}
			}

			// UncertainInterface check

			for (UncertainInterface u_interface :archiface.getU_interfaces()) {
				Interface superInterface = u_interface.getSuperInterface();
				if(superInterface != null){
					IResource st2=javaFileIResource.getProject().getFile("/src/"+superInterface.getName()+".java");
					for (Element jc : javaClasses) {
						String javaClassName = jc.attributeValue("name");
						if(superInterface.getName().equals(javaClassName)){
							@SuppressWarnings("unchecked")
							List<Element> javaMethodList = jc.selectNodes("MethodDeclaration");
							int lineNumberClass = Integer.parseInt(jc.attributeValue("lineNumber").toString());

							//optmethods check
							for(OptMethod om : u_interface.getOptmethods()){
								String optMethodNameArch = om.getName();
								String optMethodNameJava = null;
								boolean isExist = false;
								// optmethods control
								for(Element jm : javaMethodList){
									optMethodNameJava = jm.attributeValue("name");
									int lineNumberOptMethod=Integer.parseInt(jm.attributeValue("lineNumber").toString());
									if (optMethodNameJava.equals(optMethodNameArch)) {
										ProblemViewManager.addInfo1(st2, "UncertainInterface- OptionMethod : " + optMethodNameArch + " is defined", superInterface.getName(),lineNumberOptMethod);
										isExist = true;
									}
								}
								
								if(!isExist){
									ProblemViewManager.addWarning1(st2, "UncertainInterface- OptionMethod : " + optMethodNameArch + " is not defined", superInterface.getName(), lineNumberClass);
								}
							}

							//altmethods check
							for (AltMethod am : u_interface.getAltmethods()) {
								List<String> altMethodNameArch = new ArrayList<String>();
								altMethodNameArch.add(am.getName());
								altMethodNameArch.addAll(am.getA_name());
								String altMethodNameJava = null;
								boolean isDefine = false;
								// altmethods control
								for (Element jm : javaMethodList) {
									altMethodNameJava = jm.attributeValue("name");
									int lineNumberAltMethod = Integer.parseInt(jm.attributeValue("lineNumber").toString());
									for (String s : altMethodNameArch) {
										if (altMethodNameJava.equals(s)) {
												ProblemViewManager.addInfo1(st2, "UncertainInterface- AlternativeMethod : " + s + " is defined", superInterface.getName(), lineNumberAltMethod);
												isDefine= true;
										}
									}
								}
								if(isDefine == false){
									String altmethodname_all = "";
									for(String s : altMethodNameArch){
										altmethodname_all += s+" ";
									}
									ProblemViewManager.addError1(st2,"UncertainInterface- AlternativeMethod : AlternativeMethod is not defined."
											+ " You can insert an AlternativeMethod in these methods : " + altmethodname_all , jc.getName(),lineNumberClass);
								}
							}
						}
					}
				}
			}

			// behaver
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
						classNode = test.selectSingleNode("Class[@name='" + classNameL + "']");
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
				String superInterfaceName = u_behavior.getInterface().getName();
				String lastClassName = ((Interface)u_behavior.getCall().get(0).eContainer()).getName();
				String lastMethodName = null;
				String outputMsg = null;
				
				if(superInterfaceName != null){
					for (SuperMethod methodCall : u_behavior.getCall()) {
						boolean isMethodInvocationExist = false;
						String typeOfCall = methodCall.getClass().getSimpleName();	//MethodImpl : Certain Method, OptMethodImpl : Optional Method
						String currentMethodName = methodCall.getName();
						if(currentMethodName == null)continue;	//for end of calls
						String currentClassName = null;
						if(typeOfCall.equals("MethodImpl")){
							currentClassName = ((Interface)methodCall.eContainer()).getName();
						}else if(typeOfCall == "OptMethodImpl"){
							currentClassName = ((UncertainInterface)methodCall.eContainer()).getSuperInterface().getName();
						}
						int lineNumber = 0;
						Node classNode = null;
						if(lastClassName != null){
							classNode = test.selectSingleNode("Class[@name='" + lastClassName + "']");
						}
						if(classNode==null)continue;
						if (lastMethodName != null) {
							Node methodDcl = classNode.selectSingleNode("MethodDeclaration[@name='" + lastMethodName + "']");
							isMethodInvocationExist = (methodDcl.selectSingleNode("MethodInvocation[@name='" + currentMethodName + "']") != null);
							lineNumber=Integer.parseInt(((Element) methodDcl).attributeValue("lineNumber").toString());
							if (!isMethodInvocationExist) {
								IResource st2=javaFileIResource.getProject().getFile("/src/"+lastClassName+".java");
								String errMsg = "Behavior  : " + uncertainInterfaceName + " :  " + lastClassName + "." + lastMethodName + " -> " + currentMethodName + " " + "is not defined.";
								if(typeOfCall.equals("MethodImpl")){
									ProblemViewManager.addError1(st2, errMsg, currentClassName,lineNumber);
								}else{
									ProblemViewManager.addWarning1(st2, errMsg, currentClassName, lineNumber);
									currentClassName = lastClassName;
									currentMethodName = lastMethodName;	/* return to certain method and class(This impl is temporary...)*/
								}
							}
						}
	
						if (isMethodInvocationExist) {
							outputMsg = "UncertainBehavior  : " + uncertainInterfaceName + " : " + lastClassName + "." + lastMethodName + " -> " + currentClassName + "." + currentMethodName;
						}
						if (outputMsg != null) {
							IResource st2=javaFileIResource.getProject().getFile("/src/"+lastClassName+".java");
							ProblemViewManager.addInfo1(st2, outputMsg, lastClassName,lineNumber);
						}
						lastClassName = currentClassName;
						lastMethodName = currentMethodName;						
					}
				}
			}
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