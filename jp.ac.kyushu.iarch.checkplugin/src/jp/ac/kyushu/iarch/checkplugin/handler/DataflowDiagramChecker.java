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
		Resource dataflowDiagram = GraphitiModelManager
				.getGraphitiModel(dataflowDiagramResource);
		for (Interface archidataflow : archiface.getInterfaces()) {
			Dataflow_editor.External_entity umlEntity = findEntity(archidataflow,
					dataflowDiagram.getContents());
			if (umlEntity != null) {
				
				// check methods
				// for(Method m : archiclass.getMethods()){
				// Operation op = findMethod(m, umlClass);
				// if(op!=null){
				// //ProblemViewManager.addInfo(classDiagramResource,
				// "  "+archiclass.getName()+"."+m.getName()+" is valid",
				// m.getName());
				// }else{
				ProblemViewManager.addInfo(dataflowDiagramResource,
						archidataflow.getName() + " is Exist.",
						archidataflow.getName());
			} else {
				ProblemViewManager.addError(dataflowDiagramResource,
						archidataflow.getName() + " is not found.",
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

	/*
	 * private umlClass.Operation findMethod(Method method, Class umlClass) {
	 * for (Operation op : umlClass.getOwnedOperation()) { if(!op.isArchpoint())
	 * continue; if
	 * (op.getName().equals(method.getName())&&umlClass.isArchpoint()) { return
	 * op; // TODO Parameter/Return Type check. } } return null; }
	 */
}
