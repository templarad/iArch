package jp.ac.kyushu.iarch.sequencediagram.features;

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
                    return true;
                }
            }
        }
        return false;
    }

}