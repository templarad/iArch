package jp.ac.kyushu.iarch.checkplugin.handler;

import java.util.List;





import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import umlClass.Class;
import umlClass.Operation;

public class ClassDiagramChecker{
	public void checkClassDiagram(Model archiface, IResource classDiagramResource){
		Resource classDiagram = GraphitiModelManager
				.getGraphitiModel(classDiagramResource);
		for (Interface archiclass : archiface.getInterfaces()) {
			umlClass.Class umlClass = findClass(archiclass,
					classDiagram.getContents());
			if (umlClass != null) {
				ProblemViewManager.addInfo(classDiagramResource, archiclass.getName()+" is valid", archiclass.getName());
				
				//check methods
				for(Method m : archiclass.getMethods()){
					Operation op = findMethod(m, umlClass);
					if(op!=null){
						//ProblemViewManager.addInfo(classDiagramResource, "  "+archiclass.getName()+"."+m.getName()+" is valid", m.getName());						
					}else{
						ProblemViewManager.addError(classDiagramResource, "  "+archiclass.getName()+"."+m.getName()+" not found", m.getName());
					}
				}
			} else {
				ProblemViewManager.addError(classDiagramResource, archiclass.getName()
						+ " not found.", archiclass.getName());
			}
		}		
	}
	private umlClass.Class findClass(Interface archiclass,
			List<EObject> umlClasses) {
		for (EObject obj : umlClasses) {
			if (obj instanceof umlClass.Class) {
				umlClass.Class umlClass = (umlClass.Class) obj;
				if (umlClass.getName().equals(archiclass.getName())) {
					return umlClass;
				}
			}
		}
		return null;
	}

	private umlClass.Operation findMethod(Method method, Class umlClass) {
		for (Operation op : umlClass.getOwnedOperation()) {
			if (op.getName().equals(method.getName())) {
				return op;
				// TODO Parameter/Return Type check.
			}
		}
		return null;
	}
}
