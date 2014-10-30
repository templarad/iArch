package jp.ac.kyushu.iarch.dataflowdiagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;

public class AddExternal_entityFeature extends AbstractAddShapeFeature {
	 
	private static final IColorConstant EE_TEXT_FOREGROUND =
	        IColorConstant.BLACK;
	 
	    private static final IColorConstant EE_FOREGROUND =         //frame color  
	    		IColorConstant.BLACK;

	    private static final IColorConstant EE_BACKGROUND =
	    		IColorConstant.ORANGE;
	 
	    public AddExternal_entityFeature(IFeatureProvider fp) {
	        super(fp);
	    }
	 
	    public boolean canAdd(IAddContext context) {
	        // check if user wants to add a EClass
	        if (context.getNewObject() instanceof Dataflow_editor.External_entity) {
	            // check if user wants to add to a diagram
	            if (context.getTargetContainer() instanceof Diagram) {
	                return true;
	            }
	        }
	        return false;
	    }
	 
	    public PictogramElement add(IAddContext context) {
	    	Dataflow_editor.External_entity addedExternal_entity = (Dataflow_editor.External_entity) context.getNewObject();
	        Diagram targetDiagram = (Diagram) context.getTargetContainer();
	 
	        // CONTAINER SHAPE WITH ROUNDED RECTANGLE
	        IPeCreateService peCreateService = Graphiti.getPeCreateService();
	        ContainerShape containerShape =
	             peCreateService.createContainerShape(targetDiagram, true);
	 
	        // define a default size for the shape
	        int width = context.getWidth() <= 0 ? 100 : context.getWidth();
	        int height = context.getHeight() <= 0 ? 50 : context.getHeight();
//	        int width = 100;
//	        int height = 50; 
	        IGaService gaService = Graphiti.getGaService();
	        RoundedRectangle roundedRectangle; // need to access it later
	 
	        {
	            // create and set graphics algorithm
	            roundedRectangle =
	                gaService.createRoundedRectangle(containerShape, 5, 5);
	            roundedRectangle.setForeground(manageColor(EE_FOREGROUND));
	            roundedRectangle.setBackground(manageColor(EE_BACKGROUND));
	            roundedRectangle.setLineWidth(2);                           //Frame width
	            gaService.setLocationAndSize(roundedRectangle,
	                context.getX(), context.getY(), width, height);
	 
	            // if added Class has no resource we add it to the resource 
	            // of the diagram
	            // in a real scenario the business model would have its own resource
	            if (addedExternal_entity.eResource() == null) {
	                     getDiagram().eResource().getContents().add(addedExternal_entity);
	            }
	            // create link and wire it
	            link(containerShape, addedExternal_entity);
	        }
	 
	        // SHAPE WITH TEXT
	        {
	            // create shape for text
	            Shape shape = peCreateService.createShape(containerShape, false);

	            Text text = gaService.createText(shape, addedExternal_entity.getName());
	            text.setForeground(manageColor(EE_TEXT_FOREGROUND));
	            text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER); 
	            text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
	            gaService.setLocationAndSize(text,0,14, width, 20);

	            link(shape, addedExternal_entity);
	        }
	     
	        	peCreateService.createChopboxAnchor(containerShape);
	        	layoutPictogramElement(containerShape);
	        return containerShape;
	    }
	    
	}