package jp.ac.kyushu.iarch.sequencediagram.features;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import behavior.Message;
import behavior.MessageOccurrenceSpecification;




public class AddMessageFeature extends AbstractAddFeature {

    private static final IColorConstant MESSAGE_FOREGROUND = new ColorConstant(0, 0, 0);
 
    public AddMessageFeature (IFeatureProvider fp) {
        super(fp);
    }
 
    public PictogramElement add(IAddContext context) {
        IAddConnectionContext addConContext = (IAddConnectionContext) context;
        Message addedMessage = (Message) context.getNewObject();
        IPeCreateService peCreateService = Graphiti.getPeCreateService();
        IGaService gaService = Graphiti.getGaService();
        // CONNECTION WITH POLYLINE
        Connection connection = peCreateService
            .createFreeFormConnection(getDiagram());
        connection.setStart(addConContext.getSourceAnchor());
        connection.setEnd(addConContext.getTargetAnchor());
	    //gaService.setLocationAndSize(addConContext.getSourceAnchor().getGraphicsAlgorithm(), addConContext.getSourceAnchor().getGraphicsAlgorithm().getX(), addConContext.getSourceAnchor().getGraphicsAlgorithm().getX(), 1, 1);
	    //

 
        Polyline polyline = gaService.createPolyline(connection,new int[] { 50, 0, 100, 100, 0, 100 });
        polyline.setLineWidth(2);
        polyline.setForeground(manageColor(MESSAGE_FOREGROUND));
        polyline.setFilled(true);
        polyline.setX(context.getX());

        // create link and wire it
        link(connection, addedMessage);
        
        //If in the same lifeline, add two bend points.
        if(((ContainerShape)addConContext.getSourceAnchor().eContainer()).getGraphicsAlgorithm().getX() 
        		== ((ContainerShape)addConContext.getTargetAnchor().eContainer()).getGraphicsAlgorithm().getX())
        {
        	//Find the containers of the Anchors.
        	ContainerShape addSA = (ContainerShape) addConContext.getSourceAnchor().eContainer();
        	ContainerShape addTA = (ContainerShape ) addConContext.getTargetAnchor().eContainer();
        	
        	//Get the position
        	Point e = gaService.createPoint(addSA.getGraphicsAlgorithm().getX()+30, addSA.getGraphicsAlgorithm().getY()+4);
        	Point e2 = gaService.createPoint(addTA.getGraphicsAlgorithm().getX()+30, addTA.getGraphicsAlgorithm().getY()+4);
        	
        	//Add bend points.
        	((FreeFormConnection)polyline.eContainer()).getBendpoints().add(e);
        	((FreeFormConnection)polyline.eContainer()).getBendpoints().add(e2);        	
        }//add some bending-points
        
        // add dynamic text decorator for the association name 
        ConnectionDecorator textDecorator =
                peCreateService.createConnectionDecorator(connection, true,
                0.5, true);
        Text text = gaService.createDefaultText(getDiagram(),textDecorator);
        text.setForeground(manageColor(IColorConstant.BLACK));
        gaService.setLocation(text, 10, 0);
        // set reference name in the text decorator
         Message message = (Message) context.getNewObject();
        text.setValue(message.getName());
    
        // add static graphical decorator (composition and navigable)
        ConnectionDecorator cd;
        cd = peCreateService
              .createConnectionDecorator(connection, false, 1.0, true);
        createArrow(cd);

        sortMessage();
        return connection;
    }
 
    public boolean canAdd(IAddContext context) {
        // return true if given business object is an EReference
        // note, that the context must be an instance of IAddConnectionContext
        if (context instanceof IAddConnectionContext
            && context.getNewObject() instanceof Message) {
            return true;
        }
        return false;
    }

    private Polyline createArrow(GraphicsAlgorithmContainer gaContainer) {
	    IGaService gaService = Graphiti.getGaService();
	    Polyline polyline =
	        gaService.createPolyline(gaContainer, new int[] { -10, 7, 0, 0, -10, -7});//{ -15, 10, 0, 0, -15, -10 }
	    polyline.setForeground(manageColor(MESSAGE_FOREGROUND));
	    polyline.setLineWidth(2);
	    return polyline;
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
    		
    		//System.out.println("Message:"+mginstance.getMessageOrder()+" "+ mginstance.getName());
    		i++;
    	}
    	return true;
    }
    
}