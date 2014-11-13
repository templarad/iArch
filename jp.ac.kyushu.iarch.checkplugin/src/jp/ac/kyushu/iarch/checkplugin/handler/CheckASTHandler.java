package jp.ac.kyushu.iarch.checkplugin.handler;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.jdt.core.ICompilationUnit;
import jp.ac.kyushu.iarch.archdsl.ArchDSLPlugin;
import jp.ac.kyushu.iarch.archdsl.archDSL.Behavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.archdsl.ui.internal.ArchDSLActivator;
import jp.ac.kyushu.iarch.checkplugin.view.SelectArchfile;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclarationStatement;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.Injector;

public class CheckASTHandler implements IHandler {
	final private static Injector injector = ArchDSLActivator.getInstance().getInjector(ArchDSLPlugin.getLanguageName());

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {}

	@Override
	public void dispose() {}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		IResource st = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;

			if (ssel.getFirstElement() instanceof IJavaProject) {
				IJavaProject project = (IJavaProject) ssel.getFirstElement();
				Document codeXmlDocument = DocumentHelper.createDocument();
				 ASTParser parser = ASTParser.newParser(AST.JLS4);
				parser.setProject(project);
				parser.setResolveBindings(true);

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
										parser.setResolveBindings(true);
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
												if ((node.getExpression()) != null){
												ITypeBinding binding = node.getExpression().resolveTypeBinding();
												
												 if (binding != null) {
															 methodInvocationElement.addAttribute("type",  binding.getName());
															 System.out.println("type :" + binding.getName());
						                            }
												 }
												IMethodBinding binding2 = node.resolveMethodBinding();
					                            if (binding2!= null) {
					                                ITypeBinding type = binding2.getDeclaringClass();
					                                if (type != null) {
					                                	methodInvocationElement.addAttribute("class",  type.getName());
					                                	System.out.println("class :" + type.getName());
					                                }
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
				IProject project2 = project.getProject();

				SelectArchfile dialog = new SelectArchfile(HandlerUtil.getActiveShell(event), project2);
				if (dialog.open() == MessageDialog.OK) {
					ProblemViewManager.removeAllProblems(project2);
					// interface
					Model archiface = getArchifaceModel(dialog.getArchiface());
					// root
					Element root = codeXmlDocument.getRootElement();
					Element test = (Element) root.selectSingleNode("//Package[@name='']");
					List<Element> testClass = test.selectNodes("Class");
					// list = root.selectNodes("Project/Package[2]");
					// List<Element> elementList = root.elements();
					// List<Element>
					// xmlProject=root.selectNodes("//Project/Package");
					// for(Element a:elementList)
					// {

					// System.out.println(a.getName());
					// }

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
										ProblemViewManager.addError1(st2, "Interface- Method :" + methodname + " is not  Exist", archiclass.getName(),lineNumberClass);
									}
								}
							}
						}
					}
					// behaver
					for (Behavior behavior : archiface.getBehaviors()) {

						String interNameString = behavior.getInterface().getName();
						String methodNameLaString = null;
						String classNameL = null;
						String outString = null;
						for (Method methodCall : behavior.getCall()) {
							boolean flag2 = false;

							String methodName = methodCall.getName();
							String classNameString = ((Interface) methodCall.eContainer()).getName();
							int lineNumber=0;
							Node classNode = null;
							if (classNameL != null) {
								classNode = test.selectSingleNode("Class[@name='" + classNameL + "']");
							}
							if (methodNameLaString != null) {
								Node methodDcl = classNode.selectSingleNode("MethodDeclaration[@name='" + methodNameLaString + "']");
								flag2 = (methodDcl.selectSingleNode("MethodInvocation[@name='" + methodName + "']") != null);
								 lineNumber=Integer.parseInt(((Element) methodDcl).attributeValue("lineNumber").toString());
								if (!flag2) {
									IResource st2=st.getProject().getFile("/src/"+classNameL+".java");
									String message = "Behavior  : " + interNameString + " :  " + classNameL + "." + methodNameLaString + " : " + methodName + " " + "is not Exist";
									ProblemViewManager.addError1(st2, message, classNameString,lineNumber);
								}
							}

							if (flag2) {
								outString = "Behavior  : " + interNameString + " : " + classNameL + "." + methodNameLaString + " ->" + classNameString + "." + methodName;
							}
							if (outString != null) {
								IResource st2=st.getProject().getFile("/src/"+classNameL+".java");
								// lineNumberClass=Integer.parseInt(a.attributeValue("lineNumber").toString());
								ProblemViewManager.addInfo1(st2, outString, classNameL,lineNumber);
							}
							classNameL = classNameString;
							methodNameLaString = methodName;
						}
					}// for
				}
			}
		}
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	private Model getArchifaceModel(IResource archifile) {
		XtextResourceSet rs = (XtextResourceSet) injector.getInstance(XtextResourceSetProvider.class).get(archifile.getProject());
		rs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

		Resource resource = rs.getResource(URI.createPlatformResourceURI(archifile.getFullPath().toString(), true), true);
		return (Model) resource.getContents().get(0);
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

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {}
}
