package jp.ac.kyushu.iarch.checkplugin.handler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import jp.ac.kyushu.iarch.archdsl.archDSL.Behavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.checkplugin.ArchfaceMarkerResolutionGenerator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
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

	public static String InsertPath;
	public static String InsertMethod;
	public static String InsertJavaCode;
//	
//	public static List<String> InserPathList;
//	public static List<String> InsertMethodList;
//	public static List<String> InsertJavaCodeList;
	
	public void SourceCodeArchifileChecker(Model archiface,	IJavaProject project){
	
		Document codeXmlDocument = DocumentHelper.createDocument();
		 ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setProject(project);
		IResource st = null;
	
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
								st = file.getResource();
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
			Element root = codeXmlDocument.getRootElement();
			Element test = (Element) root.selectSingleNode("//Package[@name='']");
			List<Element> testClass = test.selectNodes("Class");
			// }
			
			
			
			//component
			for (Interface archiclass : archiface.getInterfaces()) {
				String className = archiclass.getName();
				for (Element a : testClass) {
					String className2 = a.attributeValue("name");
					int lineNumberClass=Integer.parseInt(a.attributeValue("lineNumber").toString());
					if (className.equals(className2)) {
						IResource st2=st.getProject().getFile("/src/"+className+".java");
						ProblemViewManager.addInfo1(st2, "Interface-Class :" + className + " is Exist", st.getName(),lineNumberClass);
						@SuppressWarnings("unchecked")
						List<Element> methodList = a.selectNodes("MethodDeclaration");
						for (Method m : archiclass.getMethods()) {
							String methodname = m.getName();
							
							String methodname2 = null;
							boolean flag = false;
							
							for (Element b : methodList) {
								methodname2 = b.attributeValue("name");
								int lineNumberMethod=Integer.parseInt(b.attributeValue("lineNumber").toString());
								if (methodname2.equals(methodname)) {
									ProblemViewManager.addInfo1(st2, "Interface- Method : " + methodname+ " is Exist", archiclass.getName(),lineNumberMethod);
									flag = true;
								}
							}
							if (!flag) {
								ProblemViewManager.addError1(st2, "Interface- Method :" + methodname + " is not defined", st2.getProject().getRawLocationURI().getPath() + "/src/" + archiclass.getName()+".java",lineNumberClass);
								
							}
						}
					}
				}
			}
			//component:warning
			for (Element javaCode : testClass) {
				String javafileClassname=javaCode.attributeValue("name");
				IResource st2=st.getProject().getFile("/src/"+javafileClassname+".java");
				int lineNumberClass=Integer.parseInt(javaCode.attributeValue("lineNumber").toString());
					for(Interface archiclass : archiface.getInterfaces()){
						String ArchClassname = archiclass.getName();
							if(ArchClassname.equals(javafileClassname)){
								List<Element> methodList = javaCode.selectNodes("MethodDeclaration");
								for (Element javaCodemethod : methodList){
									String javacodemethodname = javaCodemethod.attributeValue("name");
									int lineNumberMethod=Integer.parseInt(javaCodemethod.attributeValue("lineNumber").toString());
									boolean flag = false;
										for (Method archmethod : archiclass.getMethods()){
											String Archmethodname=archmethod.getName();
											if(Archmethodname.equals(javacodemethodname)){
												flag = true;
											}
										}
											if(!flag){
												
												ProblemViewManager.addWarning1(st2, "JavaCode- Method :"+javacodemethodname+" is not in the Archface", st2.getProject().getLocationURI().getPath() + "/src/" + javafileClassname + ".java", lineNumberMethod);
											}
										}
								}
							}
					
					}
				
				
			
			// behaver
			for (Behavior behavior : archiface.getBehaviors()) {

				String interNameString = behavior.getInterface().getName();
				String methodNameLaString = null;
				String classNameL = ((Interface)behavior.getCall().get(0).eContainer()).getName();
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
							IResource st2=st.getProject().getFile("/src/"+classNameL+".java");
							String message = "Behavior  : " + interNameString + " :  " + classNameL + "." + methodNameLaString + " : " + methodName + " " + "is not defined";
							
							IMarker marker = ProblemViewManager.addError1(st2, message, st2.getProject().getRawLocationURI().getPath() + "/src/" + classNameString+".java",lineNumber);
							ArchfaceMarkerResolutionGenerator archfaceErrorResolution = new ArchfaceMarkerResolutionGenerator();
							archfaceErrorResolution.getResolutions(marker);
							
//							InserPathList.add("/src/"+classNameL+".java");
//							InsertMethodList.add(methodNameLaString);
//							InsertJavaCodeList.add(methodName);
//							
//							InsertPath="/src/"+classNameL+".java";
//							InsertMethod=methodNameLaString;
//							InsertJavaCode=methodName;
						}
					}

					if (flag2) {
						outString = "Behavior  : " + interNameString + " : " + classNameL + "." + methodNameLaString + " ->" + classNameString + "." + methodName;
					
					}
					if (outString != null) {
						IResource st2=st.getProject().getFile("/src/"+classNameL+".java");
						ProblemViewManager.addInfo1(st2, outString, classNameL,lineNumber);
					}
					classNameL = classNameString;
					methodNameLaString = methodName;	
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
			modifier = " protective";
		if (ModifiersNum == 8)
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

