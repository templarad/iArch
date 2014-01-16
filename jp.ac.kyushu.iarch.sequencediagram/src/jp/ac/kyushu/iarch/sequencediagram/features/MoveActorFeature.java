package jp.ac.kyushu.iarch.sequencediagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

import behavior.Actor;
import behavior.BehaviorExecutionSpecification;
import behavior.DestructionEvent;
import behavior.Lifeline;
import behavior.MessageOccurrenceSpecification;


public class MoveActorFeature extends DefaultMoveShapeFeature{
 
    public MoveActorFeature (IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public boolean canMoveShape(IMoveShapeContext context) {
        boolean canMove = super.canMoveShape(context);     	
        return canMove;
    }
    
    @Override
    public void moveShape(IMoveShapeContext context) {
    	IGaService gaService = Graphiti.getGaService();
    	GraphicsAlgorithm agToMove = context.getShape().getGraphicsAlgorithm();
    	gaService.setLocation(agToMove, agToMove.getX()+context.getDeltaX(), agToMove.getY());
    	for (Shape shape : getDiagram().getChildren())
    	{
    		//move the lifeline
    		if(shape.getGraphicsAlgorithm() instanceof Rectangle) 
    		{
    			PictogramElement pe = (PictogramElement) shape;
    			//PictogramElement pe = ((Rectangle)shape.getGraphicsAlgorithm()).getPictogramElement();
    			Object ob = getBusinessObjectForPictogramElement(pe);
    			//find the DestructionEvent for lifeline
    			if(ob instanceof DestructionEvent)
    			{
    				//
    				Shape shapeactor = context.getShape();
    			    Object bo = getBusinessObjectForPictogramElement(shapeactor);
    			    Actor actor = (Actor) bo;
    				Lifeline ll = actor.getInclude();
    				DestructionEvent thede = ll.getEndby();
    				if(thede == (DestructionEvent) ob){
    					//move the DestructionEvent
    					gaService.setLocation(pe.getGraphicsAlgorithm(),
    						pe.getGraphicsAlgorithm().getX()+context.getDeltaX(),
    						pe.getGraphicsAlgorithm().getY());
    				}
    			}
    			//find the BehaviorExecutionSpecification on the lifeline
    			if(ob instanceof BehaviorExecutionSpecification){
    				BehaviorExecutionSpecification be = (BehaviorExecutionSpecification) ob;
    				Shape shapeactor = context.getShape();
    			    Object bo = getBusinessObjectForPictogramElement(shapeactor);
    			    Actor actor = (Actor) bo;
    				Lifeline ll = actor.getInclude();
    				if (ll == be.getCovered().get(0)){
    					gaService.setLocation(pe.getGraphicsAlgorithm(),
        						pe.getGraphicsAlgorithm().getX()+context.getDeltaX(),
        						pe.getGraphicsAlgorithm().getY());
    				}
    			}
    			//find the MessageOccurreceSpecification on the lifeline
    			if(ob instanceof MessageOccurrenceSpecification)
    			{
    				//
    				Shape shapeactor = context.getShape();
    			    Object bo = getBusinessObjectForPictogramElement(shapeactor);
    			    behavior.Object object = (behavior.Object) bo;
    				Lifeline ll = object.getInclude();
    				MessageOccurrenceSpecification MOS = (MessageOccurrenceSpecification) ob;

    				if(ll == MOS.getCovered().get(0)){
    					//move the MessageOccurreceSpecification
    					gaService.setLocation(pe.getGraphicsAlgorithm(),
    						pe.getGraphicsAlgorithm().getX()+context.getDeltaX(),
    						pe.getGraphicsAlgorithm().getY());
    				}
    			}
    		}
    	}//for
    	
	}//move Shape
    
}