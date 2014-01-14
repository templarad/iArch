package jp.ac.kyushu.iarch.sequencediagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

public class MoveBehaviorExecutionFeature extends DefaultMoveShapeFeature{
	 
    public MoveBehaviorExecutionFeature (IFeatureProvider fp) {
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

    	gaService.setLocation(agToMove, agToMove.getX(), 
    			agToMove.getY()+context.getDeltaY());
    	

	}
    
}