package jp.ac.kyushu.iarch.sequencediagram.features;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.ILinkService;

import behavior.DestructionEvent;
import behavior.Message;
import behavior.MessageOccurrenceSpecification;

public class MoveMessageOccurrenceSpecificationFeature extends DefaultMoveShapeFeature{
 
    public MoveMessageOccurrenceSpecificationFeature (IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public boolean canMoveShape(IMoveShapeContext context) {
        //boolean canMove = super.canMoveShape(context);
    	boolean canMove = true;
        
        return canMove;
    }
    @Override
    public void moveShape(IMoveShapeContext context) {
    	ILinkService linkServivce = Graphiti.getLinkService();
    	IGaService gaService = Graphiti.getGaService();
    	GraphicsAlgorithm agToMove = context.getShape().getGraphicsAlgorithm();
    	
    	int posY = 0;//The position which will be moved to.
    	int locationY = 0;//To limit the position.
    	
    	//Check if the MOS is moved to another container shape. 
    	//If yes, the position should be counted by another way.
    	if(context.getTargetContainer() instanceof ContainerShape)
    	{
    		posY = context.getTargetContainer().getGraphicsAlgorithm().getY()+context.getY();
    	}else {
    		posY = agToMove.getY()+context.getDeltaY();
    	}
    	
    	//If there have been a DestructionEvent, get the location Y
		for(Shape shape:getDiagram().getChildren())
		{
			Object bo = getBusinessObjectForPictogramElement(shape);
			if (bo instanceof DestructionEvent)
			{
				locationY = shape.getGraphicsAlgorithm().getY();
				break;
			}
		}
		
		//Limit the posY between Object and DestructionEvent
		if (posY<95) posY = 95;//Object's default position.
		if (posY>locationY-10) posY=locationY-10;
		
    	gaService.setLocation(agToMove, agToMove.getX(), posY);
    	Object ob = getBusinessObjectForPictogramElement(context.getPictogramElement());
    	
    	//Move MOS, both source and target.
		if (ob instanceof MessageOccurrenceSpecification){
			boolean IsStart;//The context to be moved is a source MOS.
			MessageOccurrenceSpecification MgWhich = (MessageOccurrenceSpecification) ob;
			MessageOccurrenceSpecification Mgstart = (MessageOccurrenceSpecification)MgWhich.getMessage().getSendEvent();
			MessageOccurrenceSpecification Mgend = (MessageOccurrenceSpecification)Mgstart.getMessage().getReceiveEvent();
			if(MgWhich == Mgstart)IsStart = true;
			else IsStart = false;
			
			
			//When move the start MOS, find the end MOS and check if they are in the same lifeline by //#check. 
			if(IsStart){
				for (PictogramElement pe : linkServivce.getPictogramElements(getDiagram(), Mgend)){
					if (pe instanceof ContainerShape&&
							(MessageOccurrenceSpecification)getBusinessObjectForPictogramElement(pe) == Mgend)//&&pe.getGraphicsAlgorithm().getX()==context.getX()
					{		
						//#check
						if(pe.getGraphicsAlgorithm().getX() != context.getShape().getGraphicsAlgorithm().getX())
						gaService.setLocation(pe.getGraphicsAlgorithm(), pe.getGraphicsAlgorithm().getX(), posY);
					}
					else if(pe instanceof ContainerShape&&
							(MessageOccurrenceSpecification)getBusinessObjectForPictogramElement(pe) == Mgstart)
					{					
						gaService.setLocation(pe.getGraphicsAlgorithm(), pe.getGraphicsAlgorithm().getX(), posY);
					}
				}
			}
			else{
				for (PictogramElement pe : linkServivce.getPictogramElements(getDiagram(), Mgstart)){
					if (pe instanceof ContainerShape&&
							(MessageOccurrenceSpecification)getBusinessObjectForPictogramElement(pe) == Mgend)//&&pe.getGraphicsAlgorithm().getX()==context.getX()
					{		
						gaService.setLocation(pe.getGraphicsAlgorithm(), pe.getGraphicsAlgorithm().getX(), posY);
					}
					else if(pe instanceof ContainerShape&&
							(MessageOccurrenceSpecification)getBusinessObjectForPictogramElement(pe) == Mgstart)
					{
						//#check
						if(pe.getGraphicsAlgorithm().getX() != context.getShape().getGraphicsAlgorithm().getX())
						gaService.setLocation(pe.getGraphicsAlgorithm(), pe.getGraphicsAlgorithm().getX(), posY);
					}
				}
				
			}//(When move start...) if 
    	
	    	
		}//if
		sortMessage();
		
	}
    public boolean sortMessage(){
    	int i=0;
    	int order=0;
    	int locationY;//locationX,
    	String MgCounted=null;
    	List<Shape> mos=new ArrayList<Shape>();
    	for(Shape shape:getDiagram().getChildren())
		{
			Object bo = getBusinessObjectForPictogramElement(shape);
			if (bo instanceof MessageOccurrenceSpecification)
			{
				if(mos.size()==0){
					mos.add(shape);
					MgCounted=((MessageOccurrenceSpecification)bo).getMessage().getName();
					continue;
				}
				//If a message have the same name,
				//it has been add into the mos array. 
				if(MgCounted == ((MessageOccurrenceSpecification)bo).getMessage().getName())
					continue;
				
				
				locationY = shape.getGraphicsAlgorithm().getY();
				//locationX = shape.getGraphicsAlgorithm().getX();
				//Check where to insert a shape into the mos[]
				i=0;
				for(Shape sortShape:mos){
					if(sortShape==null)break;
					if(locationY < sortShape.getGraphicsAlgorithm().getY()){
						order=i;
						break;
					}
					//Case in the same Y 
					else if(locationY == sortShape.getGraphicsAlgorithm().getY()){
						order=i+1;
						break;
					}
					i++;
					order=i;
				}
				//insert by the order information
				mos.add(order, shape);
				//mos=insert(mos,shape,order);
				MgCounted=((MessageOccurrenceSpecification)bo).getMessage().getName();				
			}
		}
    	i=0;
    	for(Shape sortShape:mos){
    		if(sortShape==null)break;
    		MessageOccurrenceSpecification mosinstance=
    				(MessageOccurrenceSpecification)getBusinessObjectForPictogramElement(sortShape);
    		Message mginstance = mosinstance.getMessage();
    		mginstance.setMessageOrder(i);//set order information in business model
    		
    		//System.out.println("Message:"+mginstance.getMessageOrder()+" "+ mginstance.getName());
    		i++;
    	}
    	return true;
    }
    
//    public static Shape[] insert (List<Shape> ori, Shape val, int index) {
//        for (int i=ori.size()-1; i>index; i--){            
//            if(ori.get(i-1)==null)continue;
//            ori.get(i) = ori[i-1];
//        }
//        ori[index] = val;
//        return ori;
//    }
}