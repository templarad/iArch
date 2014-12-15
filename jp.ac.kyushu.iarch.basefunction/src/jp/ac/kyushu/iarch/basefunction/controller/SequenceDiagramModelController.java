package jp.ac.kyushu.iarch.basefunction.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import behavior.MessageOccurrenceSpecification;

/**
 * Control the sequence model when doing refactoring.
 * @author Templar
 *
 */
public class SequenceDiagramModelController {

	private List<behavior.Object> getObjects(Resource sequenceDiagram){
		List<behavior.Object> objects = new ArrayList<behavior.Object>();
		for(EObject obj : sequenceDiagram.getContents()){
			if(obj instanceof behavior.Object){
				objects.add((behavior.Object)obj);
			}
		}
		return objects;
	}
	/**
	 * Get all messages of the actor from model
	 * @param sequenceDiagram
	 * @param actorName
	 * @return
	 */
	private List<behavior.Message> getMessages(Resource sequenceDiagram, String actorName){
		List<behavior.Message> messages = new ArrayList<behavior.Message>();
		for(EObject obj : sequenceDiagram.getContents()){
			if(obj instanceof behavior.Message){
				behavior.Message msg = (behavior.Message) obj;
				String instanceName = ((MessageOccurrenceSpecification)msg.getReceiveEvent())
						.getCovered().get(0).getActor().getName();
				
				if(instanceName.equals(actorName) )
					messages.add((behavior.Message)obj);
			}
		}
		return messages;
	}
	
	
	public boolean changeObjectName(IResource sequenceResource, String currentName, String newName){
		boolean changed = false;
		Resource sequenceDiagram = GraphitiModelManager.getGraphitiModel(sequenceResource);
		List<behavior.Object> objects = getObjects(sequenceDiagram);
		for (behavior.Object obj:objects){
			if(obj.getName().equals(currentName)){
				obj.setName(newName);
				changed = true;
			}
		}
		if(changed){
			try {
				sequenceDiagram.save(null);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				changed = false;
			}
		}
		return changed;
	}
	
	public boolean changeMessageName(IResource sequenceResource,String actorName, String currentName, String newName){
		boolean changed = false;
		Resource sequenceDiagram = GraphitiModelManager.getGraphitiModel(sequenceResource);
		List<behavior.Message> objects = getMessages(sequenceDiagram, actorName);
		for (behavior.Message msg : objects){
			if(msg.getName().equals(currentName)){
				msg.setName(newName);
				changed = true;
			}
		}
		if(changed){
			try {
				sequenceDiagram.save(null);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				changed = false;
			}
		}
		return changed;
	}
	
	public synchronized boolean removeMethod(IResource sequenceResource,String actorName, String currentName){
		boolean changed = false;
		Resource sequenceDiagram = GraphitiModelManager.getGraphitiModel(sequenceResource);
		List<behavior.Message> objects = getMessages(sequenceDiagram, actorName);
		Iterator<behavior.Message> iter = objects.iterator();
		while(iter.hasNext()){
			behavior.Message msg = iter.next();
			if(msg.getName().equals(currentName)){
				iter.remove();
				changed = true;
			}
		}
		if(changed){
			try {
				sequenceDiagram.save(null);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				changed = false;
			}
		}
		return changed;
	}
}
