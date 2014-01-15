package jp.ac.kyushu.iarch.sequencediagram.diagram.providers;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.tb.ImageDecorator;
 
public class SequenceToolBehaviorProvider extends DefaultToolBehaviorProvider{

    public SequenceToolBehaviorProvider(IDiagramTypeProvider dtp) {
        super(dtp);
    }
    
    @Override
    public IDecorator[] getDecorators(PictogramElement pe) {
        IFeatureProvider featureProvider = getFeatureProvider();
        Object bo = featureProvider.getBusinessObjectForPictogramElement(pe);
        if (bo instanceof behavior.Object) {
        	behavior.Object obj = (behavior.Object) bo;
            String name = obj.getName();
            if (name != null && name.length() > 0
                && !(name.charAt(0) >= 'A' && name.charAt(0) <= 'Z')) {
                IDecorator imageRenderingDecorator =
                    new ImageDecorator(
                        IPlatformImageConstants.IMG_ECLIPSE_WARNING_TSK);
                imageRenderingDecorator
                    .setMessage("Name should start with upper case letter");
                return new IDecorator[] { imageRenderingDecorator };
            }
        }
     
        return super.getDecorators(pe);
    }
}