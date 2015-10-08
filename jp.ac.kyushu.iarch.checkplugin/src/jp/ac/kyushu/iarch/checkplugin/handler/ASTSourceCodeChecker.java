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
import jp.ac.kyushu.iarch.archdsl.archDSL.SuperCall;
import jp.ac.kyushu.iarch.archdsl.archDSL.UncertainBehavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.UncertainConnector;
import jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface;
import jp.ac.kyushu.iarch.checkplugin.model.BehaviorPairModel;
import jp.ac.kyushu.iarch.checkplugin.model.CallPairModel;
import jp.ac.kyushu.iarch.checkplugin.model.ComponentClassPairModel;
import jp.ac.kyushu.iarch.checkplugin.model.ComponentMethodPairModel;
import jp.ac.kyushu.iarch.checkplugin.ArchfaceMarkerResolutionGenerator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.eclipse.core.resources.IMarker;
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

public class ASTSourceCodeChecker{
	private List<ComponentClassPairModel> componentClassPairModels = new ArrayList<ComponentClassPairModel>();
	private List<BehaviorPairModel> behaviorPairModels = new ArrayList<BehaviorPairModel>();
	private List<BehaviorPairModel> uncertainBehaviorPairModels = new ArrayList<BehaviorPairModel>();


	public static String InsertPath;
	public static String InsertMethod;
	public static String InsertJavaCode;

	public void SourceCodeArchifileChecker(Model archiface,	IJavaProject project){
		long start = System.currentTimeMillis();
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
						final Element packgElement = rootElement.addElement("Package");
						packgElement.addAttribute("name", packg.getElementName());

						if (packg instanceof IPackageFragment){
							IPackageFragment packagefrag = (IPackageFragment) packg;
							for (ICompilationUnit file : packagefrag.getCompilationUnits()){
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
										classElement = packgElement.addElement(nodeType);
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

//										System.out.println("class name:" + className);
//										System.out.println("class Modifiers:" + classModifiersNum);
										return super.visit(node);
									}

									@Override
									public boolean visit(TypeDeclarationStatement node) {

										return super.visit(node);
									}

									@Override
									public boolean visit(MethodInvocation node) {

										// メソッド呼び出し元がない(クラスでの定数宣言など)場合はXMLに登録しない
										if(methodElement != null){
											Element methodInvocationElement = methodElement.addElement("MethodInvocation");
											methodInvocationElement.addAttribute("name", node.getName().toString());
											Element mEElement = methodInvocationElement.addElement("InvocationExpression");
//											System.out.println("Method Invocation:" + node.getName());
//											System.out.println("Method InvocationExpression:" + node.getExpression());
											if ((node.getExpression()) != null)
												mEElement.addText(node.getExpression().toString());
										}
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
										if(classElement != null){	// メソッドが定義されているクラスがない(抽象クラスなど)場合はXMLに登録しない
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
//											System.out.println("Method Define:" + node.getName());
										}
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


			// TODO リファクタリングでメソッド化されていないチェックを全て消去する
			Element root = codeXmlDocument.getRootElement();
			Element packageElement = (Element) root.selectSingleNode("//Package[@name='']");

			@SuppressWarnings("unchecked")
			List<Element> packageElements = root.selectNodes("Package");

			// pairModels Clear.
			pairModelsInit();

			// Interface check
			typeCheckInterface(archiface,packageElements);

			//component:warning
			List<Element> classNodes = packageElement.selectNodes("Class");
			for (Element javaCode : classNodes) {
				String javafileClassname=javaCode.attributeValue("name");
				IResource st2=javaFileIResource.getProject().getFile("/src/"+javafileClassname+".java");
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
			typeCheckBehavior(archiface);

			// Uncertain Behavior
			typeCheckUncertainBehavior(archiface);

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
							ProblemViewManager.addError1(st2, message, st2.getLocationURI().getPath() ,lineNumber);
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

			outputErrorMessages(javaFileIResource);
	}


	/**
	 * エラーメッセージ出力
	 * @param resource IResource型 リソース
	 */
	private void outputErrorMessages(IResource resource) {
		// tmp compile error output
		for (ComponentClassPairModel pairModel : componentClassPairModels) {
			if(pairModel.isExistJavaNode()){
//				ProblemViewManager.addInfo1(pairModel.getClassPath(resource), "Component :" + pairModel.getName()+" is defined",pairModel.getName(), Integer.parseInt(((Element) pairModel.getJavaClassNode()).attributeValue("lineNumber").toString()));
				for (ComponentMethodPairModel methodModel : pairModel.methodPairsList) {
					if(!methodModel.isAltSet()){
						if(methodModel.isExistJavaNode()){
//							ProblemViewManager.addInfo1(pairModel.getClassPath(resource), "Component :" + methodModel.getName()+" is defined",pairModel.getName(), Integer.parseInt(((Element) pairModel.getJavaClassNode()).attributeValue("lineNumber").toString()));
						}else{
							if(methodModel.isOpt()){
								ProblemViewManager.addWarning1(pairModel.getClassPath(resource),"OptComponent :" +  methodModel.getName()+" is not defined",pairModel.getName(), Integer.parseInt(((Element) pairModel.getJavaClassNode()).attributeValue("lineNumber").toString()));
							}else{
								ProblemViewManager.addError1(pairModel.getClassPath(resource),"Component :" +  methodModel.getName()+" is not defined",resource.getLocationURI().getPath() + "/src/" + pairModel.getName() + ".java", Integer.parseInt(((Element) pairModel.getJavaClassNode()).attributeValue("lineNumber").toString()));
							}
						}
					}else{
						boolean isError = true;
						for (ComponentMethodPairModel altMethod : methodModel.getAltMethodPairSets()) {
							if(altMethod.isExistJavaNode()){
//								ProblemViewManager.addInfo1(pairModel.getClassPath(resource),"AltComponent :" +  altMethod.getName() + " is not defined", pairModel.getName(), Integer.parseInt(((Element)pairModel.getJavaClassNode()).attributeValue("lineNumber").toString()));
								isError = false;	//AltMethodはひとつでも確立ができればOK
							}
						}
						if(isError){
							ProblemViewManager.addError1(pairModel.getClassPath(resource), "AltComponent : " + methodModel.getName()+" is not defined",pairModel.getName(), Integer.parseInt(((Element) pairModel.getJavaClassNode()).attributeValue("lineNumber").toString()));
						}
					}
				}
			}else{
				if(!pairModel.methodPairsList.isEmpty()){
					ProblemViewManager.addError1(pairModel.getClassPath(resource), "Component :" + pairModel.getArchInterface().getName() + " is not defined", pairModel.getArchInterface().getName(), 0);
				}else{
					ProblemViewManager.addWarning1(pairModel.getClassPath(resource), "Component :" + pairModel.getArchInterface().getName() + " is not defined", resource.getLocationURI().getPath() + "/src/" + pairModel.getArchInterface().getName() + ".java", 0);
				}
			}
		}

		for (BehaviorPairModel pairModel : behaviorPairModels) {
			List<CallPairModel> callModelList = pairModel.getCallModels();
			//ループを行う回数はコールの数 - 1
			for (int i = 0; (i < callModelList.size() - 1) && (callModelList.size() > 1); i++) {
				CallPairModel currentCallModel = callModelList.get(i);
				CallPairModel nextCallModel = callModelList.get(i+1);
				if(currentCallModel.getMethodModel().isInvocationExist(nextCallModel.getName())){
					ProblemViewManager.addInfo1(currentCallModel.getMethodModel().getParentModel().getClassPath(resource), "Connector - " + currentCallModel.getName() +" -> " + nextCallModel.getName() + " is defined", currentCallModel.getName(), Integer.parseInt(((Element)currentCallModel.getMethodModel().getJavaClassNode()).attributeValue("lineNumber").toString()));
				}else{
					ProblemViewManager.addError1(currentCallModel.getMethodModel().getParentModel().getClassPath(resource), "Connector - " + currentCallModel.getName() +" -> " + nextCallModel.getName() + " is not defined", currentCallModel.getName(), Integer.parseInt(((Element)currentCallModel.getMethodModel().getJavaClassNode()).attributeValue("lineNumber").toString()));
				}
			}
		}

		//TODO OptCallの処理を考える
		for(BehaviorPairModel pairModel : uncertainBehaviorPairModels){
			List<CallPairModel> callModelList = pairModel.getCallModels();
			//ループを行う回数はコールの数 - 1
			for (int i = 0; (i < callModelList.size() - 1) && (callModelList.size() > 1); i++) {
				CallPairModel currentCallModel = callModelList.get(i);
				CallPairModel nextCallModel = callModelList.get(i+1);
				List<ComponentMethodPairModel> currentMethodModels = new ArrayList<ComponentMethodPairModel>();
				List<ComponentMethodPairModel> nextMethodModels = new ArrayList<ComponentMethodPairModel>();

				currentMethodModels.add(currentCallModel.getMethodModel());
				if(currentCallModel.isAlt()){
					currentMethodModels.addAll(currentCallModel.getAltMethodPairSets());
				}
				nextMethodModels.add(nextCallModel.getMethodModel());
				if(nextCallModel.isAlt()){
					nextMethodModels.addAll(nextCallModel.getAltMethodPairSets());
				}
				for(ComponentMethodPairModel currentMethod: currentMethodModels){
					for(ComponentMethodPairModel nextMethod: nextMethodModels){
						if(currentMethod.isInvocationExist(nextMethod.getName())){
							ProblemViewManager.addInfo1(currentMethod.getParentModel().getClassPath(resource), "Connector - " + currentMethod.getName() +" -> " + nextMethod.getName() + " is defined", currentMethod.getName(), Integer.parseInt(((Element)currentMethod.getJavaClassNode()).attributeValue("lineNumber").toString()));
						}else{
							ProblemViewManager.addWarning1(currentMethod.getParentModel().getClassPath(resource), "Connector - " + currentMethod.getName() +" -> " + nextMethod.getName() + " is not defined", currentMethod.getName(), Integer.parseInt(((Element)currentMethod.getJavaClassNode()).attributeValue("lineNumber").toString()));
						}
					}
				}
			}
			}

		}


	/**
	 * Behaviorに記述されたメソッドの該当したメソッドの組み合わせのComponentMethodPairModelをコール順にListへ格納します．
	 * Behaviorの成立可否はComponentMethodPairModelのisInvocationExistによって判定します．
	 * @param archiface Archface全情報が入っているモデル
	 * @param packageElements パッケージ以下のDOM情報
	 */
	private void typeCheckBehavior(Model archiface) {
		for (jp.ac.kyushu.iarch.archdsl.archDSL.Connector connector : archiface.getConnectors()) {
			for (Behavior behavior : connector.getBehaviors()) {
				List<CallPairModel> callPairModels = new ArrayList<CallPairModel>();
				for(Method methodCall : behavior.getCall()){
					callPairModels.add(new CallPairModel(componentClassPairModels, methodCall));
				}
				behaviorPairModels.add(new BehaviorPairModel(behavior.getInterface().getName(),callPairModels));
			}
		}
	}

	private void typeCheckUncertainBehavior(Model archiface){
		for(UncertainConnector u_connector : archiface.getU_connectors()){
			for(UncertainBehavior u_behavior : u_connector.getU_behaviors()){
				List<CallPairModel> callPairModels = new ArrayList<CallPairModel>();
				for(SuperCall methodCall : u_behavior.getCall()){
					callPairModels.add(new CallPairModel(componentClassPairModels, (SuperCall) methodCall));
				}
				uncertainBehaviorPairModels.add(new BehaviorPairModel(u_behavior.getName(),callPairModels));
			}
		}
	}


	/**
	 * Archfaceと同じクラス，メソッド名をJavaソースコードから探し，ComponentClassPairModelへ格納します．
	 * @param archiface
	 * @param packageElements
	 */
	private void typeCheckInterface(Model archiface, List<Element> packageElements) {
		String archClassName = null;
		Node classNode =  null;
		ComponentClassPairModel classPairModel = null;
		Node methodNode = null;
		ComponentMethodPairModel methodPairModel = null;

		for (Interface archiclass : archiface.getInterfaces()) {
			archClassName = archiclass.getName();
			for(Element packageElement : packageElements){
				classNode =  packageElement.selectSingleNode("Class[@name='" + archClassName + "']");
				if(classNode != null){
					break;
				}
			}
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


	/**
	 * 不確かさを包容したComponentに対してのタイプチェックを行い、classPairModelを更新します。
	 * @param u_interfaces 不確かなComponentのリスト
	 * @param classPairModel 更新すべきComponentClassPairModelのリスト
	 */
	private void typeCheckUncertainInterface(
			EList<UncertainInterface> u_interfaces,ComponentClassPairModel classPairModel) {
		Interface superInterface = null;
		Node classNode = null;
		Node methodNode = null;
		ComponentMethodPairModel uncertainMethodPairModel = null;

		for (UncertainInterface u_interface :u_interfaces) {
			superInterface = u_interface.getSuperInterface();
			if(superInterface != null && classPairModel.isExistJavaNode()){	// if super-interface is not exist, type check should not be done.
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
	}


	private void pairModelsInit() {
		componentClassPairModels.clear();
		behaviorPairModels.clear();
	}

	public List<ComponentClassPairModel> getComponentClassPairModels() {
		return componentClassPairModels;
	}

	public List<BehaviorPairModel> getBehaviorPairModels() {
		return behaviorPairModels;
	}

	public void setBehaviorModels(List<BehaviorPairModel> pairModels){
		behaviorPairModels = pairModels;
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
