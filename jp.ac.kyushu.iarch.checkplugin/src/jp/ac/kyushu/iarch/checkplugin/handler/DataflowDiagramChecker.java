package jp.ac.kyushu.iarch.checkplugin.handler;

import java.util.List;

import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.basefunction.controller.GraphitiModelManager;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

//import Dataflow_editor.External_entity;

public class DataflowDiagramChecker {
	public void checkDataflowDiagram(Model archiface,
			IResource dataflowDiagramResource) {
		
		//Check Entity
		Resource dataflowDiagram = GraphitiModelManager
				.getGraphitiModel(dataflowDiagramResource);
		for (Interface archidataflow : archiface.getInterfaces()) {
			Dataflow_editor.External_entity umlEntity = findEntity(
					archidataflow, dataflowDiagram.getContents());
			if (umlEntity != null) {

				ProblemViewManager.addInfo(dataflowDiagramResource,
						archidataflow.getName() + " is Exist.",
						archidataflow.getName());

				// check methods(Process)
				// for(Method m : archidataflow.getProcess()){
				// Process pr = findProcess(m, umlProcess);
				// if(pr!=null){
				// ProblemViewManager.addInfo(classDiagramResource,
				// "  "+archidataflow.getName()+"."+m.getName()+" is valid",
				// m.getName());
				// }
				// else{
				// }

			} else {
				ProblemViewManager.addError(dataflowDiagramResource,
						archidataflow.getName() + " not found.",
						archidataflow.getName());
			}
		}
		
	}

	Dataflow_editor.External_entity findEntity(Interface archclass,
			List<EObject> umlEntities) {
		for (EObject obj : umlEntities) {
			if (obj instanceof Dataflow_editor.External_entity) {
				Dataflow_editor.External_entity umlEntity = (Dataflow_editor.External_entity) obj;
				if (!umlEntity.isArchpoint())
					continue;
				if (umlEntity.getName().equals(archclass.getName())) {
					return umlEntity;
				}
			}
		}
		return null;
	}

	// private Dataflow_editor.Process findProcess(Method method, Process
	// umlProcess) {
	// for (Operation pr : umlClass.getOwnedOperation()) {
	// if(!pr.isArchpoint()) continue;
	// if (pr.getName().equals(method.getName())&&umlProcess.isArchpoint()) {
	// return pr;
	// // TODO Parameter/Return Type check.
	// }
	// }
	// return null;
	// }
	
	
	
	
	
}
