package jp.ac.kyushu.iarch.classdiagram.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextMenuEntry;
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

	@Override
	public IContextMenuEntry[] getContextMenu(ICustomContext context) {
		ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(context);
		ContextMenuEntry mainmenuEntry = null;
		// create a sub-menu for all custom features
	    ContextMenuEntry subMenu = new ContextMenuEntry(null, context);
	    subMenu.setText("Refactor");
	    subMenu.setDescription("Refactor features submenu");
	    // display sub-menu hierarchical or flat
	    subMenu.setSubmenu(true);

	    // create a menu-entry in the sub-menu for each custom feature
	    for (int i = 0; i < customFeatures.length; i++) {
			ICustomFeature customFeature = customFeatures[i];
			if (customFeature.isAvailable(context)
					&& !customFeature.getName().equals("Generate All Classes")) {
				ContextMenuEntry menuEntry = new ContextMenuEntry(
						customFeature, context);
				subMenu.add(menuEntry);
			}
			if (customFeature.getName().equals("Generate All Classes")) {
				mainmenuEntry = new ContextMenuEntry(customFeature, context);
			}
		}

		IContextMenuEntry ret[] = new IContextMenuEntry[] { mainmenuEntry, subMenu };
		return ret;
	}
}
