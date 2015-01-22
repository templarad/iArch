package jp.ac.kyushu.iarch.basefunction.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;


/**
 * Control the class business model of class diagram.
 * @author Templar
 *
 */
public class ClassDiagramModel {
	
	private Resource classDiagram = null;
	
	public ClassDiagramModel(Resource ClassDiagramResource){
		classDiagram = ClassDiagramResource;
	}
	
	public umlClass.Class getClass(String className){
	
		for(EObject obj : classDiagram.getContents()){
			if(obj instanceof umlClass.Class){
				umlClass.Class eClass = (umlClass.Class) obj;
				if(eClass.getName().equals(className)){
					return (umlClass.Class)obj;
				}

			}
		}
		return null;
	}
	public umlClass.Operation getOperation(String oprationName, umlClass.Class umlclass){
		for(umlClass.Operation op : umlclass.getOwnedOperation()){
			if(op.getName().equals(oprationName)){
				return op;
			}
		}
		return null;
	}
}
