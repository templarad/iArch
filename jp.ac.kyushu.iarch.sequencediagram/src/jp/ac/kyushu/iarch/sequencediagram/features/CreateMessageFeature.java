package jp.ac.kyushu.iarch.sequencediagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;




import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import behavior.Actor;
import behavior.BehaviorExecutionSpecification;
import behavior.Lifeline;
import behavior.Message;
import behavior.BehaviorFactory;
import behavior.MessageOccurrenceSpecification;

public class CreateMessageFeature extends AbstractCreateConnectionFeature {
	
	public CreateMessageFeature(IFeatureProvider fp) {
		super(fp, "Message", "add Message");
	}
	private static final IColorConstant MESSAGE_FOREGROUND = new ColorConstant(0, 0, 0);
	private String messageName = "newMessage";
	public boolean canCreate(ICreateConnectionContext context) {
        // return true if both pictogram belong to an Lifeline
		Lifeline source = getLifeline(context.getSourcePictogramElement());
		if (source != null ) {
		    return true;
		}
		return false;
	}

	public Connection create(ICreateConnectionContext context) {
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();
		Connection newConnection = null;
		if(context.getProperty("name")!=null)
			
			setMessageName((String)context.getProperty("name"));
		// get Lifelines which should be connected
		Lifeline source = getLifeline(context.getSourcePictogramElement());
		Lifeline target = getLifeline(context.getTargetPictogramElement());
		
		if (source != null && target != null) {
			// create new business object 
			Message message = createMessage(source, target);
			getDiagram().eResource().getContents().add(message);
			// add connection for business object

			BehaviorExecutionSpecification BehaviorExecutionOnsource =BehaviorFactory.eINSTANCE.createBehaviorExecutionSpecification();
			BehaviorExecutionSpecification BehaviorExecutionOntarget =BehaviorFactory.eINSTANCE.createBehaviorExecutionSpecification();

			MessageOccurrenceSpecification startMOS = BehaviorFactory.eINSTANCE.createMessageOccurrenceSpecification();
			MessageOccurrenceSpecification endMOS = BehaviorFactory.eINSTANCE.createMessageOccurrenceSpecification();

			startMOS.setMessage(message);
			endMOS.setMessage(message);
			message.setSendEvent(startMOS);
			message.setReceiveEvent(endMOS);

			BehaviorExecutionOnsource.setStart(startMOS);
			BehaviorExecutionOntarget.setStart(endMOS);
			BehaviorExecutionOnsource.getCovered().add(source);
			BehaviorExecutionOntarget.getCovered().add(target);
			startMOS.getCovered().add(source);
			endMOS.getCovered().add(target);
			
			source.getBehaviorExecution().add(BehaviorExecutionOnsource);
			target.getBehaviorExecution().add(BehaviorExecutionOntarget);
//			startMOS.setOccurence(newStartExeOccurrence);
//			endMOS.setOccurence(newEndExeOccurrence);
			//create ContainerShape for MessageEnd
			
			
//			ContainerShape startMEContainer = peCreateService.createContainerShape(getDiagram(), true);
//			ContainerShape endMEContainer = peCreateService.createContainerShape(getDiagram(), true);
//			//create Anchor for Message
//			Anchor sourceAnchor = peCreateService.createChopboxAnchor(startMEContainer);
//			Anchor targetAnchor = peCreateService.createChopboxAnchor(endMEContainer);	
//			//link ContainerShape to MessageEnd
//			link(startMEContainer, BehaviorExecutionOnsource);
//			link(endMEContainer, BehaviorExecutionOntarget);
			
			
			//Check the Actor and Object to set the location of BehaviorExecutionSpecification
			int LocationSourceX = 0;
			int LocationTargetX = 0;
			Lifeline lifelineS = null;
			Lifeline lifelineT = null;
			ContainerShape startMEContainer = null;
			ContainerShape endMEContainer = null;
			boolean SourceExist = false;
			boolean TargetExist = false;
			for (Shape shape : getDiagram().getChildren())
	    	{
				//find actor and object to get the location for message start
	    		if(shape.getGraphicsAlgorithm() instanceof Rectangle) 
	    		{
	    			PictogramElement pe = (PictogramElement) shape;
	    			Object ob = getBusinessObjectForPictogramElement(pe);

	    			if(ob instanceof Actor)
	    			{
	    			    Actor actor = (Actor) ob;
	    				Lifeline ll = actor.getInclude();
	    				if(source == ll){//The desired actor
	    					//get the location
	    					LocationSourceX = pe.getGraphicsAlgorithm().getX()+pe.getGraphicsAlgorithm().getWidth()/2;
	    					lifelineS=ll;
	    				}
	    				else if(target == ll){
	    					LocationTargetX = pe.getGraphicsAlgorithm().getX()+pe.getGraphicsAlgorithm().getWidth()/2;
	    					lifelineT=ll;
	    				}
	    			}
	    			
	    			else if(ob instanceof behavior.Object){
	    				behavior.Object obj = (behavior.Object) ob;
	    				Lifeline ll = obj.getInclude();
	    				if(source == ll){
	    					//get the location
	    					LocationSourceX = pe.getGraphicsAlgorithm().getX()+pe.getGraphicsAlgorithm().getWidth()/2;
	    					lifelineS=ll;
	    				}
	    				else if(target == ll){
	    					LocationTargetX = pe.getGraphicsAlgorithm().getX()+pe.getGraphicsAlgorithm().getWidth()/2;
	    					lifelineT=ll;
	    				}
	    			}	    			
	    		}
	    	}//for 
			
	        if(context.getSourcePictogramElement()==context.getTargetPictogramElement())
	        {
	        	LocationTargetX = LocationSourceX;
	        	//add some bending-points
	        }


			//Check whether there have been a Rectangle stand for each BehaviorExecutionSpecification
			for (Shape shape : getDiagram().getChildren())
	    	{
				if(shape.getGraphicsAlgorithm() instanceof Rectangle) 
	    		{
					PictogramElement pe = (PictogramElement) shape;
	    			Object ob = getBusinessObjectForPictogramElement(pe);
					if(ob instanceof BehaviorExecutionSpecification){
						BehaviorExecutionSpecification bes = (BehaviorExecutionSpecification)ob;
						if (lifelineS == bes.getCovered().get(0)){
							SourceExist = true;
							startMEContainer =(ContainerShape) shape;
						}
						else if (lifelineT == bes.getCovered().get(0)){
							TargetExist = true;
							endMEContainer =(ContainerShape) shape;
						}
					}
	    		}				
			}//for Check
			if(!SourceExist){
				startMEContainer = peCreateService.createContainerShape(getDiagram(), true);
				Rectangle recStart = gaService.createRectangle(startMEContainer);
				gaService.setLocationAndSize(recStart, LocationSourceX-10, context.getSourceLocation().getY(), 21, 100);
			}
			if(!TargetExist){
				endMEContainer = peCreateService.createContainerShape(getDiagram(), true);
				Rectangle recTarget = gaService.createRectangle(endMEContainer);				
				gaService.setLocationAndSize(recTarget, LocationTargetX-10, context.getSourceLocation().getY(), 21, 100);
			}
			//link ContainerShape to MessageEnd
			link(startMEContainer, BehaviorExecutionOnsource);
			link(endMEContainer, BehaviorExecutionOntarget);
			ContainerShape startmg = peCreateService.createContainerShape(getDiagram(), true);
			ContainerShape targetmg = peCreateService.createContainerShape(getDiagram(), true);
			Rectangle dummyrects = gaService.createRectangle(startmg);
			Rectangle dummyrectt = gaService.createRectangle(targetmg);	
			dummyrects.setForeground(manageColor(MESSAGE_FOREGROUND));
			dummyrects.setBackground(manageColor(MESSAGE_FOREGROUND));
			dummyrectt.setForeground(manageColor(MESSAGE_FOREGROUND));
			dummyrectt.setBackground(manageColor(MESSAGE_FOREGROUND));
			Anchor sourceAnchor = peCreateService.createChopboxAnchor(startmg);
			Anchor targetAnchor = peCreateService.createChopboxAnchor(targetmg);
			
			
			//Check whether the message is from left to right, 
			//if not, then change the way to count location of each MessageOccurreceSpecification
	        if(LocationSourceX<LocationTargetX){
	        	gaService.setLocationAndSize(dummyrects,LocationSourceX,context.getSourceLocation().getY(),10,10);
				gaService.setLocationAndSize(dummyrectt,LocationTargetX-10,context.getSourceLocation().getY(),10,10);

	        }else if(LocationSourceX == LocationTargetX){
	        	gaService.setLocationAndSize(dummyrects, LocationSourceX, context.getSourceLocation().getY(),10,10);
	        	gaService.setLocationAndSize(dummyrectt, LocationTargetX, context.getSourceLocation().getY()+20,10,10);
	        }else{
	        	gaService.setLocationAndSize(dummyrects, LocationSourceX-10, context.getSourceLocation().getY(),10,10);
	        	gaService.setLocationAndSize(dummyrectt, LocationTargetX, context.getSourceLocation().getY(),10,10);
	        }

	        getDiagram().eResource().getContents().add(startMOS);
	        getDiagram().eResource().getContents().add(endMOS);
	        
	        link (startmg,startMOS);
	        link (targetmg,endMOS);
	        
			//link(recStart, newStartExeOccurrence);
			//link(recTarget, newEndExeOccurrence);
			//add ExecutionOccurrence to each Lifeline
//			source.getExecutions().add(newStartExeOccurrence);
//			target.getExecutions().add(newEndExeOccurrence);

			AddConnectionContext addContext =
					new AddConnectionContext(sourceAnchor, targetAnchor);
			addContext.setNewObject(message);
			newConnection =
					(Connection) getFeatureProvider().addIfPossible(addContext);
			getFeatureProvider().getDirectEditingInfo().setActive(true);
		}
		return newConnection;
}


	public boolean canStartConnection(ICreateConnectionContext context) {
		if (context.getSourcePictogramElement() instanceof FreeFormConnection) {
			Object object = getBusinessObjectForPictogramElement(context.getSourcePictogramElement());
			if (object instanceof Lifeline) {
				return true;
			}
		 }
		 return false;
	}
	
	private Lifeline getLifeline(PictogramElement pictogramE) {
		 if (pictogramE != null) {
		     Object object =
		         getBusinessObjectForPictogramElement(pictogramE);
		     if (object instanceof Lifeline) {
		         return (Lifeline) object;
		     }
		 }
		 return null;
		}
	
	@SuppressWarnings("unused")
	private ContainerShape getLifelineContainer(PictogramElement pictogramE){
		if (pictogramE instanceof FreeFormConnection){
			FreeFormConnection connection = (FreeFormConnection)pictogramE;
			if(connection.getStart().eContainer() instanceof ContainerShape)
				return (ContainerShape)connection.getStart().eContainer();
		}
		return null;
	}
	private Message createMessage(Lifeline source, Lifeline target) {		
		Message message = BehaviorFactory.eINSTANCE.createMessage();
		
//		int i=1;
//		for(Object ob : getDiagram().eResource().getContents()){			
//			if(ob instanceof Message){
//				i++;
//			}
//		}
		message.setArchpoint(true);
		message.setName(getMessageName());//+i
		//message.setEType(target);
		//message.setLowerBound(0);
		//message.setUpperBound(1);
		//source.getEStructuralFeatures().add(eReference);
		return message;
		}

	/**
	 * @return the messageName
	 */
	public String getMessageName() {
		return messageName;
	}

	/**
	 * @param messageName the messageName to set
	 */
	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}
}
