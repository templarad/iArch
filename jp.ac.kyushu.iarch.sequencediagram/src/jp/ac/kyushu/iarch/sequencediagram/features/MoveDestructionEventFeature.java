package jp.ac.kyushu.iarch.sequencediagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

import behavior.DestructionEvent;

public class MoveDestructionEventFeature extends DefaultMoveShapeFeature{
 
    public MoveDestructionEventFeature (IFeatureProvider fp) {
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
		//find all DestructionEvents
    	for (Shape shape : getDiagram().getChildren())
    	{
    		//move the lifeline
    		if(shape.getGraphicsAlgorithm() instanceof Rectangle) 
    		{
    			PictogramElement pe = (PictogramElement) shape;
    			//PictogramElement pe = ((Rectangle)shape.getGraphicsAlgorithm()).getPictogramElement();
    			Object ob = getBusinessObjectForPictogramElement(pe);
    			if(ob instanceof DestructionEvent)
    			{
    				//move the DestructionEvent
					gaService.setLocation(pe.getGraphicsAlgorithm(),
							pe.getGraphicsAlgorithm().getX(),
							pe.getGraphicsAlgorithm().getY()+context.getDeltaY());    				
    			}
    		}
    	}//for Shape in Diagram Children    	
	}  
    
}