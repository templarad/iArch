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

public class SlectPoint implements IHandler {
	final private static Injector injector = ArchDSLActivator.getInstance().getInjector(ArchDSLPlugin.getLanguageName());
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
		 IBreakpointManager mgr = DebugPlugin.getDefault().getBreakpointManager();
		IStructuredSelection ssel = (IStructuredSelection)selection;
		IJavaProject project = (IJavaProject) ssel.getFirstElement();
		IProject project2 = project.getProject();
		mgr.getBreakpoints();
		String archCodeString="", interfaceString = "";
		String className=null;
		IBreakpoint[] breakPointList = mgr.getBreakpoints();
		for (int i = 0; i < breakPointList.length; i++) {
			
			IResource re = ResourcesPlugin.getWorkspace().getRoot()
					.findMember("/ObserverPattern/Generated Archface.arch");
			Model archiface = getArchifaceModel(re);
			if (breakPointList[i] instanceof JavaMethodBreakpoint) {

				@SuppressWarnings("restriction")
				JavaMethodBreakpoint a = (JavaMethodBreakpoint) breakPointList[i];
				String methodName = a.getMethodName().toString();

				try {
					className = a.getTypeName().toString();
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int num1, num2 = 0, flag = 0;
				String behaviorString = "", behaviorString2 = null;
				String interfaceString1="interface component "+className+"{",interfaceString2="", interfaceStringole="";
				for (Behavior behavior : archiface.getBehaviors()) {
					String se = behavior.getInterface().getName();
					;
					if (se.equals(className)) {

						for (Method methodCall : behavior.getCall()) {

							String methodName2 = methodCall.getName();
							if (methodName.equals(methodName2)) {
								flag = 1;
							}
						}
						num1 = 0;
						behaviorString = "";
						 interfaceString1="interface component "+className+"{";interfaceString2="";
						 interfaceStringole="";
						for (Method methodCall : behavior.getCall()) {

							if (flag == 1) {
								
								if (!(methodCall.getName() == null)) {
									String methodName2 = methodCall.getName();
									String classNameString = ((Interface) methodCall
											.eContainer()).getName();
									behaviorString += classNameString + "."
											+ methodName2 + "->";
									num1 += 1;
									//add component
									if (classNameString.equals(className)) {
										String paramString="";
										if (!methodCall.getParam().isEmpty()) {
											paramString=methodCall.getParam().get(0).getType()+" "+methodCall.getParam().get(0).getName();
										}
										interfaceString1+="\n"+methodCall.getType()+" "+methodCall.getName()+" ("+paramString+")"+";";
										
									}
									else if (!classNameString.equals(className)) {
										if (interfaceString2.equals("")) {
											interfaceString2="interface component "+classNameString+"{";
										}
										String paramString="";
										if (!methodCall.getParam().isEmpty()) {
											paramString=methodCall.getParam().get(0).getType()+" "+methodCall.getParam().get(0).getName();
										}
										interfaceString2+="\n"+methodCall.getType()+" "+methodCall.getName()+" ("+paramString+")"+";"+"}";
										
										
									}
									
								}
							}
						}
						interfaceStringole=interfaceString1+"}"+"\n"+interfaceString2;
						if (num1 > num2) {
							num2 = num1;
							behaviorString2 = behaviorString;
							interfaceString=interfaceStringole;
						}
					}
				}
				archCodeString += className + "=" + "(" + behaviorString2
						+ className + ")" + ";" ;
			}
			
		}
		
		XMLreader sr=new XMLreader(project2);
		String ar=sr.getArchfileResource().getLocation().toOSString();
		
		File myFilePath = new File(ar);
		try {
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();   
				}
			FileWriter resultFile = new FileWriter(myFilePath);
			PrintWriter myFile = new PrintWriter(resultFile);
			myFile.println(interfaceString+"\n"+archCodeString);
			resultFile.close();
			}
		catch (Exception e) {
			System.out.println("Create File Error!");
			e.printStackTrace();
			}
		return null;
	}
	
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	private Model getArchifaceModel(IResource archifile) {
		
		XtextResourceSet rs = (XtextResourceSet) injector.getInstance(XtextResourceSetProvider.class).get(archifile.getProject());
		rs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

		Resource resource = rs.getResource(URI.createPlatformResourceURI(archifile.getFullPath().toString(), true), true);
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
