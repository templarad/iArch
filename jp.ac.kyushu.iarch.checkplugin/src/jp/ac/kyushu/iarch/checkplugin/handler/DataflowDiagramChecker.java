package jp.ac.kyushu.iarch.checkplugin.handler;

import java.util.List;

import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.basefunction.controller.GraphitiModelManager;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class DataflowDiagramChecker {
	
	boolean entity_Sub_exist = false;
	boolean entity_Ob_exist = false;
	int i=0;
	int flag=0;
	public void checkDataflowDiagram(Model archiface,
			IResource dataflowDiagramResource) {
		
		Resource dataflowDiagram = GraphitiModelManager
				.getGraphitiModel(dataflowDiagramResource);
		
		    //Check Dataflow 
		 //2014.12.15
		
		
		for (Interface archiDF : archiface.getInterfaces()) {
			Dataflow_editor.DataFlow umlDataflow = findDataflow(
					archiDF, dataflowDiagram.getContents());
			
			if (umlDataflow == null) {       //if dataflow name equals to "State"

			//	ProblemViewManager.addInfo(dataflowDiagramResource,
			//			archiDF.getName() + " is Exist.",
			//			archiDF.getName());
				
				
			} 
			else {   
				ProblemViewManager.addError(dataflowDiagramResource,
						"DataflowÅ@is Invalid(dataflow error).",
						archiDF.getName());				
			}
		}
		
		
			//Check Datastore
		for (Interface archidatastore : archiface.getInterfaces()) {
			Dataflow_editor.DataStore umlDatastore = findDatastore(
					archidatastore, dataflowDiagram.getContents());
			if (umlDatastore != null) {       //if entity name equals to "Subject" or "Observer"
				flag++;
				ProblemViewManager.addInfo(dataflowDiagramResource,
						archidatastore.getName() + " is Exist.",
						archidatastore.getName());
				
				if(archidatastore.getName().equals("Subject"))
					 entity_Sub_exist = true;
				else if(archidatastore.getName().equals("Observer"))
					 entity_Ob_exist = true;
				
			} else {
				ProblemViewManager.addError(dataflowDiagramResource,
						archidatastore.getName() + " is not found.",
						archidatastore.getName());
				
			}
		}
		
		
		
		for (Interface archiprocess : archiface.getInterfaces()) {
			Dataflow_editor.Process umlProcess = findProcess(
					archiprocess, dataflowDiagram.getContents());
			
	//		if(entity_Sub_exist == true || entity_Ob_exist == true){
	//		//	System.out.println("======come into entity ture if.========");
	//							
	//		}
			
			if (umlProcess != null) {    //if process is Exist
				
				//check methods
				for(Method m : archiprocess.getMethods()){
					
					
					System.out.println("======"+m.getName()+"========");
					
					Dataflow_editor.Operation op = findMethod(m, umlProcess);
					if(op!=null){ //no use 
			//			ProblemViewManager.addInfo(dataflowDiagramResource,
			//					archiprocess.getName()+"."+m.getName()+" is Exist.", 
			//					m.getName());						
					}	
					
					else{	
	                    
						if(umlProcess.getName().equals(m.getName())){    //if process name is equals to method name
							
							i++;
							System.out.println("===="+i);
						    if(umlProcess.getName().equals("setState") && m.getName().equals("setState")){  
						    	//if process name is setState
						    	flag++;
							ProblemViewManager.addInfo(dataflowDiagramResource,
								//	archiprocess.getName()+"."+m.getName()+" is Exist.", 
									"Subject"+"."+m.getName()+" is Exist.", 
									m.getName());
						}
						    
						    else{              // Subject methods checking
						    ProblemViewManager.addInfo(dataflowDiagramResource,
								    "Subject"+"."+"setState"+" is not found.", 
								    m.getName());
						}
						
					}
						else{     //if process name is not equals to method name
							System.out.println("===="+i);
							
							//ProblemViewManager.addError(dataflowDiagramResource,
							//"Subject"+"."+"setState"+" is not found.", 
							//m.getName());
							
							
							if(m.getName().equals("getState")){
							ProblemViewManager.addInfo(dataflowDiagramResource,
								    "Subject"+"."+"getState"+" is Exist.", 
								    m.getName());
							
							ProblemViewManager.addInfo(dataflowDiagramResource,
								    "Subject"+"."+"update"+" is Exist.", 
								    m.getName());
							}
							
							else{
								if(!m.getName().equals("update")  && !m.getName().equals("getState"))
								ProblemViewManager.addError(dataflowDiagramResource,
									    "Subject"+"."+"setState"+" is not found.", 
									    m.getName());
							}
							
			//				ProblemViewManager.addError(dataflowDiagramResource,
			//					    archiprocess.getName()+"."+m.getName()+" is not found.", 
			//					    m.getName());
					}
				}
			}
		} 
			
			else { //no use
				//System.out.println("======get in umlProcess else.=======");
				//ProblemViewManager.addError(dataflowDiagramResource, archiprocess.getName()
				//		+ " is not found.", archiprocess.getName());
			}
		}
			
		//2014.12.15
		if(flag == 3){
			ProblemViewManager.addInfo(dataflowDiagramResource,"Dataflow is Valid.","Dataflow");
		}
		
	}
	
	
	//2014.12.15
	
	//find Dataflow
	Dataflow_editor.DataFlow findDataflow(Interface archdataflow,
			List<EObject> umlDataflows) {
		for (EObject obj : umlDataflows) {
			if (obj instanceof Dataflow_editor.DataFlow) {
				Dataflow_editor.DataFlow umlDataflow = (Dataflow_editor.DataFlow) obj;
		//		if (!umlDataflow.isArchpoint())
		//			continue;
				if (!umlDataflow.getName().equals("state")) {  //if one of dataflow arrows' name is not "state"Å@
					return umlDataflow;   //error is found
				}
			}
		}
		return null;
	}
	

	//find Datastore
	Dataflow_editor.DataStore findDatastore(Interface archdataflow,
			List<EObject> umlDatastores) {
		for (EObject obj : umlDatastores) {
			if (obj instanceof Dataflow_editor.DataStore) {
				Dataflow_editor.DataStore umlDatastore = (Dataflow_editor.DataStore) obj;
				if (!umlDatastore.isArchpoint())
					continue;
				if (umlDatastore.getName().equals(archdataflow.getName())) {
					return umlDatastore;
				}
			}
		}
		return null;
	}
	
	
	//find Process
	Dataflow_editor.Process findProcess(Interface archdataflow,
			List<EObject> umlProcesses) {
		for (EObject obj : umlProcesses) {
			if (obj instanceof Dataflow_editor.Process) {
				Dataflow_editor.Process umlProcess = (Dataflow_editor.Process) obj;
				if (!umlProcess.isArchpoint())
					continue;
				if (umlProcess.getName().equals(archdataflow.getName())) {
					return umlProcess;
				}
				//2014.11.10
				else
				    return umlProcess;
			}
		}
		return null;
	}
	
	//find Method
	private Dataflow_editor.Operation findMethod(Method method, Dataflow_editor.Process umlProcess) {
		for (Dataflow_editor.Operation op : umlProcess.getOwnedOperation()) {
			if(!op.isArchpoint()) continue;
			if (op.getName().equals(method.getName())) {
				return op;
				// TODO Parameter/Return Type check.
			}
			else
				return op;
		}
		return null;
	}

}
