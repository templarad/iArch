package jp.ac.kyushu.iarch.classdiagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import umlClass.Operation;
 
public class AddOperationFeature extends AbstractAddShapeFeature {
	private static final IColorConstant OPERATION_TEXT_FOREGROUND =
            IColorConstant.BLACK;
//    private static final IColorConstant ATTRIBUTE_TEXT_FOREGROUND =
//        IColorConstant.BLACK;
// 
    private static final IColorConstant OPERATION_FOREGROUND =
        new ColorConstant(98, 131, 167);

//    private static final IColorConstant ATTRIBUTE_BACKGROUND =
//        new ColorConstant(187, 218, 247);
// 
    public AddOperationFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    public boolean canAdd(IAddContext context) {
        // check if user wants to add a Attribute
        if (context.getNewObject() instanceof Operation) {
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
        int linenum=0;
        // define a default size for the shape
        int height;
    	Operation addedOperation = (Operation) context.getNewObject();
    	ContainerShape targetClass =  context.getTargetContainer();
    	Object bo=getBusinessObjectForPictogramElement(targetClass);
    	umlClass.Class eClass=(umlClass.Class) bo;
        // CONTAINER SHAPE WITH ROUNDED RECTANGLE
        IPeCreateService peCreateService = Graphiti.getPeCreateService();
 
        
        
        IGaService gaService = Graphiti.getGaService();
        peCreateService = Graphiti.getPeCreateService();
        gaService = Graphiti.getGaService();
        
        //Define the Operation graphic
        int width=targetClass.getGraphicsAlgorithm().getWidth();
        height = targetClass.getGraphicsAlgorithm().getHeight() <= eClass.getAttribute().size()*20+eClass.getOwnedOperation().size()*20+32 ? eClass.getAttribute().size()*20+eClass.getOwnedOperation().size()*20+32:targetClass.getGraphicsAlgorithm().getHeight();
        gaService.setSize(targetClass.getGraphicsAlgorithm(), width, height) ;
        int start=eClass.getAttribute().size()*20+32;

        for (Shape shape : targetClass.getChildren()) {
            if (shape.getGraphicsAlgorithm() instanceof Polyline) {
            	linenum++;
            	}
            }
        if(linenum==1)
        // SHAPE WITH LINE
        {
            // create shape for line
            Shape shape = peCreateService.createShape(targetClass, false);
 
            // create and set graphics algorithm
            Polyline polyline =
                gaService.createPolyline(shape, new int[] { 0, start, width, start });
            polyline.setForeground(manageColor(OPERATION_FOREGROUND));
            polyline.setLineWidth(2);
        }
        
        
        {
        	
                // create shape for operation
                Shape shape = peCreateService.createShape(targetClass, true);
     
                // create and set text graphics algorithm
              //DataType datetype = addedOperation.getDatatype();
                //System.out.println(datetype.getName()+"...operation name:"+datetype.getOwnedOperation().get(0).getName());
                Text text = gaService.createText(shape,addedOperation.getName()+"()");
                text.setForeground(manageColor(OPERATION_TEXT_FOREGROUND));
                text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT); 
                // vertical alignment has as default value "center"
                text.setFont(gaService.manageDefaultFont(getDiagram(), true, true));
                gaService.setLocationAndSize(text, 2, start, targetClass.getGraphicsAlgorithm().getWidth()-4, 20);
     
                // create link and wire it
                link(shape, addedOperation);

        }

        //layoutPictogramElement(targetClass);
        peCreateService.createChopboxAnchor(targetClass);
        
        // call the layout feature
        layoutPictogramElement(targetClass);
        return targetClass;
    }
    
}