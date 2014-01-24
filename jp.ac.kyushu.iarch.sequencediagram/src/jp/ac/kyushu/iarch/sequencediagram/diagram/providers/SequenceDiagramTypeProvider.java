package jp.ac.kyushu.iarch.sequencediagram.diagram.providers;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.emf.ecore.resource.Resource;

public class SequenceDiagramTypeProvider extends AbstractDiagramTypeProvider
		implements IDiagramTypeProvider {
	private IToolBehaviorProvider[] toolBehaviorProviders;

	public SequenceDiagramTypeProvider() {
		super();
		setFeatureProvider(new SequenceFeatureProvider(this));
	}
	
	@Override
    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
        if (toolBehaviorProviders == null) {
            toolBehaviorProviders =
                new IToolBehaviorProvider[] { new SequenceToolBehaviorProvider(
                    this) };
        }
        return toolBehaviorProviders;
    }
	
	@Override
	public void resourcesSaved(Diagram diagram,
            Resource[] savedResources){

//		String path = savedResources[0].getURI().toPlatformString(true).toString();
//		IResource re = ResourcesPlugin.getWorkspace().getRoot().findMember(path);

    	//-----------Mark errors in diagram
//    	if(problems.length>0){
//    		for(IMarker problem:problems){
//    			try {
//    				for(Shape shape:diagram.getChildren()){    					
//    						Object ob = getFeatureProvider().getBusinessObjectForPictogramElement(shape);
//    						if (ob instanceof behavior.Object) {
//    				        	behavior.Object obj = (behavior.Object) ob;
//    				            String name = obj.getName();
//    				            if (name == (String) problem.getAttribute(IMarker.LOCATION)) {
//    				            	//Color c = shape.getGraphicsAlgorithm().getForeground();
//    				            	
//    				            	//shape.getGraphicsAlgorithm().setForeground(c);
//    				            	break;
//
//    				            }else{
//    				            	//shape.getGraphicsAlgorithm().setForeground(shape.getGraphicsAlgorithm().getForeground());
//    				            }
//    				        }
//    				}
//					
//					
//				} catch (CoreException e) {
//					// TODO Auto-generated catch block
//					System.out.println("no location information");
//					e.printStackTrace();
//				}
//    		}//end for
//    	}
    	//------------End mark errors in diagram
		//shape.get(0).getGraphicsAlgorithm().setForeground(MESSAGE_FOREGROUND.);
		
	}
}
