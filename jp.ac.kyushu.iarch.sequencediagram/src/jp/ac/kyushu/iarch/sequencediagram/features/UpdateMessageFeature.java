package jp.ac.kyushu.iarch.sequencediagram.features;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import behavior.Message;
import behavior.MessageOccurrenceSpecification;

public class UpdateMessageFeature extends AbstractUpdateFeature {
	 
    public UpdateMessageFeature(IFeatureProvider fp) {
        super(fp);
    }
    public boolean canUpdate(IUpdateContext context) {
        // return true, if linked business object is a Association
        Object bo =
            getBusinessObjectForPictogramElement(context.getPictogramElement());
        return (bo instanceof Message);
    }
 
    public IReason updateNeeded(IUpdateContext context) {
        Object bo =
                getBusinessObjectForPictogramElement(context.getPictogramElement());
        if(bo instanceof Message){
        	Message mg = (Message) bo;
            PictogramElement pictogramElement = context.getPictogramElement();
            if (pictogramElement instanceof FreeFormConnection) {
            	FreeFormConnection cs = (FreeFormConnection) pictogramElement;
            	for (Shape shape : cs.getConnectionDecorators()) {
                    if (shape.getGraphicsAlgorithm() instanceof Text) {
                        Text text = (Text) shape.getGraphicsAlgorithm();
                        if(!text.getValue().equals(mg.getName()))
                        	return Reason.createTrueReason();
                    }
                }
            }
        }
        return Reason.createFalseReason();
    }
 
    public boolean update(IUpdateContext context) {
        // retrieve name from business model
        String businessName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof Message) {
        	Message eMessage = (Message) bo;
            businessName = eMessage.getName();
        }
 
        // Set name in pictogram model
        if (pictogramElement instanceof FreeFormConnection) {
        	FreeFormConnection cs = (FreeFormConnection) pictogramElement;
            for (Shape shape : cs.getConnectionDecorators()) {
                if (shape.getGraphicsAlgorithm() instanceof Text) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    text.setValue(businessName);
                    sortMessage();
                    return true;
                }
            }
        }
        return false;
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
    		
    		System.out.println("Message:"+mginstance.getMessageOrder()+" "+ mginstance.getName());
    		i++;
    	}
    	return true;
    }

}