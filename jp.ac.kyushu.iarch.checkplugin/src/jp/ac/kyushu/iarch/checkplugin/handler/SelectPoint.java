package jp.ac.kyushu.iarch.checkplugin.handler;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jp.ac.kyushu.iarch.archdsl.ArchDSLPlugin;
import jp.ac.kyushu.iarch.archdsl.archDSL.Behavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.archdsl.archDSL.Param;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointManager;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.debug.core.breakpoints.JavaLineBreakpoint;
import org.eclipse.jdt.internal.debug.core.breakpoints.JavaMethodBreakpoint;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.Injector;

import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.ui.internal.ArchDSLActivator;
import jp.ac.kyushu.iarch.basefunction.reader.XMLreader;

public class SelectPoint implements IHandler {
	Element test=null;
	final private static Injector injector = ArchDSLActivator.getInstance()
			.getInjector(ArchDSLPlugin.getLanguageName());

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		IBreakpointManager mgr = DebugPlugin.getDefault()
				.getBreakpointManager();
		IStructuredSelection ssel = (IStructuredSelection) selection;
		IJavaProject project = (IJavaProject) ssel.getFirstElement();
		IProject project2 = project.getProject();
		Model newsarchiface = null;
		XMLreader sr = new XMLreader(project2);/*
		try {
			GenerateArchifaceCode(sr.getARXMLResource());
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		mgr.getBreakpoints();
		String archCodeString = "", interfaceString = "";
		String className = null, methodName = null;
		IBreakpoint[] breakPointList = mgr.getBreakpoints();

		for (int i = 0; i < breakPointList.length; i++) {

			IResource re = ResourcesPlugin.getWorkspace().getRoot()
					.findMember("/ObserverPattern/Generated Archface.arch");
			Model archiface = getArchifaceModel(re);

			if (breakPointList[i] instanceof JavaMethodBreakpoint) {

				@SuppressWarnings("restriction")
				JavaMethodBreakpoint a = (JavaMethodBreakpoint) breakPointList[i];
				methodName = a.getMethodName().toString();
				try {
					className = a.getTypeName().toString();
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (breakPointList[i] instanceof JavaLineBreakpoint) {
				JavaLineBreakpoint a = (JavaLineBreakpoint) breakPointList[i];
				className = "Observer";
				methodName = "update";

			}

			int n = 0, m = 0, flag = 0, flag2 = 0;
			Behavior behavior2 = null;
			String se2 = "";

			for (Behavior behavior : archiface.getBehaviors()) {
				String se = behavior.getInterface().getName();
				if (!se2.equals(se)) {
					n = 0;
				}
				for (Method methodCall : behavior.getCall()) {

					String methodName2 = methodCall.getName();
					if (methodName.equals(methodName2) && (!se.equals("Main"))) {
						flag = 1;
					}
					m += 1;
				}
				if (!se2.equals(se) && flag2 == 1) {
					m = 0;
					n = 0;
					flag2 = 0;
					String behaviorString = "";
					for (Method methodCall : behavior2.getCall()) {
						if (methodCall.getName() != null) {
							behaviorString += ((Interface) methodCall
									.eContainer()).getName()
									+ "."
									+ methodCall.getName() + "->";

						}

					}
					String interfaceString1 = "";
					for (Method methodCall : behavior2.getCall()) {
						String paramString = "";
						if (!methodCall.getParam().isEmpty()) {
							paramString = methodCall.getParam().get(0)
									.getType()
									+ " "
									+ methodCall.getParam().get(0).getName();
						}
						if (methodCall.getName() == null) {
							continue;
						}
						if (((Interface) methodCall.eContainer())
								.getName().equals(se2)) {

							interfaceString1 += "\n" + methodCall.getType()
									+ " " + methodCall.getName() + " ("
									+ paramString + ")" + ";";
						}
					}

					interfaceString1 = "interface component " + se2 + "{"
							+ interfaceString1 + "}" + "\n";
					archCodeString += se2 + "=" + "(" + behaviorString + se2
							+ ")" + ";" + "\n";
					interfaceString += interfaceString1;
				}
				if (flag == 1 && m > n) {
					n = m;
					behavior2 = behavior;
					flag2 = 1;
					flag = 0;

				}
				m = 0;
				se2 = se;
			}
			String behaviorString = "", interfaceString1 = "";
			for (Method methodCall : behavior2.getCall()) {
				if (methodCall.getName() != null) {
					behaviorString += ((Interface) methodCall.eContainer())
							.getName() + "." + methodCall.getName() + "->";

				}

			}

			for (Method methodCall : behavior2.getCall()) {
				String paramString = "";
				if (!methodCall.getParam().isEmpty()) {
					paramString = methodCall.getParam().get(0).getType() + " "
							+ methodCall.getParam().get(0).getName();
				}

				if (methodCall.getName() == null) {
					continue;
				}
				if (((Interface) methodCall.eContainer())
						.getName().equals(se2)) {

					interfaceString1 += "\n" + methodCall.getType() + " "
							+ methodCall.getName() + " (" + paramString + ")"
							+ ";";
				}
			}

			interfaceString1 = "interface component " + se2 + "{"
					+ interfaceString1 + "}" + "\n";

			interfaceString += interfaceString1;
			archCodeString += se2 + "=" + "(" + behaviorString + se2 + ")"
					+ ";" + "\n";
		}
		String ar = sr.getArchfileResource().getLocation().toOSString();

		File myFilePath = new File(ar);
		try {
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			FileWriter resultFile = new FileWriter(myFilePath);
			PrintWriter myFile = new PrintWriter(resultFile);
			myFile.println(interfaceString +archCodeString);
			resultFile.close();
		} catch (Exception e) {
			System.out.println("Create File Error!");
			e.printStackTrace();
		}
		return null;
	}
	private void GenerateArchifaceCode(IResource xmlfile) throws DocumentException{

		Model newarchfile=null;
		
		String archfaceString="";
	SAXReader reader = new SAXReader();
	 Document XMLdocument = reader.read(xmlfile.getLocation().toString());
	 Element root = XMLdocument.getRootElement();
    test = (Element) root.selectSingleNode("//Package[@name='']");
	 for (Iterator classIterator = test.elementIterator(); classIterator.hasNext();) { 
			
            Element classXML = (Element) classIterator.next();
            String ClassName = classXML.attributeValue("name"); 
            archfaceString+="interface component  "+ClassName+" {";
            archfaceString+= "\n";
            for (Iterator methodIterator = classXML.elementIterator(); methodIterator.hasNext();) {
                Element methodXML = (Element) methodIterator.next();
                String ex=methodXML.getName().toString();
            	if (methodXML.getName().toString()=="MethodDeclaration") {
                    String methodName=methodXML.attributeValue("name");
                    //Add Modifiers
                    List methodModifiers= methodXML.selectNodes("MethodModifiers/modifier");
                    Element lastModifiers=(Element) methodModifiers.get(methodModifiers.size()-1);
                    String modifierString=lastModifiers.getText();
                    if (!modifierString.equals("void")) {
                    	modifierString=methodXML.element("returnType").getText();
					}
                    String methodParameter="";
                    
                    List methodParameterEle = methodXML.selectNodes("parameterTypeElement");
                    if (methodParameterEle.size()!=0) {
					  methodParameter=methodXML.element("parameterTypeElement").element("parameterType").getText();
					}
                    archfaceString+="	"+modifierString;
                    //String methodArgumentType=methodXML.attributeValue("");
                    archfaceString+=" "+methodName+"  ("+methodParameter+")";
    	            archfaceString+= "\n";
    	            
    				}
            }
            archfaceString+="}"+"\n";
	 }
	 
	 //behavior list
	 for (Iterator classIterator = test.elementIterator(); classIterator.hasNext();) { 
         Element classXML = (Element) classIterator.next();
         String ClassName = classXML.attributeValue("name"); 
         for (Iterator methodIterator = classXML.elementIterator(); methodIterator.hasNext();) {
        	 
             Element methodXML = (Element) methodIterator.next();
         	if (methodXML.getName().toString().equals("MethodDeclaration")) {
         		archfaceString+=ClassName+"= "+"{";
                 String methodName=methodXML.attributeValue("name");
                 //Add Modifiers
                 List methodInvocations= methodXML.selectNodes("MethodInvocation");
					 archfaceString+=ClassName+"."+methodName+"->"+retrunString(ClassName, methodXML);
					 
                 
                 archfaceString+=ClassName+"}"+"\n";
 				}
         }
         archfaceString+="\n";
	 }
	 //Manufacture sequence
/*	 for (Iterator classIterator = test.elementIterator(); classIterator.hasNext();) { 
			
         Element classXML = (Element) classIterator.next();
         String ClassName = classXML.attributeValue("name"); 
         archfaceString+=ClassName+"= ";
         for (Iterator methodIterator = classXML.elementIterator(); methodIterator.hasNext();) {
             Element methodXML = (Element) methodIterator.next();
             String ex=methodXML.getName().toString();
         	if (methodXML.getName().toString()=="MethodDeclaration") {
                 String methodName=methodXML.attributeValue("name");
                 //Add Modifiers
                 archfaceString+="  		"+ClassName+"."+methodName+"->";
                 List methodInvocations= methodXML.selectNodes("MethodInvocation");
                 for (Iterator iterator = methodInvocations.iterator(); iterator
							.hasNext();) {
						Element object = (Element) iterator.next();
						String methodNameInvo=object.attributeValue("name");
						String methodClass=object.attributeValue("type");
						if (!(methodClass==null)){
							
						archfaceString+=methodClass+"."+methodNameInvo+"  ;  ";
						}
						else {
							methodClass=ClassName;
							archfaceString+=methodClass+"."+methodNameInvo+"  ;  ";
						
						}
						codeMap.put(ClassName+"."+methodName,methodClass+"."+methodNameInvo);
					}
                 archfaceString+="\n";
 				}
  	       archfaceString+="\n";
         }
	       archfaceString+="\n";
	 }
	 */
	String projectPath = xmlfile.getProject().getLocation().toOSString();
	String ArchiCodeFile=projectPath +"/Generated Archface.arch";
	File myFilePath = new File(ArchiCodeFile);
	try {
		if (!myFilePath.exists()) {
			myFilePath.createNewFile();   
			}
		FileWriter resultFile = new FileWriter(myFilePath);
		PrintWriter myFile = new PrintWriter(resultFile);
		myFile.println(archfaceString);
		resultFile.close();
		}
	catch (Exception e) {
		System.out.println("Create File Error!");
		e.printStackTrace();
		}
	
	
	}
	private String retrunString(String className,Element methodElement)
	{
		String aString="";
		List methodInvocations= methodElement.selectNodes("MethodInvocation");
		for (Iterator iterator = methodInvocations.iterator(); iterator
			 .hasNext();) {
			if (!iterator .hasNext()) {
				 aString="\n";
				break;
			}
			Element object = (Element) iterator.next();
			String methodInvoName=object.attributeValue("name");
			String methodClass=object.attributeValue("type");
			if (methodClass==null){
				methodClass=className;
			}
			aString+=methodClass+"."+methodInvoName+"->";
			try {
				
				Element methodElement2=(Element) test.selectSingleNode("//Class[@name='"+methodClass+"']/MethodDeclaration[@name='"+methodInvoName+"']");
				 		//+ "/MethodDeclaration[@name='"+methodInvoName+"']");	
				
				if (!(methodElement2==null)) {
					aString+=retrunString(methodClass,methodElement2);
				}
				
			} 
			
			catch (Exception e) {
				continue;
				// TODO: handle exception
			}
		}
		return aString;
         
			
		}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	private Model getArchifaceModel(IResource archifile) {

		XtextResourceSet rs = (XtextResourceSet) injector.getInstance(
				XtextResourceSetProvider.class).get(archifile.getProject());
		rs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

		Resource resource = rs.getResource(URI.createPlatformResourceURI(
				archifile.getFullPath().toString(), true), true);
		return (Model) resource.getContents().get(0);
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
