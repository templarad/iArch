package jp.ac.kyushu.iarch.classdiagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import umlClass.Association;

public class UpdateAssociationFeature extends AbstractUpdateFeature {
	 
    public UpdateAssociationFeature(IFeatureProvider fp) {
        super(fp);
    }
    public boolean canUpdate(IUpdateContext context) {
        // return true, if linked business object is a Association
        Object bo =
            getBusinessObjectForPictogramElement(context.getPictogramElement());
        return (bo instanceof Association);
    }
 
    public IReason updateNeeded(IUpdateContext context) {
        // retrieve name from pictogram model
//        String pictogramName = null;
//        PictogramElement pictogramElement = context.getPictogramElement();
//        if (pictogramElement instanceof FreeFormConnection) {
//        	FreeFormConnection ff = (FreeFormConnection) pictogramElement;
//            for (Shape shape : ff.) {////Žæ‚ê‚È‚¢
//                if (shape.getGraphicsAlgorithm() instanceof Text) {
//                    Text text = (Text) shape.getGraphicsAlgorithm();
//                    pictogramName = text.getValue();
//                }
//            }
//        }
// 
//        // retrieve name from business model
//        String businessName = null;
//        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
//        if (bo instanceof Association) {
//        	Association eReference = (Association) bo;
//            businessName = eReference.getName();
//        }
// 
//        // update needed, if names are different
//        boolean updateNameNeeded =
//            ((pictogramName == null && businessName != null) || 
//                (pictogramName != null && !pictogramName.equals(businessName)));
//        if (updateNameNeeded) {
//            return Reason.createTrueReason("Name is out of date");
//        } else {
//            return Reason.createFalseReason();
//        }
        return Reason.createFalseReason();
    }
 
    public boolean update(IUpdateContext context) {
        // retrieve name from business model
        String businessName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof Association) {
        	Association eReference = (Association) bo;
            businessName = eReference.getName();
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