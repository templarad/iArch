package jp.ac.kyushu.iarch.dataflowdiagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;


public class AddProcessFeature extends AbstractAddShapeFeature {
	 
	private static final IColorConstant PROCESS_TEXT_FOREGROUND =
	        IColorConstant.BLACK;
	 
	    private static final IColorConstant PROCESS_FOREGROUND =
	        new ColorConstant(60, 120, 167);

	    private static final IColorConstant PROCESS_BACKGROUND =
	        new ColorConstant(170, 200, 247);
	 
	    public AddProcessFeature(IFeatureProvider fp) {
	        super(fp);
	    }
	 
	    public boolean canAdd(IAddContext context) {
	        // check if user wants to add a EClass
	        if (context.getNewObject() instanceof Dataflow_editor.Process) {
	            // check if user wants to add to a diagram
	            if (context.getTargetContainer() instanceof Diagram) {
	                return true;
	            }
	        }
	        return false;
	    }
	    
//	    private static int width = 90;
//		private static int height = 60;
		
//    start to describe the shape!!  //
	    
	    public PictogramElement add(IAddContext context) {
	    	Dataflow_editor.Process addedProcess = (Dataflow_editor.Process) context.getNewObject();
	        Diagram targetDiagram = (Diagram) context.getTargetContainer();
	 
	        
	        IPeCreateService peCreateService = Graphiti.getPeCreateService();
	        ContainerShape containerShape =
	             peCreateService.createContainerShape(targetDiagram, true);
	         
	        // define a default size for the shape
	        int width = context.getWidth() <= 0 ? 100 : context.getWidth();
//	        int height = context.getHeight() <= 0 ? 50 : context.getHeight();
//	        int width = 100;
//	        int height = 50; 
	        IGaService gaService = Graphiti.getGaService();
//	        RoundedRectangle roundedRectangle; // need to access it later
	        GraphicsAlgorithm containerAlgorithm = null;
	        
	        int x = context.getX();
			int y = context.getY();
			
	            // create and set graphics algorithm
	        int range = 90;
	        	
	        {
	        	
				containerAlgorithm = gaService.createEllipse(containerShape);
				gaService.setLocationAndSize(containerAlgorithm, x, y, range, range);
				containerAlgorithm.setForeground(manageColor(PROCESS_FOREGROUND));
				containerAlgorithm.setBackground(manageColor(PROCESS_BACKGROUND));
				containerAlgorithm.setLineWidth(2);             	            
	            link(containerShape, addedProcess);
	        }
	        
	        // SHAPE WITH TEXT
	        {

	            Shape shape = peCreateService.createShape(containerShape, false);
	            Text text = gaService.createText(shape, addedProcess.getName());
	            text.setForeground(manageColor(PROCESS_TEXT_FOREGROUND));
	            text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER); 
	            text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
	            gaService.setLocationAndSize(text,-5, 33, width, 20);
	 
	            link(shape, addedProcess);
	        }

	           peCreateService.createChopboxAnchor(containerShape);
	           layoutPictogramElement(containerShape);
	        return containerShape;
	    }
	    
	}