package jp.ac.kyushu.iarch.classdiagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;

import umlClass.Property;
 
public class AddAttributeFeature extends AbstractAddShapeFeature {
	private static final IColorConstant ATTRIBUTE_TEXT_FOREGROUND =
            IColorConstant.BLACK;
//    private static final IColorConstant ATTRIBUTE_TEXT_FOREGROUND =
//        IColorConstant.BLACK;
// 
//    private static final IColorConstant ATTRIBUTE_FOREGROUND =
//        new ColorConstant(98, 131, 167);
//
//    private static final IColorConstant ATTRIBUTE_BACKGROUND =
//        new ColorConstant(187, 218, 247);
// 
    public AddAttributeFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    public boolean canAdd(IAddContext context) {
        // check if user wants to add a Attribute
        if (context.getNewObject() instanceof Property) {
        	// check if user wants to add into a Class
        	ContainerShape shape = context.getTargetContainer();
        	Object bo=getBusinessObjectForPictogramElement(shape);
        	if(bo instanceof umlClass.Class){//if(!(shape instanceof Diagram))
        		return true;
        	}            
        }
        return false;
    }
 
    public PictogramElement add(IAddContext context) {
    	Property addedAttribute = (Property) context.getNewObject();
    	ContainerShape targetClass =  context.getTargetContainer();
    	Object bo=getBusinessObjectForPictogramElement(targetClass);
    	umlClass.Class eClass=(umlClass.Class) bo;
        // CONTAINER SHAPE WITH ROUNDED RECTANGLE
        IPeCreateService peCreateService = Graphiti.getPeCreateService();
 
        // define a default size for the shape
        int height = 50; 
        
        IGaService gaService = Graphiti.getGaService();
        peCreateService = Graphiti.getPeCreateService();
        gaService = Graphiti.getGaService();
        
        //Resize the Class graphic
        height = targetClass.getGraphicsAlgorithm().getHeight() <= eClass.getAttribute().size()*20+32 ? eClass.getAttribute().size()*20+32:targetClass.getGraphicsAlgorithm().getHeight();
        gaService.setSize(targetClass.getGraphicsAlgorithm(), targetClass.getGraphicsAlgorithm().getWidth(), height) ;
        {
        	
                // create shape for text
                Shape shape = peCreateService.createShape(targetClass, true);
     
                // create and set text graphics algorithm
                Text text = gaService.createText(shape, addedAttribute.getName());
                text.setForeground(manageColor(ATTRIBUTE_TEXT_FOREGROUND));
                text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT); 
                // vertical alignment has as default value "center"
                text.setFont(gaService.manageDefaultFont(getDiagram(), true, true));
                gaService.setLocationAndSize(text, 2, height-30, targetClass.getGraphicsAlgorithm().getWidth()-4, 20);
     
                // create link and wire it
                link(shape, addedAttribute);
                
        }
        peCreateService.createChopboxAnchor(targetClass);
        
        // call the layout feature
        layoutPictogramElement(targetClass);
        return targetClass;
    }
    
}