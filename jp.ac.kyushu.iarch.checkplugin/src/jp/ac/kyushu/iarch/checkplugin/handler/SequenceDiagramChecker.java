package jp.ac.kyushu.iarch.checkplugin.handler;

import java.util.ArrayList;
import java.util.List;

import jp.ac.kyushu.iarch.archdsl.archDSL.Behavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import behavior.Message;

public class SequenceDiagramChecker {
	public boolean checkSequenceDiagram(Model archiface, IResource sequenceResource){
		Resource sequenceDiagram = GraphitiModelManager.getGraphitiModel(sequenceResource);
		List<Message> diagramMessages = getMassageSequence(sequenceDiagram);

		for(Behavior behavior : archiface.getBehaviors()){
			if(checkMessageOrder(behavior, diagramMessages)){
				ProblemViewManager.addInfo(sequenceResource, behavior.getInterface().getName()+
						" sequence order is valid",behavior.getInterface().getName()+" sequence" );
			}else{
				ProblemViewManager.addError(sequenceResource, behavior.getInterface().getName()+
						" sequence order is invalid",behavior.getInterface().getName()+" sequence" );//"."+behavior.getCall().get(order).getName()+			
			}
		}
		return false;
	}
	
	private List<Message> getMassageSequence(Resource sequenceDiagram){
		List<Message> messages = new ArrayList<Message>();
		for(EObject obj : sequenceDiagram.getContents()){
			if(obj instanceof Message){
				//Use the Archpoint attribute in selecting Messages
				if(((Message) obj).isArchpoint())
					messages.add((Message)obj);
			}
		}
		return messages;
	}
	
	private boolean checkMessageOrder(Behavior behavior, List<Message> diagramMessages){
		int diagOrderCount = 0;
		int messageOrderCount = 0;
		for(Method methodCall : behavior.getCall()){
			System.out.println("in "+methodCall.getName());
			for(diagOrderCount=0;;diagOrderCount++){
				if(diagOrderCount>=diagramMessages.size()){
					return false;
				}
				System.out.println(" c :"+diagramMessages.get(diagOrderCount));
				if(methodCall.getName().equals(diagramMessages.get(diagOrderCount).getName())
						&&messageOrderCount<=diagramMessages.get(diagOrderCount).getMessageOrder()){
					System.out.println(methodCall.getName()+"=="+diagramMessages.get(diagOrderCount).getName());
					messageOrderCount=diagramMessages.get(diagOrderCount).getMessageOrder();
					break;
				}else{
					System.out.println("  "+methodCall.getName()+"!="+diagramMessages.get(diagOrderCount).getName());
				}
			}
			
		}
		return true;
	}
}
