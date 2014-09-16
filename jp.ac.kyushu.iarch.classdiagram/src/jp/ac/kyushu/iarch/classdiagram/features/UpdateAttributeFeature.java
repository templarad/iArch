package jp.ac.kyushu.iarch.classdiagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;

import org.eclipse.graphiti.mm.algorithms.Text;


import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;


public class UpdateAttributeFeature extends AbstractUpdateFeature {
    
    public UpdateAttributeFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    public boolean canUpdate(IUpdateContext context) {
        // return true, if linked business object is a EClass
        Object bo =
            getBusinessObjectForPictogramElement(context.getPictogramElement());
        return (bo instanceof umlClass.Property||bo instanceof umlClass.Operation);
    }
 
    public IReason updateNeeded(IUpdateContext context) {
        // retrieve name from pictogram model
        String pictogramName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        if (pictogramElement instanceof Shape) {
        	Shape shape = (Shape) pictogramElement;
        	Text text = (Text) shape.getGraphicsAlgorithm();
            pictogramName = text.getValue();
            
        }
 
        // retrieve name from business model
        String businessName = null;
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof umlClass.Property) {
        	umlClass.Property eProperty = (umlClass.Property) bo;
            businessName = eProperty.getName();
        }else if(bo instanceof umlClass.Operation){
        	umlClass.Operation eOperation = (umlClass.Operation) bo;
            businessName = eOperation.getName()+"()";
        }
 
        // update needed, if names are different
        boolean updateNameNeeded =
            ((pictogramName == null && businessName != null) || 
                (pictogramName != null && !pictogramName.equals(businessName)));
        if (updateNameNeeded) {
            return Reason.createTrueReason("Name is out of date");
        } else {
            return Reason.createFalseReason();
        }
    }
 
    public boolean update(IUpdateContext context) {
        // retrieve name from business model
  ///////////////////////////////////////  	
    	String businessName = null;
    	PictogramElement pictogramElement = context.getPictogramElement();
    	Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof umlClass.Property) {
        	umlClass.Property eProperty = (umlClass.Property) bo;
            businessName = eProperty.getName();
        }else if(bo instanceof umlClass.Operation){
        	umlClass.Operation eOperation = (umlClass.Operation) bo;
            businessName = eOperation.getName()+"()";
        }

        if (pictogramElement instanceof Shape) {
        	Shape shape = (Shape) pictogramElement;
        	Text text = (Text) shape.getGraphicsAlgorithm();
            text.setValue(businessName);
            
        }
        return true;

    }
}