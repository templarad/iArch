package jp.ac.kyushu.iarch.sequencediagram.diagram.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.tb.ImageDecorator;
import org.eclipse.graphiti.ui.editor.DiagramEditor;

import behavior.NamedElement;
 
public class SequenceToolBehaviorProvider extends DefaultToolBehaviorProvider{

    public SequenceToolBehaviorProvider(IDiagramTypeProvider dtp) {
        super(dtp);
    }
    
    @Override
    public IDecorator[] getDecorators(PictogramElement pe) {
    	//DiagramEditor =
    	IMarker[] problems = null;
    	List<String> location = new ArrayList<String>();
    	String path = pe.eContainer().eResource().getURI().toPlatformString(true).toString();
    	IResource re = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
    	
    	//get problems from IMarker
    	try {
    		problems = re.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
    		
    	} catch (CoreException e) {
    		   // something went wrong
    	}

    	//-----------Mark errors in diagram
//    	if(problems.length>0){
//    		IFeatureProvider featureProvider = getFeatureProvider();        	
//            Object bo = featureProvider.getBusinessObjectForPictogramElement(pe);
//    		for(IMarker problem:problems){
//    			try {
//					location.add((String) problem.getAttribute(IMarker.LOCATION));
//					if (bo instanceof behavior.Object) {
//			        	behavior.Object obj = (behavior.Object) bo;
//			            String name = obj.getName();
//			            if (name == (String) problem.getAttribute(IMarker.LOCATION)) {
//			                IDecorator imageRenderingDecorator =
//			                    new ImageDecorator(
//			                        IPlatformImageConstants.IMG_ECLIPSE_ERROR_TSK);//IMG_ECLIPSE_WARNING_TSK
//			                imageRenderingDecorator
//			                    .setMessage((String) problem.getAttribute(IMarker.MESSAGE));
//			                return new IDecorator[] { imageRenderingDecorator };
//			            }
//			        }
//				} catch (CoreException e) {
//					// TODO Auto-generated catch block
//					System.out.println("no location information");
//					e.printStackTrace();
//				}
//    		}//end for
//    	}
    	//------------End mark errors in diagram
        
        
     
        return super.getDecorators(pe);
    }
}