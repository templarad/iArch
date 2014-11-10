package jp.ac.kyushu.iarch.checkplugin.handler;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jp.ac.kyushu.iarch.basefunction.controller.GraphitiModelManager;
import jp.ac.kyushu.iarch.checkplugin.utils.ProjectSelectionUtils;
import jp.ac.kyushu.iarch.checkplugin.view.SelectDiagramsDialog;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import umlClass.Operation;
import behavior.Lifeline;
import behavior.Message;
import behavior.MessageOccurrenceSpecification;


public class GenerateArchCode implements IHandler {


	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IProject project = ProjectSelectionUtils.getProject(event, "Generate ArchiCode");
		
		SelectDiagramsDialog dialog = new SelectDiagramsDialog(
				HandlerUtil.getActiveShell(event), project);
		if (dialog.open() == MessageDialog.OK) {
			
//			// clear problems
//			ProblemViewManager.removeAllProblems(project);
			
			// Generate archiface code
			GenerateArchifaceCode(
					dialog.getClassDiagram(), dialog.getSequenceDiagrams());
		}

		return null;
	}

	/**
	 * Gen the Archiface Code
	 *
	 */
	private void GenerateArchifaceCode(
			IResource classDiagramResource,
			List<IResource> sequenceDiagramResources) {

		String Code="";
		Resource classDiagram = GraphitiModelManager
				.getGraphitiModel(classDiagramResource);
		
		Code+= findClass(classDiagram.getContents());//Gen Class Code
		Code+= "\n";
		Code+= getSequenceCode(sequenceDiagramResources);//Gen Squence Code
		String projectPath = classDiagramResource.getProject().getLocation().toOSString();
		String ArchiCodeFile=projectPath +"/Gen-Arch.arch";
		File myFilePath = new File(ArchiCodeFile);
		try {
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();   
				}
			FileWriter resultFile = new FileWriter(myFilePath);
			PrintWriter myFile = new PrintWriter(resultFile);
			myFile.println(Code);
			resultFile.close();
			}
		catch (Exception e) {
			System.out.println("Create File Error!");
			e.printStackTrace();
			}
		
	}
	
	/**
	 * Gen the Sequence Code
	 *
	 * @return the String(Sequence Code)
	 */
	private String getSequenceCode(List<IResource> sequenceDiagramResources) {
		String SequenceCode="";//CODE
		for(IResource sequenceDiagramResource : sequenceDiagramResources){
			Resource sequenceDiagram = GraphitiModelManager.getGraphitiModel(sequenceDiagramResource);
			List<behavior.Object> diagramObject = new ArrayList<behavior.Object>();
			List<Message> messages = new ArrayList<Message>();
			for(EObject obj : sequenceDiagram.getContents()){
				if(obj instanceof behavior.Object&&((behavior.Object) obj).isArchpoint()){
					diagramObject.add((behavior.Object)obj);
				}
				if(obj instanceof Message){
					messages.add((Message)obj);
				}
			}
			for(behavior.Object ob: diagramObject){
				SequenceCode += ob.getName() + " = (";
				for(Message msg:messages){
					Lifeline oblifeline = ob.getInclude();
					Lifeline sendlifeline = ((MessageOccurrenceSpecification)msg.getSendEvent()).getCovered().get(0);
					Lifeline recivelifeline = ((MessageOccurrenceSpecification)msg.getReceiveEvent()).getCovered().get(0);					
					if (oblifeline == sendlifeline){
						SequenceCode += recivelifeline.getActor().getName()+ "." +msg.getName()+"->";
						
					}else if(oblifeline == recivelifeline){
						SequenceCode += ob.getName()+ "." +msg.getName()+"->";
					}
				}
				SequenceCode += ob.getName() + ");\n";
			}
			
			SequenceCode += "";
		}
		return SequenceCode;
	}

	
	/**
	 * Gen the class code
	 *
	 * @return the String(interface code)
	 */
	private String findClass(List<EObject> umlClasses) {
		String InterfaceCode="";
		for (EObject obj : umlClasses) {
			if (obj instanceof umlClass.Class) {				
				umlClass.Class umlClass = (umlClass.Class) obj;
				InterfaceCode+="\ninterface component "+umlClass.getName()+" {\n";
				InterfaceCode+=findMethod(umlClass);
				InterfaceCode+="\n}\n";
			}			
		}
		
		return InterfaceCode;
	}
	
	/**
	 * Gen method Code
	 *
	 * @return the String(method Code)
	 */
	private String findMethod(umlClass.Class umlClass){
		String Code="";
		for(Operation operation:umlClass.getOwnedOperation()){
			Code+="\tvoid "+operation.getName()+"();\n";//+"\t\t"+"execution(void "+operation.getName()+"()) ;\n"
		}
		return Code;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
	}
}
