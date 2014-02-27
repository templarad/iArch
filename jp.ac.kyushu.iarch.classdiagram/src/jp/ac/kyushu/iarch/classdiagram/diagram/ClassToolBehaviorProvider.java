package jp.ac.kyushu.iarch.classdiagram.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.tb.ImageDecorator;

import umlClass.NamedElement;


public class ClassToolBehaviorProvider extends DefaultToolBehaviorProvider{

	public ClassToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
		// TODO Auto-generated constructor stub
	}

	 @Override
	public IDecorator[] getDecorators(PictogramElement pe) {
	    	
    	IFeatureProvider featureProvider = getFeatureProvider();
        Object bo = featureProvider.getBusinessObjectForPictogramElement(pe);

        if(bo instanceof NamedElement){
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
