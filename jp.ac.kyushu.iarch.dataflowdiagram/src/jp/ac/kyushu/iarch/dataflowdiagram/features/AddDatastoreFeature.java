package jp.ac.kyushu.iarch.dataflowdiagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
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

public class AddDatastoreFeature extends AbstractAddShapeFeature {
	 
	private static final IColorConstant DATASTORE_TEXT_FOREGROUND =
	        IColorConstant.BLACK;
	 
	    private static final IColorConstant DATASTORE_FOREGROUND =
	    		IColorConstant.BLACK;

//	    private static final IColorConstant DATASTORE_BACKGROUND =
//	    		IColorConstant.WHITE;
	 
	    public AddDatastoreFeature(IFeatureProvider fp) {
	        super(fp);
	    }
	 
	    public boolean canAdd(IAddContext context) {  
	        if (context.getNewObject() instanceof Dataflow_editor.DataStore) {
	            if (context.getTargetContainer() instanceof Diagram) {
	                return true;
	            }
	        }
	        return false;
	    }
	 
	    
	    public PictogramElement add(IAddContext context) {
	    	Dataflow_editor.DataStore addedDataStore = (Dataflow_editor.DataStore) context.getNewObject();
	        Diagram targetDiagram = (Diagram) context.getTargetContainer();
	 
	        // CONTAINER SHAPE WITH ROUNDED RECTANGLE
	        IPeCreateService peCreateService = Graphiti.getPeCreateService();
	        ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
	        // define a default size for the shape
	        //int width = context.getWidth() <= 0 ? 100 : context.getWidth();
	        //int height = context.getHeight() <= 0 ? 50 : context.getHeight();
	        
	        int width = 120;
	        int height = 60; 
	        
	        IGaService gaService = Graphiti.getGaService();
	        Rectangle rect;  // dummy Rect      
	        {            
	        		rect = gaService.createRectangle(containerShape);
	        		rect.setForeground(manageColor(255, 255, 255));   
	    			//rect.setBackground(manageColor(DATASTORE_BACKGROUND));   //white
	    			rect.setFilled(false);            //< !!!set filled!!! >
	    			gaService.setLocationAndSize(rect, context.getX(),context.getY(), width, height);  //y=30
	    			if (addedDataStore.eResource() == null) {
	                    getDiagram().eResource().getContents().add(addedDataStore);
	                    }        
	    			link(containerShape, addedDataStore);
	        }	
	     // SHAPE WITH TEXT
	        {
				Shape shape = peCreateService.createShape(containerShape, false);
				Text text = gaService.createText(shape, addedDataStore.getName());
				text.setForeground(manageColor(DATASTORE_TEXT_FOREGROUND));
				text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
				text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
				gaService.setLocationAndSize(text, 5, -15, width, 80);
				link(shape, addedDataStore);
			}
	        {
	        	Shape shape = peCreateService.createShape(containerShape, false);
	        	Polyline downline = gaService.createPolyline(shape, new int[]{10,0,width-1,0});
	        	downline.setForeground(manageColor(DATASTORE_FOREGROUND));      //black
	        	downline.setBackground(manageColor(255,255,255)); 
	        	downline.setLineWidth(2);
	        	link(shape, addedDataStore);	        		
	        }	        	
	        {
	        	Shape shape = peCreateService.createShape(containerShape, false);
	        	Polyline upline = gaService.createPolyline(shape, new int[]{10,height-15,width-1,height-15});
	        	upline.setForeground(manageColor(DATASTORE_FOREGROUND));
	        	upline.setBackground(manageColor(255,255,255)); 
	        	upline.setLineWidth(2);
	        	link(shape, addedDataStore);
	        }
	     
	        	
    		
	        /*	   
	        
	        // SHAPE WITH TEXT
	        {
	            // create shape for text
	            Shape shape = peCreateService.createShape(containerShape, false);
	 
	            // create and set text graphics algorithm
	            Text text = gaService.createText(shape, addedDataStore.getName());
	            text.setForeground(manageColor(DATASTORE_TEXT_FOREGROUND));
	            text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER); 
	            // vertical alignment has as default value "center"
	            text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
	            gaService.setLocationAndSize(text, 0, 0, width, 20);
	 
	            // create link and wire it
	            link(shape, addedDataStore);
	        }
	        
	        */
	        peCreateService.createChopboxAnchor(containerShape);	       
	        //layoutPictogramElement(containerShape);
	        return containerShape;
	    }
}