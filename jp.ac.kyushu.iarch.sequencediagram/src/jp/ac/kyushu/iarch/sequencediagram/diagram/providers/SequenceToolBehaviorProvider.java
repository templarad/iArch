package jp.ac.kyushu.iarch.sequencediagram.diagram.providers;


import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.tb.ImageDecorator;

import behavior.Message;
import behavior.NamedElement;
 
public class SequenceToolBehaviorProvider extends DefaultToolBehaviorProvider{

    public SequenceToolBehaviorProvider(IDiagramTypeProvider dtp) {
        super(dtp);
    }
    
    @SuppressWarnings("unused")
	@Override
    public IDecorator[] getDecorators(PictogramElement pe) {
    	
    	IFeatureProvider featureProvider = getFeatureProvider();
        
        if (pe instanceof ConnectionDecorator) {        	
    		PictogramElement pecon = ((ConnectionDecorator)pe).getConnection();
    		Object bo = featureProvider.getBusinessObjectForPictogramElement(pecon);
    		if(bo instanceof Message){
            	for(Object ob: pe.eContents()){
            		if(!((Message) bo).isArchpoint()){
            			IDecorator imageRenderingDecorator =
                                new ImageDecorator(
                                    IPlatformImageConstants.IMG_ECLIPSE_WARNING_TSK);
                            imageRenderingDecorator
                                .setMessage("Archpoint Unselected");
                            return new IDecorator[] { imageRenderingDecorator };
            		}
            	}
            }
    	}
    	
        Object bo = featureProvider.getBusinessObjectForPictogramElement(pe);
        
        if(bo instanceof behavior.Object){
        	boolean isArchpoint = ((NamedElement)bo).isArchpoint();
        	if(!isArchpoint){
        		IDecorator imageRenderingDecorator =
                        new ImageDecorator(
                            IPlatformImageConstants.IMG_ECLIPSE_WARNING_TSK);
                    imageRenderingDecorator
                        .setMessage("Archpoint Unselected");
                    return new IDecorator[] { imageRenderingDecorator };
        	}
        }
        return super.getDecorators(pe);
    }
}