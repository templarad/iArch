package jp.ac.kyushu.iarch.sequencediagram.diagram.providers;

import jp.ac.kyushu.iarch.sequencediagram.features.*;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IMoveAnchorFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IMoveAnchorContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import behavior.Actor;
import behavior.BehaviorExecutionSpecification;
import behavior.DestructionEvent;
import behavior.Lifeline;
import behavior.Message;
import behavior.MessageOccurrenceSpecification;

public class SequenceFeatureProvider extends DefaultFeatureProvider {

	public SequenceFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}
	
	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		if(context.getNewObject() instanceof behavior.Actor){
			return new AddActorFeature(this);
		}else if(context.getNewObject() instanceof behavior.Object){
			return new AddObjectFeature(this);
		}else if(context.getNewObject() instanceof behavior.Lifeline){
			return new AddLifelineFeature(this);
		}else if(context.getNewObject() instanceof behavior.Message){
			return new AddMessageFeature(this);
		}
		return super.getAddFeature(context);
	}
	
	@Override
	public ICreateFeature[] getCreateFeatures() {
		return new ICreateFeature[]{new CreateObjectFeature(this), 
									new CreateActorFeature(this)};
	}
	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
	   PictogramElement pictogramElement = context.getPictogramElement();
	   if (pictogramElement  instanceof ContainerShape) {
	       Object bo = getBusinessObjectForPictogramElement(pictogramElement);
	       if (bo instanceof Actor) {
	           return new UpdateActorFeature(this);
	       }
	       if (bo instanceof behavior.Object) {
	           return new UpdateObjectFeature(this);
	       }	       
       }else if(pictogramElement instanceof FreeFormConnection){
    	   Object bo = getBusinessObjectForPictogramElement(pictogramElement);
    	   if(bo instanceof Message){
    		   return new UpdateMessageFeature(this);
    	   }
       }else if(pictogramElement instanceof ConnectionDecorator){
    	   if(pictogramElement.eContainer() instanceof FreeFormConnection){
    		   Object bo = getBusinessObjectForPictogramElement((FreeFormConnection)pictogramElement.eContainer());
    		   if (bo instanceof Message){
    			   return new UpdateMessageFeature(this);
    		   }
    	   }
       }
	   return super.getUpdateFeature(context);
	 } 
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		
		return new ICreateConnectionFeature[]{new CreateLifelineFeature(this),
											  new CreateMessageFeature(this)};
	}
	@Override
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
	    Shape shape = context.getShape();
	    Object bo = getBusinessObjectForPictogramElement(shape);
	    if (bo instanceof Lifeline) {
	        return new MoveLifelineFeature(this);
	    }	    
	    else if (bo instanceof Actor) {
	        return new MoveActorFeature(this);
	    }else if (bo instanceof behavior.Object) {
	        return new MoveObjectFeature(this);
	    }else if (bo instanceof DestructionEvent) {
	        return new MoveDestructionEventFeature(this);
	    }else if (bo instanceof BehaviorExecutionSpecification) {
	        return new MoveBehaviorExecutionFeature(this);
	    }else if (bo instanceof MessageOccurrenceSpecification){
	    	return new MoveMessageOccurrenceSpecificationFeature(this);
	    }
	    return super.getMoveShapeFeature(context);
	 } 
	@Override
	public IMoveAnchorFeature getMoveAnchorFeature(IMoveAnchorContext context) {
		
		return new MoveAnchorFeature(this);
	}
	@Override
	public IReconnectionFeature getReconnectionFeature(IReconnectionContext context) {
		return new ReconnectionFeature(this);
		} 
	@Override
	public IDirectEditingFeature getDirectEditingFeature(
	    IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pe);
        if (bo instanceof Actor) {
            return new DirectEditActorFeature(this);
        }
        else if(bo instanceof behavior.Object){
        	return new DirectEditObjectFeature(this);
        }
        else if(bo instanceof Message){
        	return new DirectEditMessageFeature(this);
        }
        else if(pe instanceof ConnectionDecorator){
        	return new DirectEditMessageFeature(this);
        }
        return super.getDirectEditingFeature(context);
     } 
	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
	    return new ICustomFeature[] { new RenameMessageFeature(this),
	    							new GenerateSequenceDiagramFeature(this)};
	} 
	@Override
	public IResizeShapeFeature getResizeShapeFeature(
	        IResizeShapeContext context) {
	    Shape shape = context.getShape();
	    Object bo = getBusinessObjectForPictogramElement(shape);
	    if (bo instanceof DestructionEvent) {
	        return new ResizeDestructionEventFeature(this);
	    }else if (bo instanceof Actor) {
	        return new ResizeActorFeature(this);
	    }else if (bo instanceof behavior.Object) {
	        return new ResizeObjectFeature(this);
	    }else if (bo instanceof BehaviorExecutionSpecification) {
	        return new ResizeBehaviorExecutionFeature(this);
	    }else if (bo instanceof MessageOccurrenceSpecification) {
	        return new ResizeMessageOccurrenceSpecificationFeature(this);
	    }
	    return super.getResizeShapeFeature(context);
	 }
	
}
