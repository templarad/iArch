package jp.ac.kyushu.iarch.classdiagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;


import umlClass.Operation;
import umlClass.Property;

public class UpdateClassFeature extends AbstractUpdateFeature {
    
    public UpdateClassFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    public boolean canUpdate(IUpdateContext context) {
        // return true, if linked business object is a EClass
        Object bo =
            getBusinessObjectForPictogramElement(context.getPictogramElement());
        return (bo instanceof umlClass.Class);
    }
 
    public IReason updateNeeded(IUpdateContext context) {
        // retrieve name from pictogram model
        String pictogramName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        if (pictogramElement instanceof ContainerShape) {
            ContainerShape cs = (ContainerShape) pictogramElement;
            for (Shape shape : cs.getChildren()) {
                if (shape.getGraphicsAlgorithm() instanceof Text) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    pictogramName = text.getValue();
                    break;
                }
            }
        }
 
        // retrieve name from business model
        String businessName = null;
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof umlClass.Class) {
        	umlClass.Class eClass = (umlClass.Class) bo;
            businessName = eClass.getName();
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
    	
    	int linenum=0;
        String businessName = null;
        String name=null;
        PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof umlClass.Class) {
        	umlClass.Class eClass = (umlClass.Class) bo;
            businessName = eClass.getName();            
        }
 
        // Set name in pictogram model
        if (pictogramElement instanceof ContainerShape) {
        	int i=0;
        	int j=1;
        	ContainerShape cs = (ContainerShape) pictogramElement;
            umlClass.Class eClass = (umlClass.Class) getBusinessObjectForPictogramElement(cs);
            IGaService gaService = Graphiti.getGaService();
            int width=cs.getGraphicsAlgorithm().getWidth();
            int height = cs.getGraphicsAlgorithm().getHeight() <= eClass.getAttribute().size()*20+eClass.getOwnedOperation().size()*20+32 ? eClass.getAttribute().size()*20+eClass.getOwnedOperation().size()*20+32:cs.getGraphicsAlgorithm().getHeight();
            int start=eClass.getAttribute().size()*20+32;
            gaService.setSize(cs.getGraphicsAlgorithm(), width, height) ;
            for (Shape shape : cs.getChildren()) {            	
            	Object bos = getBusinessObjectForPictogramElement(shape);
                if (shape.getGraphicsAlgorithm() instanceof Text&&bo instanceof umlClass.Class) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    text.setValue(businessName);
                }
                if (shape.getGraphicsAlgorithm() instanceof Text&&bos instanceof Operation) {
                    name = ((Operation) bos).getName() + "()";
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    text.setValue(name);
                    gaService.setLocationAndSize(text, 2, start+i*20, cs.getGraphicsAlgorithm().getWidth()-4, 20);
                    i++;
                }
                if (shape.getGraphicsAlgorithm() instanceof Text&&bos instanceof Property) {
                	name = ((Property) bos).getName();
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    text.setValue(name);
                    gaService.setLocationAndSize(text, 2, j*20, cs.getGraphicsAlgorithm().getWidth()-4, 20);
                    j++;
                }
                if (shape.getGraphicsAlgorithm() instanceof Polyline) {
                	linenum++;
                	if(linenum==2){
                		Polyline polyline = (Polyline) shape.getGraphicsAlgorithm();
	                    polyline.getPoints().get(0).setY(start);
	                    polyline.getPoints().get(1).setY(start);
	                    }
                }
                
            }
            return true;
        }
 
        return false;
////////////////////////////////////////////////
//    	String businessName = null;
//        PictogramElement pictogramElement = context.getPictogramElement();
//        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
//        if (bo instanceof umlClass.Class) {
//        	umlClass.Class eClass = (umlClass.Class) bo;
//            businessName = eClass.getName();
//        }
// 
//        // Set name in pictogram model
//        if (pictogramElement instanceof ContainerShape) {
//            ContainerShape cs = (ContainerShape) pictogramElement;
//            for (Shape shape : cs.getChildren()) {
//                if (shape.getGraphicsAlgorithm() instanceof Text) {
//                    Text text = (Text) shape.getGraphicsAlgorithm();
//                    text.setValue(businessName);
//                    return true;
//                }
//            }
//        }
// 
//        return false;
////////////////////////////////////////////    
    }
}