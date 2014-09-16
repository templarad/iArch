package jp.ac.kyushu.iarch.classdiagram.features;


import org.eclipse.graphiti.features.IFeatureProvider;

import org.eclipse.graphiti.features.context.IDeleteContext;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

public class DeleteClassFeature extends DefaultDeleteFeature{
	
	private boolean hasDoneChanges = false;
	public DeleteClassFeature(IFeatureProvider fp) {
		super(fp);
	}
    @Override
    public String getName() {
        return "Delete Class";
    }
 
    @Override
    public String getDescription() {
        return "Refactoring using Delete Class Pattern";
    }
    @Override
    public boolean canDelete(IDeleteContext context) {
    	// allow delete if exactly one pictogram element
        // representing a Class is selected
        boolean ret = false;
        PictogramElement pes = context.getPictogramElement();
        if (pes != null) {
            Object bo = getBusinessObjectForPictogramElement(pes);
            if (bo instanceof umlClass.Class) {
                ret = true;
            }
        }
        //if the class is not included in marker
        //
        return ret;
    }
    
    @Override
	public void preDelete(IDeleteContext context) {
	}
    
    @Override
    public void delete(IDeleteContext context){
    	if (context instanceof IDeleteContext) {
    		PictogramElement pes = ((IDeleteContext) context).getPictogramElement();
    		if (pes != null) {
                Object bo = getBusinessObjectForPictogramElement(pes);
                if (bo instanceof umlClass.Class) {
                	umlClass.Class eClass = (umlClass.Class) bo;
                    String currentName = eClass.getName();
                    getDiagram().eResource().getContents().remove(eClass);
//                    XMLreader xx= new XMLreader();
//                    Model archmodel = ArchModel.getArchfaceModel(xx.getArchfileResource());
//                    
//                    for(Interface interfc :archmodel.getInterfaces()){
//                    	if(interfc.getName()==currentName){
//                    		archmodel.getBehaviors().remove(interfc);
//                    		break;
//                    	}
//                    }
                    this.hasDoneChanges = true;
                    updatePictogramElement(pes);
                    
                }
            }
			delete((IDeleteContext) context);
		}
        // TODO Auto-generated method stub
        
		
	}
	
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
   
}
